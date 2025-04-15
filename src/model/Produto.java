package model;

public class Produto {
  private String nome;
  private int id;
  private double preco;

  public Produto(String nome, double preco) {
    this.nome = nome;
    this.preco = preco;
  }

  public Produto(int id, String nome, double preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public double getPreco() {
    return preco;
  }

}