public class Usuario extends Pessoa{ 
	
	private int idadePessoa;  
	private Boolean assinaturaPessoa;
	private static int nroUsuarios = 0;
	ArrayList <Ingresso> ingressosComprados = new ArrayList<>(); 
	
	//Construtor da classe Usuario
	public Usuario(String nome, String login, String senha, int idade) { 
		super(nome,login,senha); 
		setIdadePessoa(idade);
		
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
	
	
	//Metodo que define preço do ingresso, baseado na idade e assinatura. - Poderia estar em uma classe mais adequada
	public double getPrecoIngresso(Sessao sessao, Usuario usuario){
		//Multiplicacao do preço original pelo desconto aplicado, apenas um exemplo...
		if(getIdadePessoa() < 18 && usuario instanceof UsuarioAssinante) 
			return sessao.getPrecoSessao()*0.4;
		
		else if(usuario instanceof UsuarioAssinante)
			return sessao.getPrecoSessao()*0.7;	
		
		else if(getIdadePessoa() < 18)
			return sessao.getPrecoSessao()*0.5;
		
		else
			return sessao.getPrecoSessao();
	}
	
	//Metodo para comprar ingresso
	public Boolean comprarIngresso(Sessao sessao, Usuario usuario, int nroAssento) {
		if(!sessao.getNroAssento(nroAssento) && getIdadePessoa() > sessao.getFilmeSessao().getClassificacaoFilme())
			{
				sessao.reservarPoltrona(nroAssento); 
				Ingresso ingresso = new Ingresso(sessao, nroAssento, getPrecoIngresso(sessao, usuario)); 
				ingressosComprados.add(ingresso);
				return true;
			}
			
		else
			return false; 
	}
}
