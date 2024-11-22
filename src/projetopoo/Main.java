package projetopoo;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

// comando para compilar o codigo: no diretorio da pasta projetopoo, javac projetopoo/*.java
// comando para rodar o codigo: java projetopoo.Main

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("GIG CINEMAS");
        Gerente gerente = new Gerente("Nome do Admin", "admin", "123", cinema);
        
        Scanner sc = new Scanner(System.in);
        boolean estaRodando = true;
        Pessoa pessoa = null;
        int opcao, opcaoMenuGerente;
        
        limpaConsole();
        while(estaRodando) {
            if(pessoa == null) { // menu nao logado
                opcao = imprimeMenuNaoLogado(cinema, sc);
                limpaConsole();

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
                        System.out.println("- Erro: opcao invalida. Tente novamente!");
                        sc.nextLine();
                        break;
                }
                limpaConsole();
            }
            
            else {
                if (pessoa instanceof Gerente) { // menu do gerente
                    opcao = imprimeMenuGerente(sc);
                    limpaConsole();

                    switch(opcao) {
                        case 1: // aba de filmes 
                            opcaoMenuGerente = imprimeMenuGerenteFilme(sc);
                            limpaConsole();

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
                                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                                    sc.nextLine();
                                    break;
                            }
                            break;
                        case 2: // aba de sala
                            opcaoMenuGerente = imprimeMenuGerenteSala(sc);
                            limpaConsole();

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
                                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                                    sc.nextLine();
                                    break;
                            }
                            break;
                        case 3: // aba de sessao
                            opcaoMenuGerente = imprimeMenuGerenteSessao(sc);
                            limpaConsole();

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
                                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                                    sc.nextLine();
                                    break;
                            }
                            break;
                        case 4: // aba de promocao
                            opcaoMenuGerente = imprimeMenuGerentePromocao(sc);
                            limpaConsole();

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
                                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                                    sc.nextLine();
                                    break;
                            }

                            break;
                        case 5: // aba de relatorios
                            opcaoMenuGerente = imprimeMenuGerenteRelatorio(sc); 
                        	limpaConsole();

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
                                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                                    sc.nextLine();
                                    break;                       			
                        	}        
                            break;
                        case 6: // sair
                            pessoa = null;
                            break;
                        default:
                            System.out.println("- Erro: opcao invalida. Tente novamente!");
                            sc.nextLine();
                            break;
                    } 
                    limpaConsole();
                }
                else if (pessoa instanceof Usuario) { // menu do usuario
                    opcao = imprimeMenuUsuario(sc);
                    limpaConsole();

                    switch(opcao) {
                        case 1: // aba para comprar ingressos
                            imprimeMenuUsuarioComprarIngresso((Usuario)pessoa, gerente, sc);
                            break;
                        case 2: // aba para comprar assinatura
                            pessoa = imprimeMenuUsuarioComprarAssinatura((Usuario)pessoa, gerente, sc);
                            break;
                        case 3: // aba para ver perfil
                            imprimeMenuUsuarioPerfil((Usuario)pessoa);
                            sc.nextLine();
                            break;
                        case 4: // sair 
                            pessoa = null;
                            break;
                        default:
                            System.out.println("- Erro: opcao invalida. Tente novamente!");
                            sc.nextLine();
                            break;
                    }    
                    limpaConsole();
                }
            }
        }
        sc.close();
    }
    
    private static int imprimeMenuNaoLogado(Cinema cinema, Scanner sc) {
        int opcao = 0;
        
        System.out.println(cinema.getNomeCinema());
        System.out.println("Bem Vindo!");
        System.out.println("");
        System.out.println("(1) Cadastro");
        System.out.println("(2) Login");
        System.out.println("(3) Sair");
        
        try {
            System.out.printf("Entre uma opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
            System.out.println();
                 
        } catch(NumberFormatException e) {}

        System.out.println();
        return opcao;
    }
    
    private static void imprimeMenuCadastro(ArrayList<Usuario> listaUsuarios, Gerente gerente, Scanner sc) {
        String nomeUsuario;
        String loginUsuario;
        String senhaUsuario;
        int idadeUsuario = 0;
        
        System.out.println("CADASTRO");
        System.out.printf("Digite seu nome: ");
        nomeUsuario = sc.nextLine();
        System.out.printf("Digite um usuario: ");
        loginUsuario = sc.nextLine();
        System.out.printf("Digite uma senha: ");
        senhaUsuario = sc.nextLine();

        try {
                System.out.printf("Digite sua idade: ");
                idadeUsuario = Integer.parseInt(sc.nextLine());
                System.out.println();
                excecaoNumerosNegativos(idadeUsuario); 

            } catch(NumberFormatException e) {
                System.err.println("- Erro: a idade deve ser um numero. Tente novamente!");
                sc.nextLine();
                return; 
                
            } catch (IllegalArgumentException i) {
                System.err.println("- Erro: a idade deve ser um numero positivo. Tente novamente!");
                sc.nextLine();
                return; 
            }

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
            System.out.println("- Erro no cadastro: usuario ja esta cadastrado. Tente novamente!");
        }
        
        sc.nextLine();
    }    

    // metodo que busca o login do usuario no arraylist de usuarios
    private static Usuario buscarUsuario(String loginUsuario, ArrayList<Usuario> listaUsuarios) {
        for (Usuario usuarioTemporario : listaUsuarios) {
            if (loginUsuario.equals(usuarioTemporario.getLoginPessoa())) {
                return usuarioTemporario;
            }
        }

        return null;
    }
    
    private static Pessoa imprimeMenuLogin(ArrayList<Usuario> listaUsuarios, Gerente gerente, Scanner sc) {
        String loginTemporario;
        String senhaTemporaria;
        
        System.out.println("LOGIN");
        System.out.printf("Digite um usuario: ");
        loginTemporario = sc.nextLine();
        System.out.printf("Digite uma senha: ");
        senhaTemporaria = sc.nextLine();
        System.out.println();

        // checa se administrador esta fazendo o login
        if (loginTemporario.equals(gerente.getLoginPessoa()) && senhaTemporaria.equals(gerente.getSenhaPessoa())) {
            System.out.println("Sucesso no Login! Bem-vindo!");   
            sc.nextLine();         
            return gerente;
        }

        // checa se usuario cadastrado esta fazendo o login
        for (Usuario usuarioTemporario : listaUsuarios) {
            if (loginTemporario.equals(usuarioTemporario.getLoginPessoa()) && senhaTemporaria.equals(usuarioTemporario.getSenhaPessoa())) {
                System.out.println("Sucesso no Login! Bem-vindo!");
                sc.nextLine();        
                return usuarioTemporario; 
            }
        }   
        
        System.out.println("- Erro no login: usuario ou senha incorretos. Tente novamente!");
        sc.nextLine();         
        return null;
    }
    
    // menu do gerente
    private static int imprimeMenuGerente(Scanner sc) {
        int opcao = 0;

        System.out.println("MENU DO GERENTE");
        System.out.println("(1) Filme");
        System.out.println("(2) Sala");
        System.out.println("(3) Sessao");
        System.out.println("(4) Promocao");
        System.out.println("(5) Exibir Relatorios");
        System.out.println("(6) Sair");

        try {
             System.out.printf("Entre uma opcao: ");
             opcao = Integer.parseInt(sc.nextLine());
        } catch(NumberFormatException e) {}
        
        System.out.println();
        return opcao;
    }

    // menu do gerente - aba de filmes
    private static int imprimeMenuGerenteFilme(Scanner sc) {
        int opcao = 0;
        
        System.out.println("FILME");
        System.out.println("(1) Cadastrar Filme");
        System.out.println("(2) Editar Filme");
        System.out.println("(3) Remover Filme");
        System.out.println("(4) Listar Filmes");
        System.out.println("(5) Sair");

        try {
            System.out.printf("Entre uma opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
                 
        } catch(NumberFormatException e) {}

        System.out.println();
        return opcao;
    }
    
    private static void imprimeMenuGerenteCadastroFilme(Gerente gerente, Scanner sc) {
        String nomeFilme;
        String sinopseFilme;
        int classificacaoFilme = 0;
        String classificacaoFilmeString;
        String generoFilme;
        int duracaoFilme = 0;
        String confirmacao;
                
        System.out.println("CADASTRAR FILME NO CATALOGO");
        System.out.println("Entre com as informacoes do filme desejado: ");
        System.out.print("- Nome: ");
        nomeFilme = sc.nextLine();
        System.out.print("- Sinopse: ");
        sinopseFilme = sc.nextLine();

        System.out.println("Opcoes de classificacao indicativa: \'livre\', \'10\', \'12\', \'14\', \'16\', \'18\'");
        System.out.print("- Classificacao Indicativa: ");
        classificacaoFilmeString = sc.nextLine();

        // MUDAR METODO PARA TRATAR EXCEÇÃO AQUI
        if (checaClassificacaoIndicativa(classificacaoFilmeString) != -1) {
            classificacaoFilme = checaClassificacaoIndicativa(classificacaoFilmeString); 
        }
        else {
            System.out.println("- Erro no cadastro: classificacao invalida. Tente novamente!");
            sc.nextLine();
            return;
        }

        System.out.print("- Genero: ");
        generoFilme = sc.nextLine();
        
       try {
           System.out.print("- Duracao (em minutos): ");
           duracaoFilme = Integer.parseInt(sc.nextLine());
           excecaoNumerosNegativos(duracaoFilme);
                
        } catch(NumberFormatException e) {
           System.err.println("- Erro: a duracao deve ser um numero. Tente novamente!");
           sc.nextLine(); 
           return; 
       
        } catch(IllegalArgumentException e) {
           System.err.println("- Erro: a duracao deve ser um numero inteiro positivo. Tente novamente!");
           sc.nextLine(); 
           return; 
        }
       
        System.out.println();
                
        Filme filmeTemporario = new Filme(nomeFilme, sinopseFilme, classificacaoFilme, generoFilme, duracaoFilme);
        
        System.out.println(filmeTemporario.toString());
        System.out.print("Confirmar adicao do filme ao catalogo (Sim ou Nao): ");
        confirmacao = sc.nextLine();
        
        if (confirmacao.equalsIgnoreCase("Sim")) {
            if(gerente.adicionarFilme(filmeTemporario)) { 
                System.out.println("Filme adicionado com sucesso!");
            }
            else {
                System.out.println("- Erro no cadastro: filme ja existe no catalogo. Tente novamente!");
            }
        }

        sc.nextLine();
    }
    
    private static void imprimeMenuGerenteEdicaoFilme(Gerente gerente, Scanner sc) {
        int opcao = 0;
        String nomeFilme;
        String confirmacao;

        System.out.println("EDITAR FILME DO CATALOGO");
        imprimeListaFilmes(gerente.getCinema());
        System.out.printf("Digite o nome do filme a ser alterado: ");
        nomeFilme = sc.nextLine();
        System.out.println();
        
        // busca filme disponivel no catalogo e checa se ha alguma sessao cadastrada com aquele filme 
        Filme filme = gerente.buscarFilme(nomeFilme);
        
        if (filme != null && !(gerente.buscarSessaoComFilme(filme))) {
            System.out.println("Parametros que podem ser alterados: ");
            System.out.println("(1) Nome");
            System.out.println("(2) Sinopse");
            System.out.println("(3) Classificacao Indicativa");
            System.out.println("(4) Genero");
            System.out.println("(5) Duracao");
            System.out.print("Escolha um parametro: ");
            
            try {
               System.out.printf("Entre uma opcao: ");
               opcao = Integer.parseInt(sc.nextLine());
                     
            } catch(NumberFormatException e) {}
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
                        if (gerente.editarFilme(filme, nomeNovo, "", -1, "", -1)) {
                            System.out.println("Filme editado com sucesso!");
                        }
                        else {
                            System.out.println("- Erro na edicao: nome novo do filme ja esta cadastrado. Tente novamente!");
                        }
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
                        System.out.println("Filme editado com sucesso!");
                    }
                    break;
                case 3:
                    System.out.println("Opcoes de classificacao indicativa: \'livre\', \'10\', \'12\', \'14\', \'16\', \'18\'");
                    System.out.print("Digite a classificacao indicativa nova: ");
                    String classificacaoFilmeString = sc.nextLine();
                    int classificacaoNova;

                    if (checaClassificacaoIndicativa(classificacaoFilmeString) != -1) {
                        classificacaoNova = checaClassificacaoIndicativa(classificacaoFilmeString); 
                    }
                    else {
                        System.out.println("- Erro no cadastro: classificacao invalida. Tente novamente!");
                        sc.nextLine();
                        return;
                    }
                    System.out.println();

                    System.out.println("- Classificacao Indicativa Antiga: " + filme.getClassificacaoFilme());
                    System.out.println("- Classificacao Indicativa Nova: " + classificacaoNova);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarFilme(filme, "", "", classificacaoNova, "", -1);
                        System.out.println("Filme editado com sucesso!");
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
                        System.out.println("Filme editado com sucesso!");
                    }
                    break;
                case 5:
                    System.out.println();
                    int duracaoNova = 0;
                    
                    try {
                       System.out.printf("Digite a duracao nova: ");
                       duracaoNova = Integer.parseInt(sc.nextLine());
                       excecaoNumerosNegativos(duracaoNova);
                    } catch(NumberFormatException e) {
                       System.err.println("- Erro:a duracao nova deve ser um numero inteiro. Tente novamente!");
                       sc.nextLine(); 
                       return;
                    } catch(IllegalArgumentException e) {
                       System.err.println("- Erro: a duracao nova deve ser um numero positivo. Tente novamente!");
                       sc.nextLine();
                       return; 
                    }
                    
                    System.out.println();
                    System.out.println("- Duracao Antiga: " + filme.getDuracaoFilme());
                    System.out.println("- Duracao Nova: " + duracaoNova);
                    
                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();
                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarFilme(filme, "", "", -1, "", duracaoNova);
                        System.out.println("Filme editado com sucesso!");
                    }
                    break;
                default:
                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                    break;
            }
        }
        else {
            System.out.println("- Erro na edicao: filme nao encontrado ou filme com sessao cadastrada. Tente novamente!");
        }
        
        sc.nextLine();
    }
    
    private static void imprimeMenuGerenteRemocaoFilme(Gerente gerente, Scanner sc) {
        String nomeFilme;
        String motivoExclusaoFilme;
        String confirmacao;

        System.out.println("REMOCAO DE FILME DO CATALOGO");
        imprimeListaFilmes(gerente.getCinema());
        System.out.printf("Digite o nome do filme a ser removido: ");
        nomeFilme = sc.nextLine();

        // busca filme disponivel no catalogo e checa se ha alguma sessao cadastrada com aquele filme 
        Filme filme = gerente.buscarFilme(nomeFilme);
        
        if (filme != null && !(gerente.buscarSessaoComFilme(filme))) { 
            System.out.printf("Digite o motivo de exclusao do filme: ");
            motivoExclusaoFilme = sc.nextLine();

            System.out.print("Confirmar remocao do filme (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                gerente.removerFilme(filme, motivoExclusaoFilme);
                System.out.println("Filme removido com sucesso!");
            }
        }
        else {
            System.out.println("- Erro na remocao: filme nao encontrado ou filme com sessao cadastrada. Tente novamente!");
        }
        
        sc.nextLine();
    }
    
    private static void imprimeListaFilmes(Cinema cinema) {
        for (Filme f : cinema.getListaFilmes()) {
            if (!(f instanceof FilmeIndisponivel)) {
                System.out.println(f.toString());
            }
        }
    }
    
    // metodo que retorna a classificacao indicativa como numero inteiro
    private static int checaClassificacaoIndicativa(String classificacaoFilmeString) {
        if (classificacaoFilmeString.equalsIgnoreCase("livre")) return 0;
        else if (classificacaoFilmeString.equals("10")) return 10;
        else if (classificacaoFilmeString.equals("12")) return 12;
        else if (classificacaoFilmeString.equals("14")) return 14;
        else if (classificacaoFilmeString.equals("16")) return 16;
        else if (classificacaoFilmeString.equals("18")) return 18;
        else return -1;
    }
    
    // menu do gerente - aba de salas
    private static int imprimeMenuGerenteSala(Scanner sc) {
        int opcao = 0;
        
        System.out.println("SALA");
        System.out.println("(1) Cadastrar Sala");
        System.out.println("(2) Editar Sala");
        System.out.println("(3) Remover Sala");
        System.out.println("(4) Listar Salas");
        System.out.println("(5) Sair");

        try {
            System.out.printf("Entre uma opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
        } catch(NumberFormatException e) {}

        System.out.println();
        return opcao;
    }

    private static void imprimeMenuGerenteCadastroSala(Gerente gerente, Scanner sc) {
        int nroSala = 0;
        int nroAssentos = 0;
        String tipoTelaString;
        boolean tipoTela = false;
        String confirmacao;

        System.out.println("CADASTRAR SALA");
        System.out.println("Entre com as informacoes da sala:");

        try {
            System.out.print("- Numero da Sala: ");
            nroSala = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(nroSala);
        } catch(NumberFormatException e) {
            System.err.println("- Erro: o numero da sala deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return; 
        
        } catch(IllegalArgumentException e) {
            System.err.println("- Erro: o numero da sala deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return; 
        }
        
        try {
            System.out.print("- Numero de Assentos: ");
            nroAssentos = Integer.parseInt(sc.nextLine());
            excecaoNroAssentos(nroAssentos);
        } catch(NumberFormatException e) {
            System.err.println("- Erro: o numero de assentos deve ser um numero. Tente novamente!");
            sc.nextLine();
            return; 
        
        } catch(IllegalArgumentException e) {
            System.err.println("- Erro: o numero de assento deve ser um numero positivo maior que 30. Tente novamente!");
            sc.nextLine();
            return; 
        
        }

        try {
            System.out.printf("Digite o tipo de tela novo (2D ou 3D): ");
            tipoTelaString = sc.nextLine();
            tipoTela = excecaoTipoTela(tipoTelaString);
        
        } catch (IllegalArgumentException e) {
            System.err.println("- Erro: tipo de tela invalido. Tente novamente");
            sc.nextLine();
            return; 
        
        }

        Sala salaTemporaria = new Sala(nroSala, nroAssentos, tipoTela);

        System.out.println(salaTemporaria.toString());
        System.out.print("Confirmar adicao da sala (Sim ou Nao): ");
        confirmacao = sc.nextLine();
        
        if (confirmacao.equalsIgnoreCase("Sim")) {
            if(gerente.adicionarSala(salaTemporaria)) {
                System.out.println("Sala adicionada com sucesso!");
            }
            else {
                System.out.println("- Erro no cadastro: sala ja existe. Tente novamente!");
            }
        }
        sc.nextLine();
    }

    private static void imprimeMenuGerenteEdicaoSala(Gerente gerente, Scanner sc) {
        int opcao = 0;
        int nroSala = 0;
        String confirmacao;

        System.out.println("EDITAR SALA");
        imprimeListaSalas(gerente.getCinema());

        try {
            System.out.printf("Digite o numero da sala a ser editada: ");
            nroSala = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(nroSala);
        } catch(NumberFormatException e) {
            System.err.println("- Erro: o numero da sala  deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return; 
        } catch(IllegalArgumentException e) {
            System.err.println("- Erro: o numero da sala deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return; 
        }
        System.out.println();
        
        // busca sala e checa se ha alguma sessao cadastrada com aquela sala 
        Sala sala = gerente.buscarSala(nroSala);

        if (sala != null && !(gerente.buscarSessaoComSala(sala))) { 
            System.out.println("Parametros que podem ser alterados: ");
            System.out.println("(1) Numero da Sala");
            System.out.println("(2) Numero de Assentos");
            System.out.println("(3) Tipo de Tela");

            try {
                System.out.printf("Entre uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
        
                     
            } catch(NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
                sc.nextLine();
                return; 
            }
            System.out.println();

            switch(opcao) {
                case 1:
                    int nroSalaNovo = 0;

                    try {
                        System.out.print("Digite o numero da sala novo: ");
                        nroSalaNovo = Integer.parseInt(sc.nextLine());
                        excecaoNumerosNegativos(nroSalaNovo);

                    } catch(NumberFormatException e) {
                        System.err.println("- Erro: o numero novo da sala deve ser um numero. Tente novamente!");
                        sc.nextLine();
                        return; 

                    } catch(IllegalArgumentException e) {
                        System.err.println("- Erro: o numero novo da sala deve ser um numero positivo. Tente novamente!");
                        sc.nextLine();
                        return; 
                    }
                    System.out.println();

                    System.out.println("- Numero da Sala Antigo: " + sala.getNroSala());
                    System.out.println("- Numero da Sala Novo: " + nroSalaNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        if (gerente.editarSala(sala,nroSalaNovo, -1, null)) {
                            System.out.println("Sala editada com sucesso!");
                        }
                        else {
                            System.out.println("- Erro na edicao: numero da sala ja esta cadastrado. Tente novamente!");
                        }
                    }
                    break;
                case 2:
                    int nroAssentosNovo = 0;

                    try {
                        System.out.printf("Digite o numero de assentos novo: ");
                        nroAssentosNovo = Integer.parseInt(sc.nextLine());
                        excecaoNroAssentos(nroAssentosNovo);

                    } catch(NumberFormatException e) {
                        System.err.println("- Erro: o novo numero de assentos deve ser um numero inteiro. Tente novamente!");
                        sc.nextLine();
                        return; 
                    } catch(IllegalArgumentException e) {
                        System.err.println("- Erro: o novo numero de assento deve ser um numero positivo maior que 30. Tente novamente!");
                        sc.nextLine();
                        return; 
                    }
                    System.out.println();

                    System.out.println("- Numero de Assentos Antigo: " + sala.getNroAssentos());
                    System.out.println("- Numero de Assentos Novo: " + nroAssentosNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarSala(sala, 0, nroAssentosNovo, null);
                        System.out.println("Sala editada com sucesso!");
                    }
                    break;
                case 3:
                    boolean tipoTelaNovo = false;
                    String tipoTelaString;

                    try {
                        System.out.printf("Digite o tipo de tela novo (2D ou 3D): ");
                        tipoTelaString = sc.nextLine();
                        tipoTelaNovo = excecaoTipoTela(tipoTelaString);
                        
                    } catch (IllegalArgumentException e) {
                        System.err.println("- Erro: tipo de tela invalido. Tente novamente");
                        sc.nextLine();
                        return; 
                    }
                    System.out.println();
                    
                    System.out.println("- Tipo de Tela Antigo: " + (sala.getTipoTela() ? "3D" : "2D"));
                    System.out.println("- Numero de Assentos Novo: " + (tipoTelaNovo ? "3D" : "2D"));

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarSala(sala, 0, -1, tipoTelaNovo);
                        System.out.println("Sala editada com sucesso!");
                    }
                    break;
                default:
                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                    break;
            }    
        }
        else {
            System.out.println("- Erro na edicao: sala nao encontrada ou sala com sessao cadastrada. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void imprimeMenuGerenteRemocaoSala(Gerente gerente, Scanner sc) {
        int nroSala = 0;
        String confirmacao;

        System.out.println("REMOCAO DE SALA");
        imprimeListaSalas(gerente.getCinema());

        try {
            System.out.printf("Digite o numero da sala a ser removida: ");
            nroSala = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(nroSala);
        } catch(NumberFormatException e) {
            System.err.println("- Erro: o numero da sala  deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return; 
        } catch(IllegalArgumentException e) {
            System.err.println("- Erro: o numero da sala deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return; 
        }
        System.out.println();

        // busca sala e checa se ha alguma sessao cadastrada com aquela sala 
        Sala sala = gerente.buscarSala(nroSala);
        
        if (sala != null && !(gerente.buscarSessaoComSala(sala))) {
            System.out.print("Confirmar remocao da sala (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                gerente.removerSala(sala);
                System.out.println("Sala removida com sucesso!");
            }
        }
        else {
            System.out.println("- Erro na remocao: sala nao encontrada ou sala com sessao cadastrada. Tente novamente!");
        }
        sc.nextLine();
    }
    
    private static void imprimeListaSalas(Cinema cinema) {
        for (Sala s : cinema.getListaSalas()) {
            System.out.println(s.toString());
        }
    }

    // menu do gerente - aba de sessoes
    private static int imprimeMenuGerenteSessao(Scanner sc) {
        int opcao = 0;
        
        System.out.println("SESSAO");
        System.out.println("(1) Cadastrar Sessao");
        System.out.println("(2) Editar Sessao");
        System.out.println("(3) Remover Sessao");
        System.out.println("(4) Listar Sessoes");
        System.out.println("(5) Sair");

        try {
            System.out.printf("Entre uma opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
                 
        } catch(NumberFormatException e) {}
        
        System.out.println();
        return opcao;
    }

    private static void imprimeMenuGerenteCadastroSessao(Gerente gerente, Scanner sc) {
        String nomeFilme;
        Filme filmeSessao; 
        int nroSala = 0;
        Sala salaSessao;
        String diaSessaoString; 
        LocalDate diaSessao = null;
        String horarioSessaoString;
        LocalTime horarioSessao = null;
        DateTimeFormatter formatter;
        double precoSessao = 0.0;
        String confirmacao;

        System.out.println("CADASTRAR SESSAO");
        System.out.println("Entre com as informacoes da sessao: ");
        System.out.print("- Nome do Filme: ");
        nomeFilme = sc.nextLine();
        
        // busca filme disponivel no catalogo
        filmeSessao = gerente.buscarFilme(nomeFilme);

        // se encontra um filme, o cadastro da sessao eh realizado
        if (filmeSessao != null) {

            try {
                System.out.print("- Numero da Sala: ");
                nroSala = Integer.parseInt(sc.nextLine());
                excecaoNumerosNegativos(nroSala);
            } catch(NumberFormatException e) {
                System.err.println("- Erro: o numero da sala  deve ser um numero inteiro. Tente novamente!");
                sc.nextLine();
                return; 
            } catch(IllegalArgumentException e) {
                System.err.println("- Erro: o numero da sala deve ser um numero positivo. Tente novamente!");
                sc.nextLine();
                return; 
            }
            System.out.println();

            // busca sala do cinema
            salaSessao = gerente.buscarSala(nroSala);
            
            // se encontra uma sala, o cadastro de sessao eh realizado
            if (salaSessao != null) {
                
                try {
                    System.out.print("- Dia da sessao (DD/MM/YYYY): ");
                    diaSessaoString = sc.nextLine();
                    formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    diaSessao = LocalDate.parse(diaSessaoString, formatter);

                    System.out.print("- Horario da sessao (HH:mm): ");
                    horarioSessaoString = sc.nextLine();
                    formatter = DateTimeFormatter.ofPattern("HH:mm");
                    horarioSessao = LocalTime.parse(horarioSessaoString, formatter);

                } catch(DateTimeParseException e) {
                    System.err.println("- Erro: data ou horario invalidos. Tente novamente!");
                }
                
                // combina data e horario em diaHorarioSessao
                LocalDateTime diaHorarioSessao = diaSessao.atTime(horarioSessao);

                try {
                    System.out.print("- Preco da sessao: ");
                    precoSessao = Double.parseDouble(sc.nextLine());
                    excecaoNumerosNegativos(precoSessao);
                       
                } catch(NumberFormatException e) {
                    System.err.println("- Erro: o preco da sessao deve ser um numero double. Tente novamente!");
                    sc.nextLine();
                    return; 
                } catch(IllegalArgumentException e) {
                    System.err.println("- Erro: o preco da sessao deve ser um numero positivo. Tente novamente!");
                    sc.nextLine();
                    return; 
                }

                Sessao sessaoTemporaria = new Sessao(diaHorarioSessao, precoSessao, false, 1, salaSessao, filmeSessao); // conferir promocao

                System.out.println(sessaoTemporaria.toString());
                System.out.print("Confirmar adicao da sessao (Sim ou Nao): ");
                confirmacao = sc.nextLine();

                // confirma a criacao de uma sessao, checando condicoes de horario e classificacao indicativa
                if (confirmacao.equalsIgnoreCase("Sim")) {
                    if (gerente.adicionarSessao(sessaoTemporaria)) {
                        System.out.println("Sessao adicionada com sucesso!");
                    }
                    else {
                        System.out.println("- Erro no cadastro. Tente novamente!");
                        System.out.println("- Possiveis problemas: dia e horario coincidem com outra sessao ou sessao +18 antes das 20h.");
                        Sessao.decrementaQuantidadeSessoes();
                    }
                }
                else {
                    Sessao.decrementaQuantidadeSessoes();
                }
            }
            else {
                System.out.println("- Erro no cadastro: sala nao encontrada. Tente novamente!");
            }
        }
        else {
            System.out.println("- Erro no cadastro: filme nao encontrado. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void imprimeMenuGerenteEdicaoSessao(Gerente gerente, Scanner sc) {
        int opcao = 0;
        int codigoSessao = 0;
        DateTimeFormatter formatter;
        String confirmacao;

        System.out.println("EDITAR SESSAO");
        imprimeListaSessoes(gerente.getCinema());

        try {
            System.out.printf("Digite o codigo da sessao a ser alterada: ");
            codigoSessao = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(codigoSessao);
            
        } catch(NumberFormatException e) {
            System.err.println("- Erro: o o codigo da sessao deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return; 
        } catch(IllegalArgumentException e) {
            System.err.println("- Erro: o o codigo da sessao deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return; 
        }
        System.out.println();
        
        // busca sessao disponivel no cinema
        Sessao sessao = gerente.buscarSessao(codigoSessao);

        // se encontra sessao no catalogo e sessao nao possui ingressos vendidos, permite a mudança de parametros
        if (sessao != null && sessao.getAssentosDisponiveis() == sessao.getListaAssentos().length - 1) {
            System.out.println("Parametros que podem ser alterados: ");
            System.out.println("(1) Filme da Sessao");
            System.out.println("(2) Sala da Sessao");
            System.out.println("(3) Dia");
            System.out.println("(4) Horario");
            System.out.println("(5) Preco da Sessao");
            System.out.print("Escolha um parametro: ");
            
            
            try {
                System.out.printf("Entre uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());                     
            } catch(NumberFormatException e){}
            System.out.println();

            switch(opcao) {
                case 1: 
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
                            System.out.println("Sessao editada com sucesso!");
                        }
                    }
                    else {
                        System.out.println("- Erro na edicao: filme nao encontrado. Tente novamente!");
                    }
                    break;
                case 2: 
                    int nroSalaNovo = 0;
                    imprimeListaSalas(gerente.getCinema());

                    try {
                        System.out.print("Digite o numero novo da sala: ");
                        nroSalaNovo = Integer.parseInt(sc.nextLine());
                        excecaoNumerosNegativos(nroSalaNovo);                            
                    } catch(NumberFormatException e) {
                        System.err.println("- Erro: o novo numero da sala  deve ser um numero inteiro. Tente novamente!");
                        sc.nextLine();
                        return; 
                    } catch(IllegalArgumentException e) {
                        System.err.println("- Erro: o novo numero da sala deve ser um numero positivo. Tente novamente!");
                        sc.nextLine();
                        return; 
                    }
                    System.out.println();

                    Sala salaSessao = gerente.buscarSala(nroSalaNovo);

                    if (salaSessao != null) {
                        System.out.println("- Sala Antiga: " + sessao.getSalaSessao().getNroSala());
                        System.out.println("- Sala Nova: " + nroSalaNovo);

                        System.out.print("Confirmar edicao (Sim ou Nao): ");
                        confirmacao = sc.nextLine();
                        
                        if (confirmacao.equalsIgnoreCase("Sim")) {
                            gerente.editarSessao(sessao, null, null, -1, salaSessao, null);
                            System.out.println("Sessao editada com sucesso!");
                        }
                    }
                    else {
                        System.out.println("- Erro na edicao: sala nao encontrada. Tente novamente!");
                    }
                    break;
                case 3: // mudança do dia da sessão
                    LocalDate diaSessao = null;

                    try {
                        System.out.print("Digite o dia novo (DD/MM/YYYY): ");
                        String diaSessaoString = sc.nextLine();
                        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        diaSessao = LocalDate.parse(diaSessaoString, formatter);

                    } catch (DateTimeParseException e) {
                        System.err.println("- Erro: data invalida. Tente novamente!");
                        sc.nextLine();
                        return; 
                    }                    
                    System.out.println();

                    System.out.println("- Dia Antigo: " + sessao.getDiaSessao());
                    System.out.println("- Dia Novo: " + diaSessao);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();
                        
                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        if (!(gerente.editarSessao(sessao, diaSessao, null, -1, null, null))) {
                            System.out.println("- Erro na edicao: intervalo de horario coincide com o de outra sessao. Tente novamente!");
                        }
                        else {
                            System.out.println("Sessao editada com sucesso!");
                        }
                    }
                    break;
                case 4: // mudança do horário da sessão
                    LocalTime horarioSessao = null;
                    
                    try {
                        System.out.print("Digite o horario novo (MM:mm): ");
                        String horarioSessaoString = sc.nextLine();
                        formatter = DateTimeFormatter.ofPattern("HH:mm");
                        horarioSessao = LocalTime.parse(horarioSessaoString, formatter);

                    } catch(DateTimeParseException e) {
                        System.err.println("- Erro: data invalida. Tente novamente!");
                        sc.nextLine();
                        return; 
                    }                    
                    System.out.println();

                    System.out.println("- Horario Antigo: " + sessao.getHorarioSessao());
                    System.out.println("- Horario Novo: " + horarioSessao);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();
                        
                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        if (!(gerente.editarSessao(sessao, null, horarioSessao, -1, null, null))) {
                            System.out.println("- Erro na edicao: intervalo de horario coincide com o de outra sessao. Tente novamente!");
                        }
                        else {
                            System.out.println("Sessao editada com sucesso!");
                        }
                    }
                    break;
                case 5: // mudança do preço da sessão
                    double precoSessaoNovo = 0.0;

                    try {
                        System.out.print("Digite o preco novo: ");
                        precoSessaoNovo = Double.parseDouble(sc.nextLine());
                        excecaoNumerosNegativos(precoSessaoNovo);

                    } catch(NumberFormatException e) {
                        System.err.println("- Erro: o preco do filme deve ser um numero double. Tente novamente!");
                        sc.nextLine();
                        return; 
                    } catch(IllegalArgumentException e) {
                        System.err.println("- Erro: o preco do filme deve ser um numero positivo. Tente novamente!");
                        sc.nextLine();
                        return; 
                    }
                    System.out.println();

                    System.out.println("- Preco Antigo: " + sessao.getPrecoSessao());
                    System.out.println("- Preco Novo: " + precoSessaoNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();
                        
                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        gerente.editarSessao(sessao, null, null, precoSessaoNovo, null, null);
                        System.out.println("Sessao editada com sucesso!");
                    }
                    break;
                default:
                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                    break;
            }
        }
        else {
            System.out.println("- Erro na edicao: sessao nao encontrada ou sessao com ingressos comprados. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void imprimeMenuGerenteRemocaoSessao(Gerente gerente, Scanner sc) {
        int codigoSessao = 0;
        String motivoExclusaoSessao;
        String confirmacao;

        System.out.println("REMOCAO DE SESSAO");
        imprimeListaSessoes(gerente.getCinema());

        try {
            System.out.printf("Digite o codigo da sessao a ser removida: ");
            codigoSessao = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(codigoSessao);
                  
        } catch(NumberFormatException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return; 
        } catch(IllegalArgumentException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return; 
        }
        System.out.println();

        // busca sessão disponivel no cinema
        Sessao sessao = gerente.buscarSessao(codigoSessao);
        
        // se encontra sessao no catalogo e sessao nao possui ingressos vendidos, permite a remocao
        if (sessao != null && sessao.getAssentosDisponiveis() == sessao.getListaAssentos().length -1) {

            System.out.printf("Digite o motivo de exclusao da sessao: ");
            motivoExclusaoSessao = sc.nextLine();

            System.out.print("Confirmar remocao da sessao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                gerente.removerSessao(sessao, motivoExclusaoSessao);
                System.out.println("Sessao removida com sucesso!");
            }
        }
        else {
            System.out.println("- Erro na remocao: sessao nao encontrada ou sessao com ingressos comprados. Tente novamente!");
        }
        sc.nextLine();        
    }

    private static void imprimeListaSessoes(Cinema cinema) {
        for (Sessao s : cinema.getListaSessoes()) {
            if (!(s instanceof SessaoIndisponivel)) {
                System.out.println(s.toString());
            }
        }
    }

    // menu do gerente - aba de promocoes
    private static int imprimeMenuGerentePromocao(Scanner sc) {
        int opcao = 0;
        
        System.out.println("PROMOCAO");
        System.out.println("(1) Cadastrar Promocao");
        System.out.println("(2) Editar Promocao");
        System.out.println("(3) Remover Promocao");
        System.out.println("(4) Sair");
        
        try {
            System.out.printf("Entre uma opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
                 
        } catch(NumberFormatException e) {}

        System.out.println();
        return opcao;
    }

    private static void imprimeMenuGerenteCadastroPromocao(Gerente gerente, Scanner sc) {
        int codigoSessao = 0;
        double porcentagemPromocional = 0;
        String confirmacao;

        System.out.println("CADASTRAR PROMOCAO");
        imprimeListaSessoes(gerente.getCinema());

        try {
            System.out.print("Digite o codigo da sessao a qual a promocao ira ser adicionada : ");
            codigoSessao = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(codigoSessao);
                
        } catch(NumberFormatException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return; 
        } catch(IllegalArgumentException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return; 
        }
        System.out.println();

        // busca sessao no catalogo
        Sessao sessao = gerente.buscarSessao(codigoSessao);

        // se acha sessao no catalogo, permite o cadastro de promocao
        if (sessao != null) {
            // checar se promocao eh um valor entre 0 e 100
            try {
                System.out.print("Qual sera a porcentagem da promocao? ");
                porcentagemPromocional = Double.parseDouble(sc.nextLine()); 
                execcaoPorcentagemPromocional(porcentagemPromocional);     
                    
            } catch(NumberFormatException e) {
                System.err.println("- Erro: a porcentagem da promocao deve ser um numero. Tente novamente!");
                sc.nextLine();
                return; 
            } catch(IllegalArgumentException e) {
                System.err.println("- Erro: a porcentagem da promocao deve ser um numero entre 0 e 100. Tente novamente!");
                sc.nextLine();
                return; 
            }
            porcentagemPromocional = porcentagemPromocional/100.00;
            System.out.println();

            System.out.print("Confirmar adicao da promocao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.adicionarPromocao(sessao, porcentagemPromocional)) {
                    System.out.println("Promocao adicionada com sucesso!");
                }
                else {
                    System.out.println("- Erro no cadastro: promocao ja cadastrada. Tente novamente!");
                }
            }
        }
        else {
            System.out.println("- Erro no cadastro: sessao nao encontrada. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void imprimeMenuGerenteEdicaoPromocao(Gerente gerente, Scanner sc) {
        int codigoSessao = 0;
        double porcentagemPromocionalNova = 0;
        String confirmacao;

        System.out.println("EDITAR PROMOCAO");
        imprimeListaSessoes(gerente.getCinema());

        try {
            System.out.print("Digite o codigo da sessao a qual a promocao esta ligada: ");
            codigoSessao = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(codigoSessao);
        } catch(NumberFormatException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return; 
        } catch(IllegalArgumentException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return; 
        }
        System.out.println();

        // busca sessao no catalogo
        Sessao sessao = gerente.buscarSessao(codigoSessao);

        // se acha sessao no catalogo, permite a edicao de promocao
        if (sessao != null) {
            // checar se promocao eh um valor entre 0 e 100
            try {
                System.out.print("Qual sera a porcentagem nova da promocao? ");
                porcentagemPromocionalNova = Double.parseDouble(sc.nextLine());
                execcaoPorcentagemPromocional(porcentagemPromocionalNova);
            } catch(NumberFormatException e) {
                System.err.println("- Erro: a porcentagem da promocao deve ser um numero. Tente novamente!");
                sc.nextLine();
                return; 
            } catch(IllegalArgumentException e) {
                System.err.println("- Erro: a porcentagem da promocao deve ser um numero entre 0 e 100. Tente novamente!");
                sc.nextLine();
                return; 
            }         
            porcentagemPromocionalNova = porcentagemPromocionalNova/100.00;
            System.out.println();
                    
            System.out.println("- Promocao Antiga: " + sessao.getPorcentagemPromocional() * 100 + "%");
            System.out.println("- Promocao Nova: " + porcentagemPromocionalNova * 100 + "%");

            System.out.print("Confirmar edicao da promocao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.editarPromocao(sessao, porcentagemPromocionalNova)) {
                    System.out.println("Promocao editada com sucesso!");
                }
                else {
                    System.out.println("- Erro na edicao: sessao nao possui promocao. Tente novamente!");
                }
            }
        }
        else {
            System.out.println("- Erro na edicao: sessao nao encontrada. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void imprimeMenuGerenteRemocaoPromocao(Gerente gerente, Scanner sc) {
        int codigoSessao = 0;
        String confirmacao;

        System.out.println("REMOCAO DE PROMOCAO");
        imprimeListaSessoes(gerente.getCinema());

        try {
            System.out.printf("Digite o codigo da sessao para remover sua promocao: ");
            codigoSessao = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(codigoSessao);
        } catch(NumberFormatException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero. Tente novamente!");
            sc.nextLine();
            return; 
        } catch(IllegalArgumentException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return; 
        }
        System.out.println();
        
        // busca sessao no catalogo
        Sessao sessao = gerente.buscarSessao(codigoSessao);
        
        // se acha sessao no catalogo, permite a edicao de promocao
        if (sessao != null) {
            System.out.print("Confirmar remocao da promocao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.excluirPromocao(sessao)) {
                    System.out.println("Promocao removida com sucesso!");
                }
                else {
                    System.out.println("- Erro na remocao: sessao nao possui promocao. Tente novamente!");
                }
            }
        }
        else {
            System.out.println("- Erro na remocao: sessao nao encontrada. Tente novamente!");
        }
        sc.nextLine();        
    }

    // menu do gerente - aba de relatorios
    private static int imprimeMenuGerenteRelatorio(Scanner sc) {
    	int opcao = 0;
    	
    	System.out.println("RELATORIO");
        System.out.println("(1) Filmes");
        System.out.println("(2) Sessoes");
        System.out.println("(3) Sala");
        System.out.println("(4) Usuarios");
        System.out.println("(5) Sair");

        try {
            System.out.printf("Entre uma opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
                         
        } catch(NumberFormatException e) {}

        System.out.println();
        return opcao; 
    }
    
    private static void imprimeMenuGerenteRelatorioFilmes(Gerente gerente, Cinema cinema) {
        System.out.println("FILMES CADASTRADOS: \n");
        gerente.gerarRelatorioFilmes(cinema.getListaFilmes());
        System.out.println();
    }
    
    private static void imprimeMenuGerenteRelatorioSessoes(Gerente gerente, Cinema cinema) {
        System.out.println("SESSOES CADASTRADAS: \n");
        gerente.gerarRelatorioSessoes(cinema.getListaSessoes());
        System.out.println();
    }
    
    private static void imprimeMenuGerenteRelatorioSalas(Gerente gerente, Cinema cinema) {
        System.out.println("SALAS CADASTRADAS: \n");
        gerente.gerarRelatorioSalas(cinema.getListaSalas());
        System.out.println();	
    }
    
    private static void imprimeMenuGerenteRelatorioUsuario(Gerente gerente) {	
        System.out.println("USUARIOS CADASTRADOS: \n");
        gerente.gerarRelatorioUsuarios();
        System.out.println();	
    }
    
    // menu do usuario
    private static int imprimeMenuUsuario(Scanner sc) {
        int opcao = 0;
        
        System.out.println("MENU DO USUARIO");
        System.out.println("(1) Comprar Ingresso");
        System.out.println("(2) Comprar Assinatura");
        System.out.println("(3) Ver perfil");
        System.out.println("(4) Sair");
    
        try {
            System.out.print("Digite uma opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
                 
        } catch(NumberFormatException e) {}
        
        System.out.println();
        return opcao;
    }

    private static void imprimeMenuUsuarioComprarIngresso(Usuario usuario, Gerente gerente, Scanner sc) {
        String nomeFilme;
        int codigoSessao = 0;
        int nroAssento = 0;
        String confirmacao;

        System.out.println("CATALOGO DE FILMES");
        imprimeListaFilmes(gerente.getCinema());
        System.out.print("Digite o nome do filme escolhido: ");
        nomeFilme = sc.nextLine();
        System.out.println();
        
        // busca filme solicitado e imprime sessoes com esse filme
        Filme filme = gerente.buscarFilme(nomeFilme);

        if (filme != null) {
            for (Sessao sessao : gerente.getCinema().getListaSessoes()) {
                if (sessao.getFilmeSessao() == filme) {
                    System.out.println(sessao.toString());
                }
            }

            try {
                System.out.printf("Digite o codigo da sessao escolhida: ");
                codigoSessao = Integer.parseInt(sc.nextLine());
                excecaoNumerosNegativos(codigoSessao);
            } catch(NumberFormatException e) {
                System.err.println("- Erro: o codigo da sessao deve ser um numero inteiro. Tente novamente!");
                sc.nextLine();
                return; 
            } catch(IllegalArgumentException e) {
                System.err.println("- Erro: o codigo da sessao deve ser um numero positivo. Tente novamente!");
                sc.nextLine();
                return; 
            }
            System.out.println();

            // busca se sessao existe
            Sessao sessao = gerente.buscarSessao(codigoSessao);

            if (sessao != null) {
                // imprime lista de assentos e pede para usuario digitar um assento disponivel
                sessao.imprimeListaAssentos();

                try {
                    System.out.printf("Digite o numero de assento disponivel: ");
                    nroAssento = Integer.parseInt(sc.nextLine());
                    excecaoCompraIngresso(nroAssento, sessao);
                } catch(NumberFormatException e) {
                    System.err.println("- Erro: o numero de assento deve ser um numero. Tente novamente!");
                    sc.nextLine();
                    return; 
                } catch(ArrayIndexOutOfBoundsException e) {
                    System.err.println("- Erro: o assento selecionado deve estar listado. Tente novamente!");
                    sc.nextLine();
                    return; 
                }
                System.out.println();                
                
                // checa disponibilidade do assento
                while (sessao.getDisponibilidadeAssento(nroAssento)) {
                    System.out.println("- Erro na compra: assento indisponivel. Tente novamente!");

                    try {
                        System.out.printf("Digite o numero de assento disponivel: ");
                        nroAssento = Integer.parseInt(sc.nextLine());
                        excecaoCompraIngresso(nroAssento, sessao);
                    } catch(NumberFormatException e) {
                        System.err.println("- Erro: o numero de assento deve ser um numero. Tente novamente!");
                        sc.nextLine();
                        return; 
                    } catch(ArrayIndexOutOfBoundsException e) {
                        System.err.println("- Erro: o assento selecionado deve estar listado. Tente novamente!");
                        sc.nextLine();
                        return; 
                    }
                    System.out.println();
                }

                Ingresso ingresso = new Ingresso(sessao, nroAssento, usuario.getPrecoIngresso(sessao));
                System.out.println(ingresso.toString());

                System.out.print("Confirmar compra de ingresso (Sim ou Nao): ");
                confirmacao = sc.nextLine();

                if (confirmacao.equalsIgnoreCase("Sim")) {
                    if (usuario.comprarIngresso(sessao, nroAssento)) {
                        System.out.println("Ingresso comprado com sucesso!");
                    }
                    else {
                        System.out.println("- Erro na compra: idade menor que classificacao indicativa. Tente novamente!");
                    }
                }
            }
            else {
                System.out.println("- Erro na compra: sessao nao encontrada. Tente novamente!");
            }
        }
        else {
            System.out.println("- Erro na compra: filme nao encontrado. Tente novamente!");
        }
        sc.nextLine();
    }

    private static Usuario imprimeMenuUsuarioComprarAssinatura(Usuario usuario, Gerente gerente, Scanner sc) {
        System.out.println("ASSINATURA");

        // checa se usuario ja eh assinante
        if (usuario instanceof UsuarioAssinante) {
            System.out.println("Voce ja possui uma assinatura!");
        }  
        // caso usuario nao seja, oferece opcao de se tornar assinante
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
            }
            
        }
        sc.nextLine();
        return usuario;
    }

    private static void imprimeMenuUsuarioPerfil(Usuario usuario) {
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

    private static void limpaConsole() {
        try {
            String sistemaOperacional = System.getProperty("os.name").toLowerCase();

            // comando para windows
            if (sistemaOperacional.contains("win")) { // comando para windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else { // comando para mac/linux
                
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) { // caso o comando nao funcione, imprime linhas em branco
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }

    }

    // metodos de excecao para simplificar as estruturas em outros metodos
    // aceita apenas numeros positivos - opção, códigos, idade, duração, nroSala
    private static <T extends Number & Comparable<T>> void excecaoNumerosNegativos(T numeroEntrada) throws IllegalArgumentException {
    	if(numeroEntrada.doubleValue() < 0) {  
    		throw new IllegalArgumentException(); 
    	}
    }
    
    // numeros de assentos são obrigatoriamente definidos a partir de 30 - cadastro e edição de sala
    private static void excecaoNroAssentos(int numeroEntrada) throws IllegalArgumentException {
    	if(numeroEntrada < 30) {
    		throw new IllegalArgumentException(); 
    	}
    }

    // checa se o tipo de tela eh igual a 2d ou 3d
    private static boolean excecaoTipoTela(String tipoTela) throws IllegalArgumentException {
        if (tipoTela.equalsIgnoreCase("2D")) {
            return false;
        }
        else if (tipoTela.equalsIgnoreCase("3D")) {
            return true;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    // aceita apenas numeros entre 0 e 100, caso contrário lança excecao - métodos de promoção
    private static void execcaoPorcentagemPromocional(double numeroEntrada) throws IllegalArgumentException {
    	if(numeroEntrada <= 0 || numeroEntrada >= 100) {
    		throw new IllegalArgumentException(); 
    	}
    }     
    
    private static void excecaoCompraIngresso(int numeroEntrada, Sessao sessao) throws ArrayIndexOutOfBoundsException {
        if (numeroEntrada < 0 || numeroEntrada > sessao.getSalaSessao().getNroAssentos()) {
            throw new ArrayIndexOutOfBoundsException("Número de assento fora do intervalo válido.");
        }
    } 
}
