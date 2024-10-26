package main.java.com.test.projetopoo;

public class FilmeIndisponivel extends Filme {
    private String motivoExclusaoFilme;
    
    public FilmeIndisponivel(String nomeFilme, String sinopseFilme, int classificacaoFilme, String generoFilme, int duracaoFilme, String motivoExclusaoFilme) {
        super(nomeFilme, sinopseFilme, classificacaoFilme, generoFilme, duracaoFilme);
        setMotivoExclusaoFilme(motivoExclusaoFilme);
    }
    
    public void setMotivoExclusaoFilme(String motivoExclusaoFilme) {
        this.motivoExclusaoFilme = motivoExclusaoFilme;
    }
    
    public String getMotivoExclusaoFilme(String motivoExclusaoFilme) {
        return this.motivoExclusaoFilme;
    }
}
