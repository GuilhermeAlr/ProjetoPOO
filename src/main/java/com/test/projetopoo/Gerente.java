package main.java.com.test.projetopoo;

import java.util.ArrayList;

public class Gerente extends Pessoa{
    private Cinema cinema;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public Gerente(String nomeGerente, String loginGerente, String senhaGerente, Cinema cinema, ArrayList<Usuario> listaUsuarios) {
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
    public boolean adicionaFilme(Filme filme) {
        
        for (Filme f : cinema.getListaFilmes()) {
            if (f.getNomeFilme().equalsIgnoreCase(filme.getNomeFilme())) {
                return false;
            }
        }
        
        cinema.getListaFilmes().add(filme);
        return true;
        
    }

    public boolean editarFilme(String nomeFilme, String nomeNovo, String sinopseNova, int classificacaoNova, String generoNovo, int duracaoNova) {
        
        for (Filme f : cinema.getListaFilmes()) {
            if (f.getNomeFilme().equalsIgnoreCase(nomeFilme)) {
                if (!nomeNovo.equals("")) {
                    f.setNomeFilme(nomeNovo);
                }
                else if (!sinopseNova.equals("")) {
                    f.setSinopseFilme(sinopseNova);
                }
                else if (classificacaoNova != -1) { 
                    f.setClassificacaoFilme(classificacaoNova);
                }
                else if (!generoNovo.equals("")) {
                    f.setGeneroFilme(generoNovo);
                }
                else if (duracaoNova != -1) {
                    f.setDuracaoFilme(duracaoNova);
                }
                return true;
            }
        }
        
        System.out.println("Filme não encontrado");
        return false;
    }
    
    public boolean removerFilme(String nomeFilme, String motivoExclusaoFilme) {
        
        for (Filme f : cinema.getListaFilmes()) {
            if (f.getNomeFilme().equalsIgnoreCase(nomeFilme) && !(f instanceof FilmeIndisponivel)) {
                int index = cinema.getListaFilmes().indexOf(f);
               
                FilmeIndisponivel filmeIndisponivel = new FilmeIndisponivel(f.getNomeFilme(), f.getSinopseFilme(), f.getClassificacaoFilme(), f.getGeneroFilme(), f.getDuracaoFilme(), motivoExclusaoFilme);
                cinema.getListaFilmes().set(index, filmeIndisponivel);
                
                System.out.println("Filme " + nomeFilme + " removido com sucesso");
                return true;
            }
        }
        
        System.out.println("Filme não encontrado");
        return false;
        
    }

	// métodos para adicionar, editar e excluir promoções para uma sessão 
    public boolean criarPromocao(Sessao sessao, double porcentagemPromocional) {
        if (!(sessao.getComPromocao())) {
            sessao.setComPromocao(true);
            sessao.setPorcentagemPromocional(porcentagemPromocional);
            return true;
        } 
        else {
            return false;
        }
        
    }

    public boolean editarPromocao(Sessao sessao, double porcentagemPromocional) {
    	if(sessao.getComPromocao()) {
    		sessao.setPorcentagemPromocional(porcentagemPromocional);
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
