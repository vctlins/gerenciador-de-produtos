package controller;

import dao.ProdutoImplDAO;
import model.Produto;

import java.sql.SQLException;
import java.util.List;

public class ProdutoController {

  private ProdutoImplDAO dao;

  public ProdutoController() {
    this.dao = new ProdutoImplDAO();
  }

  public void cadastrarProduto(String nome, double preco) throws SQLException {
    Produto p = new Produto(nome, preco);
    dao.cadastrar(p);
  }

  public List<Produto> listarProdutos() throws SQLException {
    List<Produto> lista = dao.listar();
    if (lista.isEmpty()) {
      System.out.println("Nenhum produto encontrado.");
    } else {
      for (Produto p : lista) {
        System.out.println("ID: " + p.getId() +
            "\nNome: " + p.getNome() +
            "\nPreço: R$ " + p.getPreco());
        System.out.println("\n--------------------------");
      }
    }
        return lista;
  }

  public void atualizarProduto(int novoId, String novoNome, double novoPreco) throws SQLException {
    Produto p = new Produto(novoId, novoNome, novoPreco);
    dao.atualizar(p);
  }

  public void removerProduto(int id) throws SQLException {
    dao.remover(id);
  }
}
