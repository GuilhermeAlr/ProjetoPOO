package main.java.com.test.projetopoo;

import java.time.LocalDate;
import java.time.LocalTime;
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
    public boolean adicionarFilme(Filme filme) {
        
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
    
    // métodos para adicionar, editar e remover sala
    public boolean adicionarSala(Sala sala) {
        for (Sala s : cinema.getListaSalas()) {
            if (s.getNroSala() == sala.getNroSala()){
                return false;
            }
        }
        cinema.getListaSalas().add(sala);
        return true;
    }
    
    public boolean editarSala(int nroSala, int nroSalaNovo, int nroAssentoNovo, boolean tipoTelaNovo){
        for (Sala s : cinema.getListaSalas()) {
            if (s.getNroSala() == nroSala){
                if (nroSalaNovo != 0) {
                    s.setNroSala(nroSalaNovo);
                }
                else if (nroAssentoNovo != -1) {
                    s.setNroAssentos(nroAssentoNovo);
                }
                //0 = false / 1 = true
                else if (tipoTelaNovo != true) { 
                    s.setTipoTela(tipoTelaNovo);
                }
                else if (tipoTelaNovo != false) { 
                    s.setTipoTela(tipoTelaNovo);
                }
                return true;    
            }
        }
        System.out.println("Sala não encontrada");
        return false;
    }
    
    public boolean removerSala(int nroSala) {
        for (Sala s : cinema.getListaSalas()) {
            if (s.getNroSala() == nroSala) {
                cinema.getListaSalas().remove(s);
                return true;
            }
        }
        return false;
    }
    
    // métodos para adicionar, editar e remover sala
    public boolean adicionarSessao(Sessao sessao) {
        for (Sessao s : cinema.getListaSessoes()) {
            if (s.getCodigoSessao() == sessao.getCodigoSessao()){
                return false;
            }
        }
        cinema.getListaSessoes().add(sessao);
        return true;
    }
    
    public static void imprimeListaSessoes(Cinema cinema) {     
        for (Sessao s : cinema.getListaSessoes()) {
            if (!(s instanceof SessaoIndisponivel)) {
                System.out.println(s.toString());
            }
        }
    }
    
    public boolean removerSessao(Sessao sessao, int codigoSessao, String motivoExclusaoSessao) {
        for (Sessao s : cinema.getListaSessoes()) {
            if (s.getCodigoSessao() == sessao.getCodigoSessao() && !(s instanceof SessaoIndisponivel)) {
                int index = cinema.getListaSessoes().indexOf(s);
               
                SessaoIndisponivel sessaoIndisponivel = new SessaoIndisponivel(s.getCodigoSessao(),s.getDiaSessao(), s.getHorarioSessao(), s.getListaAssentos(),
                                                        s.getPrecoSessao(), s.getComPromocao(), s.getPorcentagemPromocional(), s.getSalaSessao(), s.getFilmeSessao(), motivoExclusaoSessao);
                cinema.getListaSessoes().set(index, sessaoIndisponivel);
                
                System.out.println("Sessao " + codigoSessao + " removido com sucesso");
                return true;
            }
        }
        
        System.out.println("Filme não encontrado");
        return false;
    
    }
    
    public boolean editarSessao(int codigoSessao, int codigoSesaoNovo, LocalDate diaSessaoNovo, LocalTime horarioSessaoNovo, 
            int quantAssentosNovo, double precoSessaoNovo, Boolean comPromocaoNovo, double porcentagemPromocionalNovo, 
            Sala salaSessaoNovo, Filme filmeSessaoNovo){
        for (Sessao s : cinema.getListaSessoes()) {
            if (s.getCodigoSessao() == codigoSessao){
                if (codigoSesaoNovo != 0) {
                    s.setCodigoSessao(codigoSesaoNovo);
                }
                else if (!diaSessaoNovo.isEqual(LocalDate.of(1500, 1, 1))) {
                    s.setDiaSessao(diaSessaoNovo);
                }
                else if (!horarioSessaoNovo.equals(LocalTime.of(23, 59))) { 
                     s.setHorarioSessao(horarioSessaoNovo);
                }
                else if (quantAssentosNovo != -1) { 
                     Boolean[] assentosSala = new Boolean[quantAssentosNovo];
                     for (int i = 0; i < assentosSala.length; i++) assentosSala[i] = false;
                     s.setListaAssentos(assentosSala);
                }
                else if (precoSessaoNovo != -1) { 
                     s.setPrecoSessao(precoSessaoNovo);
                }
                else if (porcentagemPromocionalNovo != -1) { 
                     s.setPorcentagemPromocional(porcentagemPromocionalNovo);
                }
                else if (salaSessaoNovo != s.getSalaSessao()) { 
                     s.setSalaSessao(salaSessaoNovo);
                }
                else if (filmeSessaoNovo != s.getFilmeSessao()) { 
                     s.setFilmeSessao(filmeSessaoNovo);
                }
                else if (comPromocaoNovo != true) { 
                     s.setComPromocao(comPromocaoNovo);
                }
                else if (comPromocaoNovo != false) { 
                     s.setComPromocao(comPromocaoNovo);
                }
                return true;    
            }
        }
        System.out.println("Sala não encontrada");
        return false;
    }
}
