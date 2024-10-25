package main.java.com.test.projetopoo;

public class Pessoa {

	private String nomePessoa; 
	private String loginPessoa; 
	private String senhaPessoa;
	
	public Pessoa(String nome, String login, String senha) { 
	
		setNomePessoa(nome); 
		setLoginPessoa(login); 
		setSenhaPessoa(senha); 		
		
	}
	
	public void setNomePessoa (String nomePessoa) {
		this.nomePessoa = nomePessoa; 
	}
	public String getNomePessoa() {
		return nomePessoa; 
	}
	
	public void setLoginPessoa (String loginPessoa) {
		this.emailPessoa = emailPessoa; 
	}
	public String getLoginPessoa() {
		return loginPessoa;
	}
	
	public void setSenhaPessoa (String senhaPessoa) {
		this.senhaPessoa = senhaPessoa;
	}
	public String getSenhaPessoa() {
		return senhaPessoa;
	}
		
}
