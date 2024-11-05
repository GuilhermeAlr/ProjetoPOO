package main.java.com.test.projetopoo;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public boolean editarFilme(Filme filme, String nomeNovo, String sinopseNova, int classificacaoNova, String generoNovo, int duracaoNova) {
        if (!(filme instanceof FilmeIndisponivel)) {
            if (!nomeNovo.equals("")) {
                if (buscarFilme(nomeNovo) == null) { // checa se a pessoa esta modificando o nome de um filme para um que nao existe
                    filme.setNomeFilme(nomeNovo); 
                }
                else {
                    return false;
                }
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
        
        return true;
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
            if (f.getNomeFilme().equalsIgnoreCase(nomeFilme) && !(f instanceof FilmeIndisponivel)) {
                return f;
            }
        }
        
        return null;
        
    }

    // métodos para adicionar, editar e remover sala
    public boolean adicionarSala(Sala sala) {
        if (buscarSala(sala.getNroSala()) == null) {
            cinema.getListaSalas().add(sala);
            return true;
        }
        else {
            return false;
        }
        
    }
    
    public boolean editarSala(Sala sala, int nroSalaNovo, int nroAssentoNovo, Boolean tipoTelaNovo){
        if (nroSalaNovo != 0) {
            if (buscarSala(nroSalaNovo) == null) { // checa se a pessoa esta modificando o numero de uma sala para um que nao existe
                sala.setNroSala(nroSalaNovo);
            }
            else {
                return false;
            }
        }
        else if (nroAssentoNovo != -1) {
            sala.setNroAssentos(nroAssentoNovo);
        }
        else if (tipoTelaNovo != null) { 
            sala.setTipoTela(tipoTelaNovo);
        }
        return true;    
        
    }
    
    public boolean removerSala(int nroSala) {
        Sala sala = buscarSala(nroSala);

        if (sala != null) {
            cinema.getListaSalas().remove(sala);
            return true;
        }
        else {
            return false;
        }
    }

    public Sala buscarSala(int nroSala) {
        for (Sala s : cinema.getListaSalas()) {
            if (s.getNroSala() == nroSala) {
                return s;
            }
        }
        
        return null;
        
    }

    // metodos para adicionar, editar e remover sala
    public boolean adicionarSessao(Sessao sessao) {
        if (buscarSessao(sessao.getCodigoSessao()) == null) {
            cinema.getListaSessoes().add(sessao);
            return true;
        }
        else {
            return false;
        }
        
    }

    public boolean editarSessao(Sessao sessao, int codigoSesaoNovo, LocalDate diaSessaoNovo, LocalTime horarioSessaoNovo, double precoSessaoNovo, Boolean comPromocaoNovo, double porcentagemPromocionalNovo, Sala salaSessaoNovo, Filme filmeSessaoNovo) {
        
        if (codigoSesaoNovo != 0) {
            if (buscarSessao(codigoSesaoNovo) == null) { // checa se a pessoa esta modificando o codigo de uma sessao para um que nao existe
                sessao.setCodigoSessao(codigoSesaoNovo);
            }
            else {
                return false;
            }
        }
        else if (!diaSessaoNovo.isEqual(LocalDate.of(1500, 1, 1))) {
            sessao.setDiaSessao(diaSessaoNovo);
        }
        else if (!horarioSessaoNovo.equals(LocalTime.of(23, 59))) { 
            sessao.setHorarioSessao(horarioSessaoNovo);
        }
        else if (precoSessaoNovo != -1) { 
            sessao.setPrecoSessao(precoSessaoNovo);
        }
        else if (porcentagemPromocionalNovo != -1) { 
            sessao.setPorcentagemPromocional(porcentagemPromocionalNovo);
        }
        else if (salaSessaoNovo != sessao.getSalaSessao()) { 
            sessao.setSalaSessao(salaSessaoNovo);
        }
        else if (filmeSessaoNovo != sessao.getFilmeSessao()) { 
            sessao.setFilmeSessao(filmeSessaoNovo);
        }
        return true;    
    }


    public Sessao buscarSessao(int codigoSessao) {
        for (Sessao s : cinema.getListaSessoes()) {
            if (s.getCodigoSessao() == codigoSessao && !(s instanceof SessaoIndisponivel)) {
                return s;
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
