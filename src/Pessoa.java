public class Pessoa {

	private String nomePessoa; 
	private String emailPessoa; 
	private String senhaPessoa;
	
	public Pessoa(String nome, String email, String senha) { 
	
		setNomePessoa(nome); 
		setEmailPessoa(email); 
		setSenhaPessoa(senha); 		
		
	}
	
	public void setNomePessoa (String nomePessoa) {
			this.nomePessoa = nomePessoa; 
	}
	public String getNomePessoa() {
		return nomePessoa; 
	}
	
	public void setEmailPessoa (String emailPessoa) {
			this.emailPessoa = emailPessoa; 
	}
	public String getEmailPessoa() {
		return emailPessoa;
	}
	
	public void setSenhaPessoa (String senhaPessoa) {
			this.senhaPessoa = senhaPessoa;
	}
	public String getSenhaPessoa() {
		return senhaPessoa;
	}
		
}
