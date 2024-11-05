package main.java.com.test.projetopoo;
import java.time.LocalDate;
import java.time.LocalTime;

public class SessaoIndisponivel extends Sessao{
    private String motivoExclusaoSessao;
    
    public SessaoIndisponivel(int codigoSessao, LocalDate diaSessao, LocalTime horarioSessao, double precoSessao, boolean comPromocao, double porcentagemPromocional, Sala salaSessao, Filme filmeSessao, String motivoExclusaoSessao){
        super(codigoSessao, diaSessao, horarioSessao, precoSessao, comPromocao, porcentagemPromocional, salaSessao, filmeSessao);
        setMotivoExclusaoSessao(motivoExclusaoSessao);
    }
    
    public void setMotivoExclusaoSessao(String motivoExclusaoSessao){
        this.motivoExclusaoSessao = motivoExclusaoSessao;
    }
    public String getMotivoExclusaoSessao(){
        return this.motivoExclusaoSessao;
    }
    @Override
    public String toString() {
        String promocaoString = "";

        if (getComPromocao() == true) {
            promocaoString = "Sim (%" + getPorcentagemPromocional() + ")"; 
        }
        else if (getComPromocao() == false) {
            promocaoString = "Nao";
        }
        return "Sessao: " + getCodigoSessao() + 
               "\n- Filme: " + getFilmeSessao().getNomeFilme() + 
               "\n- Sala: " + getSalaSessao().getNroSala() +
               "\n- Dia: " + getDiaSessao() +
               "\n- Horario: " + getHorarioSessao() +
               "\n- Preco: " + getPrecoSessao() +
               "\n- Assentos Disponiveis: " + getAssentosDisponiveis() + "/" + getListaAssentos().length +
               "\n- Possui Promocao: " + promocaoString +
               "\n- Disponibilidade: Indisponivel" +
               "\n- Motiva da exclusao: " + getMotivoExclusaoSessao();

    }
}
