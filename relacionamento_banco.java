import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Classe Endereco
class Endereco {
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;
    
    // construtor
    public Endereco(String pais, String estado, String cidade, String bairro, 
                   String rua, String numero, String complemento) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
    
    // getters
    public String getPais() {
        return pais;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public String getRua() {
        return rua;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    // metodo para mostrar endereco
    public void mostrarEndereco() {
        System.out.println(rua + ", " + numero + " - " + bairro + " - " + cidade + "/" + estado + " - " + pais);
        if (complemento != null && !complemento.isEmpty()) {
            System.out.println("Complemento: " + complemento);
        }
    }
}

// Classe Documento
class Documento {
    private String tipoDocumento;
    private String numeroDocumento;
    private String orgaoExpedidor;
    
    // construtor
    public Documento(String tipoDocumento, String numeroDocumento, String orgaoExpedidor) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.orgaoExpedidor = orgaoExpedidor;
    }
    
    // getters
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    
    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }
    
    // metodo para mostrar documento
    public void mostrarDocumento() {
        System.out.println(tipoDocumento + ": " + numeroDocumento + " - " + orgaoExpedidor);
    }
}

// Classe Pessoa
class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Pessoa pai;
    private Pessoa mae;
    
    // construtor
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    // construtor com pai e mae
    public Pessoa(String nome, LocalDate dataNascimento, Pessoa pai, Pessoa mae) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.pai = pai;
        this.mae = mae;
    }
    
    // getters
    public String getNome() {
        return nome;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public Pessoa getPai() {
        return pai;
    }
    
    public Pessoa getMae() {
        return mae;
    }
    
    // setters para pai e mae
    public void setPai(Pessoa pai) {
        this.pai = pai;
    }
    
    public void setMae(Pessoa mae) {
        this.mae = mae;
    }
    
    // metodo para mostrar pessoa
    public void mostrarPessoa() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento.format(formatter));
        if (pai != null) {
            System.out.println("Pai: " + pai.getNome());
        }
        if (mae != null) {
            System.out.println("Mãe: " + mae.getNome());
        }
    }
}

// Classe Banco
class Banco {
    private String numeroBanco;
    private String nomeBanco;
    private String cnpj;
    
    // construtor
    public Banco(String numeroBanco, String nomeBanco, String cnpj) {
        this.numeroBanco = numeroBanco;
        this.nomeBanco = nomeBanco;
        this.cnpj = cnpj;
    }
    
    // getters
    public String getNumeroBanco() {
        return numeroBanco;
    }
    
    public String getNomeBanco() {
        return nomeBanco;
    }
    
    public String getCnpj() {
        return cnpj;
    }
    
    // metodo para mostrar banco
    public void mostrarBanco() {
        System.out.println("Banco: " + numeroBanco + " - " + nomeBanco + " (CNPJ: " + cnpj + ")");
    }
}

// Classe Agencia
class Agencia {
    private String numeroAgencia;
    private String nomeAgencia;
    private Endereco endereco;
    
    // construtor
    public Agencia(String numeroAgencia, String nomeAgencia, Endereco endereco) {
        this.numeroAgencia = numeroAgencia;
        this.nomeAgencia = nomeAgencia;
        this.endereco = endereco;
    }
    
    // getters
    public String getNumeroAgencia() {
        return numeroAgencia;
    }
    
    public String getNomeAgencia() {
        return nomeAgencia;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    // metodo para mostrar agencia
    public void mostrarAgencia() {
        System.out.println("Agência: " + numeroAgencia + " - " + nomeAgencia);
        System.out.print("Endereço: ");
        endereco.mostrarEndereco();
    }
}

// Classe Cliente
class Cliente {
    private Pessoa pessoa;
    private Documento documento;
    private Endereco endereco;
    private String telefoneContato;
    private String profissao;
    private double rendaMensal;
    
    // construtor
    public Cliente(Pessoa pessoa, Documento documento, Endereco endereco, 
                  String telefoneContato, String profissao, double rendaMensal) {
        this.pessoa = pessoa;
        this.documento = documento;
        this.endereco = endereco;
        this.telefoneContato = telefoneContato;
        this.profissao = profissao;
        this.rendaMensal = rendaMensal;
    }
    
    // getters
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public Documento getDocumento() {
        return documento;
    }
    
    public Endereco getEndereco() {
        return endereco;
    }
    
    public String getTelefoneContato() {
        return telefoneContato;
    }
    
    public String getProfissao() {
        return profissao;
    }
    
    public double getRendaMensal() {
        return rendaMensal;
    }
    
    // metodo para mostrar cliente
    public void mostrarCliente() {
        System.out.println("=== DADOS DO CLIENTE ===");
        pessoa.mostrarPessoa();
        System.out.print("Documento: ");
        documento.mostrarDocumento();
        System.out.print("Endereço: ");
        endereco.mostrarEndereco();
        System.out.println("Telefone: " + telefoneContato);
        System.out.println("Profissão: " + profissao);
        System.out.println("Renda Mensal: R$ " + rendaMensal);
    }
}

// Classe Conta
class Conta {
    private Banco banco;
    private Agencia agencia;
    private Cliente cliente;
    private String numeroConta;
    private double saldoConta;
    
    // construtor
    public Conta(Banco banco, Agencia agencia, Cliente cliente, String numeroConta, double saldoConta) {
        this.banco = banco;
        this.agencia = agencia;
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldoConta = saldoConta;
    }
    
    // getters
    public Banco getBanco() {
        return banco;
    }
    
    public Agencia getAgencia() {
        return agencia;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public String getNumeroConta() {
        return numeroConta;
    }
    
    public double getSaldoConta() {
        return saldoConta;
    }
    
    // setter para saldo
    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }
    
    // metodo para mostrar conta completa
    public void mostrarConta() {
        System.out.println("========== DADOS DA CONTA ==========");
        banco.mostrarBanco();
        agencia.mostrarAgencia();
        System.out.println("Número da Conta: " + numeroConta);
        System.out.println("Saldo: R$ " + saldoConta);
        System.out.println();
        cliente.mostrarCliente();
    }
}

// Classe principal para testar
public class TesteSistemaBanco {
    public static void main(String[] args) {
        
        // criando endereco
        Endereco endereco1 = new Endereco("Brasil", "SP", "São Paulo", "Centro", 
                                          "Rua das Flores", "123", "Apto 45");
        
        // criando documento
        Documento doc1 = new Documento("RG", "12.345.678-9", "SSP/SP");
        
        // criando pessoas (pai e mae)
        Pessoa pai = new Pessoa("João Silva", LocalDate.of(1960, 5, 15));
        Pessoa mae = new Pessoa("Maria Silva", LocalDate.of(1965, 8, 20));
        
        // criando pessoa principal
        Pessoa pessoa1 = new Pessoa("Carlos Silva", LocalDate.of(1990, 3, 10), pai, mae);
        
        // criando cliente
        Cliente cliente1 = new Cliente(pessoa1, doc1, endereco1, "(11) 99999-9999", 
                                      "Engenheiro", 8500.0);
        
        // criando banco
        Banco banco1 = new Banco("001", "Banco do Brasil", "00.000.000/0001-91");
        
        // criando endereco da agencia
        Endereco enderecoAgencia = new Endereco("Brasil", "SP", "São Paulo", "Centro", 
                                               "Av. Paulista", "1000", "");
        
        // criando agencia
        Agencia agencia1 = new Agencia("1234", "Agência Paulista", enderecoAgencia);
        
        // criando conta
        Conta conta1 = new Conta(banco1, agencia1, cliente1, "12345-6", 2500.50);
        
        // exibindo todas as informacoes
        conta1.mostrarConta();
    }
}