package com.AutoPrime.autoPrime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.AutoPrime.autoPrime.Entities.Veiculo;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeVeiculos;

@Controller
public class Estoque {

    private static Estoque instance;

    @Autowired
    private RepositorioDeVeiculos repositorioDeVeiculos;

    private Estoque() {

    }

    public static Estoque getInstance() {
        if (instance == null) {
            instance = new Estoque();
        }
        return instance;
    }

    public void negarCompra(String mensagemDeErro) {
        exibirErro(mensagemDeErro);
    }

    public boolean aprovarVeiculo() {
        // Lógica de aprovação do veículo
        System.out.println("Veículo aprovado com sucesso.");
        return true;
    }

    public boolean validarVeiculo(Veiculo veiculo) {
        // Lógica de validação do veículo
        if (veiculo != null) {
            return aprovarVeiculo();
        } else {
            negarCompra("Veículo não atende às especificações.");
        }
        return false;
    }

    public void exibirVeiculos() {
        for (Veiculo veiculo : repositorioDeVeiculos.findAll()) {
            exibirDados(veiculo);
        }
    }

    public void exibirVeiculoSelecionado(Veiculo veiculo) {
        if (veiculo != null) {
            exibirDados(veiculo);
        } else {
            exibirErro("Veículo não encontrado.");
        }
    }

    public void exibirErro(String mensagemDeErro) {
        System.err.println("Erro: " + mensagemDeErro);
    }

    public void exibirDados(Veiculo veiculo) {
        if (veiculo != null) {
            System.out.println("Dados do Veículo:");
            System.out.println("Id: " + veiculo.getId());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Ano: " + veiculo.getAno());
            System.out.println("Preço: " + veiculo.getPreco());
            System.out.println("Status: " + veiculo.getStatus());
        } else {
            exibirErro("Veículo não encontrado.");
        }
    }

    @GetMapping("/veiculo/delete/{id}")
    public String retirarVeiculo(@PathVariable(name = "id") int id, Model model) {
        Veiculo veiculo = repositorioDeVeiculos.findById(id);
        if (validarVeiculo(veiculo)) {
            repositorioDeVeiculos.delete(veiculo);
            System.out.println("Veículo retirado do estoque.");
        } else {
            exibirErro("Veículo não encontrado no estoque.");
        }
        return "redirect:/veiculo/list";
    }
   
    public boolean verificarEstoque(Veiculo veiculo) {
        if (veiculo != null && repositorioDeVeiculos.findById(veiculo.getId()) != null) {
             validarVeiculo(veiculo);
        } else {
            exibirErro("Veículo não encontrado no estoque.");
        }
        return false;
    }

    public List<Veiculo> listarVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        for (Veiculo veiculo : repositorioDeVeiculos.findAll()) {
            veiculos.add(veiculo);
        }
        return veiculos;
    }

    @GetMapping("/veiculo/list")
    public String getVeiculos(Model model) {
        model.addAttribute("veiculos", listarVeiculos());
        return "vehicle_list";
    }

    @GetMapping("/veiculo/edit/{id}")
    public String editarVeiculo(@PathVariable(name = "id") int id, Model model) {
        Veiculo veiculo = repositorioDeVeiculos.findById(id);
        model.addAttribute("veiculo", veiculo);
        return "vehicle_edit";
    }

    @PostMapping("/veiculo/edit/{id}")
    public String atualizar(@ModelAttribute("veiculo") Veiculo veiculo) {
        // Lógica de atualização do estoque
        repositorioDeVeiculos.save(veiculo);
        System.out.println("com.AutoPrime.autoPrime.Estoque atualizado.");
        return "redirect:/veiculo/list";
    }


    @GetMapping("/veiculo/register")
    public String teste(Model model){
        model.addAttribute("veiculo", new Veiculo());
        return "vehicle_register";
    }

    @PostMapping("/veiculo/register")
    public String adicionarVeiculo(@ModelAttribute("veiculo") Veiculo veiculo) {
        if (validarVeiculo(veiculo)) {
            repositorioDeVeiculos.save(veiculo);
            System.out.println("Veículo adicionado ao estoque.");
        } else {
            exibirErro("Não é possível adicionar um veículo nulo.");
        }
        return "redirect:/veiculo/register";
    }
}
