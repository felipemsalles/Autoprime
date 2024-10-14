package com.AutoPrime.autoPrime.Managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.AutoPrime.autoPrime.Entities.Cliente;
import com.AutoPrime.autoPrime.Entities.Funcionario;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeCliente;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeFuncionario;

@Controller
public class GerenciadorDeUsuario {

    @Autowired
    private RepositorioDeCliente repositorioDeCliente;

    @Autowired
    private RepositorioDeFuncionario repositorioDeFuncionario;

    private static GerenciadorDeUsuario instance;

    private GerenciadorDeUsuario() {

    }

    public static GerenciadorDeUsuario getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeUsuario();
        }
        return instance;
    }

    @GetMapping("/cliente/list")
    public String getCliente(Model model) {
        model.addAttribute("clientes", repositorioDeCliente.findAll());
        return "client_list";
    }
    
    @GetMapping("/cliente/delete/{cpf}")
    public String retirarCliente(@PathVariable(name = "cpf") String cpf, Model model) {
        Cliente cliente = repositorioDeCliente.findByCpf(cpf);
        if (cliente!= null) {
            repositorioDeCliente.delete(cliente);
            System.out.println("Cliente deletado.");
        } 
        return "redirect:/cliente/list";
    }

    @GetMapping("/cliente/edit/{cpf}")
    public String editarCliente(@PathVariable(name = "cpf") String cpf, Model model) {
        Cliente cliente = repositorioDeCliente.findByCpf(cpf);
        model.addAttribute("cliente", cliente);
        return "client_edit";
    }

    @PostMapping("/cliente/edit/{cpf}")
    public String atualizar(@ModelAttribute("cliente") Cliente cliente) {
        // Lógica de atualização do cliente
        repositorioDeCliente.save(cliente);
        System.out.println("com.AutoPrime.autoPrime.Cliente atualizado.");
        return "redirect:/cliente/list";
    }

    @GetMapping("/funcionario/list")
    public String getFuncionario(Model model) {
        model.addAttribute("funcionarios", repositorioDeFuncionario.findAll());
        return "staff_list";
    }
    
    @GetMapping("/funcionario/delete/{cpf}")
    public String retirarFuncionario(@PathVariable(name = "cpf") String cpf, Model model) {
        Funcionario funcionario = repositorioDeFuncionario.findByCpf(cpf);
        if (funcionario != null) {
            repositorioDeFuncionario.delete(funcionario);
            System.out.println("Funcionario deletado.");
        } 
        return "redirect:/funcionario/list";
    }
    @GetMapping("/funcionario/edit/{cpf}")
    public String editarFuncionario(@PathVariable(name = "cpf") String cpf, Model model) {
        Funcionario funcionario = repositorioDeFuncionario.findByCpf(cpf);
        model.addAttribute("funcionario", funcionario);
        return "staff_edit";
    }

    @PostMapping("/funcionario/edit/{cpf}")
    public String atualizar(@ModelAttribute("funcionario") Funcionario funcionario) {
        // Lógica de atualização do funcionario
        repositorioDeFuncionario.save(funcionario);
        System.out.println("com.AutoPrime.autoPrime.Funcionario atualizado.");
        return "redirect:/funcionario/list";
    }
}


