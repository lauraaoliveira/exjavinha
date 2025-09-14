import java.util.Scanner;

public class Carro {
    int velocidade;
    boolean ligado;
    final int VELOCIDADE_MAXIMA = 300;
    boolean nitroDisponivel;
    boolean nitroUsado;

    public Carro() {
        this.velocidade = 0;
        this.ligado = false;
        this.nitroDisponivel = false;
        this.nitroUsado = false;
    }

    public void arrancar() {
        if (ligado) {
            System.out.println("O carro já está ligado, Dom!!");
        } else {
            ligado = true;
            System.out.println("VRUUUUUUUUM! O carro foi ligado! NITROS PRONTOS!");
        }
    }

    public void parar() {
        if (!ligado) {
            System.out.println("O carro já está parado, parceiro!");
        } else if (velocidade > 0) {
            System.out.println("Reduza a velocidade antes de parar ou vai bater!!!!!!");
        } else {
            ligado = false;
            System.out.println("O carro foi desligado. Missão cumprida, Dom!!");
        }
    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("Você precisa ligar o carro antes de acelerar!");
        } else if (nitroUsado) {
            System.out.println("🚀 O carro não é um foguete! Não é possível acelerar mais depois do nitro!");
        } else if (velocidade >= VELOCIDADE_MAXIMA) {
            System.out.println("Velocidade máxima atingida!! Vai explodir o motor se não usar o NITRO!!");
            nitroDisponivel = true; // ativa o nitro quando chegar na máxima
        } else {
            velocidade += 100;
            if (velocidade > VELOCIDADE_MAXIMA) {
                velocidade = VELOCIDADE_MAXIMA;
                nitroDisponivel = true;
            }
            System.out.println("Acelerando!!! Velocidade atual: " + velocidade + " km/h");
        }
    }

    public void frear() {
        if (!ligado || velocidade == 0) {
            System.out.println("Não dá pra frear um carro parado, né?");
        } else {
            velocidade -= 50;
            if (velocidade < 0) {
                velocidade = 0;
            }
            System.out.println("Freando!!! Velocidade atual: " + velocidade + " km/h");
        }
    }

    public void buzinar() {
        System.out.println("BIIIIIIIII BIIIIIIIII !!! SAI DA FRENTE QUE O DOM TÁ PASSANDO");
    }

    public void nitro() {
        if (!ligado) {
            System.out.println("Não dá pra usar nitro com o carro desligado!");
        } else if (!nitroDisponivel) {
            System.out.println("Você ainda não atingiu a velocidade máxima para ativar o nitro!");
        } else {
            velocidade *= 2;
            System.out.println("🔥🔥🔥 NITRO ATIVADO!!! Velocidade insana: " + velocidade + " km/h 🔥🔥🔥");
            nitroDisponivel = false;
            nitroUsado = true; // marca que o nitro já foi usado
        }
    }

    public void status() {
        System.out.println("## STATUS DO CARRO ##\n");
        System.out.println("Ligado: " + (ligado ? "Sim" : "Não"));
        System.out.println("Velocidade: " + velocidade + " km/h");
        System.out.println("Nitro disponível: " + (nitroDisponivel ? "Sim" : "Não"));
        System.out.println("Nitro já usado: " + (nitroUsado ? "Sim" : "Não"));
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carro carro = new Carro();
        int opcao;

        do {
            System.out.println("\n### MENU VELOZES & FURIOSOS ###");
            System.out.println("1. Arrancar");
            System.out.println("2. Parar");
            System.out.println("3. Acelerar");
            System.out.println("4. Frear");
            System.out.println("5. Buzinar");
            System.out.println("6. Usar Nitro");
            System.out.println("7. Ver Status");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    carro.arrancar();
                    break;
                case 2:
                    carro.parar();
                    break;
                case 3:
                    carro.acelerar();
                    break;
                case 4:
                    carro.frear();
                    break;
                case 5:
                    carro.buzinar();
                    break;
                case 6:
                    carro.nitro();
                    break;
                case 7:
                    carro.status();
                    break;
                case 0:
                    System.out.println("Saindo... Até a próxima corrida, Dom!");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha de 0 a 7");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
