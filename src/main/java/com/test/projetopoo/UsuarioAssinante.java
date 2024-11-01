package main.java.com.test.projetopoo;

public class UsuarioAssinante extends Usuario {
	public UsuarioAssinante(String nomeUsuario, String loginUsuario, String senhaUsuario, int idadeUsuario) { 
		super(nomeUsuario, loginUsuario, senhaUsuario, idadeUsuario);
	}
	
	@Override
	public double getPrecoIngresso(Sessao sessao){	
		return 0.7 * super.getPrecoIngresso(sessao);
	}
	
}
