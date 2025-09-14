import java.util.Scanner;

public class Tv {
    boolean ligada;
    int volume;
    int canal; // índice do dorama
    boolean mutada;

    // doramas
    String[] doramas = {
            "Pousando no Amor",
            "Beleza Verdadeira",
            "Alquimia das Almas",
            "Vincenzo",
            "Sorriso Real",
            "Rainha das Lágrimas",
            "A Lição",
            "Pretendente Surpresa"
    };

    public Tv() {
        ligada = false;
        volume = 10; // volume inicial
        canal = 0;   // começa no primeiro dorama
        mutada = false;
    }

    public void ligar() {
        if (ligada) {
            System.out.println("A TV já está ligada 📺!");
        } else {
            ligada = true;
            System.out.println("Você ligou a TV. Assistindo: " + doramas[canal] + " | Volume " + volume);
        }
    }

    public void desligar() {
        if (!ligada) {
            System.out.println("A TV já está desligada!");
        } else {
            ligada = false;
            System.out.println("Você desligou a TV. Até mais!");
        }
    }

    public void aumentarVolume() {
        if (!ligada) {
            System.out.println("A TV está desligada, não dá para aumentar o volume!");
            return;
        }
        if (mutada) {
            System.out.println("A TV está no mudo. Desmute primeiro!");
            return;
        }
        if (volume < 100) {
            volume++;
            System.out.println("Volume: " + volume);
        } else {
            System.out.println("Volume já está no máximo! Os vizinhos vão reclamar! 🔊");
        }
    }

    public void diminuirVolume() {
        if (!ligada) {
            System.out.println("A TV está desligada, não dá para diminuir o volume!");
            return;
        }
        if (mutada) {
            System.out.println("A TV está no mudo. Desmute primeiro!");
            return;
        }
        if (volume > 0) {
            volume--;
            System.out.println("Volume: " + volume);
        } else {
            System.out.println("O volume já está no mínimo!");
        }
    }

    public void mudarCanal(int novoCanal) {
        if (!ligada) {
            System.out.println("Ligue a TV antes de mudar de dorama! 🔌");
            return;
        }
        if (novoCanal >= 1 && novoCanal <= doramas.length) {
            canal = novoCanal - 1;
            System.out.println("Assistindo agora: " + doramas[canal]);
        } else {
            System.out.println("Canal inválido! Escolha entre 1 e " + doramas.length);
        }
    }

    public void proximoCanal() {
        if (!ligada) {
            System.out.println("Ligue a TV antes de mudar de dorama! 🔌");
            return;
        }
        canal++;
        if (canal >= doramas.length) {
            canal = 0; // volta para o primeiro dorama
        }
        System.out.println("Assistindo agora: " + doramas[canal]);
    }

    public void canalAnterior() {
        if (!ligada) {
            System.out.println("Ligue a TV antes de mudar de dorama! 🔌");
            return;
        }
        canal--;
        if (canal < 0) {
            canal = doramas.length - 1; // volta para o último dorama
        }
        System.out.println("Assistindo agora: " + doramas[canal]);
    }

    public void mutar() {
        if (!ligada) {
            System.out.println("Ligue a TV antes de mutar! 🔌");
            return;
        }
        if (!mutada) {
            mutada = true;
            System.out.println("A TV está mutada. 🤫");
        } else {
            mutada = false;
            System.out.println("Som restaurado. Volume: " + volume);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tv tv = new Tv();

        int opcao;
        do {
            System.out.println("\n--- CONTROLE REMOTO (TV de Doramas) ---");
            System.out.println("1 - Ligar a TV");
            System.out.println("2 - Desligar a TV");
            System.out.println("3 - Aumentar volume");
            System.out.println("4 - Diminuir volume");
            System.out.println("5 - Escolher dorama específico");
            System.out.println("6 - Próximo dorama");
            System.out.println("7 - Dorama anterior");
            System.out.println("8 - Mutar/Desmutar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    tv.ligar();
                    break;
                case 2:
                    tv.desligar();
                    break;
                case 3:
                    tv.aumentarVolume();
                    break;
                case 4:
                    tv.diminuirVolume();
                    break;
                case 5:
                    if (!tv.ligada) {
                        System.out.println("Ligue a TV antes de ver a lista de doramas! 🔌");
                        break;
                    }
                    System.out.println("Doramas disponíveis:");
                    for (int i = 0; i < tv.doramas.length; i++) {
                        System.out.println((i + 1) + " - " + tv.doramas[i]);
                    }
                    System.out.print("Digite o número do dorama (1 a " + tv.doramas.length + "): ");
                    int canal = sc.nextInt();
                    tv.mudarCanal(canal);
                    break;
                case 6:
                    tv.proximoCanal();
                    break;
                case 7:
                    tv.canalAnterior();
                    break;
                case 8:
                    tv.mutar();
                    break;
                case 0:
                    System.out.println("Encerrando o controle remoto...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}
