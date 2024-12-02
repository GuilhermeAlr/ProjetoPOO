package projetopoo;

/** A classe Filme representa um objeto filme com suas características, 
 *  que contém nome, sinopse, classificação, genêro e duração.
 * 
 *  @author Isabela Aoki
 *  @since 1.0
 */

public class Filme {
    private String nomeFilme;
    private String sinopseFilme;
    private int classificacaoFilme;
    private String generoFilme;
    private int duracaoFilme;

    /** Construtor da classe Filme. 
     * 
     *  Inicializa a classe filme com suas características.
     * 
     *  @param nomeFilme Nome do filme.
     *  @param sinopseFilme Sinopse do filme.
     *  @param classificacaoFilme Classificação do filme (0, 10, 12, 14, 16, 18).
     *  @param generoFilme Gênero do filme.
     *  @param duracaoFilme Duração do filme (em minutos).
     */
    public Filme (String nomeFilme, String sinopseFilme, int classificacaoFilme, String generoFilme, int duracaoFilme) {
        setNomeFilme(nomeFilme);
        setSinopseFilme(sinopseFilme);
        setClassificacaoFilme(classificacaoFilme);
        setGeneroFilme(generoFilme);
        setDuracaoFilme(duracaoFilme);
    }
    
    /** 
     * Muda o nome do filme.
     * 
     * @param nomeFilme Novo nome do filme.
     */
    public final void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }
    
    /**
     * Obtêm o nome do filme.
     * 
     * @return <code>String</code> Nome do filme.
     */
    public String getNomeFilme() {
        return this.nomeFilme;
    }

    /** 
     * Muda a sinopse do filme.
     * 
     * @param sinopseFilme Nova sinopse do filme.
     */
    public final void setSinopseFilme(String sinopseFilme) {
        this.sinopseFilme = sinopseFilme;
    }

    /**
     * Obtêm a sinopse do filme.
     * 
     * @return <code>String</code> Sinopse do filme.
     */
    public String getSinopseFilme() {
        return this.sinopseFilme;
    }
    
    /** 
     * Muda a classificação do filme.
     * <p> 
     * Caso a nova classificação não for uma opção válida 
     * (0, 10, 12, 14, 16, 18), ela será alterada para 0. 
     * </p>
     * 
     * @param classificacaoFilme Nova classificação do filme.
     */
    public final void setClassificacaoFilme(int classificacaoFilme) {
        switch(classificacaoFilme) {
            case 0, 10, 12, 14, 16, 18 -> this.classificacaoFilme = classificacaoFilme;
            default -> { this.classificacaoFilme = 0;
            }
        }
    }
    
    /**
     * Obtêm a classificação do filme.
     * 
     * @return <code>integer</code> Classificação do filme.
     */
    public int getClassificacaoFilme() {
        return this.classificacaoFilme;
    }

    /** 
     * Muda o gênero do filme.
     * 
     * @param generoFilme Novo gênero do filme.
     */
    public final void setGeneroFilme(String generoFilme) {
        this.generoFilme = generoFilme;
    }

    /**
     * Obtêm o gênero do filme.
     * 
     * @return <code>String</code> Gênero do filme.
     */
    public String getGeneroFilme() {
        return this.generoFilme;
    }

    /** 
     * Muda a duração do filme.
     * 
     * @param duracaoFilme Nova duração do filme (em minutos).
     */
    public final void setDuracaoFilme(int duracaoFilme) {
        this.duracaoFilme = duracaoFilme;
    }

    /**
     * Obtêm a duração do filme.
     * 
     * @return <code>integer</code> Duração do filme (em minutos).
     */
    public int getDuracaoFilme() {
        return this.duracaoFilme;
    }
    
    /**
     * Retorna uma representação em string do filme. 
     * 
     * @return <code>String</code> Informações detalhadas sobre o filme e suas características. 
     */
    @Override
    public String toString() {
        return "Filme: " + getNomeFilme() + 
                " | " + (getClassificacaoFilme() == 0 ? "Livre" : getClassificacaoFilme()) + 
                " | " + getGeneroFilme() + 
                " | " + getDuracaoFilme() + "m" + "\n" +
                "- Sinopse: " + getSinopseFilme();
    }

}