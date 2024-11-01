package main.java.com.test.projetopoo;
import java.time.LocalDate;
import java.time.LocalTime;

public class SessaoIndisponivel extends Sessao{
    private String motivoExclusaoSessao;
    
    public SessaoIndisponivel(int codigoSessao, LocalDate diaSessao, LocalTime horarioSessao, Boolean[] arrayAssentos, double precoSessao, boolean comPromocao, double porcentagemPromocional, Sala salaSessao, Filme filmeSessao, String motivoExclusaoSessao){
        super(codigoSessao, diaSessao, horarioSessao, arrayAssentos, precoSessao, comPromocao, porcentagemPromocional, salaSessao, filmeSessao);
        setMotivoExclusaoSessao(motivoExclusaoSessao);
    }
    
    public void setMotivoExclusaoSessao(String motivoExclusaoSessao){
        this.motivoExclusaoSessao = motivoExclusaoSessao;
    }
    public String getMotivoExclusaoSessao(String motivoExclusaoSessao){
        return this.motivoExclusaoSessao;
    }
}