import java.util.ArrayList;
import java.util.List;

// Classe Artista
class Artista {
    private String nomeArtista;
    private String nacionalidade;
    private String estiloMusical;
    
    // construtor
    public Artista(String nomeArtista, String nacionalidade, String estiloMusical) {
        this.nomeArtista = nomeArtista;
        this.nacionalidade = nacionalidade;
        this.estiloMusical = estiloMusical;
    }
    
    // getters
    public String getNomeArtista() {
        return nomeArtista;
    }
    
    public String getNacionalidade() {
        return nacionalidade;
    }
    
    public String getEstiloMusical() {
        return estiloMusical;
    }
    
    // setters
    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }
    
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    
    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }
    
    // metodo para mostrar artista
    public void mostrarArtista() {
        System.out.println("Artista: " + nomeArtista);
        System.out.println("Nacionalidade: " + nacionalidade);
        System.out.println("Estilo Musical: " + estiloMusical);
    }
}

// Classe Musica
class Musica {
    private String nomeMusica;
    private int tempoDuracao; // em segundos
    
    // construtor
    public Musica(String nomeMusica, int tempoDuracao) {
        this.nomeMusica = nomeMusica;
        this.tempoDuracao = tempoDuracao;
    }
    
    // getters
    public String getNomeMusica() {
        return nomeMusica;
    }
    
    public int getTempoDuracao() {
        return tempoDuracao;
    }
    
    // setters
    public void setNomeMusica(String nomeMusica) {
        this.nomeMusica = nomeMusica;
    }
    
    public void setTempoDuracao(int tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }
    
    // metodo para converter segundos em minutos:segundos
    public String getDuracaoFormatada() {
        int minutos = tempoDuracao / 60;
        int segundos = tempoDuracao % 60;
        return minutos + ":" + String.format("%02d", segundos);
    }
    
    // metodo para mostrar musica
    public void mostrarMusica() {
        System.out.println("♪ " + nomeMusica + " - " + getDuracaoFormatada());
    }
}

// Classe Album
class Album {
    private String nomeAlbum;
    private int anoLancamento;
    private Artista artista;
    private List<Musica> listaMusicas;
    private String nomeGravadora;
    
    // construtor
    public Album(String nomeAlbum, int anoLancamento, Artista artista, String nomeGravadora) {
        this.nomeAlbum = nomeAlbum;
        this.anoLancamento = anoLancamento;
        this.artista = artista;
        this.nomeGravadora = nomeGravadora;
        this.listaMusicas = new ArrayList<>();
    }
    
    // getters
    public String getNomeAlbum() {
        return nomeAlbum;
    }
    
    public int getAnoLancamento() {
        return anoLancamento;
    }
    
    public Artista getArtista() {
        return artista;
    }
    
    public List<Musica> getListaMusicas() {
        return listaMusicas;
    }
    
    public String getNomeGravadora() {
        return nomeGravadora;
    }
    
    // setters
    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }
    
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    public void setNomeGravadora(String nomeGravadora) {
        this.nomeGravadora = nomeGravadora;
    }
    
    // metodo para adicionar musica na lista
    public void adicionarMusica(Musica musica) {
        listaMusicas.add(musica);
    }
    
    // metodo para remover musica da lista
    public void removerMusica(Musica musica) {
        listaMusicas.remove(musica);
    }
    
    // metodo para calcular duracao total do album
    public int calcularDuracaoTotal() {
        int totalSegundos = 0;
        for (Musica musica : listaMusicas) {
            totalSegundos += musica.getTempoDuracao();
        }
        return totalSegundos;
    }
    
    // metodo para formatar duracao total
    public String getDuracaoTotalFormatada() {
        int total = calcularDuracaoTotal();
        int minutos = total / 60;
        int segundos = total % 60;
        return minutos + ":" + String.format("%02d", segundos);
    }
    
    // metodo para mostrar album completo
    public void mostrarAlbum() {
        System.out.println("============================");
        System.out.println("ÁLBUM: " + nomeAlbum);
        System.out.println("Ano: " + anoLancamento);
        System.out.println("Gravadora: " + nomeGravadora);
        System.out.println("============================");
        
        // mostrar dados do artista
        artista.mostrarArtista();
        
        System.out.println("\n--- LISTA DE MÚSICAS ---");
        if (listaMusicas.isEmpty()) {
            System.out.println("Nenhuma música cadastrada.");
        } else {
            for (int i = 0; i < listaMusicas.size(); i++) {
                System.out.print((i + 1) + ". ");
                listaMusicas.get(i).mostrarMusica();
            }
            System.out.println("\nDuração total: " + getDuracaoTotalFormatada());
            System.out.println("Total de faixas: " + listaMusicas.size());
        }
        System.out.println("============================");
    }
}

// Classe principal para testar
public class TesteSistemaAlbum {
    public static void main(String[] args) {
        
        // criando artista
        Artista artista1 = new Artista("Ed Sheeran", "Inglês", "Pop/Folk");
        
        // criando album
        Album album1 = new Album("÷ (Divide)", 2017, artista1, "Atlantic Records");
        
        // criando musicas
        Musica musica1 = new Musica("Shape of You", 233); // 3:53
        Musica musica2 = new Musica("Castle on the Hill", 261); // 4:21
        Musica musica3 = new Musica("Thinking Out Loud", 281); // 4:41
        Musica musica4 = new Musica("Perfect", 263); // 4:23
        Musica musica5 = new Musica("Galway Girl", 170); // 2:50
        
        // adicionando musicas no album
        album1.adicionarMusica(musica1);
        album1.adicionarMusica(musica2);
        album1.adicionarMusica(musica3);
        album1.adicionarMusica(musica4);
        album1.adicionarMusica(musica5);
        
        // mostrando album completo
        album1.mostrarAlbum();
        
        System.out.println("\n");
        
        // testando com outro artista/album
        Artista artista2 = new Artista("Charlie Brown Jr.", "Brasileiro", "Rock/Reggae");
        Album album2 = new Album("Transpiração Contínua Prolongada", 1997, artista2, "Chaos");
        
        Musica musica6 = new Musica("Proibida pra Mim", 195);
        Musica musica7 = new Musica("Quinta-Feira", 180);
        Musica musica8 = new Musica("Confisco", 165);
        
        album2.adicionarMusica(musica6);
        album2.adicionarMusica(musica7);
        album2.adicionarMusica(musica8);
        
        album2.mostrarAlbum();
    }
}