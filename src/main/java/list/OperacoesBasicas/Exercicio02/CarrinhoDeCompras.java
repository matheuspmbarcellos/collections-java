package main.java.list.OperacoesBasicas.Exercicio02;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listItens;

    public CarrinhoDeCompras() {
        this.listItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        this.listItens.add(new Item(nome, preco, quantidade));
    }
    public void removerItem(String nome) {
        List<Item> itemParaRemover = new ArrayList<>();
        for (Item t: listItens) {
            if(t.getNome().equalsIgnoreCase(nome)) {
                itemParaRemover.add(t);
            }
        }
        listItens.removeAll(itemParaRemover);
    }
    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!listItens.isEmpty()) {
            for(Item i: listItens) {
                valorTotal += i.getPreco() * i.getQuantidade();
            }
            return valorTotal;
        } else {
            throw new RuntimeException("O carrinho está vazio!");
        }
    }
    public void exibirItens() {
        if (!listItens.isEmpty()) {
            System.out.println(this.listItens);
        } else {
            System.out.println("O carrinho está vazio!");
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.adicionarItem("feijao",8.99,2);
        carrinhoDeCompras.exibirItens();
        System.out.println("O valor total do carrinho é: R$" + carrinhoDeCompras.calcularValorTotal());
        carrinhoDeCompras.removerItem("feijao");
        carrinhoDeCompras.exibirItens();
        System.out.println("O valor total do carinho é: " + carrinhoDeCompras.calcularValorTotal());
    }
}
