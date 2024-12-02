package projetopoo;
import java.util.ArrayList;

/** A classe Cinema representa um objeto cinema, 
 *  que contém uma lista de filmes, salas e sessões.
 * 
 *  <p>
 *  Essa classe é usada para gerenciar as listas dinâmicas, 
 *  que são inicializadas vazias e preenchidas ao longo da execução do programa.
 *  </p>
 * 
 *  @author Isabela Aoki
 *  @since 1.0
 *  @see Filme
 *  @see Sala
 *  @see Sessao
 */

public class Cinema {
    private String nomeCinema;
    private ArrayList<Filme> listaFilmes;
    private ArrayList<Sala> listaSalas;
    private ArrayList<Sessao> listaSessoes;

    /** Construtor da classe Cinema. 
     * 
     *  Inicializa de forma vazia as listas de filme, salas, e sessões.
     * 
     *  @param nomeCinema Nome do cinema.
     */
    public Cinema(String nomeCinema) {
        this.nomeCinema = nomeCinema;
        listaFilmes = new ArrayList<>();
        listaSalas = new ArrayList<>();
        listaSessoes = new ArrayList<>();
    }

    /** 
     * Configura o nome do cinema.
     * 
     * @param nomeCinema Novo nome do cinema.
     */
    public void setNomeCinema(String nomeCinema) {
        this.nomeCinema = nomeCinema;
    }
    
    /**
     * Obtêm o nome do cinema.
     * 
     * @return <code>String</code> Nome do cinema.
     */
    public String getNomeCinema() {
        return this.nomeCinema;
    }

    /**
     * Obtêm a lista de filmes do cinema.
     * 
     * @return <code>ArrayList</code> contendo os filmes cadastrados.
     */
    public ArrayList<Filme> getListaFilmes() {
        return this.listaFilmes;
    }
    
    /**
     * Obtêm a lista de salas do cinema.
     * 
     * @return <code>ArrayList</code> contendo as salas cadastradas.
     */
    public ArrayList<Sala> getListaSalas() {
        return this.listaSalas;
    }
    
    /**
     * Obtêm a lista de sessões do cinema.
     * 
     * @return <code>ArrayList</code> contendo as sessões cadastradas.
     */
    public ArrayList<Sessao> getListaSessoes() {
        return this.listaSessoes;
    }

}