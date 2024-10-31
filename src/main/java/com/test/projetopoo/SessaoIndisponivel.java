package projetopoo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class SessaoIndisponivel extends Sessao{
    private String motivoExclusaoSessao;
    
    public SessaoIndisponivel(int codigoSessao, LocalDate diaSessao, LocalTime horarioSessao, ArrayList<Sala> listaAssentos,
           double precoSessao, boolean comPromocao, double porcentagemPromocional, String motivoExclusaoSessao){
        super(codigoSessao, diaSessao, horarioSessao, listaAssentos, precoSessao, comPromocao, porcentagemPromocional);
        setMotivoExclusaoSessao(motivoExclusaoSessao);
    }
    
    public void setMotivoExclusaoSessao(String motivoExclusaoSessao){
        this.motivoExclusaoSessao = motivoExclusaoSessao;
    }
    public String getMotivoExclusaoSessao(String motivoExclusaoSessao){
        return this.motivoExclusaoSessao;
    }
}