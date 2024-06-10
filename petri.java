import java.util.Scanner;
import java.util.Stack;

public class PilhaSimples {
    private Stack<Integer> pilha;

    public PilhaSimples() {
        pilha = new Stack<>();
    }

    public void adicionar(int item) {
        pilha.push(item);
    }

    public Integer remover() {
        return pilha.isEmpty() ? null : pilha.pop();
    }

    public void removerTodasOcorrencias(int item) {
        pilha.removeIf(i -> i == item);
    }

    public void listarPilha() {
        System.out.println(pilha);
    }

    public Integer buscar(int item) {
        return pilha.contains(item) ? item : null;
    }

    public Integer maiorElemento() {
        if (pilha.isEmpty()) return null;
        return pilha.stream().max(Integer::compare).orElse(null);
    }

    public Integer menorElemento() {
        if (pilha.isEmpty()) return null;
        return pilha.stream().min(Integer::compare).orElse(null);
    }

    public void calcularMedia() {
        if (pilha.isEmpty()) {
            System.out.println("A pilha está vazia.");
            return;
        }
        double soma = 0;
        for (int num : pilha) {
            soma += num;
        }
        double media = soma / pilha.size();
        System.out.printf("Média dos elementos na pilha: %.2f\n", media);
    }

    public int quantidade() {
        return pilha.size();
    }

    public void aumentarCapacidade(int novaCapacidade) {
        System.out.println("Capacidade aumentada para " + novaCapacidade + " (placeholder).");
    }

    public static void main(String[] args) {
        PilhaSimples pilha = new PilhaSimples();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar");
            System.out.println("2. Remover");
            System.out.println("3. Remover todas ocorrências do elemento");
            System.out.println("4. Listar pilha/ Ver todos os elementos");
            System.out.println("5. Buscar");
            System.out.println("6. Maior");
            System.out.println("7. Menor");
            System.out.println("8. Calcular Média");
            System.out.println("9. Quantidade");
            System.out.println("10. Aumentar capacidade da pilha");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite um número para adicionar na pilha: ");
                    int numAdicionar = scanner.nextInt();
                    pilha.adicionar(numAdicionar);
                    break;
                case 2:
                    Integer valorRemovido = pilha.remover();
                    if (valorRemovido != null) {
                        System.out.println("Elemento removido: " + valorRemovido);
                        System.out.println("Elementos na pilha: ");
                        pilha.listarPilha();
                    } else {
                        System.out.println("A pilha já está vazia.");
                    }
                    break;
                case 3:
                    System.out.print("Digite um número para remover todas as ocorrências: ");
                    int numRemover = scanner.nextInt();
                    pilha.removerTodasOcorrencias(numRemover);
                    System.out.println("Elementos na pilha: ");
                    pilha.listarPilha();
                    break;
                case 4:
                    System.out.println("Elementos na pilha: ");
                    pilha.listarPilha();
                    break;
                case 5:
                    System.out.print("Digite um número para buscar: ");
                    int numBuscar = scanner.nextInt();
                    Integer resultadoBusca = pilha.buscar(numBuscar);
                    if (resultadoBusca != null) {
                        System.out.println("Elemento encontrado: " + resultadoBusca);
                    } else {
                        System.out.println("Elemento não encontrado.");
                    }
                    break;
                case 6:
                    Integer maior = pilha.maiorElemento();
                    if (maior != null) {
                        System.out.println("Maior elemento: " + maior);
                    } else {
                        System.out.println("A pilha está vazia.");
                    }
                    break;
                case 7:
                    Integer menor = pilha.menorElemento();
                    if (menor != null) {
                        System.out.println("Menor elemento: " + menor);
                    } else {
                        System.out.println("A pilha está vazia.");
                    }
                    break;
                case 8:
                    pilha.calcularMedia();
                    break;
                case 9:
                    System.out.println("Quantidade de elementos na pilha: " + pilha.quantidade());
                    break;
                case 10:
                    System.out.print("Digite a nova capacidade da pilha: ");
                    int novaCapacidade = scanner.nextInt();
                    pilha.aumentarCapacidade(novaCapacidade);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
