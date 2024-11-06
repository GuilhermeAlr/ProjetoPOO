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
    
    // construtor da classe Sessao
    public Sessao(int codigoSessao, LocalDate diaSessao, LocalTime horarioSessao, double precoSessao, Boolean comPromocao, double porcentagemPromocional, Sala salaSessao, Filme filmeSessao){
        setCodigoSessao(codigoSessao);
        setDiaSessao(diaSessao);
        setHorarioSessao(horarioSessao);
        setListaAssentos(salaSessao.getNroAssentos() + 1); // a lista de assentos começa em 1 e vai ate nro de assentos da sala
        setPrecoSessao(precoSessao);
        setComPromocao(comPromocao); 
        setPorcentagemPromocional(porcentagemPromocional);
        setSalaSessao(salaSessao);
        setFilmeSessao(filmeSessao);
    }

    // metodo para reservar o lugar
    public void reservarAssento(int nroAssento){
            this.listaAssentos[nroAssento] = true;
    }

    // metodo que retorna se o assento esta disponivel ou nao
    public Boolean getDisponibilidadeAssento(int nroAssento) {
        return this.listaAssentos[nroAssento];
    }

    public void imprimeListaAssentos(){
        String assento = "";
        
        for (int i = 1; i < getListaAssentos().length; i++) {
            if (listaAssentos[i]) {
                assento += "[X] ";
            } else {
                assento += "[" + i + "] "; 
            }
            
            //quebra a linha a cada 10 assentos
            if (i % 10 == 0) {
                assento += "\n"; 
            }
        }

        System.out.println(assento);
    }

    // metodo que retorna o nro de assentos disponiveis
    public int getAssentosDisponiveis() {
        int nroAssentosDisponiveis = 0;

        for (int i = 1; i < listaAssentos.length; i++) {
            if (getDisponibilidadeAssento(i) == false) {
                nroAssentosDisponiveis++;
            } 
        }

        return nroAssentosDisponiveis;
    }

    // get e set codigoSessao
    public void setCodigoSessao(int codigoSessao){
        this.codigoSessao = codigoSessao;
    }

    public int getCodigoSessao(){
        return this.codigoSessao;
    }
    
    // get e set diaSessao
    public void setDiaSessao(LocalDate diaSessao){
        this.diaSessao = diaSessao;
    }

    public LocalDate getDiaSessao(){
        return this.diaSessao;
    }
    
    // get e set horarioSessao
    public void setHorarioSessao(LocalTime horarioSessao){
        this.horarioSessao = horarioSessao;
    }

    public LocalTime getHorarioSessao(){
        return this.horarioSessao;
    }
    
    // get e set arrayAssentos
    public void setListaAssentos(int nroAssentos){
        listaAssentos = new Boolean[nroAssentos];
        for (int i = 1; i < listaAssentos.length; i++) { // colocando assentos como indisponiveis
            listaAssentos[i] = false;
        }
    }

    public Boolean[] getListaAssentos(){
        return this.listaAssentos;
    }
    
    // get e set precoSessao
    public void setPrecoSessao(double precoSessao){
        this.precoSessao = precoSessao;
    }

    public double getPrecoSessao(){
        return this.precoSessao;
    }
    
    // get e set comPromocao
    public void setComPromocao(Boolean comPromocao){
        this.comPromocao = comPromocao;
    }
    public boolean getComPromocao(){
        return this.comPromocao;
    }
    
    // get e set porcentagemPromocional
    public void setPorcentagemPromocional(double porcentagemPromocional){
        this.porcentagemPromocional = porcentagemPromocional;
    }
    public double getPorcentagemPromocional(){
        return  this.porcentagemPromocional;
    }
    
    // get e set salaSessao
    public void setSalaSessao(Sala salaSessao) {
        this.salaSessao = salaSessao;
    }

    public Sala getSalaSessao() {
        return this.salaSessao;
    }
    
    // get e set filmeSessao
    public void setFilmeSessao(Filme filmeSessao) {
        this.filmeSessao = filmeSessao;
    }
    public Filme getFilmeSessao() {
        return this.filmeSessao;
    }

    @Override
    public String toString() {
        String precoString = "";
        String promocaoString = "";

        if (comPromocao == true) {
            precoString = "- Preco Original: " + getPrecoSessao() + 
                        "\n- Preco da Meia-Entrada: " + getPrecoSessao()/2.0 + 
                        "\n- Preco Promocional: " + (getPrecoSessao() * (1 - porcentagemPromocional)) + 
                        "\n- Preco para Assinantes: " + getPrecoSessao() * 0.7;
            promocaoString = "- Possui Promocao: Sim (%" + (porcentagemPromocional * 100) + ")"; 
        }
        else if (comPromocao == false) {
            precoString = "- Preco Original: " + getPrecoSessao() + 
                        "\n- Preco da Meia-Entrada: " + getPrecoSessao()/2.0 + 
                        "\n- Preco para Assinantes: " + getPrecoSessao() * 0.7;
            promocaoString = "- Possui Promocao: Nao";
        }
        return "Sessao: " + getCodigoSessao() + 
               "\n- Filme: " + filmeSessao.getNomeFilme() + 
               "\n- Sala: " + salaSessao.getNroSala() +
               "\n- Dia: " + diaSessao +
               "\n- Horario: " + horarioSessao +
               "\n" + promocaoString +
               "\n" + precoString +
               "\n- Assentos Disponiveis: " + getAssentosDisponiveis() + "/" + (listaAssentos.length - 1);
    }
}
