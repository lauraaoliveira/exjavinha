// Classe abstrata CorpoCeleste
abstract class CorpoCeleste {
    protected String nome;
    protected double massa;
    protected double distanciaDaTerra;
    
    // construtor
    public CorpoCeleste(String nome, double massa, double distanciaDaTerra) {
        this.nome = nome;
        this.massa = massa;
        this.distanciaDaTerra = distanciaDaTerra;
    }
    
    // getters
    public String getNome() {
        return nome;
    }
    
    public double getMassa() {
        return massa;
    }
    
    public double getDistanciaDaTerra() {
        return distanciaDaTerra;
    }
    
    // metodo abstrato que deve ser implementado pelas subclasses
    public abstract void exibirInformacoes();
}

// Subclasse Planeta
class Planeta extends CorpoCeleste {
    
    public Planeta(String nome, double massa, double distanciaDaTerra) {
        super(nome, massa, distanciaDaTerra);
    }
    
    // implementacao do metodo abstrato
    @Override
    public void exibirInformacoes() {
        System.out.println("O planeta " + this.nome + " tem massa " + this.massa + " kg e está a " + this.distanciaDaTerra + " km da Terra");
    }
}

// Subclasse Estrela
class Estrela extends CorpoCeleste {
    
    public Estrela(String nome, double massa, double distanciaDaTerra) {
        super(nome, massa, distanciaDaTerra);
    }
    
    // implementacao do metodo abstrato
    @Override
    public void exibirInformacoes() {
        System.out.println("A estrela " + this.nome + " tem massa " + this.massa + " kg e está a " + this.distanciaDaTerra + " km da Terra");
    }
}

// Classe principal para testar
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CORPOS CELESTES ===\n");
        
        // criando instancias de planetas
        Planeta marte = new Planeta("Marte", 6.42e23, 225000000);
        Planeta jupiter = new Planeta("Júpiter", 1.9e27, 628000000);
        
        // criando instancias de estrelas
        Estrela sol = new Estrela("Sol", 1.989e30, 149600000);
        Estrela proxima = new Estrela("Próxima Centauri", 2.44e29, 4.24e13);
        
        // exibindo informacoes dos planetas
        System.out.println("--- PLANETAS ---");
        marte.exibirInformacoes();
        jupiter.exibirInformacoes();
        
        System.out.println();
        
        // exibindo informacoes das estrelas
        System.out.println("--- ESTRELAS ---");
        sol.exibirInformacoes();
        proxima.exibirInformacoes();
    }
}