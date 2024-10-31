package projetopoo;

public class Sala {
    private int nroSala;
    private int quantAssentos;
    private boolean tipoTela; //2D = false ou 3D = true 
    private boolean[] listaAssentos;
    
    public Sala(int nroSala, int quantAssentos, boolean tipoTela){
        setNroSala(nroSala);
        setQuantAssentos(quantAssentos);
        setTipoTela(tipoTela);
        setListaAssentos(quantAssentos);
    }
    
    //Get e Set: nroSala
    public void setNroSala(int nroSala){
        this.nroSala = nroSala;
    }
    public int getNroSala(){
        return nroSala;
    }
    
    //Get e Set: nroAssentos
    public void setQuantAssentos(int quantAssentos){
        this.quantAssentos = quantAssentos;
    }
    public int getQuantAssentos(){
        return quantAssentos;
    }
   
    //Get e Set: tipoTela
    public void setTipoTela(boolean tipoTela){
        this.tipoTela = tipoTela;
    }
    public boolean getTipoTela(){
        return tipoTela;
    }
    
    //Get e Set: listaAssentos
    public void setListaAssentos(int quantAssentos){
        this.listaAssentos = new boolean[quantAssentos];
    }
    public boolean[] getListaAssentos(){
        return listaAssentos;
    }
    
    //Metodo reservar o lugar
    public void reservarLugar(boolean[] listaAssentos, int lugarReservado){
        this.listaAssentos[lugarReservado] = true;
    }
    
    //só para testar
    public void exibirInformacoes() {
        System.out.println("Numero da Sala: " + nroSala);
        System.out.println(tipoTela ? "Tipo da Tela: 2D" : "Tipo da Tela: 3D");
        System.out.println("Quantidade de Lugares: " + quantAssentos);
        System.out.print("Status dos Lugares: ");
        for(boolean lugar : listaAssentos) {
            System.out.print(lugar ? "[Ocupado] " : "[Livre] ");
        }
        reservarLugar(listaAssentos, 5);
        System.out.println();
        for(boolean lugar : listaAssentos) {
            System.out.print(lugar ? "[Ocupado] " : "[Livre] ");
        }
    }
    
}