package projetopoo;

/** A classe FilmeIndisponivel representa um objeto filme, que está indisponível.
 * 
 *  <p>
 *  Essa classe herda de {@link Filme} e adiciona um motivo para a exclusão do filme. 
 *  </p>
 * 
 * @author Isabela Aoki
 * @since 1.0
 * @see Filme
 */

public class FilmeIndisponivel extends Filme {
    private static String motivoExclusaoFilme;
    
    /** Construtor da classe FilmeIndisponivel. 
     * 
     *  Inicializa um objeto filme com suas características e um motivo de sua exclusão.
     * 
     *  @param nomeFilme Nome do filme.
     *  @param sinopseFilme Sinopse do filme.
     *  @param classificacaoFilme Classificação do filme (0, 10, 12, 14, 16, 18).
     *  @param generoFilme Gênero do filme.
     *  @param duracaoFilme Duração do filme (em minutos).
     *  @param motivoExclusaoFilme Motivo da exclusão do filme.
     */
    public FilmeIndisponivel(String nomeFilme, String sinopseFilme, int classificacaoFilme, String generoFilme, int duracaoFilme, String motivoExclusaoFilme) {
        super(nomeFilme, sinopseFilme, classificacaoFilme, generoFilme, duracaoFilme);
        setMotivoExclusaoFilme(motivoExclusaoFilme);
    }
    
    /** 
     * Muda o motivo de exclusão do filme.
     * 
     * @param motivoExclusaoFilme Novo motivo de exclusão do filme.
     */
    public static void setMotivoExclusaoFilme(String motivoExclusaoFilme) {
    	FilmeIndisponivel.motivoExclusaoFilme = motivoExclusaoFilme;
    }
    
    /**
     * Obtém o motivo de exclusão do filme.
     * 
     * @return <code>String</code> Motivo de exclusão do filme.
     */
    public static String getMotivoExclusaoFilme() {
        return FilmeIndisponivel.motivoExclusaoFilme;
    }
    
}
