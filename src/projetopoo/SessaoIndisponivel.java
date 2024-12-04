package projetopoo;
import java.time.LocalDateTime;

public class SessaoIndisponivel extends Sessao{
	
    private static String motivoExclusaoSessao;
    
    public SessaoIndisponivel(int codigoSessao, LocalDateTime diaHorarioSessao, double precoSessao, boolean comPromocao, double porcentagemPromocional, Sala salaSessao, Filme filmeSessao, String motivoExclusaoSessao){
        super(codigoSessao, diaHorarioSessao, precoSessao, comPromocao, porcentagemPromocional, salaSessao, filmeSessao);
        setMotivoExclusaoSessao(motivoExclusaoSessao);
    }
    
    public static void setMotivoExclusaoSessao(String motivoExclusaoSessao){
    	SessaoIndisponivel.motivoExclusaoSessao = motivoExclusaoSessao;
    }
    public static String getMotivoExclusaoSessao(){
        return SessaoIndisponivel.motivoExclusaoSessao;
    }
}
