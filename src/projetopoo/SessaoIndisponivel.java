package projetopoo;
import java.time.LocalDateTime;

/** A classe SessaoIndisponivel representa uma sessão, que está indisponível no catálogo.
 * 
 *  <p>
 *  Essa classe herda de {@link Sessao} e adiciona um motivo para a exclusão da sessão. 
 *  </p>
 * 
 * @author Guilherme Almendro
 * @since 1.0
 * @see Sessao
 * @see java.time.LocalDateTime
 */

public class SessaoIndisponivel extends Sessao{
    private static String motivoExclusaoSessao;
    
    /** Construtor da classe SessaoIndisponivel.
     * 
     * Inicializa uma sessão indisponível com suas características de {@link Sessao} e um motivo de sua exclusão.
     * 
     * @param codigoSessao Código da sessão.
     * @param diaHorarioSessao Data e horário da sessão.
     * @param precoSessao Preço da sessão.
     * @param comPromocao Variável que indica se sessão possui (<code>true</code>) ou não promoção (<code>false</code>). 
     * @param porcentagemPromocional Porcentagem promocional entre 0 e 1.
     * @param salaSessao Sala onde será a sessão.
     * @param filmeSessao Filme exibido na sessão.
     * @param motivoExclusaoSessao Motivo da exclusão da sessão.
     */
    public SessaoIndisponivel(int codigoSessao, LocalDateTime diaHorarioSessao, double precoSessao, boolean comPromocao, double porcentagemPromocional, Sala salaSessao, Filme filmeSessao, String motivoExclusaoSessao){
        super(codigoSessao, diaHorarioSessao, precoSessao, comPromocao, porcentagemPromocional, salaSessao, filmeSessao);
        setMotivoExclusaoSessao(motivoExclusaoSessao);
    }
    
    /** 
     * Muda o motivo de exclusão da sessão.
     * 
     * @param motivoExclusaoSessao Novo motivo de exclusão da sessão.
     */
    public static void setMotivoExclusaoSessao(String motivoExclusaoSessao){
    	SessaoIndisponivel.motivoExclusaoSessao = motivoExclusaoSessao;
    }
    
    /**
     * Obtém o motivo de exclusão da sessão.
     * 
     * @return <code>String</code> Motivo de exclusão da sessão.
     */
    public static String getMotivoExclusaoSessao(){
        return SessaoIndisponivel.motivoExclusaoSessao;
    }
    
}
