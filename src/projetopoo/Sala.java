package projetopoo;

/** A classe Sala representa uma sala de cinema com
 *  número da sala, número de asssentos e o tipo de tela.
 * 
 * @author Guilherme Almendro
 * @since 1.0
 */

public class Sala {
    private int nroSala;
    private int nroAssentos;
    private boolean tipoTela; // Tipo de tela: false = 2D, true = 3D. 
    
    /** Construtor da classe Sala.
     * 
     * Inicializa uma sala com suas características.
     * 
     * @param nroSala Número da sala.
     * @param nroAssentos Número de assentos da sala. 
     * @param tipoTela Tipo da tela da sala (false = 2D, true = 3D).
     */
    public Sala(int nroSala, int nroAssentos, boolean tipoTela){
        setNroSala(nroSala);
        setNroAssentos(nroAssentos);
        setTipoTela(tipoTela);
    }

    /** 
     * Muda o número da sala.
     * 
     * @param nroSala Novo número da sala.
     */
    public final void setNroSala(int nroSala){
        this.nroSala = nroSala;
    }

    /**
     * Obtém o número da sala.
     * 
     * @return <code>integer</code> Número da sala.
     */
    public int getNroSala(){
        return this.nroSala;
    }
    
    /** 
     * Muda o número de assentos da sala.
     * 
     * @param nroAssentos Novo número de assentos da sala.
     */
    public final void setNroAssentos(int nroAssentos){
        this.nroAssentos = nroAssentos;
    }
    
    /**
     * Obtém o número de assentos da sala.
     * 
     * @return <code>integer</code> Número de assentos da sala.
     */
    public int getNroAssentos(){
        return this.nroAssentos;
    }
   
    /** 
     * Muda o tipo de tela da sala, sendo que false = 2D e true = 3D.
     * 
     * @param tipoTela Novo tipo de tela.
     */
    public final void setTipoTela(boolean tipoTela){
        this.tipoTela = tipoTela;
    }

    /**
     * Obtém o tipo de tela da sala.
     * 
     * @return <code>boolean</code> Tipo de tela da sala.
     */
    public boolean getTipoTela(){
        return this.tipoTela;
    }
    
    /**
     * Retorna uma representação em string da sala. 
     * 
     * @return <code>String</code> Informações detalhadas sobre a sala e suas características. 
     */
    @Override
    public String toString() {
        return "Sala " + getNroSala() + 
               " | Numero de Assentos: " + getNroAssentos() + 
               " | Tipo de Tela: " + (this.tipoTela ? "3D" : "2D");
    }
    
}