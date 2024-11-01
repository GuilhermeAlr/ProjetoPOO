package main.java.com.test.projetopoo;

public class Pessoa {

	private String nomePessoa; 
	private String loginPessoa; 
	private String senhaPessoa;
	
	public Pessoa(String nomePessoa, String loginPessoa, String senhaPessoa) { 
		setNomePessoa(nomePessoa); 
		setLoginPessoa(loginPessoa); 
		setSenhaPessoa(senhaPessoa); 		
	}
	
	public void setNomePessoa (String nomePessoa) {
		this.nomePessoa = nomePessoa; 
	}

	public String getNomePessoa() {
		return this.nomePessoa; 
	}
	
	public void setLoginPessoa (String loginPessoa) {
		this.loginPessoa = loginPessoa; 
	}

	public String getLoginPessoa() {
		return this.loginPessoa;
	}
	
	public void setSenhaPessoa (String senhaPessoa) {
		this.senhaPessoa = senhaPessoa;
	}
	
	public String getSenhaPessoa() {
		return this.senhaPessoa;
	}
		
}
