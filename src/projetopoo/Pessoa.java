package projetopoo;

/** A classe Pessoa representa uma pessoa com informações básicas.
 * 
 *  <p>
 *  Essa classe é usada como superclasse para as classes {@link Usuario} e {@link Gerente}, 
 *  fornecendo informações, como nome, login e senha da pessoa.
 *  </p>
 * 
 *  @author Giovanna Noventa
 *  @since 1.0
 */

public class Pessoa {
    private String nomePessoa; 
    private String loginPessoa; 
    private String senhaPessoa;
	
    /** Construtor da classe Pessoa. 
     * 
     *  Inicializa uma pessoa com suas características.
     * 
     *  @param nomePessoa Nome da pessoa.
     *  @param loginPessoa Login da pessoa.
     *  @param senhaPessoa Senha da pessoa.
     */
    public Pessoa(String nomePessoa, String loginPessoa, String senhaPessoa) { 
		setNomePessoa(nomePessoa); 
		setLoginPessoa(loginPessoa); 
		setSenhaPessoa(senhaPessoa); 		
    }
	
    /** 
     * Muda o nome da pessoa.
     * 
     * @param nomePessoa Novo nome da pessoa.
     */
    public final void setNomePessoa (String nomePessoa) {
		this.nomePessoa = nomePessoa; 
    }

    /**
     * Obtém o nome da pessoa.
     * 
     * @return <code>String</code> Nome da pessoa.
     */
    public String getNomePessoa() {
        return this.nomePessoa; 
    }

    /** 
     * Muda o login da pessoa.
     * 
     * @param loginPessoa Novo login da pessoa.
     */
    public final void setLoginPessoa (String loginPessoa) {
		this.loginPessoa = loginPessoa; 
    }

    /**
     * Obtém o login da pessoa.
     * 
     * @return <code>String</code> Login da pessoa.
     */
    public String getLoginPessoa() {
		return this.loginPessoa;
    }
	
    /** 
     * Muda a senha da pessoa.
     * 
     * @param senhaPessoa Nova senha da pessoa.
     */
    public final void setSenhaPessoa (String senhaPessoa) {
		this.senhaPessoa = senhaPessoa;
    }

    /**
     * Obtém a senha da pessoa.
     * 
     * @return <code>String</code> Senha da pessoa.
     */
    public String getSenhaPessoa() {
		return this.senhaPessoa;
    }
    
}
