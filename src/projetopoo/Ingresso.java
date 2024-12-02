package projetopoo;

/** A classe Ingresso representa um objeto ingresso 
 *  de uma sessão de cinema e suas características.
 *  
 *  <p>
 *  A classe possui uma {@link Sessao} específica associada a ela e contêm informações
 *  do número do assento e o preço do ingresso.
 *  </p>
 * 
 *  @author Isabela Aoki
 *  @since 1.0
 *  @see Sessao
 */

public class Ingresso {
    private Sessao sessao;
    private int nroAssento;
    private double precoIngresso;
    
    /** Construtor da classe Ingresso. 
     * 
     *  Inicializa um objeto ingresso com uma sessão, o número do assento e o preço do ingresso.
     * 
     *  @param sessao Sessão associada ao ingresso.
     *  @param nroAssento Número do assento.
     *  @param precoIngresso Preço do ingresso no momento em que foi comprado.
     */
    public Ingresso(Sessao sessao, int nroAssento, double precoIngresso) {
        setSessao(sessao);
        setNroAssento(nroAssento);
        setPrecoIngresso(precoIngresso);
    }

    /** 
     * Muda a sessão do ingresso.
     * 
     * @param sessao Nova sessão associada ao ingresso.
     */
    public final void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    
    /**
     * Obtêm a sessão do ingresso.
     * 
     * @return <code>Sessao</code> Sessão associada ao ingresso.
     */
    public Sessao getSessao() {
        return this.sessao;
    } 
    
    /**
     * Muda o número do assento.
     * 
     * @param nroAssento Novo número do assento.
     */
    public final void setNroAssento(int nroAssento) {
        this.nroAssento = nroAssento;
    }
    
    /**
     * Obtêm o número do assento do ingresso.
     * 
     * @return <code>integer</code> Número do assento. 
     */
    public int getNroAssento() {
        return this.nroAssento;
    }
    
    /**
     * Muda o preço do ingresso.
     * 
     * @param precoIngresso Novo preço do ingresso.
     */
    public final void setPrecoIngresso(double precoIngresso) {
        this.precoIngresso = precoIngresso;
    }
    
    /**
     * Obtêm o preço do ingresso.
     * 
     * @return <code>double</code> Preço do ingresso. 
     */
    public double getPrecoIngresso() {
        return this.precoIngresso;
    }
    
    /**
     * Retorna uma representação em string do ingresso.
     * 
     * <p>
     * A representação inclui informações do ingresso, como o filme, data e sala, as quais são características de sessão.
     * Além disso, inclui o número do assento e preço do ingresso.
     * </p>
     * 
     * @return <code>String</code> Informações detalhadas sobre o ingresso. 
     */
    @Override
    public String toString() {
        return "- Filme: " + sessao.getFilmeSessao().getNomeFilme() + 
               " | Data: " + sessao.getDiaSessao() + " " + sessao.getHorarioSessao() + 
               " | Sala: " + sessao.getSalaSessao().getNroSala() + 
               " | Poltrona: " + getNroAssento() + 
               " | Preço: R$" + getPrecoIngresso();
    }
    
}