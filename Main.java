import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializar a árvore com alguns nós
        Arvore<Aluno> arvore = new Arvore<>();
        Arvore.adicionar(new Aluno("98452345", "João da Costa - RAIZ"));
        Arvore.adicionar(new Aluno("67237834", "Maria da Penha"));
        Arvore.adicionar(new Aluno("99234512", "Carlos Luiz do Nascimento"));

        while (true) {
            System.out.println("Menu de Opções:");
            System.out.println("1- Inserir nó");
            System.out.println("2- Remover nó");
            System.out.println("3- Pesquisar nó");
            System.out.println("4- Esvaziar árvore");
            System.out.println("5- Exibir árvore");
            System.out.println("6- Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o RGM: ");
                    String rgm = scanner.nextLine();
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    arvore.adicionar(new Aluno(rgm, nome));
                    break;

                case 2:
                    System.out.print("Digite o RGM para remover: ");
                    rgm = scanner.nextLine();
                    arvore.remover(new Aluno(rgm, null));
                    break;

                case 3:
                    System.out.print("Digite o RGM para pesquisar: ");
                    rgm = scanner.nextLine();
                    Elemento<Aluno> encontrado = arvore.pesquisar(new Aluno(rgm, null));
                    if (encontrado != null) {
                        System.out.println("Aluno encontrado: " + encontrado.getValor());
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    arvore.esvaziar();
                    System.out.println("Árvore esvaziada.");
                    break;

                case 5:
                    System.out.println("Escolha o tipo de exibição:");
                    System.out.println("1- In-ordem");
                    System.out.println("2- Pré-ordem");
                    System.out.println("3- Pós-ordem");
                    int tipoExibicao = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer

                    String tipo = "";
                    switch (tipoExibicao) {
                        case 1:
                            tipo = "inordem";
                            break;
                        case 2:
                            tipo = "preordem";
                            break;
                        case 3:
                            tipo = "posordem";
                            break;
                        default:
                            System.out.println("Tipo de exibição inválido.");
                            continue;
                    }

                    arvore.exibir(arvore.getRaiz(), tipo);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
