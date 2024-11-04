package main.java.com.test.projetopoo;

public class SalaIndisponivel extends Sala {
    private String motivoExclusaoSala;
    
    public SalaIndisponivel(int nroSala, int nroAssentos, boolean tipoTela, String motivoExclusaoSala){
        super(nroSala, nroAssentos, tipoTela);
        setMotivoExclusaoSala(motivoExclusaoSala);
    }
    
    public void setMotivoExclusaoSala(String motivoExclusaoSala){
        this.motivoExclusaoSala = motivoExclusaoSala;
    }
    public String getMotivoExclusaoSala(String motivoExclusaoSala){
        return this.motivoExclusaoSala;
    }
}
