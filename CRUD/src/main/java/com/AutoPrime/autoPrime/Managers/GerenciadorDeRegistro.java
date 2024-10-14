package com.AutoPrime.autoPrime.Managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.AutoPrime.autoPrime.Entities.Cliente;
import com.AutoPrime.autoPrime.Entities.Funcionario;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeCliente;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeFuncionario;

@Controller
public class GerenciadorDeRegistro{

    @Autowired
    private RepositorioDeCliente repositorioDeCliente;

    @Autowired
    private RepositorioDeFuncionario repositorioDeFuncionario;

    private static GerenciadorDeRegistro instance;

    private GerenciadorDeRegistro() {

    }

    public static GerenciadorDeRegistro getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeRegistro();
        }
        return instance;
    }

    @GetMapping("/registro/cliente")
    public String registerCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "client_register";
    }

    @PostMapping("/registro/cliente")
    public String cadastra(@ModelAttribute("cliente") Cliente cliente) {
        repositorioDeCliente.save(cliente);
        return "redirect:/registro/cliente";
    }

    @GetMapping("/registro/funcionario")
    public String registerFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "staff_register";
    }

    @PostMapping("/registro/funcionario")
    public String cadastra(@ModelAttribute("funcionario") Funcionario funcionario) {
        repositorioDeFuncionario.save(funcionario);
        return "redirect:/registro/funcionario";
    }
}