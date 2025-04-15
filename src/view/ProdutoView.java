package view;

import controller.ProdutoController;

import java.sql.SQLException;
import java.util.Scanner;

public class ProdutoView {
    public static void main(String[] args) throws SQLException {
        ProdutoController controller = new ProdutoController();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Remover Produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.print("\n");
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o preço do produto: ");
                    String precoStr = scanner.nextLine().replace(",", ".");
                    double preco = Double.parseDouble(precoStr);
                    controller.cadastrarProduto(nome, preco);
                    break;

                case 2:
                    controller.listarProdutos();
                    break;

                case 3:
                    System.out.print("ID do produto que deseja atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Novo preço: ");
                    String novoPrecoStr = scanner.nextLine().replace(",", ".");
                    double novoPreco = Double.parseDouble(novoPrecoStr);

                    controller.atualizarProduto(idAtualizar, novoNome, novoPreco);
                    break;

                case 4:
                    System.out.print("ID do produto que deseja remover: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();

                    controller.removerProduto(idRemover);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
