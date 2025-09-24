// Classe pai Animal
class Animal {
    protected String nome;
    protected double comprimento;
    protected String cor;
    protected String ambiente;
    protected double velocidade;
    
    // construtor
    public Animal(String nome, double comprimento, String cor, String ambiente, double velocidade) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.cor = cor;
        this.ambiente = ambiente;
        this.velocidade = velocidade;
    }
    
    // getters
    public String getNome() {
        return nome;
    }
    
    public double getComprimento() {
        return comprimento;
    }
    
    public String getCor() {
        return cor;
    }
    
    public String getAmbiente() {
        return ambiente;
    }
    
    public double getVelocidade() {
        return velocidade;
    }
    
    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }
    
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
    
    // metodo para mostrar dados do animal
    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Comprimento: " + comprimento + " cm");
        System.out.println("Cor: " + cor);
        System.out.println("Ambiente: " + ambiente);
        System.out.println("Velocidade: " + velocidade + " km/h");
    }
    
    // metodo que pode ser sobrescrito (polimorfismo)
    public void emitirSom() {
        System.out.println(nome + " faz algum som...");
    }
    
    // metodo que pode ser sobrescrito
    public void mover() {
        System.out.println(nome + " está se movendo a " + velocidade + " km/h");
    }
}

// Classe filha Peixe
class Peixe extends Animal {
    private String tipoBarbatana;
    private String tipoCauda;
    
    // construtor
    public Peixe(String nome, double comprimento, String cor, String ambiente, 
                double velocidade, String tipoBarbatana, String tipoCauda) {
        super(nome, comprimento, cor, ambiente, velocidade);
        this.tipoBarbatana = tipoBarbatana;
        this.tipoCauda = tipoCauda;
    }
    
    // getters especificos do peixe
    public String getTipoBarbatana() {
        return tipoBarbatana;
    }
    
    public String getTipoCauda() {
        return tipoCauda;
    }
    
    // setters especificos do peixe
    public void setTipoBarbatana(String tipoBarbatana) {
        this.tipoBarbatana = tipoBarbatana;
    }
    
    public void setTipoCauda(String tipoCauda) {
        this.tipoCauda = tipoCauda;
    }
    
    // sobrescrevendo o metodo da classe pai (polimorfismo)
    @Override
    public void mostrarDados() {
        System.out.println("=== DADOS DO PEIXE ===");
        super.mostrarDados(); // chama o metodo da classe pai
        System.out.println("Tipo da Barbatana: " + tipoBarbatana);
        System.out.println("Tipo da Cauda: " + tipoCauda);
    }
    
    // sobrescrevendo metodo emitirSom
    @Override
    public void emitirSom() {
        System.out.println(nome + " faz blub blub blub...");
    }
    
    // sobrescrevendo metodo mover
    @Override
    public void mover() {
        System.out.println(nome + " está nadando a " + velocidade + " km/h");
    }
    
    // metodo especifico do peixe
    public void nadar() {
        System.out.println(nome + " está nadando no " + ambiente);
    }
}

// Classe filha Ave
class Ave extends Animal {
    private String tipoAsas;
    private int quantidadePatas;
    
    // construtor
    public Ave(String nome, double comprimento, String cor, String ambiente, 
              double velocidade, String tipoAsas, int quantidadePatas) {
        super(nome, comprimento, cor, ambiente, velocidade);
        this.tipoAsas = tipoAsas;
        this.quantidadePatas = quantidadePatas;
    }
    
    // getters especificos da ave
    public String getTipoAsas() {
        return tipoAsas;
    }
    
    public int getQuantidadePatas() {
        return quantidadePatas;
    }
    
    // setters especificos da ave
    public void setTipoAsas(String tipoAsas) {
        this.tipoAsas = tipoAsas;
    }
    
    public void setQuantidadePatas(int quantidadePatas) {
        this.quantidadePatas = quantidadePatas;
    }
    
    // sobrescrevendo o metodo da classe pai (polimorfismo)
    @Override
    public void mostrarDados() {
        System.out.println("=== DADOS DA AVE ===");
        super.mostrarDados(); // chama o metodo da classe pai
        System.out.println("Tipo das Asas: " + tipoAsas);
        System.out.println("Quantidade de Patas: " + quantidadePatas);
    }
    
    // sobrescrevendo metodo emitirSom
    @Override
    public void emitirSom() {
        System.out.println(nome + " canta piu piu piu...");
    }
    
    // sobrescrevendo metodo mover
    @Override
    public void mover() {
        System.out.println(nome + " está voando a " + velocidade + " km/h");
    }
    
    // metodo especifico da ave
    public void voar() {
        System.out.println(nome + " está voando no " + ambiente);
    }
}

// Classe principal para testar
public class TesteAnimais {
    public static void main(String[] args) {
        
        // criando um peixe
        Peixe peixe1 = new Peixe("Tubarão", 200.0, "Cinza", "Oceano", 50.0, "Triangular", "Falciforme");
        
        // criando uma ave  
        Ave ave1 = new Ave("Águia", 80.0, "Marrom", "Montanha", 120.0, "Longas e largas", 2);
        
        // testando os objetos
        peixe1.mostrarDados();
        peixe1.emitirSom();
        peixe1.mover();
        peixe1.nadar();
        
        System.out.println();
        
        ave1.mostrarDados();
        ave1.emitirSom();
        ave1.mover();
        ave1.voar();
        
        System.out.println();
        System.out.println("=== TESTANDO POLIMORFISMO ===");
        
        // exemplo de polimorfismo - referencia da classe pai apontando para objetos filhos
        Animal animal1 = new Peixe("Salmão", 60.0, "Rosa", "Rio", 30.0, "Arredondada", "Bifurcada");
        Animal animal2 = new Ave("Beija-flor", 10.0, "Verde", "Jardim", 80.0, "Pequenas e rápidas", 2);
        
        // chamando metodos - polimorfismo em acao
        System.out.println("Animal 1:");
        animal1.mostrarDados();
        animal1.emitirSom();
        animal1.mover();
        
        System.out.println();
        
        System.out.println("Animal 2:");
        animal2.mostrarDados();
        animal2.emitirSom();
        animal2.mover();
        
        // demonstrando que é possivel ter um array de animais diferentes
        System.out.println();
        System.out.println("=== ARRAY DE ANIMAIS ===");
        
        Animal[] zoologico = {peixe1, ave1, animal1, animal2};
        
        for (Animal animal : zoologico) {
            System.out.println("Animal: " + animal.getNome());
            animal.emitirSom();
            animal.mover();
            System.out.println("---");
        }
    }
}