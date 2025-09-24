// Classe mãe Perfume
class Perfume {
    protected String nome;
    protected String marca;
    protected int volume; // em ml
    protected double preco;
    
    // construtor
    public Perfume(String nome, String marca, int volume, double preco) {
        this.nome = nome;
        this.marca = marca;
        this.volume = volume;
        this.preco = preco;
    }
    
    // getters
    public String getNome() {
        return nome;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public double getPreco() {
        return preco;
    }
    
    // metodo para mostrar dados
    public void mostrarPerfume() {
        System.out.println("Nome: " + nome);
        System.out.println("Marca: " + marca);
        System.out.println("Volume: " + volume + "ml");
        System.out.println("Preço: R$ " + preco);
    }
    
    // metodo que pode ser sobrescrito
    public void usarPerfume() {
        System.out.println("Aplicando " + nome + "...");
    }
}

// Classe filha PerfumeFeminino
class PerfumeFeminino extends Perfume {
    private String tipoFragrancia; // floral, frutal, doce, etc
    private boolean paraOcasiao; // true = festa/noite, false = dia a dia
    
    // construtor
    public PerfumeFeminino(String nome, String marca, int volume, double preco,
                          String tipoFragrancia, boolean paraOcasiao) {
        super(nome, marca, volume, preco);
        this.tipoFragrancia = tipoFragrancia;
        this.paraOcasiao = paraOcasiao;
    }
    
    // getters
    public String getTipoFragrancia() {
        return tipoFragrancia;
    }
    
    public boolean isParaOcasiao() {
        return paraOcasiao;
    }
    
    // sobrescrevendo o metodo da classe mãe
    @Override
    public void mostrarPerfume() {
        System.out.println("=== PERFUME FEMININO ===");
        super.mostrarPerfume();
        System.out.println("Tipo: " + tipoFragrancia);
        System.out.println("Ocasião: " + (paraOcasiao ? "Festas/Noite" : "Dia a dia"));
    }
    
    @Override
    public void usarPerfume() {
        if (paraOcasiao) {
            System.out.println("Aplicando " + nome + " para uma ocasião especial! ✨");
        } else {
            System.out.println("Aplicando " + nome + " para o dia a dia 🌸");
        }
    }
    
    // metodo especifico
    public void combinarComRoupa() {
        System.out.println("Este perfume " + tipoFragrancia + " combina bem com roupas elegantes!");
    }
}

// Classe filha PerfumeMasculino
class PerfumeMasculino extends Perfume {
    private String intensidade; // leve, moderado, intenso
    private boolean paraEsporte; // true = esportivo, false = social
    
    // construtor
    public PerfumeMasculino(String nome, String marca, int volume, double preco,
                           String intensidade, boolean paraEsporte) {
        super(nome, marca, volume, preco);
        this.intensidade = intensidade;
        this.paraEsporte = paraEsporte;
    }
    
    // getters
    public String getIntensidade() {
        return intensidade;
    }
    
    public boolean isParaEsporte() {
        return paraEsporte;
    }
    
    // sobrescrevendo o metodo da classe mãe
    @Override
    public void mostrarPerfume() {
        System.out.println("=== PERFUME MASCULINO ===");
        super.mostrarPerfume();
        System.out.println("Intensidade: " + intensidade);
        System.out.println("Tipo: " + (paraEsporte ? "Esportivo" : "Social"));
    }
    
    @Override
    public void usarPerfume() {
        if (paraEsporte) {
            System.out.println("Aplicando " + nome + " antes do treino! 💪");
        } else {
            System.out.println("Aplicando " + nome + " para o trabalho/social 👔");
        }
    }
    
    // metodo especifico
    public void duracaoFragrancia() {
        if (intensidade.equals("intenso")) {
            System.out.println("Este perfume dura o dia todo!");
        } else if (intensidade.equals("moderado")) {
            System.out.println("Este perfume dura cerca de 6-8 horas");
        } else {
            System.out.println("Este perfume é mais suave, dura 4-6 horas");
        }
    }
}

// Classe principal para testar
public class TesteColecaoPerfumes {
    public static void main(String[] args) {
        
        // criando perfume feminino
        PerfumeFeminino perfume1 = new PerfumeFeminino("Gabriela Sabatini", "Gabriela Sabatini", 60, 89.90,
                                                      "Floral", false);
        
        // criando perfume masculino
        PerfumeMasculino perfume2 = new PerfumeMasculino("The One", "Dolce & Gabbana", 100, 299.90,
                                                        "intenso", false);
        
        // testando os perfumes
        perfume1.mostrarPerfume();
        perfume1.usarPerfume();
        perfume1.combinarComRoupa();
        System.out.println();
        
        perfume2.mostrarPerfume();
        perfume2.usarPerfume();
        perfume2.duracaoFragrancia();
        System.out.println();
        
        // exemplo de polimorfismo
        System.out.println("=== MINHA COLEÇÃO ===");
        Perfume perfume3 = new PerfumeFeminino("Miss Dior", "Dior", 50, 450.00, "Doce", true);
        Perfume perfume4 = new PerfumeMasculino("Invictus", "Paco Rabanne", 100, 280.00, "moderado", true);
        
        // array da coleção
        Perfume[] colecao = {perfume1, perfume2, perfume3, perfume4};
        
        double valorTotal = 0;
        for (Perfume perfume : colecao) {
            System.out.println("- " + perfume.getNome() + " (" + perfume.getMarca() + ") - R$ " + perfume.getPreco());
            perfume.usarPerfume();
            valorTotal += perfume.getPreco();
            System.out.println();
        }
        
        System.out.println("Valor total da coleção: R$ " + valorTotal);
        System.out.println("Quantidade de perfumes: " + colecao.length);
    }
}