package main.java.com.test.projetopoo;
import java.time.LocalDate;
import java.time.LocalTime;

public class SessaoIndisponivel extends Sessao{
	
    private static String motivoExclusaoSessao;
    
    public SessaoIndisponivel(int codigoSessao, LocalDate diaSessao, LocalTime horarioSessao, double precoSessao, boolean comPromocao, double porcentagemPromocional, Sala salaSessao, Filme filmeSessao, String motivoExclusaoSessao){
        super(codigoSessao, diaSessao, horarioSessao, precoSessao, comPromocao, porcentagemPromocional, salaSessao, filmeSessao);
        setMotivoExclusaoSessao(motivoExclusaoSessao);
    }
    
    public static void setMotivoExclusaoSessao(String motivoExclusaoSessao){
    	SessaoIndisponivel.motivoExclusaoSessao = motivoExclusaoSessao;
    }
    public static String getMotivoExclusaoSessao(){
        return SessaoIndisponivel.motivoExclusaoSessao;
    }
}
