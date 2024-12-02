package projetopoo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

/** A classe Sessão representa uma sessão de cinema com suas características.
 * 
 * <p>
 * Uma sessão possui um código, o dia e horário, a lista de assentos disponíveis e indisponíveis,
 * o seu preço e suas promoções, o {@link Filme} exibido e a {@link Sala} onde será a sessão.
 * O dia e horário da sessão são definidos utilizando {@link java.time.LocalDateTime}, {@link java.time.LocalDate}, {@link java.time.LocalTime}
 * </p>
 * 
 * <p>
 * Essa classe serve como superclassse para {@link SessaoIndisponivel}, 
 * oferecendo todas as características de uma sessão disponível.
 * </p> 
 * 
 * @author Guilherme Almendro
 * @since 1.0
 * @see Sala
 * @see Filme
 * @see java.time.LocalDate
 * @see java.time.LocalTime
 * @see java.time.LocalDateTime
 */

public class Sessao{
    private static int quantidadeSessoes = 0; // Variável estática que define o código da sessão, conforme a quantidade de sessões criadas.
    private int codigoSessao;
    private LocalDateTime diaHorarioSessao;
    private Boolean[] listaAssentos; // Lista de assentos disponíveis (true) e indisponíveis (false).
    private double precoSessao; 
    private boolean comPromocao;
    private double porcentagemPromocional; // Número da porcentagem entre 0 e 1.
    private Sala salaSessao;
    private Filme filmeSessao;
    
    /** Construtor da classe Sessão.
     * 
     * Inicializa uma sessão com suas características.
     * 
     * @param diaHorarioSessao Data e horário da sessão.
     * @param precoSessao Preço da sessão.
     * @param comPromocao Variável que indica se sessão possui (<code>true</code>) ou não promoção (<code>false</code>). 
     * @param porcentagemPromocional Porcentagem promocional entre 0 e 1.
     * @param salaSessao Sala onde será a sessão.
     * @param filmeSessao Filme exibido na sessão.
     */
    public Sessao(LocalDateTime diaHorarioSessao, double precoSessao, Boolean comPromocao, double porcentagemPromocional, Sala salaSessao, Filme filmeSessao){
        setCodigoSessao(quantidadeSessoes);
        setDiaHorarioSessao(diaHorarioSessao);
        setListaAssentos(salaSessao.getNroAssentos() + 1); // Lista de assentos começa em 1 e vai até o número de assentos definidos na sala.
        setPrecoSessao(precoSessao);
        setComPromocao(comPromocao); 
        setPorcentagemPromocional(porcentagemPromocional);
        setSalaSessao(salaSessao);
        setFilmeSessao(filmeSessao);
        
        // Aumenta a quantidade de sessões instanciadas.
        quantidadeSessoes++;
    }

    /**
     * Decrementa a quantidade total de sessões.
     */
    public static void decrementaQuantidadeSessoes() {
        quantidadeSessoes--;
    }
    
    /** 
     * Reserva o assento de uma sessão, tornando o ocupado (<code>true</code>).
     * 
     * @param nroAssento Número do assento a ser reservado.
     */
    public void reservarAssento(int nroAssento){
        this.listaAssentos[nroAssento] = true;
    }

    /**
     * Obtém a disponibilidade do assento, sendo que ocupado (<code>true</code>) e desocupado (<code>false</code>).
     * 
     * @param nroAssento Número do assento a ser verificado.
     * @return <code>Boolean</code> Disponibilidade do assento. 
     */
    // metodo que retorna se o assento esta disponivel ou nao
    public Boolean getDisponibilidadeAssento(int nroAssento) {
        return this.listaAssentos[nroAssento];
    }

    /**
     * Imprime a lista de assentos. Se estiver disponível, imprime número, 
     * e se estiver reservado, imprime '[X]'.
     */
    public void imprimeListaAssentos(){
        String assento = "";
        
        for (int i = 1; i < getListaAssentos().length; i++) {
            if (listaAssentos[i]) {
                assento += "[X] ";
            } else {
                assento += "[" + i + "] "; 
            }
            
            //quebra a linha a cada 10 assentos
            if (i % 10 == 0) {
                assento += "\n"; 
            }
        }
        
        System.out.println(assento);
    }

    /**
     * Obtém o número de assentos disponíveis.
     * 
     * @return <code>integer</code> Número de assentos disponíveis.
     */
    public int getAssentosDisponiveis() {
        int nroAssentosDisponiveis = 0;

        for (int i = 1; i < listaAssentos.length; i++) {
            if (getDisponibilidadeAssento(i) == false) {
                nroAssentosDisponiveis++;
            } 
        }

        return nroAssentosDisponiveis;
    }

    /** 
     * Muda o código da sessão.
     * 
     * @param codigoSessao Novo código da sessão.
     */
    public final void setCodigoSessao(int codigoSessao) {
        this.codigoSessao = codigoSessao;
    }

    /**
     * Obtém o código da sessão. 
     * 
     * @return <code>integer</code> Código da sessão. 
     */
    public int getCodigoSessao(){
        return codigoSessao;
    }
    
    /** 
     * Muda a data e o horário da sessão.
     * 
     * @param diaHorarioSessao Novo data e horário da sessão. 
     * @see java.time.LocalDateTime
     */
    public final void setDiaHorarioSessao(LocalDateTime diaHorarioSessao) {
        this.diaHorarioSessao = diaHorarioSessao;
    }

    /**
     * Obtém a data e o horário da sessão. 
     * 
     * @return <code>LocalDateTime</code> Data e horário da sessão.
     * @see java.time.LocalDateTime
     */
    public LocalDateTime getDiaHorarioSessao() {
        return this.diaHorarioSessao;
    }

    /** 
     * Muda a data da sessão, mantendo o horário.
     * 
     * @param diaSessao Novo data da sessão. 
     * @see java.time.LocalDate
     */
    public void setDiaSessao(LocalDate diaSessao){
        this.diaHorarioSessao = getHorarioSessao().atDate(diaSessao);
    }

    /**
     * Obtém a data da sessão. 
     * 
     * @return <code>LocalDate</code> Data da sessão.
     * @see java.time.LocalDate
     */
    public LocalDate getDiaSessao(){
        return this.diaHorarioSessao.toLocalDate();
    }
    
    /** 
     * Muda o horário da sessão, mantendo a data.
     * 
     * @param horarioSessao Novo horário da sessão. 
     * @see java.time.LocalTime
     */
    public void setHorarioSessao(LocalTime horarioSessao){
        this.diaHorarioSessao = getDiaSessao().atTime(horarioSessao);
    }

    /**
     * Obtém o horário da sessão. 
     * 
     * @return <code>LocalTime</code> Horário da sessão.
     * @see java.time.LocalTime
     */
    public LocalTime getHorarioSessao(){
        return this.diaHorarioSessao.toLocalTime();
    }
    
    /**
     * Inicializa a lista de assentos com sua quantidade, colocando-os como indisponíveis (<code>false</code>).
     * Ela começa em 1 e vai até o número de assentos definidos na sala.
     * 
     * @param nroAssentos Número de assentos.
     */
    public final void setListaAssentos(int nroAssentos){
        listaAssentos = new Boolean[nroAssentos];
        for (int i = 1; i < listaAssentos.length; i++) {
            listaAssentos[i] = false;
        }
    }

    /**
     * Obtém a lista de assentos da sessão, sendo que cada elemento é um objeto <code>Boolean</code>.
     * 
     * @return Array de <code>Boolean</code> Lista de Assentos.
     */
    public Boolean[] getListaAssentos(){
        return this.listaAssentos;
    }
    
    /** 
     * Muda o preço da sessão.
     * 
     * @param precoSessao Novo preço da sessão. 
     */
    public final void setPrecoSessao(double precoSessao){
        this.precoSessao = precoSessao;
    }

    /**
     * Obtém o preço da sessão. 
     * 
     * @return <code>double</code> Preço da sessão.
     */
    public double getPrecoSessao(){
        return this.precoSessao;
    }
    
    /** 
     * Muda a variável para indicar se a sessão tem promoção (<code>true</code>) ou não (<code>false</code>).
     * 
     * @param comPromocao Indica se sessão possui promoção. 
     */
    public final void setComPromocao(boolean comPromocao){
        this.comPromocao = comPromocao;
    }
    
    /**
     * Obtém se a sessão tem promoção (<code>true</code>) ou não (<code>false</code>).
     * 
     * @return <code>boolean</code> Sessão possui promoção. 
     */
    public boolean getComPromocao(){
        return this.comPromocao;
    }
    
    /**
     * Muda a porcentagem promocional da sessão.
     * 
     * @param porcentagemPromocional Porcentagem promocional da sessão (entre 0 e 1).
     */
    public final void setPorcentagemPromocional(double porcentagemPromocional){
        this.porcentagemPromocional = porcentagemPromocional;
    }
    
    /**
     * Obtém a porcentagem promocional da sessão.
     * 
     * @return <code>double</code> Porcentagem promocional da sessão. 
     */
    public double getPorcentagemPromocional(){
        return  this.porcentagemPromocional;
    }
    
    /**
     * Muda a sala em que será a sessão.
     * 
     * @param salaSessao Sala associada à sessão.
     * @see Sala
     */
    public final void setSalaSessao(Sala salaSessao) {
        this.salaSessao = salaSessao;
    }

    /**
     * Obtém a sala em que será a sessão.
     * 
     * @return <code>Sala</code> Sala associada à sessão.
     * @see Sala
     */
    public Sala getSalaSessao() {
        return this.salaSessao;
    }
    
    /**
     * Muda o filme que será exibido na sessão.
     * 
     * @param filmeSessao Filme associado à sessão.
     * @see Filme
     */
    public final void setFilmeSessao(Filme filmeSessao) {
        this.filmeSessao = filmeSessao;
    }
    
    /**
     * Obtém o filme exibido na sessão.
     * 
     * @return <code>Filme</code> Filme associado à sessão.
     * @see Filme
     */
    public Filme getFilmeSessao() {
        return this.filmeSessao;
    }

    /**
     * Retorna uma representação em string da sessão. 
     * 
     * <p>
     * Caso não tenha promoção, o preço normal, de meia-entrada e de assinatura são exibidos. Caso tenha promoção, além desses, o preço promocional é exibido.
     * </p>
     * 
     * @return <code>String</code> Informações detalhadas sobre a sessão e suas características. 
     */
    @Override
    public String toString() {
        String precoString = "";
        String promocaoString = "";

        if (comPromocao == true) {
            promocaoString = "- Possui Promocao: Sim (desconto de %" + (porcentagemPromocional * 100) + ")"; 
            precoString = "- Preco: R$" + getPrecoSessao() + 
                        " | Meia-Entrada: R$" + getPrecoSessao() * 0.5 + 
                        " | Preco Promocional: R$" + (getPrecoSessao() * (1 - porcentagemPromocional)) + 
                        " | Preco para Assinantes: R$" + getPrecoSessao() * 0.7;
        }
        else if (comPromocao == false) {
            promocaoString = "- Possui Promocao: Nao";
            precoString = "- Preco: R$" + getPrecoSessao() + 
                        " | Meia-Entrada: R$" + getPrecoSessao() *0.5 + 
                        " | Preco para Assinantes: R$" + getPrecoSessao() * 0.7;
        }
        
        return "Sessao: " + getCodigoSessao() + 
               " | Filme: " + filmeSessao.getNomeFilme() + 
               " | Sala " + salaSessao.getNroSala() +
               " | Data: " + getDiaSessao() + " " + getHorarioSessao() +
               "\n" + promocaoString +
               "\n" + precoString +
               "\n- Assentos Disponiveis: " + getAssentosDisponiveis() + "/" + (listaAssentos.length - 1);
    }
}

