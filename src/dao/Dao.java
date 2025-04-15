package dao;

import model.Produto;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
  void cadastrar(Produto produto) throws SQLException;

  List<Produto> listar() throws SQLException;

  void atualizar(Produto produto) throws SQLException;

  void remover(int id) throws SQLException;
}
