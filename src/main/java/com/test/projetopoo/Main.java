package main.java.com.test.projetopoo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Cinema cinema = new Cinema("GIG CINEMAS");

        Gerente gerente = new Gerente("Nome do Admin", "admin", "123", cinema);
        
        Scanner sc = new Scanner(System.in);
        boolean estaRodando = true;
        Pessoa pessoa = null;
        int opcao, opcaoMenuGerente;
        
        while(estaRodando) {
            if(pessoa == null) { // menu nao logado
                opcao = imprimeMenuNaoLogado(cinema, sc);
                
                switch(opcao) {
                    case 1: 
                        imprimeMenuCadastro(gerente.getListaUsuarios(), gerente, sc);
                        break;
                    case 2:
                        pessoa = imprimeMenuLogin(gerente.getListaUsuarios(), gerente, sc);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Opcao invalida. Tente novamente");
                        break;
                }
                
            }
            
            else {
                if (pessoa instanceof Gerente) { // menu gerente
                    opcao = imprimeMenuGerente(sc);
                    
                    switch(opcao) {
                        case 1: // aba de filmes 
                            opcaoMenuGerente = imprimeMenuGerenteFilme(sc);

                            switch(opcaoMenuGerente) {
                                case 1:
                                    imprimeMenuGerenteCadastroFilme(gerente, sc);
                                    break;
                                case 2:
                                    imprimeMenuGerenteEdicaoFilme(gerente, sc);
                                    break;
                                case 3:
                                    imprimeMenuGerenteRemocaoFilme(gerente, sc);
                                    break;
                                case 4:
                                    imprimeListaFilmes(cinema);
                                    sc.nextLine();
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Opcao invalida. Tente novamente");
                                    break;
                            }
                            break;
                        case 2: // aba de sala
                            opcaoMenuGerente = imprimeMenuGerenteSala(sc);

                            switch(opcaoMenuGerente) {
                                case 1:
                                    imprimeMenuGerenteCadastroSala(gerente, sc);
                                    break;
                                case 2:
                                    imprimeMenuGerenteEdicaoSala(gerente, sc);
                                    break;
                                case 3:
                                    imprimeMenuGerenteRemocaoSala(gerente, sc);
                                    break;
                                case 4:
                                    imprimeListaSalas(cinema);
                                    sc.nextLine();
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Opcao invalida. Tente novamente");
                                    break;
                            }
                            break;
                        case 3: // aba de sessao
                            opcaoMenuGerente = imprimeMenuGerenteSessao(sc);

                            switch(opcaoMenuGerente) {
                                case 1:
                                    imprimeMenuGerenteCadastroSessao(gerente, sc);
                                    break;
                                case 2:
                                    imprimeMenuGerenteEdicaoSessao(gerente, sc);
                                    break;
                                case 3:
                                    imprimeMenuGerenteRemocaoSessao(gerente, sc);
                                    break;
                                case 4:
                                    imprimeListaSessoes(cinema);
                                    sc.nextLine();
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Opcao invalida. Tente novamente");
                                    break;
                            }
                            break;
                        case 4: // aba de promocao
                            opcaoMenuGerente = imprimeMenuGerentePromocao(sc);

                            switch(opcaoMenuGerente) {
                                case 1:
                                    imprimeMenuGerenteCadastroPromocao(gerente, sc);
                                    break;
                                case 2:
                                    imprimeMenuGerenteEdicaoPromocao(gerente, sc);
                                    break;
                                case 3:
                                    imprimeMenuGerenteRemocaoPromocao(gerente, sc);
                                    break;
                                case 4: 
                                    break;
                                default: 
                                    System.out.println("Opcao invalida. Tente novamente");
                                    break;
                            }

                            break;
                        case 5: // aba de relatorios
                            opcaoMenuGerente = imprimeMenuGerenteRelatorio(sc); 
                        	
                        	switch(opcaoMenuGerente) {
                        		case 1:
                        			imprimeMenuGerenteRelatorioFilmes(gerente, cinema);
                        			sc.nextLine();
                        			break;
                        		case 2: 
                        			imprimeMenuGerenteRelatorioSessoes(gerente, cinema); 
                        			sc.nextLine();
                        			break;
                        		case 3: 
                        			imprimeMenuGerenteRelatorioSalas(gerente, cinema); 
                        			sc.nextLine();
                        			break;
                        		case 4: 
                        			imprimeMenuGerenteRelatorioUsuario(gerente); 
                        			sc.nextLine();
                        			break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Opcao invalida. Tente novamente");
                                    break;                       			
                        	}        
                            break;
                        case 6: // sair
                            pessoa = null;
                            break;
                        default:
                            System.out.println("Opcao invalida. Tente novamente");
                            break;
                    } 
                    
                }
                else if (pessoa instanceof Usuario) { // menu usuario
                    opcao = imprimeMenuUsuario(sc);
                    
                    switch(opcao) {
                        case 1: // aba para comprar ingressos
                            imprimeMenuUsuarioComprarIngresso((Usuario)pessoa, gerente, sc);
                            break;
                        case 2: // aba para comprar assinatura
                            pessoa = imprimeMenuUsuarioComprarAssinatura((Usuario)pessoa, gerente, sc);
                            break;
                        case 3: // aba para ver perfil
                            imprimeMenuUsuarioPerfil((Usuario)pessoa); // VERIFICAR ISSO
                            sc.nextLine();
                            break;
                        case 4: // sair 
                            pessoa = null;
                            break;
                        default:
                            System.out.println("Opcao invalida. Tente novamente");
                            break;
                    }    
                }
            }
        }
        
        sc.close();
    }
    
    public static int imprimeMenuNaoLogado(Cinema cinema, Scanner sc) {
        int opcao; 
        
        System.out.println(cinema.getNomeCinema());
        System.out.println("Bem Vindo!");
        System.out.println("");
        System.out.println("(1) Cadastro");
        System.out.println("(2) Login");
        System.out.println("(3) Sair");
        System.out.printf("Entre uma opcao: ");
        opcao = Integer.parseInt(sc.nextLine());
        System.out.println();

        return opcao;
    }
    
    public static void imprimeMenuCadastro(ArrayList<Usuario> listaUsuarios, Gerente gerente, Scanner sc) {
        String nomeUsuario;
        String loginUsuario;
        String senhaUsuario;
        int idadeUsuario;
        
        System.out.println("CADASTRO");
        System.out.printf("Digite seu nome: ");
        nomeUsuario = sc.nextLine();
        System.out.printf("Digite um usuario: ");
        loginUsuario = sc.nextLine();
        System.out.printf("Digite uma senha: ");
        senhaUsuario = sc.nextLine();
        System.out.printf("Digite sua idade: ");
        idadeUsuario = Integer.parseInt(sc.nextLine());
        System.out.println();

        if (buscarUsuario(loginUsuario, listaUsuarios) == null) {
            Usuario usuario = new Usuario(nomeUsuario, loginUsuario, senhaUsuario, idadeUsuario);
            listaUsuarios.add(usuario);

            System.out.println("Usuario cadastrado com sucesso!");
            System.out.println("- Nome: " + nomeUsuario);
            System.out.println("- Idade: " + idadeUsuario);
            System.out.println("- Login: " + loginUsuario);
            System.out.println("- Senha: " + senhaUsuario);
        }
        else {
            System.out.println("Erro no cadastro. Usuario ja esta cadastrado");            
        }
        
        System.out.println();

    }    

    public static Usuario buscarUsuario(String loginUsuario, ArrayList<Usuario> listaUsuarios) {
        for (Usuario usuarioTemporario : listaUsuarios) {
            if (loginUsuario.equals(usuarioTemporario.getLoginPessoa())) {
                return usuarioTemporario;
            }
        }

        return null;
    }
    
    public static Pessoa imprimeMenuLogin(ArrayList<Usuario> listaUsuarios, Gerente gerente, Scanner sc) {
        String loginTemporario;
        String senhaTemporaria;
        
        System.out.println("LOGIN");
        System.out.printf("Digite um usuario: ");
        loginTemporario = sc.nextLine();
        System.out.printf("Digite uma senha: ");
        senhaTemporaria = sc.nextLine();
        System.out.println();

        if (loginTemporario.equals(gerente.getLoginPessoa()) && senhaTemporaria.equals(gerente.getSenhaPessoa())) {
            System.out.println("Sucesso no Login! Bem-vindo!");   
            System.out.println();         
            return gerente;
        }

        for (Usuario usuarioTemporario : listaUsuarios) {
            if (loginTemporario.equals(usuarioTemporario.getLoginPessoa()) && senhaTemporaria.equals(usuarioTemporario.getSenhaPessoa())) {
                System.out.println("Sucesso no Login! Bem-vindo!");
                System.out.println();
                return usuarioTemporario;
            }
        }   
        
        System.out.println("Erro no login. Usuario ou senha incorretos");
        System.out.println();
        return null;

    }
    
    public static int imprimeMenuGerente(Scanner sc) {
        int opcao;
        
        System.out.println("MENU DO GERENTE");
        System.out.println("(1) Filme");
        System.out.println("(2) Sala");
        System.out.println("(3) Sessao");
        System.out.println("(4) Promocao");
        System.out.println("(5) Exibir Relatorios");
        System.out.println("(6) Sair");

        System.out.print("Digite uma opcao: ");
        opcao = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        return opcao;
    }

    public static int imprimeMenuGerenteFilme(Scanner sc) {
        int opcao;
        
        System.out.println("FILME");
        System.out.println("(1) Cadastrar Filme");
        System.out.println("(2) Editar Filme");
        System.out.println("(3) Remover Filme");
        System.out.println("(4) Listar Filmes");
        System.out.println("(5) Sair");

        System.out.print("Digite uma opcao: ");
        opcao = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        return opcao;
    }
    
    public static void imprimeMenuGerenteCadastroFilme(Gerente gerente, Scanner sc) {
        String nomeFilme;
        String sinopseFilme;
        int classificacaoFilme;
        String generoFilme;
        int duracaoFilme;
        String confirmacao;
                
        System.out.println("CADASTRAR FILME NO CATALOGO");
        System.out.println("Entre com as informacoes do filme desejado: ");
        System.out.print("- Nome: ");
        nomeFilme = sc.nextLine();
        System.out.print("- Sinopse: ");
        sinopseFilme = sc.nextLine();
        System.out.print("- Classificacao Indicativa: ");
        classificacaoFilme = Integer.parseInt(sc.nextLine());
        System.out.print("- Genero: ");
        generoFilme = sc.nextLine();
        System.out.print("- Duracao (em minutos): ");
        duracaoFilme = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        Filme filmeTemporario = new Filme(nomeFilme, sinopseFilme, classificacaoFilme, generoFilme, duracaoFilme);
        
        System.out.println(filmeTemporario.toString());
        System.out.print("Confirmar adicao do filme ao catalogo (Sim ou Nao): ");
        confirmacao = sc.nextLine();
        
        if (confirmacao.equalsIgnoreCase("Sim")) {
            if(gerente.adicionarFilme(filmeTemporario)) {
                System.out.println("Filme adicionado com sucesso");
                System.out.println();
            }
            else {
                System.out.println("Filme ja existe no catalogo");
                System.out.println();
            }
        }
        
    }
    
    public static void imprimeMenuGerenteEdicaoFilme(Gerente gerente, Scanner sc) {
        int opcao;
        String nomeFilme;
        String confirmacao;

        System.out.println("EDITAR FILME DO CATALOGO");
        imprimeListaFilmes(gerente.getCinema());
        System.out.printf("Digite o nome do filme a ser alterado: ");
        nomeFilme = sc.nextLine();
        System.out.println();
        
        Filme filme = gerente.buscarFilme(nomeFilme);

        if (filme != null) {
            System.out.println("Parametros que podem ser alterados: ");
            System.out.println("(1) Nome");
            System.out.println("(2) Sinopse");
            System.out.println("(3) Classificacao Indicativa");
            System.out.println("(4) Genero");
            System.out.println("(5) Duracao");
            System.out.print("Escolha um parametro: ");
            opcao = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch(opcao) {
                case 1: 
                    System.out.print("Digite o nome novo: ");
                    String nomeNovo = sc.nextLine();
                    System.out.println();

                    System.out.println("- Nome Antigo: " + filme.getNomeFilme());
                    System.out.println("- Nome Novo: " + nomeNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarFilme(filme, nomeNovo, "", -1, "", -1);
                    }
                    break;
                case 2:
                    System.out.printf("Digite a sinopse nova: ");
                    String sinopseNova = sc.nextLine();
                    System.out.println();

                    System.out.println("Sinopse Antiga: " + filme.getSinopseFilme());
                    System.out.println("Sinopse Nova: " + sinopseNova);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarFilme(filme, "", sinopseNova, -1, "", -1);
                    }
                    break;
                case 3:
                    System.out.printf("Digite a classificacao indicativa nova: ");
                    int classificacaoNova = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    System.out.println("- Classificacao Indicativa Antiga: " + filme.getClassificacaoFilme());
                    System.out.println("- Classificacao Indicativa Nova: " + classificacaoNova);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarFilme(filme, "", "", classificacaoNova, "", -1);
                    }
                    break;
                case 4:
                    System.out.printf("Digite o genero novo: ");
                    String generoNovo = sc.nextLine();
                    System.out.println();

                    System.out.println("- Genero Antigo: " + filme.getGeneroFilme());
                    System.out.println("- Genero Novo: " + generoNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarFilme(filme, "", "", -1, generoNovo, -1);
                    }
                    break;
                case 5:
                    System.out.printf("Digite a duracao nova: ");
                    int duracaoNova = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    System.out.println("- Duracao Antiga: " + filme.getDuracaoFilme());
                    System.out.println("- Genero Novo: " + duracaoNova);
                    
                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarFilme(filme, "", "", -1, "", duracaoNova);
                    }
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
        else {
            System.out.println("Filme nao encontrado");
        }
        
        System.out.println();
       
    }
    
    public static void imprimeMenuGerenteRemocaoFilme(Gerente gerente, Scanner sc) {
        String nomeFilme;
        String motivoExclusaoFilme;
        String confirmacao;

        System.out.println("REMOCAO DE FILME DO CATALOGO");
        imprimeListaFilmes(gerente.getCinema());
        System.out.printf("Digite o nome do filme a ser removido: ");
        nomeFilme = sc.nextLine();

        Filme filme = gerente.buscarFilme(nomeFilme);
        
        if (filme != null) { 
            System.out.printf("Digite o motivo de exclusao do filme: ");
            motivoExclusaoFilme = sc.nextLine();

            for (Sessao s : gerente.getCinema().getListaSessoes()) { // verifica se ha sessoes cadastradas com aquele filme
                if (s.getFilmeSessao() == filme) {
                    System.out.println("Sessao possui filme cadastrado. Tente novamente");
                    System.out.println();
                    return;
                }
            }

            System.out.print("Confirmar remocao do filme (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.removerFilme(filme, motivoExclusaoFilme)) {
                    System.out.println("Filme removido com sucesso");
                }
                else {
                    System.out.println("Filme ja foi removido");
                }
            }
        }
        else {
            System.out.println("Filme nao encontrado");
        }
        
        System.out.println();
    }
    
    public static void imprimeListaFilmes(Cinema cinema) {
                
        for (Filme f : cinema.getListaFilmes()) {
            if (!(f instanceof FilmeIndisponivel)) {
                System.out.println(f.toString());
            }
        }
    }

    public static int imprimeMenuGerenteSala(Scanner sc) {
        int opcao;
        
        System.out.println("SALA");
        System.out.println("(1) Cadastrar Sala");
        System.out.println("(2) Editar Sala");
        System.out.println("(3) Remover Sala");
        System.out.println("(4) Listar Salas");
        System.out.println("(5) Sair");

        System.out.print("Digite uma opcao: ");
        opcao = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        return opcao;
    }

    public static void imprimeMenuGerenteCadastroSala(Gerente gerente, Scanner sc) {
        int nroSala;
        int nroAssentos;
        String tipoTelaString;
        boolean tipoTela;
        String confirmacao;

        System.out.println("CADASTRAR SALA");
        System.out.println("Entre com as informacoes da sala:");
        System.out.print("- Numero da Sala: ");
        nroSala = Integer.parseInt(sc.nextLine());
        System.out.print("- Numero de Assentos: ");
        nroAssentos = Integer.parseInt(sc.nextLine());
        System.out.print("- Tipo da Tela (2D ou 3D): ");
        tipoTelaString = sc.nextLine();
        System.out.println();

        if (tipoTelaString.equalsIgnoreCase("2D")) {
            tipoTela = false;
        }
        else if (tipoTelaString.equalsIgnoreCase("3D")) {
            tipoTela = true;
        }
        else {
            System.out.println("Tipo de tela invalido. Tente novamente");
            sc.nextLine();
            return;
        }

        Sala salaTemporaria = new Sala(nroSala, nroAssentos, tipoTela);

        
        System.out.println(salaTemporaria.toString());
        System.out.print("Confirmar adicao da sala (Sim ou Nao): ");
        confirmacao = sc.nextLine();
        
        if (confirmacao.equalsIgnoreCase("Sim")) {
            if(gerente.adicionarSala(salaTemporaria)) {
                System.out.println("Sala adicionada com sucesso");
                System.out.println();
            }
            else {
                System.out.println("Sala ja existe");
                System.out.println();
            }
        }
    }

    public static void imprimeMenuGerenteEdicaoSala(Gerente gerente, Scanner sc) {
        int opcao;
        int nroSala;
        String confirmacao;

        System.out.println("EDITAR SALA");
        imprimeListaSalas(gerente.getCinema());
        System.out.printf("Digite o numero da sala a ser alterada: ");
        nroSala = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        Sala sala = gerente.buscarSala(nroSala);

        if (sala != null) { 
            System.out.println("Parametros que podem ser alterados: ");
            System.out.println("(1) Numero da Sala");
            System.out.println("(2) Numero de Assentos");
            System.out.println("(3) Tipo de Tela");
            System.out.print("Escolha um parametro: ");
            opcao = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch(opcao) {
                case 1:
                    System.out.print("Digite o numero da sala novo: ");
                    int nroSalaNovo = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    System.out.println("- Numero da Sala Antigo: " + sala.getNroSala());
                    System.out.println("- Numero da Sala Novo: " + nroSalaNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarSala(sala,nroSalaNovo, -1, null);
                    }
                    break;
                case 2:
                    System.out.printf("Digite o numero de assentos novo: ");
                    int nroAssentosNovo = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    System.out.println("- Numero de Assentos Antigo: " + sala.getNroAssentos());
                    System.out.println("- Numero de Assentos Novo: " + nroAssentosNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarSala(sala, 0, nroAssentosNovo, null);
                    }
                    break;
                case 3:
                    System.out.printf("Digite o tipo de tela novo (2D ou 3D): ");
                    String tipoTelaString = sc.nextLine();
                    System.out.println();

                    boolean tipoTelaNovo;
                    if (tipoTelaString.equalsIgnoreCase("2D")) {
                        tipoTelaNovo = false;
                    }
                    else if (tipoTelaString.equalsIgnoreCase("3D")) {
                        tipoTelaNovo = true;
                    }
                    else {
                        System.out.println("Tipo de tela invalido. Tente novamente");
                        sc.nextLine();
                        return;
                    }

                    System.out.println("- Tipo de Tela Antigo: " + (sala.getTipoTela() ? "3D" : "2D"));
                    System.out.println("- Numero de Assentos Novo: " + (tipoTelaNovo ? "3D" : "2D"));

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarSala(sala, 0, -1, tipoTelaNovo);
                    }
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }    
        }

        System.out.println();

    }

    public static void imprimeMenuGerenteRemocaoSala(Gerente gerente, Scanner sc) {
        int nroSala;
        String confirmacao;

        System.out.println("REMOCAO DE SALA");
        imprimeListaSalas(gerente.getCinema());
        System.out.printf("Digite o numero da sala a ser removida: ");
        nroSala = Integer.parseInt(sc.nextLine());

        Sala sala = gerente.buscarSala(nroSala);
        
        if (sala != null) {

            for (Sessao s : gerente.getCinema().getListaSessoes()) { // verifica se ha alguma sessao cadastrada para a sala
                if (s.getSalaSessao() == sala) {
                    System.out.println("Sala possui sessao cadastrada");
                    System.out.println();
                    return;
                }
            }

            System.out.print("Confirmar remocao da sala (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.removerSala(nroSala)) {
                    System.out.println("Sala removida com sucesso");
                }
                else {
                    System.out.println("Sala ja foi removido");
                }
            }
        }
        else {
            System.out.println("Sala nao encontrado");
        }
        
        System.out.println();
    }
    
    public static void imprimeListaSalas(Cinema cinema) {
        for (Sala s : cinema.getListaSalas()) {
            System.out.println(s.toString());
        }
    }

    public static int imprimeMenuGerenteSessao(Scanner sc) {
        int opcao;
        
        System.out.println("SESSAO");
        System.out.println("(1) Cadastrar Sessao");
        System.out.println("(2) Editar Sessao");
        System.out.println("(3) Remover Sessao");
        System.out.println("(4) Listar Sessoes");
        System.out.println("(5) Sair");

        System.out.print("Digite uma opcao: ");
        opcao = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        return opcao;
    }

    public static void imprimeMenuGerenteCadastroSessao(Gerente gerente, Scanner sc) {
        String nomeFilme;
        Filme filmeSessao; 
        int nroSala;
        Sala salaSessao;
        String diaSessaoString; 
        LocalDate diaSessao;
        String horarioSessaoString;
        LocalTime horarioSessao;
        DateTimeFormatter formatter;
        double precoSessao;
        String confirmacao;

        System.out.println("CADASTRAR SESSAO");
        System.out.println("Entre com as informacoes da sessao: ");
        System.out.print("- Nome do Filme: ");
        nomeFilme = sc.nextLine();
        
        // busca filme disponivel no catalogo
        filmeSessao = gerente.buscarFilme(nomeFilme);

        // se encontra um filme, o cadastro da sessão é realizado
        if (filmeSessao != null) {
            System.out.print("- Numero da Sala: ");
            nroSala = Integer.parseInt(sc.nextLine());

            // busca sala do cinema
            salaSessao = gerente.buscarSala(nroSala);
            
            // se encontra uma sala, o cadastro de uma sessao é realizado
            if (salaSessao != null) {
                System.out.print("- Dia da sessao (DD/MM/YYYY): ");
                diaSessaoString = sc.nextLine();
                formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                diaSessao = LocalDate.parse(diaSessaoString, formatter); 

                System.out.print("- Horario da sessao (HH:mm): ");
                horarioSessaoString = sc.nextLine();
                formatter = DateTimeFormatter.ofPattern("HH:mm");
                horarioSessao = LocalTime.parse(horarioSessaoString, formatter);

                LocalDateTime diaHorarioSessao = diaSessao.atTime(horarioSessao);

                System.out.print("- Preco da sessao: ");
                precoSessao = Double.parseDouble(sc.nextLine());
                System.out.println();

                Sessao sessaoTemporaria = new Sessao(diaHorarioSessao, precoSessao, false, 1, salaSessao, filmeSessao); // conferir promocao

                System.out.println(sessaoTemporaria.toString());
                System.out.print("Confirmar adicao da sessao (Sim ou Nao): ");
                confirmacao = sc.nextLine();

                // confirma a criacao de uma sessao, checando condições de horário e classificação indicativa
                if (confirmacao.equalsIgnoreCase("Sim")) {
                    if (gerente.adicionarSessao(sessaoTemporaria)) {
                        System.out.println("Sessao adicionada com sucesso");
                    }
                    else {
                        System.out.println("Erro ao adicionar a sessao.");
                        System.out.println("Possiveis problemas: dia e horario coincidem com outra sessao ou sessao +18 antes das 20h.");
                        Sessao.decrementaQuantidadeSessoes();
                    }
                }
                else {
                    Sessao.decrementaQuantidadeSessoes();
                }
            }
            else {
                System.out.println("Sala nao encontrada");
            }
        }
        else {
            System.out.println("Filme nao encontrado");
        }

        System.out.println();

    }

    public static void imprimeMenuGerenteEdicaoSessao(Gerente gerente, Scanner sc) {
        int opcao;
        int codigoSessao;
        DateTimeFormatter formatter;
        String confirmacao;

        System.out.println("EDITAR SESSAO");
        imprimeListaSessoes(gerente.getCinema());
        System.out.printf("Digite o codigo da sessao a ser alterada: ");
        codigoSessao = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        // busca sessao disponivel no cinema
        Sessao sessao = gerente.buscarSessao(codigoSessao);

        // se encontra sessao no catalogo, permite a mudança de parâmetros
        if (sessao != null) {
            System.out.println("Parametros que podem ser alterados: ");
            System.out.println("(1) Filme da Sessao");
            System.out.println("(2) Sala da Sessao");
            System.out.println("(3) Dia");
            System.out.println("(4) Horario");
            System.out.println("(5) Preco da Sessao");
            System.out.print("Escolha um parametro: ");
            opcao = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch(opcao) {
                case 1: // mudança do filme da sessão
                    imprimeListaFilmes(gerente.getCinema());
                    System.out.print("Digite o nome do filme novo: ");
                    String nomeFilmeNovo = sc.nextLine();
                    System.out.println();

                    Filme filmeSessao = gerente.buscarFilme(nomeFilmeNovo);

                    if (filmeSessao != null) {
                        System.out.println("- Filme Antigo: " + sessao.getFilmeSessao().getNomeFilme());
                        System.out.println("- Filme Novo: " + nomeFilmeNovo);

                        System.out.print("Confirmar edicao (Sim ou Nao): ");
                        confirmacao = sc.nextLine();
                        
                        if (confirmacao.equalsIgnoreCase("Sim")) {
                            gerente.editarSessao(sessao, null, null, -1, null, filmeSessao);
                        }
                    }
                    else {
                        System.out.println("Filme nao encontrado");
                    }
                    break;
                case 2: // mudança da sala da sessão
                    imprimeListaSalas(gerente.getCinema());
                    System.out.print("Digite o numero novo da sala: ");
                    int nroSalaNovo = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    Sala salaSessao = gerente.buscarSala(nroSalaNovo);

                    if (salaSessao != null) {
                        System.out.println("- Sala Antiga: " + sessao.getSalaSessao().getNroSala());
                        System.out.println("- Sala Nova: " + nroSalaNovo);

                        System.out.print("Confirmar edicao (Sim ou Nao): ");
                        confirmacao = sc.nextLine();
                        
                        if (confirmacao.equalsIgnoreCase("Sim")) {
                            gerente.editarSessao(sessao, null, null, -1, salaSessao, null);
                        }
                    }
                    else {
                        System.out.println("Sala nao encontrada");
                    }
                    break;
                case 3: // mudança do dia da sessão
                    System.out.print("Digite o dia novo (DD/MM/YYYY): ");
                    String diaSessaoString = sc.nextLine();
                    formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate diaSessao = LocalDate.parse(diaSessaoString, formatter); // TESTAR EXCECAO
                    System.out.println();
                    
                    System.out.println("- Dia Antigo: " + sessao.getDiaSessao());
                    System.out.println("- Dia Novo: " + diaSessao);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();
                        
                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        if (!(gerente.editarSessao(sessao, diaSessao, null, -1, null, null))) {
                            System.out.println("Erro ao editar sessao. Intervalo de horario coincide com o de outra sessao...");
                        }
                    }
                    break;
                case 4: // mudança do horário da sessão
                    System.out.print("Digite o horario novo (MM:mm): ");
                    String horarioSessaoString = sc.nextLine();
                    formatter = DateTimeFormatter.ofPattern("HH:mm");
                    LocalTime horarioSessao = LocalTime.parse(horarioSessaoString, formatter); // TESTAR EXCECAO
                    System.out.println();
                    
                    System.out.println("- Horario Antigo: " + sessao.getHorarioSessao());
                    System.out.println("- Horario Novo: " + horarioSessao);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();
                        
                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        if (!(gerente.editarSessao(sessao, null, horarioSessao, -1, null, null))) {
                            System.out.println("Erro ao editar sessao. Intervalo de horario coincide com o de outra sessao...");
                        }
                    }
                    break;
                case 5: // mudança do preço da sessão
                    System.out.print("Digite o preco novo: ");
                    double precoSessaoNovo = Double.parseDouble(sc.nextLine());
                    System.out.println();

                    System.out.println("- Preco Antigo: " + sessao.getPrecoSessao());
                    System.out.println("- Sala Nova: " + precoSessaoNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();
                        
                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarSessao(sessao, null, null, precoSessaoNovo, null, null);
                    }
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
        else {
            System.out.println("Sessao nao encontrada");
        }

        System.out.println();
        
    }

    public static void imprimeMenuGerenteRemocaoSessao(Gerente gerente, Scanner sc) {
        int codigoSessao;
        String motivoExclusaoSessao;
        String confirmacao;

        System.out.println("REMOCAO DE SESSAO");
        imprimeListaSessoes(gerente.getCinema());
        System.out.printf("Digite o codigo da sessao a ser removida: ");
        codigoSessao = Integer.parseInt(sc.nextLine());

        // busca sessão disponivel no cinema
        Sessao sessao = gerente.buscarSessao(codigoSessao);
        
        // se encontra sessão no catálogo, permite a remoção
        if (sessao != null) {

            System.out.printf("Digite o motivo de exclusao da sessao: ");
            motivoExclusaoSessao = sc.nextLine();

            System.out.print("Confirmar remocao da sessao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.removerSessao(sessao, motivoExclusaoSessao)) {
                    System.out.println("Sessao removida com sucesso");
                }
                else {
                    System.out.println("Sessao ja foi removida");
                }
            }
        }
        else {
            System.out.println("Sessao nao encontrada");
        }
        
        System.out.println();
    }

    public static void imprimeListaSessoes(Cinema cinema) {
        for (Sessao s : cinema.getListaSessoes()) {
            if (!(s instanceof SessaoIndisponivel)) {
                System.out.println(s.toString());
            }
        }
    }

    public static int imprimeMenuGerentePromocao(Scanner sc) {
        int opcao;
        
        System.out.println("PROMOCAO");
        System.out.println("(1) Cadastrar Promocao");
        System.out.println("(2) Editar Promocao");
        System.out.println("(3) Remover Promocao");
        System.out.println("(4) Sair");

        System.out.print("Digite uma opcao: ");
        opcao = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        return opcao;
    }

    public static void imprimeMenuGerenteCadastroPromocao(Gerente gerente, Scanner sc) {
        int codigoSessao;
        double porcentagemPromocional;
        String confirmacao;

        System.out.println("CADASTRAR PROMOCAO");
        imprimeListaSessoes(gerente.getCinema());
        System.out.print("Digite o codigo da sessao a qual a promocao ira ser adicionada : ");
        codigoSessao = Integer.parseInt(sc.nextLine());

        Sessao sessao = gerente.buscarSessao(codigoSessao);

        if (sessao != null) {
            System.out.print("Qual sera a porcentagem da promocao? ");
            porcentagemPromocional = Double.parseDouble(sc.nextLine()); // 0 < promocao < 100

            porcentagemPromocional = porcentagemPromocional/100.00;

            System.out.print("Confirmar adicao da promocao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.adicionarPromocao(sessao, porcentagemPromocional)) {
                    System.out.println("Promocao adicionada com sucesso");
                }
                else {
                    System.out.println("Erro ao adicionar promocao. Promocao ja existe");
                }
            }
        }
        else {
            System.out.println("Sessao nao encontrada");
        }

        System.out.println();
    }

    public static void imprimeMenuGerenteEdicaoPromocao(Gerente gerente, Scanner sc) {
        int codigoSessao;
        double porcentagemPromocionalNova;
        String confirmacao;

        System.out.println("EDITAR PROMOCAO");
        imprimeListaSessoes(gerente.getCinema());
        System.out.print("Digite o codigo da sessao a qual a promocao esta ligada : ");
        codigoSessao = Integer.parseInt(sc.nextLine());

        Sessao sessao = gerente.buscarSessao(codigoSessao);

        if (sessao != null) {
            System.out.print("Qual sera a porcentagem nova da promocao? ");
            porcentagemPromocionalNova = Double.parseDouble(sc.nextLine()); // 0 < promocao < 100
            porcentagemPromocionalNova = porcentagemPromocionalNova/100.00;
            System.out.println();
                    
            System.out.println("- Promocao Antiga: " + sessao.getPorcentagemPromocional() * 100 + "%");
            System.out.println("- Promocao Nova: " + porcentagemPromocionalNova * 100 + "%");

            System.out.print("Confirmar edicao da promocao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.editarPromocao(sessao, porcentagemPromocionalNova)) {
                    System.out.println("Promocao editada com sucesso");
                }
                else {
                    System.out.println("Erro ao editar promocao. Sessao nao possui promocao");
                }
            }
        }
        else {
            System.out.println("Sessao nao encontrada");
        }

        System.out.println();
    }

    public static void imprimeMenuGerenteRemocaoPromocao(Gerente gerente, Scanner sc) {
        int codigoSessao;
        String confirmacao;

        System.out.println("REMOCAO DE PROMOCAO");
        imprimeListaSessoes(gerente.getCinema());
        System.out.printf("Digite o codigo da sessao para remover sua promocao: ");
        codigoSessao = Integer.parseInt(sc.nextLine());

        Sessao sessao = gerente.buscarSessao(codigoSessao);
        
        if (sessao != null) { // VERIFICAR SE TEM SESSOES CADASTRADAS
            System.out.print("Confirmar remocao da promocao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.excluirPromocao(sessao)) {
                    System.out.println("Promocao removida com sucesso");
                }
                else {
                    System.out.println("Sessao nao possui promocao");
                }
            }
        }
        else {
            System.out.println("Sessao nao encontrada");
        }
        
        System.out.println();
    }

public static int imprimeMenuGerenteRelatorio(Scanner sc) {
    	int opcao; 
    	
    	System.out.println("RELATORIO");
        System.out.println("(1) Filmes");
        System.out.println("(2) Sessoes");
        System.out.println("(3) Sala");
        System.out.println("(4) Usuarios");
        System.out.println("(5) Sair");

        System.out.print("Digite uma opcao: ");
        opcao = Integer.parseInt(sc.nextLine()); 
        System.out.println();
        
        return opcao; 
    }
    
public static void imprimeMenuGerenteRelatorioFilmes(Gerente gerente, Cinema cinema) {
    	System.out.println("FILMES CADASTRADOS: \n");
        gerente.gerarRelatorioFilmes(cinema.getListaFilmes());
        System.out.println();
    }
    
public static void imprimeMenuGerenteRelatorioSessoes(Gerente gerente, Cinema cinema) {
         System.out.println("SESSOES CADASTRADAS: \n");
         gerente.gerarRelatorioSessoes(cinema.getListaSessoes());
         System.out.println();
    }
    
public static void imprimeMenuGerenteRelatorioSalas(Gerente gerente, Cinema cinema) {
        System.out.println("SALAS CADASTRADAS: \n");
        gerente.gerarRelatorioSalas(cinema.getListaSalas());
        System.out.println();	
    }
    
public static void imprimeMenuGerenteRelatorioUsuario(Gerente gerente) {	
        System.out.println("USUARIOS CADASTRADOS: \n");
        gerente.gerarRelatorioUsuarios();
        System.out.println();	
    }
public static int imprimeMenuUsuario(Scanner sc) {
        int opcao;
        
        System.out.println("MENU DO USUARIO");
        System.out.println("(1) Comprar Ingresso");
        System.out.println("(2) Comprar Assinatura");
        System.out.println("(3) Ver perfil");
        System.out.println("(4) Sair");

        System.out.print("Digite uma opcao: ");
        opcao = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        return opcao;
    }

    public static void imprimeMenuUsuarioComprarIngresso(Usuario usuario, Gerente gerente, Scanner sc) {
        String nomeFilme;
        int codigoSessao;
        int nroAssento;
        String confirmacao;

        System.out.println("CATALOGO DE FILMES");
        imprimeListaFilmes(gerente.getCinema());
        System.out.print("Digite o nome do filme escolhido: ");
        nomeFilme = sc.nextLine();
        System.out.println();
        
        Filme filme = gerente.buscarFilme(nomeFilme);

        if (filme != null) { // se o filme existe no catalogo
            for (Sessao sessao : gerente.getCinema().getListaSessoes()) { // imprime sessoes do filme escolhido
                if (sessao.getFilmeSessao() == filme) {
                    System.out.println(sessao.toString());
                }
            }

            System.out.printf("Digite o codigo da sessao escolhida: ");
            codigoSessao = Integer.parseInt(sc.nextLine());

            Sessao sessao = gerente.buscarSessao(codigoSessao);

            if (sessao != null) { // se a sessao existe
                sessao.imprimeListaAssentos();
            
                do {
                    System.out.printf("Digite o numero do assento disponivel: ");
                    nroAssento = Integer.parseInt(sc.nextLine());
                } while (sessao.getDisponibilidadeAssento(nroAssento));            

                Ingresso ingresso = new Ingresso(sessao, nroAssento, usuario.getPrecoIngresso(sessao));
                System.out.println(ingresso.toString());

                System.out.print("Confirmar compra de ingresso (Sim ou Nao): ");
                confirmacao = sc.nextLine();

                if (confirmacao.equalsIgnoreCase("Sim")) {
                    if (usuario.comprarIngresso(sessao, nroAssento)) {
                        System.out.println("Ingresso comprado com sucesso!");
                    }
                    else {
                        System.out.println("Erro ao comprar ingresso");
                    }
                }
            }
            else {
                System.out.println("Sessao nao encontrada");
            }
        }
        else {
            System.out.println("Filme nao encontrado");
        }
        
        System.out.println();

    }

    public static Usuario imprimeMenuUsuarioComprarAssinatura(Usuario usuario, Gerente gerente, Scanner sc) { // VERIFICAR ISSO
        System.out.println("ASSINATURA");

        if (usuario instanceof UsuarioAssinante) {
            System.out.println("Voce ja possui uma assinatura");
            sc.nextLine();
        }
        
        else {
            String confirmacao;

            System.out.println("O Cinema GIG oferece 30% de desconto para assinantes!");
            System.out.print("Deseja comprar uma assinatura (Sim ou Nao)? ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                int index = gerente.getListaUsuarios().indexOf(usuario); 
                usuario = usuario.comprarAssinatura();
                gerente.getListaUsuarios().set(index, usuario); 

                System.out.println("Assinatura comprada com sucesso!");
                System.out.println();
            }
            
        }

        return usuario;
    }

    public static void imprimeMenuUsuarioPerfil(Usuario usuario) {
        System.out.println("PERFIL");
        System.out.println("Nome: " + usuario.getNomePessoa());
        System.out.println("Idade: " + usuario.getIdadeUsuario());
        System.out.println("Usuario: " + usuario.getLoginPessoa());
        System.out.println("Senha: " + usuario.getSenhaPessoa());
        System.out.println("Assinatura: " + ((usuario instanceof UsuarioAssinante) ? "Sim" : "Nao"));
        
        System.out.println("Ingressos comprados: " + usuario.getIngressosComprados().size());

        if (usuario.getIngressosComprados().size() > 0) {
            for (Ingresso ingressoComprado : usuario.getIngressosComprados()) {
                System.out.println(ingressoComprado.toString());
            }
        }

    }

}
