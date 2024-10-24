package main.java.com.test.projetopoo;
import java.util.ArrayList; 

public class Usuario extends Pessoa{ 
	
	private int idadePessoa;  
	private Boolean assinaturaPessoa;
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

	//+Troca de Usuario -> UsuarioAssinante 
	public Boolean comprarAssinatura (Boolean assinaturaPessoa) { 
		if(assinaturaPessoa){
			this.assinaturaPessoa = assinaturaPessoa;
			return true;
		}
		else
			return false; 
	}
	
	public Boolean getAssinaturaPessoa(Usuario usuario) {
		if(usuario instanceof UsuarioAssinante)
			return true;
		else
			return false; 
	}
	
	//Ingresso
	public void setIngressosComprados (Ingresso ingresso) {
		ingressosComprados.add(ingresso); 
	}
	
	public double getPrecoIngresso(Sessao sessao){
		if(getIdadePessoa() < 18) 
			return sessao.getPrecoSessao()*0.5;
		else
			return sessao.getPrecoSessao();
	}
	
	public Boolean comprarIngresso(Sessao sessao, int nroAssento) {
		if(!sessao.getNroAssento(nroAssento) && getIdadePessoa() > sessao.getFilmeSessao().getClassificacaoFilme())
			{
				sessao.reservarPoltrona(nroAssento); //Metodo em sessao para ocupar poltrona selecionada
				Ingresso ingresso = new Ingresso(sessao, nroAssento, getPrecoIngresso(sessao)); 
				setIngressosComprados(ingresso);
				
				return true;
			}
			
		else
			return false; 
	}

}

