package main.java.com.test.projetopoo;

public class FilmeIndisponivel extends Filme {
    private static String motivoExclusaoFilme;
    
    public FilmeIndisponivel(String nomeFilme, String sinopseFilme, int classificacaoFilme, String generoFilme, int duracaoFilme, String motivoExclusaoFilme) {
        super(nomeFilme, sinopseFilme, classificacaoFilme, generoFilme, duracaoFilme);
        setMotivoExclusaoFilme(motivoExclusaoFilme);
    }
    
    public static void setMotivoExclusaoFilme(String motivoExclusaoFilme) {
    	FilmeIndisponivel.motivoExclusaoFilme = motivoExclusaoFilme;
    }
    
    public static String getMotivoExclusaoFilme() {
        return FilmeIndisponivel.motivoExclusaoFilme;
    }
    
}
