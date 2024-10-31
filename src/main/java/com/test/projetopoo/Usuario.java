package main.java.com.test.projetopoo;
package Trabalho_POO;
import java.util.ArrayList; 

public class Usuario extends Pessoa{ 
	
	private int idadePessoa;  
	private static int nroUsuarios = 0;
	ArrayList <Ingresso> ingressosComprados; 
	
	//Construtor da classe Usuario
	public Usuario(String nome, String login, String senha, int idade) { 
		super(nome,login,senha); 
		setIdadePessoa(idade);
		ingressosComprados = new ArrayList<>(); 
	
		nroUsuarios++;
	}
	
	//Get-Set idade
	public void setIdadePessoa (int idadePessoa) { 
		this.idadePessoa = idadePessoa;
	}
	public int getIdadePessoa() {
		return idadePessoa; 
	}

	//Assinatura do usuário 
	public Usuario comprarAssinatura(Boolean assinaturaPessoa, Usuario usuario) { 
		if(assinaturaPessoa && !(this instanceof UsuarioAssinante)) {
		
			ArrayList <Ingresso> ingressosCompradosAuxiliar = this.ingressosComprados;
			usuario =  new UsuarioAssinante(this.getNomePessoa(), this.getLoginPessoa(), this.getSenhaPessoa(), this.getIdadePessoa()); 
			
			this.ingressosComprados = new ArrayList<>();
			usuario.setIngressosComprados(ingressosCompradosAuxiliar);
			
			return usuario;
		}
		
		return this; 
	
	}
	
	public Boolean getAssinaturaPessoa(Usuario usuario) {
		if(usuario instanceof UsuarioAssinante)
			return true;
		else
			return false; 
	}
	
	//Ingresso
	 public void setIngressosComprados(ArrayList <Ingresso> ingressosComprados) {
	        this.ingressosComprados = ingressosComprados;
    	}

	 public ArrayList <Ingresso>  getIngressosComprados() {
	        return this.ingressosComprados;
	 }
	
	
	public double getPrecoIngresso(Sessao sessao){
		if(getIdadePessoa() < 18) 
			return sessao.getPrecoSessao()*0.5;
		else
			return sessao.getPrecoSessao();
	}
	
	public Boolean comprarIngresso(Sessao sessao, int nroAssento) {
		if(!sessao.getNroAssento(nroAssento) && getIdadePessoa() > sessao.getFilmeSessao().getClassificacaoFilme()){
				sessao.reservarPoltrona(nroAssento); //Metodo em sessao para ocupar poltrona selecionada
				Ingresso ingresso = new Ingresso(sessao, nroAssento, getPrecoIngresso(sessao)); 
				ingressosComprados.add(ingresso); 
				
				return true;
		}
			
		else
			return false; 
	}

}

