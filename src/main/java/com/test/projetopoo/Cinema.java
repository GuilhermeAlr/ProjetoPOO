package main.java.com.test.projetopoo;
import java.util.ArrayList;

public class Cinema {
    
    private String nomeCinema;
    private ArrayList<Filme> listaFilmes;
    private ArrayList<Sala> listaSalas;
    private ArrayList<Sessao> listaSessoes;

    public Cinema(String nomeCinema) {
        setNomeCinema(nomeCinema);
        listaFilmes = new ArrayList<>();
        listaSalas = new ArrayList<>();
        listaSessoes = new ArrayList<>();
    }

    public void setNomeCinema(String nomeCinema) {
        this.nomeCinema = nomeCinema;
    }
    
    public String getNomeCinema() {
        return this.nomeCinema;
    }

    public ArrayList<Filme> getListaFilmes() {
        return this.listaFilmes;
    }
    
    public ArrayList<Sala> getListaSalas() {
        return this.listaSalas;
    }
    
    public ArrayList<Sessao> getListaSessoes() {
        return this.listaSessoes;
    }

}
