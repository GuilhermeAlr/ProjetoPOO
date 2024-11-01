package main.java.com.test.projetopoo;

import java.util.ArrayList;

public class Gerente extends Pessoa{
    private Cinema cinema;
    private ArrayList<Usuario> arrayUsuarios = new ArrayList<>();

    public Gerente(String nome, String login, String senha, Cinema cinema, ArrayList<Usuario> arrayUsuarios) {
        super(nome, login, senha);
        setCinema(cinema);;
        setArrayUsuarios(arrayUsuarios);;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public void setArrayUsuarios(ArrayList<Usuario> arrayUsuarios) {
        this.arrayUsuarios = arrayUsuarios;
    }

    public ArrayList<Usuario> getArrayUsuarios() {
        return this.arrayUsuarios;
    }
    
    // metodos para adicionar, editar e indisponibilizar filme
    public boolean adicionaFilme(String nomeFilme, String sinopseFilme, int classificacaoFilme, String generoFilme, int duracaoFilme) {
        
        for (Filme f : cinema.getListaFilmes()) {
            if (f.getNomeFilme().equals(nomeFilme)) {
                return false;
            }
        }
        
        cinema.getListaFilmes().add(new Filme(nomeFilme, sinopseFilme, classificacaoFilme, generoFilme, duracaoFilme));
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
                else if (classificacaoNova != -1) { // int n aceita null e estamos usando um valor 0, ent usaremos de -1
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

	//Métodos para adicionar, editar e excluir promoções para uma sessão 
    public void criarPromocao(Sessao sessao, double descontoPromocao) {
    	sessao.setPrecoSessaoOriginal(sessao.getPrecoSessao());
    	sessao.setPrecoSessao(sessao.getPrecoSessao()*descontoPromocao);
    	sessao.setPromocao(true); 
    }
    
    public Boolean excluirPromocao(Sessao sessao) {
    	if(sessao.getPromocao()) {
    		sessao.setPrecoSessao(sessao.getPrecoSessaoOriginal());
    		sessao.setPromocao(false); 
    		return true;
    	}
    	else {
            return false; 
        }
    }
    
    public Boolean editarPromocao(Sessao sessao, double descontoPromocao) {
    	if(sessao.getPromocao()) {
    		sessao.setPrecoSessao(sessao.getPrecoSessaoOriginal());
    		sessao.setPrecoSessao(sessao.getPrecoSessao()*descontoPromocao);
        	return true; 
    	}	
    	else {
            return false; 
        }
    }

}
