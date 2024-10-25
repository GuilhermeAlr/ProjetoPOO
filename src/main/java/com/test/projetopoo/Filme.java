package main.java.com.test.projetopoo;

public class Filme {
    private String nomeFilme;
    private String descricaoFilme;
    private int classificacaoFilme;
    private String generoFilme;
    private double precoFilme;
    private int duracaoFilme;
    private static int nroFilmes;

    public Filme (String nomeFilme, String descricaoFilme, int classificacaoFilme, String generoFilme, double precoFilme, int duracaoFilme) {
        setNomeFilme(nomeFilme);
        setDescricaoFilme(descricaoFilme);
        setClassificacaoFilme(classificacaoFilme);
        setGeneroFilme(generoFilme);
        setPrecoFilme(precoFilme);
        setDuracaoFilme(duracaoFilme);

        nroFilmes++;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getNomeFilme() {
        return this.nomeFilme;
    }

    public void setDescricaoFilme(String descricaoFilme) {
        this.descricaoFilme = descricaoFilme;
    }

    public String getDescricaoFilme() {
        return this.descricaoFilme;
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

    public void setPrecoFilme(double precoFilme) {
        this.precoFilme = precoFilme;
    }

    public double getPrecoFilme() {
        return this.precoFilme;
    }

    public void setDuracaoFilme(int duracaoFilme) {
        this.duracaoFilme = duracaoFilme;
    }

    public int getDuracaoFilme() {
        return this.duracaoFilme;
    }
    
}