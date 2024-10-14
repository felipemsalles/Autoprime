package com.AutoPrime.autoPrime.Managers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.AutoPrime.autoPrime.Entities.Cliente;
import com.AutoPrime.autoPrime.Entities.Funcionario;
import com.AutoPrime.autoPrime.Entities.Usuario;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeCliente;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeFuncionario;

@Controller
public class GerenciadorDeLogin {

    @Autowired
    private RepositorioDeCliente repositorioDeCliente;

    @Autowired
    private RepositorioDeFuncionario repositorioDeFuncionario;

    private static GerenciadorDeLogin instance;

    private GerenciadorDeLogin() {

    }

    public static GerenciadorDeLogin getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeLogin();
        }
        return instance;
    }

    @GetMapping("/login")
    public String registerCliente(Model model) {
        model.addAttribute("user",new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Usuario user) {
        Cliente cliente = repositorioDeCliente.getCliente(user.getCpf(), user.getSenha());
        if(fazerLogin(cliente)){
            return "/tela-de-compra";
        }
        else{
            Funcionario funcionario = repositorioDeFuncionario.getFuncionario(user.getCpf(), user.getSenha());
            if(fazerLogin(funcionario)){
                return "/tela-de-compra";
            }
        }
        return "redirect:/login";
    }

    private boolean fazerLogin(Usuario usuario){
        if(usuario != null){
            entrar(usuario);
            return true;
        }
        return false;
    }

    public void entrar(Usuario usuario){

    }
}