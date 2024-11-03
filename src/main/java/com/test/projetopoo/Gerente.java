package main.java.com.test.projetopoo;

import java.util.ArrayList;

public class Gerente extends Pessoa{
    private Cinema cinema;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public Gerente(String nomeGerente, String loginGerente, String senhaGerente, Cinema cinema) {
        super(nomeGerente, loginGerente, senhaGerente);
        setCinema(cinema);
        setListaUsuarios(listaUsuarios);
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return this.listaUsuarios;
    }
    
    // metodos para adicionar, editar e remover filme
    public boolean adicionarFilme(Filme filme) {
        
        if (buscarFilme(filme.getNomeFilme()) == null) { // se nao encontra o filme
            cinema.getListaFilmes().add(filme);
            return true;
        }
        else {
            return false;
        }
        
    }

    public void editarFilme(Filme filme, String nomeNovo, String sinopseNova, int classificacaoNova, String generoNovo, int duracaoNova) {
        
        if (!(filme instanceof FilmeIndisponivel)) {
            if (!nomeNovo.equals("")) {
            filme.setNomeFilme(nomeNovo);
            }
            else if (!sinopseNova.equals("")) {
                filme.setSinopseFilme(sinopseNova);
            }
            else if (classificacaoNova != -1) { 
                filme.setClassificacaoFilme(classificacaoNova);
            }
            else if (!generoNovo.equals("")) {
                filme.setGeneroFilme(generoNovo);
            }
            else if (duracaoNova != -1) {
                filme.setDuracaoFilme(duracaoNova);
            }
        }
        
    }
    
    public boolean removerFilme(Filme filme, String motivoExclusaoFilme) {
        
        if (!(filme instanceof FilmeIndisponivel)) {
            int index = cinema.getListaFilmes().indexOf(filme);
            FilmeIndisponivel filmeIndisponivel = new FilmeIndisponivel(filme.getNomeFilme(), filme.getSinopseFilme(), filme.getClassificacaoFilme(), filme.getGeneroFilme(), filme.getDuracaoFilme(), motivoExclusaoFilme);
            cinema.getListaFilmes().set(index, filmeIndisponivel);

            return true;
        }
        
        else {
            return false;
        }
        
    }

    public Filme buscarFilme(String nomeFilme) {
        for (Filme f : cinema.getListaFilmes()) {
            if (f.getNomeFilme().equalsIgnoreCase(nomeFilme)) {
                return f;
            }
        }
        
        return null;
        
    }

	// métodos para adicionar, editar e excluir promoções para uma sessão 
    public boolean adicionarPromocao(Sessao sessao, double porcentagemPromocional) {
        if (!(sessao.getComPromocao())) {
            sessao.setComPromocao(true);
            sessao.setPorcentagemPromocional(porcentagemPromocional);
            return true;
        } 
        else {
            return false;
        }
        
    }

    public boolean editarPromocao(Sessao sessao, double porcentagemPromocionalNova) {
    	if(sessao.getComPromocao()) {
    		sessao.setPorcentagemPromocional(porcentagemPromocionalNova);
        	return true; 
    	}	
    	else {
            return false; 
        }
    }

    public boolean excluirPromocao(Sessao sessao) {
    	if(sessao.getComPromocao()) {
            sessao.setComPromocao(false); 
    		sessao.setPorcentagemPromocional(1);
    		return true;
    	}
    	else {
            return false; 
        }
    }    

}
