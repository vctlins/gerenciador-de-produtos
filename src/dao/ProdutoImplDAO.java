package dao;

import model.Produto;
import singleton.ConexaoSingleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoImplDAO implements Dao {

  private Connection conn;

  public ProdutoImplDAO() {
    this.conn = ConexaoSingleton.getInstance();
  }

  @Override
  public void cadastrar(Produto produto) throws SQLException {
    String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, produto.getNome());
    stmt.setDouble(2, produto.getPreco());
    stmt.executeUpdate();
    System.out.println("Produto cadastrado com sucesso!\n");
  }

  @Override
  public List<Produto> listar() throws SQLException {
    List<Produto> produtos = new ArrayList<>();
    String sql = "SELECT * FROM produtos";

    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
      Produto produto = new Produto(
          rs.getInt("id"),
          rs.getString("nome"),
          rs.getDouble("preco"));
      produtos.add(produto);
    }

    return produtos;
  }

  @Override
  public void atualizar(Produto produto) throws SQLException {
    String sql = "UPDATE produtos SET id = ?, nome = ?, preco = ? WHERE id = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, produto.getId());
    stmt.setString(2, produto.getNome());
    stmt.setDouble(3, produto.getPreco());
    stmt.setInt(4, produto.getId());

    int linhasAfetadas = stmt.executeUpdate();
    if (linhasAfetadas > 0) {
      System.out.println("Produto atualizado com sucesso!\n");
    } else {
      System.out.println("Produto com ID " + produto.getId() + " não encontrado.\n");
    }
  }

  @Override
  public void remover(int id) throws SQLException {
    String sql = "DELETE FROM produtos WHERE id = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, id);

    int linhasAfetadas = stmt.executeUpdate();
    if (linhasAfetadas > 0) {
      System.out.println("Produto removido com sucesso!\n");
    } else {
      System.out.println("Produto com ID " + id + " não encontrado.\n");
    }
  }

}
