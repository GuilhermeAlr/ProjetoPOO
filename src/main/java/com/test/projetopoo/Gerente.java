package main.java.com.test.projetopoo;

public class Gerente extends Pessoa{
    private Cinema cinema;
    private Usuario[] arrayUsuarios;

    public Gerente(String nome, String login, String senha, Cinema cinema, Usuario[] arrayUsuarios) {
        super(nome, login, senha);
        this.cinema = cinema;
        this.arrayUsuarios = arrayUsuarios; // verificar isso
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cinema getCinema() {
        return this.cinema;
    }

    public void setArrayUsuarios(Usuario[] arrayUsuarios) {
        this.arrayUsuarios = arrayUsuarios;
    }

    public Usuario[] getArrayUsuarios() {
        return this.arrayUsuarios;
    }
 
}
