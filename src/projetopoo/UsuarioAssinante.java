package projetopoo;

/** A classe UsuarioAssinante representa um cliente que possui uma assinatura, de forma que tem preços diferenciados na hora da compra.
 * 
 * <p>
 * Essa classe herda de {@link Usuario} e possui um método diferente para o cálculo do preço do ingresso. 
 * </p>
 * 
 * @author Giovanna Noventa
 * @since 1.0
 * @see Usuario
 */

public class UsuarioAssinante extends Usuario {
    /** Construtor da classe UsuarioAssinante.
     * 
     *  Inicializa um usuário assinante com as características estabelecidas em {@link Usuario}.
     * 
     * @param nomeUsuario Nome do usuário assinante.
     * @param loginUsuario Login do usuário assinante.
     * @param senhaUsuario Senha do usuário assinante.
     * @param idadeUsuario Idade do usuário assinante.
     * @see Usuario#Usuario(java.lang.String, java.lang.String, java.lang.String, int) 
     */
    public UsuarioAssinante(String nomeUsuario, String loginUsuario, String senhaUsuario, int idadeUsuario) { 
	super(nomeUsuario, loginUsuario, senhaUsuario, idadeUsuario);
    }

    /**
     * Obtém o preço do ingresso para assinantes, ou seja, com 30% de desconto do preço normal. 
     * 
     * @param sessao Sessão a qual o usuário está interessado em comprar.
     * @return <code>double</code> Preço do ingresso para assinantes.
     */
    @Override
    public double getPrecoIngresso(Sessao sessao){	
	return 0.7 * super.getPrecoIngresso(sessao);
    }
    
}
