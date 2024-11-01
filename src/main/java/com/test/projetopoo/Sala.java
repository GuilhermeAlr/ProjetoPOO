package main.java.com.test.projetopoo;

public class Sala {
    private int nroSala;
    private int nroAssentos;
    private boolean tipoTela; //2D = false ou 3D = true 
    
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
        return nroSala;
    }
    
    //Get e Set: nroAssentos
    public void setNroAssentos(int nroAssentos){
        this.nroAssentos = nroAssentos;
    }
    
    public int getNroAssentos(){
        return nroAssentos;
    }
   
    //Get e Set: tipoTela
    public void setTipoTela(boolean tipoTela){
        this.tipoTela = tipoTela;
    }

    public boolean getTipoTela(){
        return tipoTela;
    }
    
    //só para testar
    public void exibirInformacoes() {
        System.out.println("Numero da Sala: " + nroSala);
        System.out.println(tipoTela ? "Tipo da Tela: 2D" : "Tipo da Tela: 3D");
        System.out.println("Quantidade de Lugares: " + nroAssentos);
    }
    
}