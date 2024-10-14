package com.AutoPrime.autoPrime.Managers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.AutoPrime.autoPrime.Entities.Cliente;
import com.AutoPrime.autoPrime.Entities.Compra;
import com.AutoPrime.autoPrime.Entities.Veiculo;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeCliente;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeCompras;
import com.AutoPrime.autoPrime.Repositories.RepositorioDeVeiculos;
import com.AutoPrime.autoPrime.Utils.StatusVeiculo;

@Controller
public class GerenciadorDeCompras {

    @Autowired
    private RepositorioDeCompras repositorioDeCompras;

    @Autowired
    private RepositorioDeVeiculos repositorioDeVeiculos;

    @Autowired
    private RepositorioDeCliente repositorioDeCliente;

    private static GerenciadorDeCompras instance;

    private GerenciadorDeCompras() {

    }

    public static GerenciadorDeCompras getInstance() {
        if (instance == null) {
            instance = new GerenciadorDeCompras();
        }
        return instance;
    }

    public void verificarCadastro(String cpf) {

    }

    public BigDecimal calculaPreco(Veiculo veiculo) {
        BigDecimal preco = veiculo.getPreco();
        return preco;
    }

    public void emitirRecibo() {

    }

    public void informarVeiculo(Veiculo veiculo) {
        System.out.println(veiculo.getModelo());
        System.out.println(veiculo.getAno());
        System.out.println(veiculo.getPreco().toString());
        System.out.println(veiculo.getStatus());
    }

    public void getComprasDescontadas() {

    }

    private void filtrarComprasDescontadas(Compra[] compras) {

    }

    public void getOpcoesDeCompra() {

    }

    public Cliente selectCliente(String cpf) {
        return repositorioDeCliente.findByCpf(cpf);
    }

    @GetMapping("/compra/delete/{id}")
    public String retirarCompra(@PathVariable(name = "id") int id, Model model) {
        Compra compra = repositorioDeCompras.findById(id);
        if (compra != null) {
            repositorioDeCompras.delete(compra);
            System.out.println("Veículo retirado do estoque.");
        }
        return "redirect:/compra/list";
    }

    @GetMapping("/compra/list")
    public String getCompra(Model model) {
        model.addAttribute("compras", repositorioDeCompras.findAll());
        return "purchase_list"; //trocar pro html
    }

    @PostMapping("/compra/register")
    public String saveCompra(@ModelAttribute("compra") Compra compra) {
        if (compra != null) {
            Veiculo veiculo = compra.getVeiculo();
            veiculo.setStatus(StatusVeiculo.Comprado);
            repositorioDeVeiculos.save(veiculo);
            repositorioDeCompras.save(compra);
            System.out.println("Compra adicionada ao banco.");
        }
        return "redirect:/compra/register";
    }

    @GetMapping("/compra/edit/{id}")
    public String editarVeiculo(@PathVariable(name = "id") int id, Model model) {
        Compra compra = repositorioDeCompras.findById(id);
        model.addAttribute("veiculo", compra.getVeiculo());
        model.addAttribute("cliente", compra.getCliente());
        model.addAttribute("compra", compra);
        return "purchase_edit";
    }

    @PostMapping("/compra/edit/{id}")
    public String atualizar(@ModelAttribute("compra") Compra compra) {
        // Lógica de atualização do banco
        repositorioDeCompras.atualizarCompra(compra.getVeiculo(), compra.getCliente(), compra.getData(), compra.getValor(), compra.getDesconto(), compra.getStatus(), compra.getId());
        System.out.println("Compra atualizada.");
        return "redirect:/compra/list";
    }


    @GetMapping("/compra/register")
    public String createCompra(Model model){
        model.addAttribute("compra", new Compra());
        model.addAttribute("clientes", repositorioDeCliente.findAll());
        model.addAttribute("veiculos",  repositorioDeVeiculos.findByStatus(StatusVeiculo.Disponivel));
        return "purchase_register";
    }

}
