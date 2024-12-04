package projetopoo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;

/** A classe Gerente representa o gerente do cinema, que pode gerenciar o cinema com
 *  filmes, salas, sessões e promoções. 
 * 
 * <p>
 * Essa classe herda de {@link Pessoa}, adicionando a uma pessoa as funcionalidades de um gerente, 
 * como as funções de adicionar, editar, remover e buscar filmes, salas, sessões e promoções. 
 * Além disso, essa classe gera relatórios sobre o cinema.
 * </p>
 * 
 * @author Guilherme Almendro
 * @author Giovanna Noventa
 * @author Isabela Aoki
 * @since 1.0
 * @see Pessoa
 * @see java.time.LocalDate
 * @see java.time.LocalTime
 * @see java.time.LocalDateTime
 * @see java.util.ArrayList
 */
public class Gerente extends Pessoa{
    private Cinema cinema;
    private ArrayList<Usuario> listaUsuarios;

    /** Construtor da classe Gerente.
     * 
     * Inicializa um gerente com as características de {@link Pessoa}, um cinema e a lista de usuários. 
     * 
     * @param nomeGerente Nome do gerente.
     * @param loginGerente Login do gerente.
     * @param senhaGerente Senha do gerente.
     * @param cinema Cinema.
     * @see Pessoa#Pessoa(java.lang.String, java.lang.String, java.lang.String) 
     */
    public Gerente(String nomeGerente, String loginGerente, String senhaGerente, Cinema cinema) {
        super(nomeGerente, loginGerente, senhaGerente);
        setCinema(cinema);
        listaUsuarios = new ArrayList<>();
    }

    /**
     * Adiciona filme ao catálogo de filmes do cinema.
     * <p>
     * Busca primeiro se existe um filme no catálogo com o mesmo nome do que irá ser adicionado. 
     * Se existe, ele retorna <code>false</code> e não permite o cadastro de filmes repetidos. 
     * Se não existe, ele adiciona o filme ao catálogo e retorna <code>true</code>.
     * </p>
     * 
     * @param filme Filme a ser adicionado.
     * @return <code>boolean</code> Indica se o filme foi adicionado com sucesso. 
     * @see Cinema#getListaFilmes() 
     * @see Filme
     */
    public boolean adicionarFilme(Filme filme) {
        if (buscarFilme(filme.getNomeFilme()) == null) { 
            cinema.getListaFilmes().add(filme);
            return true;
        }
        return false;
    }

    /**
     * Edita filme do catálogo do cinema.
     * <p>
     * Realiza a edição dos atributos de um filme. Ele edita somente os parâmetros válidos ou não nulos fornecidos. 
     * Se o nome do filme for alterado, verifica se ele já existe no catálogo. Caso exista, ele retorna <code>false</code> e não edita o atributo.
     * </p>
     * 
     * @param filme Filme a ser editado.
     * @param nomeNovo Novo nome do filme. Se for uma string vazia, o nome não é alterado.
     * @param sinopseNova Nova sinopse do filme. Se for uma string vazia, a sinopse não é alterada.
     * @param classificacaoNova Nova classificação do filme. Se for -1, a classificação não é alterada.
     * @param generoNovo Novo gênero do filme. Se for uma string vazia, o gênero não é alterada.
     * @param duracaoNova Nova duração do filme. Se for -1, a duração não é alterada.
     * @return <code>boolean</code> Indica se o filme foi editado com sucesso.
     * @see Filme
     */
    public boolean editarFilme(Filme filme, String nomeNovo, String sinopseNova, int classificacaoNova, String generoNovo, int duracaoNova) {
        if (!nomeNovo.equals("")) {
            // Checa se o nome novo tem o mesmo nome de um filme que ja existe no catalogo
            if (buscarFilme(nomeNovo) == null) {
                filme.setNomeFilme(nomeNovo); 
            }
            else {
                return false;
            }
        }
        else if (!sinopseNova.equals("")) {
            filme.setSinopseFilme(sinopseNova);
        }
        else if (classificacaoNova != -1) { 
            filme.setClassificacaoFilme(classificacaoNova);
        }
        else if (!generoNovo.equals("")) {
            filme.setGeneroFilme(generoNovo);
        }
        else if (duracaoNova != -1) {
            filme.setDuracaoFilme(duracaoNova);
        }
        return true;
    }
    
    /**
     * Indisponibiliza filme no catálogo.
     * <p>
     * Substitui o filme por um filme indisponivel no array, copiando suas informações.
     * </p>
     * 
     * @param filme Filme a ser removido.
     * @param motivoExclusaoFilme Motivo de exclusão do filme.
     * @see FilmeIndisponivel
     * @see Cinema
     */
    public void removerFilme(Filme filme, String motivoExclusaoFilme) {
        int index = cinema.getListaFilmes().indexOf(filme);
        FilmeIndisponivel filmeIndisponivel = new FilmeIndisponivel(filme.getNomeFilme(), filme.getSinopseFilme(), filme.getClassificacaoFilme(), filme.getGeneroFilme(), filme.getDuracaoFilme(), motivoExclusaoFilme);
        cinema.getListaFilmes().set(index, filmeIndisponivel);
    }

    /**
     * Busca filme na lista de filmes disponíveis pelo nome.
     * 
     * @param nomeFilme Nome do filme procurado. 
     * @return <code>Filme</code> buscado ou <code>null</code>, caso não for encontrado.
     * @see Filme
     * @see FilmeIndisponivel
     * @see Cinema
     */
    public Filme buscarFilme(String nomeFilme) {
        for (Filme f : cinema.getListaFilmes()) {
            if (f.getNomeFilme().equalsIgnoreCase(nomeFilme) && !(f instanceof FilmeIndisponivel)) {
                return f;
            }
        }
        return null;
    }
    
    /**
     * Adiciona sala à lista de salas do cinema.
     * <p>
     * Busca primeiro se existe uma sala com o mesmo número. 
     * Se existe, ele retorna <code>false</code> e não permite o cadastro da sala. 
     * Se não existe, ele adiciona a sala à lista e retorna <code>true</code>.
     * </p>
     * 
     * @param sala Sala a ser adicionada. 
     * @return <code>boolean</code> Indica se a sala foi adicionada com sucesso. 
     * @see Cinema#getListaSalas() 
     * @see Sala
     */
    public boolean adicionarSala(Sala sala) {
        // busca se tem sala com o mesmo numero
        if (buscarSala(sala.getNroSala()) == null) {
            cinema.getListaSalas().add(sala);
            return true;
        }
        return false;
    }
    
    /**
     * Edita sala do cinema. 
     * <p>
     * Realiza a edição dos atributos de uma sala. Ele edita somente os parâmetros válidos ou não nulos fornecidos. 
     * Se o número da sala for alterado, verifica se ele já existe no catálogo. Caso exista, ele retorna <code>false</code> e não edita o atributo.
     * </p>
     * 
     * @param sala Sala a ser editada. 
     * @param nroSalaNovo Novo número da sala. Se for 0, o número não é alterado.
     * @param nroAssentoNovo Nova quantidade de assentos. Se for -1, a quantidade não é alterada.
     * @param tipoTelaNovo Novo tipo de tela. Se for null, o tipo não é alterado.
     * @return <code>boolean</code> Indica se a sala foi editada com sucesso.
     * @see Sala
     */
    public boolean editarSala(Sala sala, int nroSalaNovo, int nroAssentoNovo, Boolean tipoTelaNovo){
        if (nroSalaNovo != 0) {
            // Checa se o numero novo eh igual ao número de uma sala que ja existe
            if (buscarSala(nroSalaNovo) == null) { 
                sala.setNroSala(nroSalaNovo);
            }
            else {
                return false;
            }
        }
        else if (nroAssentoNovo != -1) {
            sala.setNroAssentos(nroAssentoNovo);
        }
        else if (tipoTelaNovo != null) { 
            sala.setTipoTela(tipoTelaNovo);
        }
        return true;    
    }
    
    /**
     * Remove sala da lista de salas do cinema.
     * 
     * @param sala Sala a ser removida.
     * @see Cinema
     */
    public void removerSala(Sala sala) {
        cinema.getListaSalas().remove(sala);
    }
    
    /**
     * Busca sala na lista de salas pelo número. 
     * 
     * @param nroSala Número da sala procurada.
     * @return <code>Sala</code> buscada ou <code>null</code>, caso não for encontrada.
     * @see Sala
     * @see Cinema
     */
    public Sala buscarSala(int nroSala) {
        for (Sala s : cinema.getListaSalas()) {
            if (s.getNroSala() == nroSala) {
                return s;
            }
        }
        return null;
    }
    
    /**
     * Adiciona sessão à lista de sessões do cinema.
     * <p>
     * Para adicionar sessão, verifica se sessões com filme +18 são depois das 20h e
     * verifica se há sessões na mesma sala e dia com intervalos de horário que coincidem. 
     * Caso não cumpra essas condições, retorna <code>false</code> e não adiciona a sessão. 
     * </p>
     * 
     * @param sessao Sessao a ser adicionada.
     * @return <code>boolean</code> Indica se a sessão foi adicionada com sucesso. 
     * @see java.time.LocalDateTime
     * @see Sessao
     * 
     */
    public boolean adicionarSessao(Sessao sessao) {
        LocalDateTime inicioSessaoNova = sessao.getDiaHorarioSessao();
        LocalDateTime finalSessaoNova = inicioSessaoNova.plusMinutes(sessao.getFilmeSessao().getDuracaoFilme());

        // Verifica se filme +18 é depois das 20h
        if (sessao.getFilmeSessao().getClassificacaoFilme() == 18 && sessao.getHorarioSessao().isBefore(LocalTime.of(20,00))) {
            return false;
        }

        // Varre o array de sessões e compara sessões que tem a mesma sala e dia
        for (Sessao s : getCinema().getListaSessoes()) {
            Sala salaTemporaria = s.getSalaSessao();
            
            if (!(s instanceof SessaoIndisponivel) && sessao.getSalaSessao().equals(salaTemporaria) && sessao.getDiaSessao().equals(s.getDiaSessao())) {
                LocalDateTime inicioSessao = s.getDiaHorarioSessao();
                LocalDateTime finalSessao = inicioSessao.plusMinutes(s.getFilmeSessao().getDuracaoFilme());

                // Verifica se possuem o mesmo intervalo de horário
                if (checarIntervaloHorario(inicioSessaoNova, finalSessaoNova, inicioSessao, finalSessao)) {
                    return false;
                }
            }
        }

        cinema.getListaSessoes().add(sessao);
        return true; 
    }
    
    /**
     * Edita sessão do cinema.
     * <p>Realiza a edição dos atributos de uma sessão. Ele edita somente os parâmetros válidos ou não nulos fornecidos se atende as condições necessárias:</p>
     * <ul>
     * <li>Na edição de dia, horário ou sala, são verificados se a mudança do atributo coincide com intervalo de horário de outra sessão. Se coincidir, retorna <code>false</code>.</li>
     * <li>Na edição de filme, verifica se o filme é +18 e depois das 20h. Se não for, retorna <code>false</code>.</li>
     * </ul>

     * 
     * @param sessao Sessão a ser editada. 
     * @param diaSessaoNovo Novo dia da sessão. Se for null, o dia não é alterado.
     * @param horarioSessaoNovo Novo horário da sessão. Se for null, o horário não é alterado.
     * @param precoSessaoNovo Novo preço da sessão. Se for -1, o preço não é alterado.
     * @param salaSessaoNovo Nova sala da sessão. Se for null, a sala não é alterada.
     * @param filmeSessaoNovo Novo filme da sessão. Se for null, o filme não é alterado.
     * @return <code>boolean</code> Indica se a sessão foi editada com sucesso.
     * @see java.time.LocalDateTime
     * @see Sessao
     * @see Gerente#checarIntervaloHorario(java.time.LocalDateTime, java.time.LocalDateTime, java.time.LocalDateTime, java.time.LocalDateTime) 
     */
    public boolean editarSessao(Sessao sessao, LocalDate diaSessaoNovo, LocalTime horarioSessaoNovo, double precoSessaoNovo, Sala salaSessaoNovo, Filme filmeSessaoNovo) {
        if (precoSessaoNovo != -1) {
            sessao.setPrecoSessao(precoSessaoNovo);
        }
        else if (salaSessaoNovo != null) {
            // Verifica se mudança de sala invade algum intervalo de horário de outra sessão
            LocalDateTime inicioSessaoNovo = sessao.getDiaHorarioSessao();
            LocalDateTime finalSessaoNovo = inicioSessaoNovo.plusMinutes(sessao.getFilmeSessao().getDuracaoFilme());
            
            for (Sessao s : getCinema().getListaSessoes()) {
                Sala salaTemporaria = s.getSalaSessao();
                
                if (!(s instanceof SessaoIndisponivel) && salaSessaoNovo.equals(salaTemporaria) && sessao.getDiaSessao().equals(s.getDiaSessao())) {
                    if (checarIntervaloHorario(inicioSessaoNovo, finalSessaoNovo, s.getDiaHorarioSessao(), s.getDiaHorarioSessao().plusMinutes(s.getFilmeSessao().getDuracaoFilme()))) {
                        return false;
                    }
                }
            }
            
            sessao.setSalaSessao(salaSessaoNovo);
        }
        else if (filmeSessaoNovo != null) { 
            // Verifica se filme +18 é depois das 20h
            if (filmeSessaoNovo.getClassificacaoFilme() == 18 && sessao.getHorarioSessao().isBefore(LocalTime.of(20,00))) {
                return false;
            }
            sessao.setFilmeSessao(filmeSessaoNovo);
        }
        else if (diaSessaoNovo != null) { 
            // Verifica se mudança de dia possui o mesmo intervalo de horario que outra sessao
            LocalDateTime inicioSessaoNovo = diaSessaoNovo.atTime(sessao.getHorarioSessao());
            LocalDateTime finalSessaoNovo = inicioSessaoNovo.plusMinutes(sessao.getFilmeSessao().getDuracaoFilme());

            for (Sessao s : getCinema().getListaSessoes()) {
                Sala salaTemporaria = s.getSalaSessao();
                
                if (!(s instanceof SessaoIndisponivel) && sessao.getSalaSessao().equals(salaTemporaria) && diaSessaoNovo.equals(s.getDiaSessao())) {
                    if (checarIntervaloHorario(inicioSessaoNovo, finalSessaoNovo, s.getDiaHorarioSessao(), s.getDiaHorarioSessao().plusMinutes(s.getFilmeSessao().getDuracaoFilme()))) {
                        return false;
                    }
                }
            }

            sessao.setDiaSessao(diaSessaoNovo);
        }
        else if (horarioSessaoNovo != null) { 
            // Verifica se mudança de horario possui o mesmo intervalo de horario que outra sessao
            LocalDateTime inicioSessaoNovo = horarioSessaoNovo.atDate(sessao.getDiaSessao());
            LocalDateTime finalSessaoNovo = inicioSessaoNovo.plusMinutes(sessao.getFilmeSessao().getDuracaoFilme());

            for (Sessao s : getCinema().getListaSessoes()) {
                Sala salaTemporaria = s.getSalaSessao();
                
                if (!(s instanceof SessaoIndisponivel) && sessao.getSalaSessao().equals(salaTemporaria) && sessao.getDiaSessao().equals(s.getDiaSessao())) {
                    if (checarIntervaloHorario(inicioSessaoNovo, finalSessaoNovo, s.getDiaHorarioSessao(), s.getDiaHorarioSessao().plusMinutes(s.getFilmeSessao().getDuracaoFilme()))) {
                        return false;
                    }
                }
            }

            sessao.setHorarioSessao(horarioSessaoNovo);
        }
        
        return true;    
    }
    
    /**
     * Indisponibiliza sessão no catálogo.
     * <p>
     * Substitui a sessão por uma sessão indisponível no array, copiando suas informações.
     * </p>
     * @param sessao Sessão a ser removida.
     * @param motivoExclusaoSessao Motivo de exclusão da sessão.
     * @see SessaoIndisponivel
     * @see Cinema
     */
    public void removerSessao(Sessao sessao, String motivoExclusaoSessao) {
        // substitui a sessao por uma sessao indisponivel no array
        int index = cinema.getListaSessoes().indexOf(sessao);
        SessaoIndisponivel sessaoIndisponivel = new SessaoIndisponivel(sessao.getCodigoSessao(), sessao.getDiaHorarioSessao(),sessao.getPrecoSessao(), sessao.getComPromocao(), sessao.getPorcentagemPromocional(), sessao.getSalaSessao(), sessao.getFilmeSessao(), motivoExclusaoSessao);
        cinema.getListaSessoes().set(index, sessaoIndisponivel);
    }
    
    /**
     * Busca sessão na lista de sessões disponíveis pelo código.
     * 
     * @param codigoSessao Código da sessão procurada.
     * @return <code>Sessao</code> buscada ou <code>null</code>, caso não for encontrada.
     * @see Sessao
     * @see Cinema
     */
    public Sessao buscarSessao(int codigoSessao) {
        for (Sessao s : cinema.getListaSessoes()) {
            if (s.getCodigoSessao() == codigoSessao && !(s instanceof SessaoIndisponivel)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Busca sessão na lista de sessões pelo código.
     * 
     * @param codigoSessao Código da sessão procurada.
     * @return <code>Sessao</code> buscada ou <code>null</code>, caso não for encontrada.
     * @see Sessao
     * @see Cinema
     */
    public boolean buscarSessaoTodas(int codigoSessao) {
        for (Sessao s : cinema.getListaSessoes()) {
            if (s.getCodigoSessao() == codigoSessao) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Busca sessão na lista de sessões disponíveis pelo filme.
     * 
     * @param filme Filme da sessão procurada.
     * @return <code>Sessao</code> buscada ou <code>null</code>, caso não for encontrada.
     * @see Filme
     * @see Sessao
     * @see Cinema
     */
    public boolean buscarSessaoComFilme(Filme filme) {
        for (Sessao s : cinema.getListaSessoes()) {
            if (s.getFilmeSessao().equals(filme) && !(s instanceof SessaoIndisponivel)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca sessão na lista de sessões disponíveis pela sala.
     * 
     * @param sala Sala da sessão procurada.
     * @return <code>Sessao</code> buscada ou <code>null</code>, caso não for encontrada.
     * @see Sala
     * @see Sessao
     * @see Cinema
     */
    public boolean buscarSessaoComSala(Sala sala) {
        for (Sessao s : cinema.getListaSessoes()) {
            if (s.getSalaSessao().equals(sala) && !(s instanceof SessaoIndisponivel)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Adiciona promoção a uma sessão do cinema.
     * <p>
     * Adiciona promoção somente a sessões que ainda não possuem. Se elas tiverem, retorna <code>false</code>.
     * </p>
     * 
     * @param sessao Sessão que irá receber uma promoção.
     * @param porcentagemPromocional Porcentagem promocional entre 0 e 1.
     * @return <code>boolean</code> Indica se promoção foi adicionada com sucesso.
     * @see Sessao
     */
    public boolean adicionarPromocao(Sessao sessao, double porcentagemPromocional) {
        // checa se sessao nao possui promocao
        if (!(sessao.getComPromocao())) {
            sessao.setComPromocao(true);
            sessao.setPorcentagemPromocional(porcentagemPromocional);
            return true;
        } 
        return false;       
    }
    
    /**
     * Edita promoção de uma sessão do cinema.
     * <p>
     * Edita promoção somente de sessões que já possuem. Se elas não tiverem promoção, retorna <code>false</code>.
     * </p>
     * 
     * @param sessao Sessão com promoção a ser editada.
     * @param porcentagemPromocionalNova Nova porcentagem promocional entre 0 e 1.
     * @return <code>boolean</code> Indica se promoção foi editada com sucesso.
     */
    public boolean editarPromocao(Sessao sessao, double porcentagemPromocionalNova) {
    	if(sessao.getComPromocao()) {
            sessao.setPorcentagemPromocional(porcentagemPromocionalNova);
            return true; 
    	}	
        return false; 
    }

    /**
     * Exclui promoção de uma sessão do cinema.
     * <p>
     * Exclui promoção somente de sessões que já possuem. Se elas não tiverem promoção, retorna <code>false</code>.
     * </p>
     * 
     * @param sessao Sessão com promoção a ser excluída.
     * @return <code>boolean</code> Indica se promoção foi excluída com sucesso.
     */
    public boolean excluirPromocao(Sessao sessao) {
        // checa se sessao possui promocao cadastrada
    	if(sessao.getComPromocao()) {
            sessao.setComPromocao(false); 
            sessao.setPorcentagemPromocional(1);
            return true;
    	}
        return false; 
    }   
    
    /**
     * Imprime filmes disponíveis e indisponíveis e sua quantidade. 
     * 
     * @param listaFilmes Lista de filmes.
     */
    public void gerarRelatorioFilmes(ArrayList <Filme> listaFilmes) {
        int nroFilmesEmCartaz = 0;
        int nroFilmesIndisponiveis = 0; 
    	
        if(!listaFilmes.isEmpty()) {
	    for(Filme filme : listaFilmes) {
	    	if(!(filme instanceof FilmeIndisponivel)) {
                    nroFilmesEmCartaz++; 
	    	}
	    	else {
                    nroFilmesIndisponiveis++; 
	    	}
	    }
        }
    	
        System.out.println("\nFilmes disponiveis: ");
    	
        if (nroFilmesEmCartaz > 0) {
            for(Filme filme : listaFilmes) {
                if(!(filme instanceof FilmeIndisponivel)) {
                    System.out.println("\n" + filme);
        	}
            }
            System.out.println("\n- Existe " + nroFilmesEmCartaz + " filme(s) em cartaz.");
        }
        else {
            System.out.println("\n- Nao existem filmes disponiveis.");
        }

        System.out.println("\nFilmes indisponiveis: ");
    	
        if (nroFilmesIndisponiveis > 0) {
            for(Filme filme : listaFilmes) {
        	if(filme instanceof FilmeIndisponivel) {
                    System.out.print("\n" + filme + "\n- Motivo de exclusao: " + FilmeIndisponivel.getMotivoExclusaoFilme()); 
        	}
            }
            System.out.println("\n\n- Existe " + nroFilmesIndisponiveis + " filme(s) indisponiveis.");
        }
        else {
            System.out.println("\n- Nao existem filmes indisponiveis.");
        }
    }
    
    /**
     * Imprime sessões disponíveis e indisponíveis e sua quantidade.
     * 
     * @param listaSessoes Lista de sessões. 
     */
    public void gerarRelatorioSessoes(ArrayList <Sessao> listaSessoes) { 	
        int nroSessoesCadastradas = 0;
        int nroSessoesIndisponiveis = 0; 
    	
        if( !listaSessoes.isEmpty()) {
            for(Sessao sessao : listaSessoes) {
                if(!(sessao instanceof SessaoIndisponivel)) {
                    nroSessoesCadastradas++; 
                }
                else {
                    nroSessoesIndisponiveis++; 
                }
	    }
    	}
    	
    	System.out.println("Sessoes disponiveis: ");
    	
        if (nroSessoesCadastradas > 0) {
            for(Sessao sessao : listaSessoes) {
        	if(!(sessao instanceof SessaoIndisponivel)) {
                    System.out.print("\n" + sessao);
        	}
            }
            System.out.println("\n\n- Existe " + nroSessoesCadastradas + " sessoes disponiveis.");	
        }
    	else {
            System.out.println("\n- Nao existem sessoes disponiveis.");
    	}
        
    	System.out.println("\nSessoes indisponiveis: ");
    	
    	if (nroSessoesIndisponiveis > 0) {
            for(Sessao sessao : listaSessoes) {
                if(sessao instanceof SessaoIndisponivel) {
                    System.out.print("\n" + sessao + "\n- Motivo de exclusao: " + SessaoIndisponivel.getMotivoExclusaoSessao()); 
                }
            }
            System.out.println("\n\n- Existe " + nroSessoesIndisponiveis + " sessoes indisponiveis.");
        }
    	else {
            System.out.println("\n- Nao existem sessoes indisponiveis.");
        }
    }
    
    /**
     * Imprime salas e sua quantidade.
     * 
     * @param listaSalas Lista de salas.
     */
    public void gerarRelatorioSalas(ArrayList <Sala> listaSalas) {    	
        int nroSalasCadastradas = 0; 

        if (!listaSalas.isEmpty()) {
            for(Sala salas : listaSalas) {
                System.out.println(salas + "\n");
                nroSalasCadastradas++;
            }
            System.out.println("- Existe " + nroSalasCadastradas + " sala(s) cadastrada(s)."); 
        }    
        else {
            System.out.println("- Nao existem salas disponiveis.");
        }	
    }
    
    /**
     * Imprime a quantidade de usuários por tipo e o valor arrecadado do cinema. 
     * 
     */
    public void gerarRelatorioUsuarios() {
        int nroUsuariosAssinantes = 0; 
	int nroUsuarios = 0; 
	double totalArrecadado = 0;
        
	for(Usuario user : listaUsuarios) {
            if(user instanceof UsuarioAssinante) {
		nroUsuariosAssinantes++;
		nroUsuarios++;
            }
            else {
		nroUsuarios++; 
            }
            
            if (user.getIngressosComprados() != null && !(user.getIngressosComprados().isEmpty())) {
                for (Ingresso ingresso : user.getIngressosComprados()) {
                    totalArrecadado += ingresso.getPrecoIngresso();
                }
            }
	}
		
	System.out.print("Numero de usuarios cadastrados: " + nroUsuarios + "\nNumero de usuarios assinantes: " + nroUsuariosAssinantes);
        System.out.print("\nTotal arrecadado: " + totalArrecadado);
   }
    
    /**
     * Verifica se intervalos de horário de sessões coincidem.
     * <p>
     * Checa as seguintes situações para verificar se o horário está livre:
     * <ul>
     * <li>Se horários de início são iguais.</li>
     * <li>Se horários de início e final da sessão nova estão entre o intervalo da sessão existente.</li>
     * <li>Se horários de início e final de sessão existente estão entre o intervalo da sessão nova.</li>
     * </ul>
     * </p>
     * 
     * @param inicioSessaoNova Início da sessão nova.
     * @param finalSessaoNova Final da sessão nova.
     * @param inicioSessao Início da sessão existente.
     * @param finalSessao Final da sessão existente.
     * @return <code>boolean</code> Indica se o horário está livre (<code>false</code>) ou se coincide (<code>true</code>).
     * @see java.time.LocalDateTime
     */
    private boolean checarIntervaloHorario(LocalDateTime inicioSessaoNova, LocalDateTime finalSessaoNova, LocalDateTime inicioSessao, LocalDateTime finalSessao) {
        // Checa se horarios de inicio são iguais
        if (inicioSessaoNova.equals(inicioSessao)) {
            return true;
        }
        // Checa se horarios de inicio e final da sessao nova estao entre o intervalo da sessao existente
        else if ((inicioSessaoNova.isAfter(inicioSessao) && inicioSessaoNova.isBefore(finalSessao)) || (finalSessaoNova.isAfter(inicioSessao) && finalSessaoNova.isBefore(finalSessao))) {
            return true;
        }
        // Checa se horarios de inicio e final de sessao existente estao entre o intervalo da sessao nova
        else if ((inicioSessao.isAfter(inicioSessaoNova) && inicioSessao.isBefore(finalSessaoNova)) || (finalSessao.isAfter(inicioSessaoNova)) && finalSessao.isBefore(finalSessaoNova)) {
            return true;
        }
        // O horario esta livre
        else { 
            return false;
        }
    }
    
    /**
     * Muda o cinema que está sendo administrado pelo gerente.
     * 
     * @param cinema Cinema.
     */
    public final void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    /**
     * Obtém o cinema que está sendo administrado pelo gerente.
     * 
     * @return <code>Cinema</code> Cinema. 
     */
    public Cinema getCinema() {
        return this.cinema;
    }

    /**
     * Muda a lista de usuários.
     * 
     * @param listaUsuarios Arraylist contendo os usuários.
     */
    public final void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * Obtém a lista de usuários.
     * 
     * @return <code>ArrayList</code> contendo os usuários.
     */
    public ArrayList<Usuario> getListaUsuarios() {
        return this.listaUsuarios;
    }     
    
}
