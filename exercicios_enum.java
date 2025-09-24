// ========================================
// EXERCÍCIO 1 - DOCUMENTO
// ========================================

// Enum para tipos de documento
enum TipoDocumento {
    RG, CPF, CNPJ, CNH, PASSAPORTE
}

// Classe Documento
class Documento {
    private String numeroDoDocumento;
    private TipoDocumento tipo;
    
    // construtor
    public Documento(String numeroDoDocumento, TipoDocumento tipo) {
        this.numeroDoDocumento = numeroDoDocumento;
        this.tipo = tipo;
    }
    
    // getters
    public String getNumeroDoDocumento() {
        return numeroDoDocumento;
    }
    
    public TipoDocumento getTipo() {
        return tipo;
    }
    
    // setters
    public void setNumeroDoDocumento(String numeroDoDocumento) {
        this.numeroDoDocumento = numeroDoDocumento;
    }
    
    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }
    
    // metodo para mostrar os dados
    public void mostrarDocumento() {
        System.out.println("Tipo: " + tipo + " - Número: " + numeroDoDocumento);
    }
}

// Classe para testar o exercicio 1
class TesteDocumento {
    public static void main(String[] args) {
        System.out.println("=== TESTE DOCUMENTO ===");
        
        Documento doc1 = new Documento("123.456.789-10", TipoDocumento.CPF);
        Documento doc2 = new Documento("12.345.678-9", TipoDocumento.RG);
        Documento doc3 = new Documento("12.345.678/0001-90", TipoDocumento.CNPJ);
        
        doc1.mostrarDocumento();
        doc2.mostrarDocumento();
        doc3.mostrarDocumento();
    }
}

// ========================================
// FIM DO EXERCÍCIO 1
// ========================================


// ========================================
// EXERCÍCIO 2 - VEÍCULO
// ========================================

// Enum para tipos de veiculo
enum TipoVeiculo {
    CARRO, MOTO, CAMINHAO, ONIBUS, BICICLETA
}

// Classe Veiculo
class Veiculo {
    private String modelo;
    private Integer anoFabricacao;
    private TipoVeiculo tipo;
    
    // construtor
    public Veiculo(String modelo, Integer anoFabricacao, TipoVeiculo tipo) {
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
    }
    
    // getters
    public String getModelo() {
        return modelo;
    }
    
    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }
    
    public TipoVeiculo getTipo() {
        return tipo;
    }
    
    // setters
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
    
    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }
    
    // metodo para mostrar os dados
    public void mostrarVeiculo() {
        System.out.println("Tipo: " + tipo + " - Modelo: " + modelo + " - Ano: " + anoFabricacao);
    }
}

// Classe para testar o exercicio 2
class TesteVeiculo {
    public static void main(String[] args) {
        System.out.println("=== TESTE VEÍCULO ===");
        
        Veiculo v1 = new Veiculo("Civic", 2020, TipoVeiculo.CARRO);
        Veiculo v2 = new Veiculo("CB 600", 2019, TipoVeiculo.MOTO);
        Veiculo v3 = new Veiculo("Scania", 2018, TipoVeiculo.CAMINHAO);
        
        v1.mostrarVeiculo();
        v2.mostrarVeiculo();
        v3.mostrarVeiculo();
    }
}

// ========================================
// FIM DO EXERCÍCIO 2
// ========================================


// ========================================
// EXERCÍCIO 3 - ALUNO
// ========================================

// Enum para grau de escolaridade
enum GrauEscolaridade {
    FUNDAMENTAL, MEDIO, SUPERIOR, POS_GRADUACAO, MESTRADO, DOUTORADO
}

// Classe Aluno
class Aluno {
    private String nome;
    private Integer idade;
    private GrauEscolaridade escolaridade;
    
    // construtor
    public Aluno(String nome, Integer idade, GrauEscolaridade escolaridade) {
        this.nome = nome;
        this.idade = idade;
        this.escolaridade = escolaridade;
    }
    
    // getters
    public String getNome() {
        return nome;
    }
    
    public Integer getIdade() {
        return idade;
    }
    
    public GrauEscolaridade getEscolaridade() {
        return escolaridade;
    }
    
    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    public void setEscolaridade(GrauEscolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }
    
    // metodo para mostrar os dados
    public void mostrarAluno() {
        System.out.println("Nome: " + nome + " - Idade: " + idade + " - Escolaridade: " + escolaridade);
    }
}

// Classe para testar o exercicio 3
class TesteAluno {
    public static void main(String[] args) {
        System.out.println("=== TESTE ALUNO ===");
        
        Aluno a1 = new Aluno("João", 15, GrauEscolaridade.FUNDAMENTAL);
        Aluno a2 = new Aluno("Maria", 17, GrauEscolaridade.MEDIO);
        Aluno a3 = new Aluno("Pedro", 22, GrauEscolaridade.SUPERIOR);
        
        a1.mostrarAluno();
        a2.mostrarAluno();
        a3.mostrarAluno();
    }
}

// ========================================
// FIM DO EXERCÍCIO 3
// ========================================