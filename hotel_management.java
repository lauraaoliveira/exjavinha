import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

// Classe para representar um cliente
class Cliente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    
    // construtor
    public Cliente(String nome, String cpf, LocalDate dataNascimento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }
    
    // getters
    public String getNome() {
        return nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    // metodo para mostrar os dados do cliente
    public void mostrarDados() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de Nascimento: " + dataNascimento.format(formatter));
        System.out.println("Telefone: " + telefone);
    }
}

// Classe para representar uma reserva
class Reserva {
    private Cliente cliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    
    public Reserva(Cliente cliente, LocalDate dataEntrada, LocalDate dataSaida) {
        this.cliente = cliente;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }
    
    // getters
    public Cliente getCliente() {
        return cliente;
    }
    
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }
    
    public LocalDate getDataSaida() {
        return dataSaida;
    }
    
    // calcula quantos dias de estadia
    public long calcularDiasEstadia() {
        return ChronoUnit.DAYS.between(dataEntrada, dataSaida);
    }
    
    // mostra os dados da reserva
    public void mostrarReserva() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n=== DADOS DA RESERVA ===");
        cliente.mostrarDados();
        System.out.println("Data de Entrada: " + dataEntrada.format(formatter));
        System.out.println("Data de Saída: " + dataSaida.format(formatter));
        System.out.println("Total de dias: " + calcularDiasEstadia());
    }
}

// Classe principal do sistema
public class SistemaHotel {
    
    // metodo para validar as datas da reserva
    public static boolean validarDatas(LocalDate dataEntrada, LocalDate dataSaida) {
        LocalDate hoje = LocalDate.now();
        
        // verifica se data de entrada é depois de hoje
        if (!dataEntrada.isAfter(hoje)) {
            System.out.println("Erro: A data de entrada deve ser posterior à data atual!");
            return false;
        }
        
        // verifica se data de saida é depois da entrada
        if (!dataSaida.isAfter(dataEntrada)) {
            System.out.println("Erro: A data de saída deve ser posterior à data de entrada!");
            return false;
        }
        
        // calcula quantos dias
        long dias = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
        if (dias > 10) {
            System.out.println("Erro: O período máximo de estadia é de 10 dias!");
            return false;
        }
        
        return true;
    }
    
    // metodo main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("*** SISTEMA DE GERENCIAMENTO DE HOTEL ***\n");
        
        // coleta dados do cliente
        System.out.println("=== CADASTRO DO CLIENTE ===");
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String dataNascStr = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascStr, formatter);
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        Cliente cliente = new Cliente(nome, cpf, dataNascimento, telefone);
        
        // coleta dados da reserva
        System.out.println("\n=== DADOS DA RESERVA ===");
        System.out.print("Data de entrada (dd/MM/yyyy): ");
        String dataEntradaStr = scanner.nextLine();
        LocalDate dataEntrada = LocalDate.parse(dataEntradaStr, formatter);
        
        System.out.print("Data de saída (dd/MM/yyyy): ");
        String dataSaidaStr = scanner.nextLine();
        LocalDate dataSaida = LocalDate.parse(dataSaidaStr, formatter);
        
        // valida as datas
        if (validarDatas(dataEntrada, dataSaida)) {
            Reserva reserva = new Reserva(cliente, dataEntrada, dataSaida);
            System.out.println("\n*** RESERVA CONFIRMADA ***");
            reserva.mostrarReserva();
        } else {
            System.out.println("Reserva não pode ser criada devido aos erros acima.");
        }
        
        scanner.close();
    }
}