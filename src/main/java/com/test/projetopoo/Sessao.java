package projetopoo;
import java.util.ArrayList;
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
    private ArrayList<Sala> arraySala;
    private ArrayList<Filme> arrayFilme;
    private int nroAssento;
    
    //Construtor da classe Sessao
    public Sessao(int codigoSessao, LocalDate diaSessao, LocalTime horarioSessao, boolean[] listaAssentos, double precoSessao, boolean comPromocao, double porcentagemPromocional, ArrayList<Sala> arraySala, ArrayList<Filme> arrayfilme, int nroAssento){
        setCodigoSessao(codigoSessao);
        setDiaSessao(diaSessao);
        setHorarioSessao(horarioSessao);
        setListaAssentos(listaAssentos);
        setPrecoSessao(precoSessao);
        setComPromocao(comPromocao);
        setPorcentagemPromocional(porcentagemPromocional);
        setArraySala(arraySala);
        setArrayFilme(arrayFilme);
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
    public double setPrecoSessao(){
        return  precoSessao;
    }
    
    //Get e Set: comPromocao
    public void setComPromocao(boolean comPromocao){
        this.comPromocao = comPromocao;
    }
    public boolean getComPromocao(){
        return  comPromocao;
    }
    
    //Get e Set: porcentagemPromocional
    public void setPorcentagemPromocional(double porcentagemPromocional){
        this.porcentagemPromocional = porcentagemPromocional;
    }
    public double getPorcentagemPromocional(){
        return  porcentagemPromocional;
    }
    
    //Get e Set: Sala
    public void setArraySala(ArrayList<Sala> arraySala) {
        this.arraySala = arraySala;
    }
    public ArrayList<Sala> getArraySala() {
        return this.arraySala;
    }
    
    //Get e Set: Filme
    public void setArrayFilme(ArrayList<Filme> arrayFilme) {
        this.arrayFilme = arrayFilme;
    }
    public ArrayList<Filme> getArrayFilme() {
        return this.arrayFilme;
    }
    
    //Get e Set: nroAssento
    public void setNroAssento(int nroAssento){
        this.nroAssento = nroAssento;
    }
    public int getNroAssento(){
        return nroAssento;
    }
    
    //Metodo reservar o lugar
    //public void reservarLugar(boolean[] listaAssentos, int lugarReservado){
    //    this.listaAssentos[lugarReservado] = true;
    //}
}