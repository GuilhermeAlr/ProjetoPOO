package main.java.com.test.projetopoo;
import java.time.LocalDate;
import java.time.LocalTime;

public class SessaoIndisponivel extends Sessao{
    private String motivoExclusaoSessao;
    
    public SessaoIndisponivel(int codigoSessao, LocalDate diaSessao, LocalTime horarioSessao, boolean[] listaAssentos, double precoSessao, boolean comPromocao, double porcentagemPromocional, Sala sala, Filme filme, int nroAssento, String motivoExclusaoSessao){
        super(codigoSessao, diaSessao, horarioSessao, listaAssentos, precoSessao, comPromocao, porcentagemPromocional, sala, filme, nroAssento);
        setMotivoExclusaoSessao(motivoExclusaoSessao);
    }
    
    public void setMotivoExclusaoSessao(String motivoExclusaoSessao){
        this.motivoExclusaoSessao = motivoExclusaoSessao;
    }
    public String getMotivoExclusaoSessao(String motivoExclusaoSessao){
        return this.motivoExclusaoSessao;
    }
}