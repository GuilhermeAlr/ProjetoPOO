package main.java.com.test.projetopoo;
import java.time.LocalDate;
import java.time.LocalTime;

public class Sessao{
    private int codigoSessao;
    private LocalDate diaSessao; 
    private LocalTime horarioSessao;
    private boolean[] listaAssentos;
    private double precoSessao;
    private boolean comPromocao;
    private double porcentagemPromocional;
    private Sala sala;
    private Filme filme;
    private int nroAssento;
    
    //Construtor da classe Sessao
    public Sessao(int codigoSessao, LocalDate diaSessao, LocalTime horarioSessao, boolean[] listaAssentos, double precoSessao, boolean comPromocao, double porcentagemPromocional, Sala sala, Filme filme, int nroAssento){
        setCodigoSessao(codigoSessao);
        setDiaSessao(diaSessao);
        setHorarioSessao(horarioSessao);
        setListaAssentos(listaAssentos);
        setPrecoSessao(precoSessao);
        setComPromocao(comPromocao);
        setPorcentagemPromocional(porcentagemPromocional);
        setSalaSessao(sala);
        setFilmeSessao(filme);
        setNroAssento(nroAssento);
    }
    
    //Get e Set: codigoSessao
    public void setCodigoSessao(int codigoSessao){
        this.codigoSessao = codigoSessao;
    }

    public int getCodigoSessao(){
        return codigoSessao;
    }
    
    //Get e Set: diaSessao
    public void setDiaSessao(LocalDate diaSessao){
        this.diaSessao = diaSessao;
    }

    public LocalDate getDiaSessao(){
        return diaSessao;
    }
    
    //Get e Set: horarioSessao
    public void setHorarioSessao(LocalTime horarioSessao){
        this.horarioSessao = horarioSessao;
    }

    public LocalTime getHorarioSessao(){
        return horarioSessao;
    }
    
    //Get e Set: arrayAssentos
    public void setListaAssentos(boolean[] arrayAssentos){
        this.listaAssentos = arrayAssentos;
    }

    public boolean[] getListaAssentos(){
        return listaAssentos;
    }
    
    //Get e Set: precoSessao
    public void setPrecoSessao(double precoSessao){
        this.precoSessao = precoSessao;
    }

    public double getPrecoSessao(){
        return this.precoSessao;
    }
    
    //Get e Set: comPromocao
    public void setComPromocao(boolean comPromocao){
        this.comPromocao = comPromocao;
    }
    public boolean getComPromocao(){
        return this.comPromocao;
    }
    
    //Get e Set: porcentagemPromocional
    public void setPorcentagemPromocional(double porcentagemPromocional){
        this.porcentagemPromocional = porcentagemPromocional;
    }
    public double getPorcentagemPromocional(){
        return  porcentagemPromocional;
    }
    
    //Get e Set: Sala
    public void setSalaSessao(Sala sala) {
        this.sala = sala;
    }

    public Sala getSalaSessao() {
        return this.sala;
    }
    
    //Get e Set: Filme
    public void setFilmeSessao(Filme filme) {
        this.filme = filme;
    }
    public Filme getFilmeSessao() {
        return this.filme;
    }
    
    //Get e Set: nroAssento
    public void setNroAssento(int nroAssento){
        this.nroAssento = nroAssento;
    }
    public int getNroAssento(){
        return nroAssento;
    }
    
    //Metodo reservar o lugar
    public void reservarLugar(boolean[] listaAssentos, int lugarReservado){
        this.listaAssentos[lugarReservado] = true;
    }
}