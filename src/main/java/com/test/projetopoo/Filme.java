package main.java.com.test.projetopoo;

public class Filme {

    private String nomeFilme;
    private String sinopseFilme;
    private int classificacaoFilme;
    private String generoFilme;
    private int duracaoFilme;
    private static int nroFilmes = 0;

    public Filme (String nomeFilme, String sinopseFilme, int classificacaoFilme, String generoFilme, int duracaoFilme) {
        
        setNomeFilme(nomeFilme);
        setSinopseFilme(sinopseFilme);
        setClassificacaoFilme(classificacaoFilme);
        setGeneroFilme(generoFilme);
        setDuracaoFilme(duracaoFilme);

        nroFilmes++;

    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getNomeFilme() {
        return this.nomeFilme;
    }

    public void setSinopseFilme(String sinopseFilme) {
        this.sinopseFilme = sinopseFilme;
    }

    public String getSinopseFilme() {
        return this.sinopseFilme;
    }

    public void setClassificacaoFilme(int classificacaoFilme) {
        switch(classificacaoFilme) {
            case 0, 10, 12, 14, 16, 18 -> this.classificacaoFilme = classificacaoFilme;
            default -> {
            }
        }
    }
    
    public int getClassificacaoFilme() {
        return this.classificacaoFilme;
    }

    public void setGeneroFilme(String generoFilme) {
        this.generoFilme = generoFilme;
    }

    public String getGeneroFilme() {
        return this.generoFilme;
    }

    public void setDuracaoFilme(int duracaoFilme) {
        this.duracaoFilme = duracaoFilme;
    }

    public int getDuracaoFilme() {
        return this.duracaoFilme;
    }

    // verificar se isso eh necessario
    public void decrementaFilmes() {
        nroFilmes--;
    }
    
}