package main.java.com.test.projetopoo;
import java.time.LocalDate;
import java.time.LocalTime;

public class Sessao{
    private int codigoSessao;
    private LocalDate diaSessao; 
    private LocalTime horarioSessao;
    private Boolean[] listaAssentos;
    private double precoSessao;
    private Boolean comPromocao;
    private double porcentagemPromocional;
    private Sala salaSessao;
    private Filme filmeSessao;
    
    //Construtor da classe Sessao
    public Sessao(int codigoSessao, LocalDate diaSessao, LocalTime horarioSessao, double precoSessao, Boolean comPromocao, double porcentagemPromocional, Sala salaSessao, Filme filmeSessao){
        setCodigoSessao(codigoSessao);
        setDiaSessao(diaSessao);
        setHorarioSessao(horarioSessao);
        setListaAssentos(salaSessao.getNroAssentos());
        setPrecoSessao(precoSessao);
        setComPromocao(comPromocao); 
        setPorcentagemPromocional(porcentagemPromocional);
        setSalaSessao(salaSessao);
        setFilmeSessao(filmeSessao);
    }

    //Metodo reservar o lugar
    public void reservarAssento(int assentoReservado){
            this.listaAssentos[assentoReservado] = true;
    }

    public Boolean getDisponibilidadeAssento(int nroAssento) {
        return this.listaAssentos[nroAssento];
    }

    public int getAssentosDisponiveis() {
        int nroAssentosDisponiveis = 0;

        for (int i = 0; i < listaAssentos.length; i++) {
            if (getDisponibilidadeAssento(i) == false) {
                nroAssentosDisponiveis++;
            } 
        }

        return nroAssentosDisponiveis;
    }

    //Get e Set: codigoSessao
    public void setCodigoSessao(int codigoSessao){
        this.codigoSessao = codigoSessao;
    }

    public int getCodigoSessao(){
        return this.codigoSessao;
    }
    
    //Get e Set: diaSessao
    public void setDiaSessao(LocalDate diaSessao){
        this.diaSessao = diaSessao;
    }

    public LocalDate getDiaSessao(){
        return this.diaSessao;
    }
    
    //Get e Set: horarioSessao
    public void setHorarioSessao(LocalTime horarioSessao){
        this.horarioSessao = horarioSessao;
    }

    public LocalTime getHorarioSessao(){
        return this.horarioSessao;
    }
    
    //Get e Set: arrayAssentos
    public void setListaAssentos(int nroAssentos){
        listaAssentos = new Boolean[nroAssentos];
        for (int i = 0; i < listaAssentos.length; i++) { // colocando assentos como indisponiveis
            listaAssentos[i] = false;
        }
    }

    public Boolean[] getListaAssentos(){
        return this.listaAssentos;
    }
    
    //Get e Set: precoSessao
    public void setPrecoSessao(double precoSessao){
        this.precoSessao = precoSessao;
    }

    public double getPrecoSessao(){
        return this.precoSessao;
    }
    
    //Get e Set: comPromocao
    public void setComPromocao(Boolean comPromocao){
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
        return  this.porcentagemPromocional;
    }
    
    //Get e Set: Sala
    public void setSalaSessao(Sala salaSessao) {
        this.salaSessao = salaSessao;
    }

    public Sala getSalaSessao() {
        return this.salaSessao;
    }
    
    //Get e Set: Filme
    public void setFilmeSessao(Filme filmeSessao) {
        this.filmeSessao = filmeSessao;
    }
    public Filme getFilmeSessao() {
        return this.filmeSessao;
    }

    @Override
    public String toString() {
        String promocaoString = "";

        if (comPromocao == true) {
            promocaoString = "Sim (%" + porcentagemPromocional + ")"; 
        }
        else if (comPromocao == false) {
            promocaoString = "Nao";
        }
        return "Sessao: " + getCodigoSessao() + 
               "\n- Filme: " + filmeSessao.getNomeFilme() + 
               "\n- Sala: " + salaSessao.getNroSala() +
               "\n- Dia: " + diaSessao +
               "\n- Horario: " + horarioSessao +
               "\n- Preco: " + precoSessao +
               "\n- Assentos Disponiveis: " + getAssentosDisponiveis() + "/" + listaAssentos.length +
               "\n- Possui Promocao: " + promocaoString;

    }
}
