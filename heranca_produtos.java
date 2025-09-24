// Classe pai Produto
class Produto {
    protected String nomeProduto;
    protected double valorProduto;
    protected String codigoProduto;
    
    // construtor
    public Produto(String nomeProduto, double valorProduto, String codigoProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.codigoProduto = codigoProduto;
    }
    
    // getters
    public String getNomeProduto() {
        return nomeProduto;
    }
    
    public double getValorProduto() {
        return valorProduto;
    }
    
    public String getCodigoProduto() {
        return codigoProduto;
    }
    
    // setters
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
    
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    
    // metodo para mostrar dados do produto
    public void mostrarProduto() {
        System.out.println("Nome: " + nomeProduto);
        System.out.println("Valor: R$ " + valorProduto);
        System.out.println("Código: " + codigoProduto);
    }
    
    // metodo que pode ser sobrescrito
    public void calcularDesconto(double porcentagem) {
        double desconto = valorProduto * (porcentagem / 100);
        double valorComDesconto = valorProduto - desconto;
        System.out.println("Valor original: R$ " + valorProduto);
        System.out.println("Desconto: " + porcentagem + "% (R$ " + desconto + ")");
        System.out.println("Valor com desconto: R$ " + valorComDesconto);
    }
}

// Classe filha Livro
class Livro extends Produto {
    private String autor;
    private int quantidadePaginas;
    private String editora;
    
    // construtor
    public Livro(String nomeProduto, double valorProduto, String codigoProduto,
                String autor, int quantidadePaginas, String editora) {
        super(nomeProduto, valorProduto, codigoProduto);
        this.autor = autor;
        this.quantidadePaginas = quantidadePaginas;
        this.editora = editora;
    }
    
    // getters especificos do livro
    public String getAutor() {
        return autor;
    }
    
    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }
    
    public String getEditora() {
        return editora;
    }
    
    // setters especificos do livro
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }
    
    public void setEditora(String editora) {
        this.editora = editora;
    }
    
    // sobrescrevendo o metodo da classe pai
    @Override
    public void mostrarProduto() {
        System.out.println("=== DADOS DO LIVRO ===");
        super.mostrarProduto(); // chama metodo da classe pai
        System.out.println("Autor: " + autor);
        System.out.println("Páginas: " + quantidadePaginas);
        System.out.println("Editora: " + editora);
    }
    
    // metodo especifico do livro
    public void informarGenero() {
        // logica simples baseada no numero de paginas
        if (quantidadePaginas < 100) {
            System.out.println("Este parece ser um livro infantil ou de contos");
        } else if (quantidadePaginas < 300) {
            System.out.println("Este parece ser um romance ou ficção");
        } else {
            System.out.println("Este parece ser um livro técnico ou épico");
        }
    }
}

// Classe filha CD
class CD extends Produto {
    private String nomeArtista;
    private int quantidadeMusicas;
    private String gravadora;
    
    // construtor
    public CD(String nomeProduto, double valorProduto, String codigoProduto,
             String nomeArtista, int quantidadeMusicas, String gravadora) {
        super(nomeProduto, valorProduto, codigoProduto);
        this.nomeArtista = nomeArtista;
        this.quantidadeMusicas = quantidadeMusicas;
        this.gravadora = gravadora;
    }
    
    // getters especificos do CD
    public String getNomeArtista() {
        return nomeArtista;
    }
    
    public int getQuantidadeMusicas() {
        return quantidadeMusicas;
    }
    
    public String getGravadora() {
        return gravadora;
    }
    
    // setters especificos do CD
    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }
    
    public void setQuantidadeMusicas(int quantidadeMusicas) {
        this.quantidadeMusicas = quantidadeMusicas;
    }
    
    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }
    
    // sobrescrevendo o metodo da classe pai
    @Override
    public void mostrarProduto() {
        System.out.println("=== DADOS DO CD ===");
        super.mostrarProduto(); // chama metodo da classe pai
        System.out.println("Artista: " + nomeArtista);
        System.out.println("Quantidade de Músicas: " + quantidadeMusicas);
        System.out.println("Gravadora: " + gravadora);
    }
    
    // metodo especifico do CD
    public void informarTipoAlbum() {
        // logica simples baseada na quantidade de musicas
        if (quantidadeMusicas <= 5) {
            System.out.println("Este é um EP (Extended Play)");
        } else if (quantidadeMusicas <= 12) {
            System.out.println("Este é um álbum padrão");
        } else {
            System.out.println("Este é um álbum duplo ou coletânea");
        }
    }
    
    // sobrescrevendo o metodo calcularDesconto para CD
    @Override
    public void calcularDesconto(double porcentagem) {
        System.out.println("Desconto especial para CDs!");
        // CD sempre tem desconto extra de 5%
        double descontoExtra = porcentagem + 5;
        super.calcularDesconto(descontoExtra);
    }
}

// Classe principal para testar
public class TesteProdutos {
    public static void main(String[] args) {
        
        // criando um livro
        Livro livro1 = new Livro("O Senhor dos Anéis", 89.90, "LIV001", 
                                 "J.R.R. Tolkien", 1200, "Martins Fontes");
        
        // criando um CD
        CD cd1 = new CD("Thriller", 45.90, "CD001", 
                       "Michael Jackson", 9, "Epic Records");
        
        // testando os objetos
        livro1.mostrarProduto();
        livro1.informarGenero();
        System.out.println();
        
        cd1.mostrarProduto();
        cd1.informarTipoAlbum();
        System.out.println();
        
        // testando desconto
        System.out.println("=== TESTANDO DESCONTO NO LIVRO ===");
        livro1.calcularDesconto(10);
        System.out.println();
        
        System.out.println("=== TESTANDO DESCONTO NO CD ===");
        cd1.calcularDesconto(15);
        System.out.println();
        
        // exemplo de polimorfismo
        System.out.println("=== POLIMORFISMO ===");
        Produto produto1 = new Livro("1984", 35.00, "LIV002", 
                                    "George Orwell", 250, "Companhia das Letras");
        Produto produto2 = new CD("Back in Black", 39.90, "CD002", 
                                 "AC/DC", 10, "Atlantic Records");
        
        // chamando metodos usando referencia da classe pai
        System.out.println("Produto 1:");
        produto1.mostrarProduto();
        produto1.calcularDesconto(20);
        System.out.println();
        
        System.out.println("Produto 2:");
        produto2.mostrarProduto();
        produto2.calcularDesconto(20);
        System.out.println();
        
        // array de produtos
        System.out.println("=== LOJA DE PRODUTOS ===");
        Produto[] estoque = {livro1, cd1, produto1, produto2};
        
        double valorTotal = 0;
        for (Produto produto : estoque) {
            System.out.println("- " + produto.getNomeProduto() + 
                             " (R$ " + produto.getValorProduto() + ")");
            valorTotal += produto.getValorProduto();
        }
        System.out.println("Valor total do estoque: R$ " + valorTotal);
    }
}