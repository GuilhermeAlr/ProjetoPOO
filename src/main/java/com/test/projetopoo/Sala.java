package main.java.com.test.projetopoo;

public class Sala {
    private int nroSala;
    private int nroAssentos;
    private boolean tipoTela; // 2D = false ou 3D = true 
    
    public Sala(int nroSala, int nroAssentos, boolean tipoTela){
        setNroSala(nroSala);
        setNroAssentos(nroAssentos);
        setTipoTela(tipoTela);
    }
    
    //Get e Set: nroSala
    public void setNroSala(int nroSala){
        this.nroSala = nroSala;
    }

    public int getNroSala(){
        return this.nroSala;
    }
    
    //Get e Set: nroAssentos
    public void setNroAssentos(int nroAssentos){
        this.nroAssentos = nroAssentos;
    }
    
    public int getNroAssentos(){
        return this.nroAssentos;
    }
   
    //Get e Set: tipoTela
    public void setTipoTela(boolean tipoTela){
        this.tipoTela = tipoTela;
    }

    public boolean getTipoTela(){
        return this.tipoTela;
    }
    
    @Override
    public String toString() {
        return "Sala: " + getNroSala() + 
               "\n- Numero de Assento: " + getNroAssentos() + 
               "\n- Tipo de Tela: " + (this.tipoTela ? "3D" : "2D");
    }
    
}