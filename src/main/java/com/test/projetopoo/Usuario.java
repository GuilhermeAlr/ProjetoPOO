package main.java.com.test.projetopoo;

import java.util.ArrayList;

public class Usuario extends Pessoa {
	private int idadeUsuario;
	ArrayList<Ingresso> ingressosComprados;
	private static int nroUsuarios = 0;

	// Construtor da classe Usuario
	public Usuario(String nomeUsuario, String loginUsuario, String senhaUsuario, int idadeUsuario) {
		super(nomeUsuario, loginUsuario, senhaUsuario);
		setIdadeUsuario(idadeUsuario);
		ingressosComprados = new ArrayList<>();

		nroUsuarios++;
	}

	// Get-Set idade
	public void setIdadeUsuario(int idadeUsuario) {
		this.idadeUsuario = idadeUsuario;
	}

	public int getIdadeUsuario() {
		return this.idadeUsuario;
	}

	// Ingresso
	public void setIngressosComprados(ArrayList<Ingresso> ingressosComprados) {
		this.ingressosComprados = ingressosComprados;
	}

	public ArrayList<Ingresso> getIngressosComprados() {
		return this.ingressosComprados;
	}

	public double getPrecoIngresso(Sessao sessao) {
		if (this.getIdadeUsuario() < 18) {
			return sessao.getPrecoSessao() * 0.5;
		} else {
			return sessao.getPrecoSessao();
		}
	}

	public boolean comprarIngresso(Sessao sessao, int nroAssento) {
		if (!sessao.getDisponibilidadeAssento(nroAssento) && this.getIdadeUsuario() >= sessao.getFilmeSessao().getClassificacaoFilme()) {
			sessao.reservarAssento(nroAssento); // Metodo em sessao para ocupar poltrona selecionada
			Ingresso ingresso = new Ingresso(sessao, nroAssento, getPrecoIngresso(sessao));
			ingressosComprados.add(ingresso);
			return true;
		} else {
			return false;
		}
	}

	// Assinatura do usuário
	public Usuario comprarAssinatura(boolean assinaturaUsuario, Usuario usuario) {
		if (assinaturaUsuario && !(this instanceof UsuarioAssinante)) {
			ArrayList<Ingresso> ingressosCompradosAuxiliar = this.ingressosComprados;
			usuario = new UsuarioAssinante(this.getNomePessoa(), this.getLoginPessoa(), this.getSenhaPessoa(), this.getIdadeUsuario());

			this.ingressosComprados = new ArrayList<>();
			usuario.setIngressosComprados(ingressosCompradosAuxiliar);

			return usuario;
		} else {
			return this;
		}
	}

	public boolean getAssinaturaUsuario(Usuario usuario) {
		if (usuario instanceof UsuarioAssinante) {
			return true;
		} else {
			return false;
		}
	}

}
