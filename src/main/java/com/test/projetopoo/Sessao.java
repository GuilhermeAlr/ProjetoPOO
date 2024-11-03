package projetopoo;
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
    public Sessao(int codigoSessao, LocalDate diaSessao, LocalTime horarioSessao, Boolean[] listaAssentos, double precoSessao, Boolean comPromocao, double porcentagemPromocional, Sala salaSessao, Filme filmeSessao){
        setCodigoSessao(codigoSessao);
        setDiaSessao(diaSessao);
        setHorarioSessao(horarioSessao);
        setListaAssentos(listaAssentos);
        setPrecoSessao(precoSessao);
        setComPromocao(comPromocao); 
        setPorcentagemPromocional(porcentagemPromocional);
        setSalaSessao(salaSessao);
        setFilmeSessao(filmeSessao);
    }

    public Boolean getDisponibilidadeAssento(int nroAssento) {
        return this.listaAssentos[nroAssento];
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
    public void setListaAssentos(Boolean[] listaAssentos){
        this.listaAssentos = listaAssentos;
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
    
    public String mostrarComPromocao(){
         return comPromocao ? "Sim" : "Nao";
    }
    
    //metodo para calcular a promocao com base na porcentagem prmocional
    public double calculoPromocao(double precoSessao, Boolean comPromocao, double porcentagemPromocional){
        if(comPromocao){
            double desconto = precoSessao * (porcentagemPromocional / 100);
            return precoSessao - desconto;
        }
        return precoSessao;
    }
    
    //metodo para pegar quantidade de assentos disponiveis (usar no relatorio das salas?)
    public int getQuantidadeAssentosDisponiveis() {
        int count = 0;
        for (Boolean assento : listaAssentos) {
            if (!assento) count++;
        }
        return count;
    }
    
    //metodo para reservar assento: [false] - [true]
    public void reservarAssento(int assentoReservado){
        this.listaAssentos[assentoReservado - 1] = true;
    }
    
    //metodo para exibir os assentos que nem em um cinema
    public String mostrarAssentos(){
        String assento = "";
            for (int i = 0; i < getListaAssentos().length; i++) {
                if (listaAssentos[i]) {
                    assento += "[X] ";
                } else {
                    assento += "[" + (i + 1) + "] "; 
                }
                //quebra a linha a cada 10 assentos
                if ((i + 1) % 10 == 0) {
                    assento += "\n"; 
                }
            }
    return assento;
    }
    
    @Override
    public String toString() {
        return "Sessao: " + getCodigoSessao() + 
               "\n| Data da Sessao: " + getDiaSessao() + 
               "\n| Horario da Sessao: " + getHorarioSessao() +
               "\n| Preco da Sessao: R$" + getPrecoSessao() +
               "\n| Com promocao: " + mostrarComPromocao() +
               "\n| Porcentagem Promocional: " + getPorcentagemPromocional() +
               "\n| Preco da Sessao com desconto: R$" + calculoPromocao(getPrecoSessao(), getComPromocao(), getPorcentagemPromocional()) +
               "\n| Lista de Assentos: \n" + mostrarAssentos() +
               "\nDetalhes do " + getFilmeSessao() +
               "\n\nDetalhes da " + getSalaSessao();
    }
}
