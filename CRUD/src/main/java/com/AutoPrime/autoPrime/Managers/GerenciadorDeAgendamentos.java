package com.AutoPrime.autoPrime.Managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.AutoPrime.autoPrime.Estoque;
import com.AutoPrime.autoPrime.Entities.Agendamento;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeAgendamentos;

@Controller
public class GerenciadorDeAgendamentos {

    @Autowired
    private RepositorioDeAgendamentos repositorioDeAgendamentos;

    @Autowired
    private Estoque estoque;

    private static GerenciadorDeAgendamentos instance;

    private GerenciadorDeAgendamentos() {

    }

    public static GerenciadorDeAgendamentos getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeAgendamentos();
        }
        return instance;
    }

    @GetMapping("/agendar")
    public String addAgendamento(Model model) {
        model.addAttribute("agendamento", new Agendamento());
        if (estoque != null)
            model.addAttribute("opcoes", estoque.listarVeiculos());
        return "scheduling";
    }

    @PostMapping("/agendar")
    public String createAgendamento(@ModelAttribute("agendamento") Agendamento agendamento) {
        repositorioDeAgendamentos.save(agendamento);
        return "redirect:/agendamentos";
    }

    @GetMapping("/agendamentos")
    public String listarAgendamentos(Model model){
        model.addAttribute("agendamentos", repositorioDeAgendamentos.findAll());
        return "schedules";
    }

    @GetMapping("/agendamentos/desmarcar/{id}")
    public String desmarcarAgendamento(@PathVariable(name = "id") long id, Model model){
        repositorioDeAgendamentos.desmarcarAgendamento(id);
        return "redirect:/agendamentos";
    }
}
