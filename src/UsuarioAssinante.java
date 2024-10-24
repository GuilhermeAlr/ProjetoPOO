package Trabalho_POO;

public class UsuarioAssinante extends Usuario {

	public UsuarioAssinante(String nome, String login, String senha, int idade) { 
		super(nome,login,senha,idade);
	}
	
	@Override
	public double getPrecoIngresso(Sessao sessao){	
		return 0.7 * super.getPrecoIngresso(sessao);
	}
	
}
