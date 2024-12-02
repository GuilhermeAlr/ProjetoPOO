package projetopoo;
import java.util.ArrayList;

/** A classe Usuario representa um cliente do programa, que possui, além dos atributos de pessoa, 
 *  uma idade e o histórico de ingressos comprados no cinema.
 * 
 * <p>
 * Essa classe herda de {@link Pessoa}, adicionando a uma pessoa as características de um cliente.
 * Também serve como superclasse para {@link UsuarioAssinante}, oferecendo suas características para um usuário com assinatura.
 * </p>
 * 
 * @author Giovanna Noventa
 * @since 1.0
 * @see Pessoa
 * @see java.util.ArrayList
 */

public class Usuario extends Pessoa {
    private int idadeUsuario;
    private ArrayList<Ingresso> ingressosComprados;

    /** Construtor da classe Usuario.
     * 
     * Inicializa um usuario com as características de {@link Pessoa}, a idade e o array de ingressos comprados vazio.
     * 
     * @param nomeUsuario Nome do usuário.
     * @param loginUsuario Login do usuário.
     * @param senhaUsuario Senha do usuário.
     * @param idadeUsuario Idade do usuário.
     * @see Pessoa#Pessoa(java.lang.String, java.lang.String, java.lang.String) 
     */
    public Usuario(String nomeUsuario, String loginUsuario, String senhaUsuario, int idadeUsuario) {
	super(nomeUsuario, loginUsuario, senhaUsuario);
	setIdadeUsuario(idadeUsuario);
	ingressosComprados = new ArrayList<>();
    }

    /**
     * Obtém o preço do ingresso de acordo com a idade do usuário ou se identificar que é uma sessão promocional. 
     * <p>Para calcular o preço: </p>
     * <ul>
     * <li>Se o usuário for menor de idade, ele paga metade do preço da sessão.</li>
     * <li>Se a sessão tem uma promoção, ele paga o preço da sessão multiplicado pela porcentagem promocional.</li>
     * <li>Se a sessão não tem uma promoção, ele paga o preço da sessão estipulado.</li>
     * </ul>
     * 
     * @param sessao Sessão a qual o usuário está interessado em comprar.
     * @return <code>double</code> Preço calculado do ingresso.
     */
    public double getPrecoIngresso(Sessao sessao) {
        if (this.getIdadeUsuario() < 18) { 
            return sessao.getPrecoSessao() * 0.5;
	} 
	else { 
            if (sessao.getComPromocao()) {
		return sessao.getPrecoSessao() * (1 - sessao.getPorcentagemPromocional());
            }
            else {
		return sessao.getPrecoSessao();
            }
        }
    }
    
    /**
     * Indica se a compra de um ingresso foi bem-sucedida, reserva o assento desejado na sessão e armazena o ingresso no array de ingressos comprados. 
     * <p>Para a compra de um ingresso ser bem-sucedida:</p>
     * <ul>
     * <li>O assento deve estar disponível.</li>
     * <li>O usuário deve ter idade maior que a classificação indicativa do filme da sessão.</li>
     * </ul>
     * 
     * @param sessao Sessão a qual o usuário está interessado em comprar.
     * @param nroAssento Assento ao qual o usuário quer reservar.
     * @return <code>boolean</code> Indica se a compra do ingresso pelo usuário foi bem-sucedida.
     * @see Sessao#getDisponibilidadeAssento(int) 
     * @see Sessao#reservarAssento(int) 
     * @see Filme#getClassificacaoFilme() 
     */
    public boolean comprarIngresso(Sessao sessao, int nroAssento) {
	if (!sessao.getDisponibilidadeAssento(nroAssento) && this.getIdadeUsuario() >= sessao.getFilmeSessao().getClassificacaoFilme()) {
            sessao.reservarAssento(nroAssento); 
            
            // Armazena o ingresso comprado no histórico do usuário.
            Ingresso ingresso = new Ingresso(sessao, nroAssento, getPrecoIngresso(sessao));
            ingressosComprados.add(ingresso);
            return true;
	} 
	return false;
    }

    /**
     * Muda um usuário para um usuário assinante, caso ele não seja, e transfere os seus dados e o histórico dos ingressos comprados.
     * <p>
     * Caso o usuário já seja um assinante, não há modificações e retorna a instância do usuário atual. 
     * Caso contrário, ele copia os dados do usuário atual para um usuário assinante e retorna essa instância.
     * </p>
     * 
     * @return <code>Usuario</code> Instância de um Usuario ou de um UsuarioAssinante.
     * @see UsuarioAssinante
     */
    public Usuario comprarAssinatura() {
        // Se o usuário atual não é instância de um UsuarioAssinante
	if (!(this instanceof UsuarioAssinante)) {
            ArrayList<Ingresso> ingressosCompradosAuxiliar = this.ingressosComprados;
            UsuarioAssinante novoUsuario = new UsuarioAssinante(this.getNomePessoa(), this.getLoginPessoa(), this.getSenhaPessoa(), this.getIdadeUsuario());
            novoUsuario.setIngressosComprados(ingressosCompradosAuxiliar);

            return novoUsuario;
	} 
	return this;
    }
    
    /** 
     * Muda a idade do usuário .
     * 
     * @param idadeUsuario Nova idade do usuário.
     */
    public final void setIdadeUsuario(int idadeUsuario) {
        this.idadeUsuario = idadeUsuario;
    }

    /**
     * Obtém a idade do usuário.
     * 
     * @return <code>integer</code> Idade do usuário.
     */
    public int getIdadeUsuario() {
    	return this.idadeUsuario;
    }

    /**
     * Muda o array de ingressos comprados do usuário. 
     * 
     * @param ingressosComprados ArrayList contendo os ingressos comprados. 
     */
    public void setIngressosComprados(ArrayList<Ingresso> ingressosComprados) {
	this.ingressosComprados = ingressosComprados;
    }

    /**
     * Obtém o array de ingressos comprados do usuário.
     * 
     * @return <code>ArrayList</code> contendo os ingressos comprados.
     */
    public ArrayList<Ingresso> getIngressosComprados() {
    	return this.ingressosComprados;
    }

}
