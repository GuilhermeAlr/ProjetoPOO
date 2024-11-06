package main.java.com.test.projetopoo;

public class Ingresso {
    private Sessao sessao;
    private int nroAssento;
    private double precoIngresso;
    
    public Ingresso(Sessao sessao, int nroAssento, double precoIngresso) {
        setSessao(sessao);
        setNroAssento(nroAssento);;
        setPrecoIngresso(precoIngresso);;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    
    public Sessao getSessao() {
        return this.sessao;
    } 
    
    public void setNroAssento(int nroAssento) {
        this.nroAssento = nroAssento;
    }
    
    public int getNroAssento() {
        return this.nroAssento;
    }
    
    public void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }
    
    public double getPrecoIngresso() {
        return this.precoIngresso;
    }
    
    @Override
    public String toString() { // podemos mudar para adequar layout da main
        return "- Filme: " + sessao.getFilmeSessao().getNomeFilme() + 
               " | Data: " + sessao.getDiaSessao() + " " + sessao.getHorarioSessao() + 
               " | Sala: " + sessao.getSalaSessao().getNroSala() + 
               " | Poltrona: " + getNroAssento() + 
               " | Preço: " + getPrecoIngresso();
    }
}
