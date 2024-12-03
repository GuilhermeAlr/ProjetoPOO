package projetopoo;
import java.util.ArrayList;

public class Usuario extends Pessoa {
	private int idadeUsuario;
	ArrayList<Ingresso> ingressosComprados;

	// construtor da classe Usuario
	public Usuario(String nomeUsuario, String loginUsuario, String senhaUsuario, int idadeUsuario) {
		super(nomeUsuario, loginUsuario, senhaUsuario);
		setIdadeUsuario(idadeUsuario);
		ingressosComprados = new ArrayList<>();
	}

	// get e set idade
	public void setIdadeUsuario(int idadeUsuario) {
		this.idadeUsuario = idadeUsuario;
	}

	public int getIdadeUsuario() {
		return this.idadeUsuario;
	}

	// get e set ingressos comprados
	public void setIngressosComprados(ArrayList<Ingresso> ingressosComprados) {
		this.ingressosComprados = ingressosComprados;
	}

	public ArrayList<Ingresso> getIngressosComprados() {
		return this.ingressosComprados;
	}

	// retorna o preco do ingresso de acordo com a idade do usuario ou se eh uma sessao promocional
	public double getPrecoIngresso(Sessao sessao) {
		// se usuario eh menor, paga meia entrada
		if (this.getIdadeUsuario() < 18) { 
			return sessao.getPrecoSessao() * 0.5;
		} 
		else { 
			// se sessao possui promocao
			if (sessao.getComPromocao()) {
				return sessao.getPrecoSessao() * sessao.getPorcentagemPromocional();
			}
			// se sessao nao possui promocao
			else {
				return sessao.getPrecoSessao();
			}
		}
	}

	// metodo de comprar ingresso
	public boolean comprarIngresso(Sessao sessao, int nroAssento) {
		// checa se assento esta disponivel e usuario possui idade maior que classif. indicativa
		if (!sessao.getDisponibilidadeAssento(nroAssento) && this.getIdadeUsuario() >= sessao.getFilmeSessao().getClassificacaoFilme()) {
			sessao.reservarAssento(nroAssento); // metodo em sessao para ocupar poltrona selecionada
			
			Ingresso ingresso = new Ingresso(sessao, nroAssento, getPrecoIngresso(sessao));
			ingressosComprados.add(ingresso);

			return true;
		} 
		return false;
	}

	// metodo para realizar assinatura
	public Usuario comprarAssinatura() {
		if (!(this instanceof UsuarioAssinante)) {
			ArrayList<Ingresso> ingressosCompradosAuxiliar = this.ingressosComprados;
			UsuarioAssinante novoUsuario = new UsuarioAssinante(this.getNomePessoa(), this.getLoginPessoa(), this.getSenhaPessoa(), this.getIdadeUsuario());
			novoUsuario.setIngressosComprados(ingressosCompradosAuxiliar);

			return novoUsuario;
		} 
		return this;
	}

}