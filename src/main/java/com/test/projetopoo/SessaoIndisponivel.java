package main.java.com.test.projetopoo;
import java.time.LocalDateTime;

public class SessaoIndisponivel extends Sessao{
	
    private static String motivoExclusaoSessao;
    
    public SessaoIndisponivel(LocalDateTime diaHorarioSessao, double precoSessao, boolean comPromocao, double porcentagemPromocional, Sala salaSessao, Filme filmeSessao, String motivoExclusaoSessao){
        super(diaHorarioSessao, precoSessao, comPromocao, porcentagemPromocional, salaSessao, filmeSessao);
        setMotivoExclusaoSessao(motivoExclusaoSessao);
    }
    
    public static void setMotivoExclusaoSessao(String motivoExclusaoSessao){
    	SessaoIndisponivel.motivoExclusaoSessao = motivoExclusaoSessao;
    }
    public static String getMotivoExclusaoSessao(){
        return SessaoIndisponivel.motivoExclusaoSessao;
    }
}
