package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton {
  private static Connection conexao;

  private ConexaoSingleton() {
  }

  public static Connection getInstance() {
    if (conexao == null) {
      try {
        conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5434/produtos_db",
            "postgres", "1207");
      } catch (SQLException e) {
        System.out.println("Erro ao conectar ao banco: " + e.getMessage());
      }
    }
    return conexao;
  }
}
