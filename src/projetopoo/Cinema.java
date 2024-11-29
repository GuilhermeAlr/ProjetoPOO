package projetopoo;
import java.util.ArrayList;

/** A classe Cinema armazena um objeto Cinema, que contém
 *  uma lista de filmes, salas e sessões.
 *  
 *  @author IsabelaAoki
 *  @see Filme
 *  @see Sala
 *  @see Sessao
 */

public class Cinema {
    private String nomeCinema;
    private ArrayList<Filme> listaFilmes;
    private ArrayList<Sala> listaSalas;
    private ArrayList<Sessao> listaSessoes;

    /** Construtor da classe Cinema
     *  Inicializa os ArrayList de filme, salas, e sessões.
     * 
     *  @param nomeCinema o nome do cinema.
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
     * @param nomeCinema o novo nome do cinema.
     */
    public void setNomeCinema(String nomeCinema) {
        this.nomeCinema = nomeCinema;
    }
    
    /**
     * Obtêm o nome do cinema.
     * 
     * @return <code>String</code> do nomeCinema
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
     * @return <code>ArrayList</code> contendo as salas cadastrados.
     */
    public ArrayList<Sala> getListaSalas() {
        return this.listaSalas;
    }
    
    /**
     * Obtêm a lista de sessões do cinema.
     * 
     * @return <code>ArrayList</code> contendo as sessões cadastrados.
     */
    public ArrayList<Sessao> getListaSessoes() {
        return this.listaSessoes;
    }

}
