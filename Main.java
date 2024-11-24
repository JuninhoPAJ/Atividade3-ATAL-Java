import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryMatrix tree = new BinaryMatrix(10);
        int input = -1;

        System.out.println("Árvore Binária Representada por Matriz");
        
        while (input != 0) {
            showMenu();
            try {
                System.out.print("Escolha uma opção: ");
                input = scanner.nextInt();

                switch (input) {
                    case 1:
                        System.out.print("Digite um número para inserir na árvore: ");
                        int valueToInsert = scanner.nextInt();
                        tree.insert(valueToInsert);
                        break;

                    case 2:
                        System.out.print("Digite o valor que você deseja remover: ");
                        int valueToRemove = scanner.nextInt();
                        tree.remove(valueToRemove);
                        break;

                    case 3:
                        tree.showRoot();
                        break;

                    case 4:
                        System.out.println("Em-Ordem (InOrder):");
                        tree.inOrder(0);
                        System.out.println();
                        break;

                    case 5:
                        System.out.println("Pré-Ordem (PreOrder):");
                        tree.preOrder(0);
                        System.out.println();
                        break;

                    case 6:
                        System.out.println("Pós-Ordem (PostOrder):");
                        tree.postOrder(0);
                        System.out.println();
                        break;

                    case 0:
                        System.out.println("Encerrando o programa.");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.next();
            }
        }
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1: Para inserir");
        System.out.println("2: Para remover");
        System.out.println("3: Para exibir a raiz");
        System.out.println("4: Para exibir em ordem(InOrder)");
        System.out.println("5: Para exibir em pré-ordem(PreOrder)");
        System.out.println("6: Para exibir em pós-ordem(PostOrder)");
        System.out.println("0: Para sair");
    }
}
