import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String nome;
    int quantidade;
    double valorUnitario;

    public Item(String nome, int quantidade, double valorUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public double calcularSubtotal() {
        return quantidade * valorUnitario;
    }

    public void alterarQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }
}

public class ListaCompras {
    static ArrayList<Item> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void adicionarItem() {
        System.out.print("Digite o nome do item: ");
        String nome = sc.next();
        System.out.print("Digite a quantidade: ");
        int qtd = sc.nextInt();
        System.out.print("Digite o valor unitário: ");
        double valor = sc.nextDouble();

        lista.add(new Item(nome, qtd, valor));
        System.out.println("Item adicionado com sucesso!");
    }

    public static void consultarLista() {
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia!");
            return;
        }
        System.out.println("\n--- LISTA DE COMPRAS ---");
        for (int i = 0; i < lista.size(); i++) {
            Item item = lista.get(i);
            System.out.println((i + 1) + ". " + item.nome + " - Quantidade: " + item.quantidade + " - Valor unitário: R$" + item.valorUnitario + " - Subtotal: R$" + item.calcularSubtotal());
        }
    }

    public static void alterarQuantidade() {
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia!");
            return;
        }
        consultarLista();
        System.out.print("Escolha o número do item que deseja alterar a quantidade: ");
        int indice = sc.nextInt() - 1;
        if (indice < 0 || indice >= lista.size()) {
            System.out.println("Item inválido!");
            return;
        }
        System.out.print("Digite a nova quantidade: ");
        int novaQtd = sc.nextInt();
        lista.get(indice).alterarQuantidade(novaQtd);
        System.out.println("Quantidade alterada com sucesso!");
    }

    public static void excluirItem() {
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia!");
            return;
        }
        consultarLista();
        System.out.print("Escolha o número do item que deseja excluir: ");
        int indice = sc.nextInt() - 1;
        if (indice < 0 || indice >= lista.size()) {
            System.out.println("Item inválido!");
            return;
        }
        lista.remove(indice);
        System.out.println("Item removido com sucesso!");
    }

    public static void calcularTotal() {
        double total = 0;
        for (Item item : lista) {
            total += item.calcularSubtotal();
        }
        System.out.println("Valor total da compra: R$" + total);
    }

    public static void encerrarLista() {
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia! Nada para encerrar.");
            return;
        }
        double total = 0;
        for (Item item : lista) {
            total += item.calcularSubtotal();
        }

        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1 - À vista (dinheiro ou pix) - 5% de desconto");
        System.out.println("2 - Cartão da loja - 7% de desconto");
        System.out.println("3 - Cartão comum - sem desconto");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();

        double totalFinal = total;
        switch (opcao) {
            case 1:
                totalFinal = total * 0.95;
                System.out.println("Pagamento à vista escolhido. 5% de desconto aplicado!");
                break;
            case 2:
                totalFinal = total * 0.93;
                System.out.println("Cartão da loja escolhido. 7% de desconto aplicado!");
                break;
            case 3:
                System.out.println("Cartão comum. Sem desconto.");
                break;
            default:
                System.out.println("Opção inválida. Sem desconto aplicado.");
                break;
        }
        System.out.println("Valor final a pagar: R$" + totalFinal);
        System.out.println("Compra finalizada. Obrigado por comprar! 🛒");
        lista.clear();
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- MENU LISTA DE COMPRAS ---");
            System.out.println("1 - Adicionar item");
            System.out.println("2 - Consultar lista");
            System.out.println("3 - Alterar quantidade");
            System.out.println("4 - Excluir item");
            System.out.println("5 - Valor total da compra");
            System.out.println("6 - Encerrar lista e escolher pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    adicionarItem();
                    break;
                case 2:
                    consultarLista();
                    break;
                case 3:
                    alterarQuantidade();
                    break;
                case 4:
                    excluirItem();
                    break;
                case 5:
                    calcularTotal();
                    break;
                case 6:
                    encerrarLista();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}
