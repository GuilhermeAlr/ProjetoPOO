package main.java.com.test.projetopoo;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Cinema cinema = new Cinema("GIG CINEMAS");
        ArrayList<Usuario> listaUsuarios = new ArrayList<>(); // valor pre-definido
        Gerente gerente = new Gerente("Nome do Admin", "admin", "123", cinema, listaUsuarios);
        
        Scanner sc = new Scanner(System.in);
        boolean estaRodando = true;
        int estaLogado = -1;
        int opcao, opcaoMenuGerente;
        
        while(estaRodando) {
            if(estaLogado == -1) { // menu nao logado
                opcao = imprimeMenuNaoLogado(cinema, sc);
                
                switch(opcao) {
                    case 1: 
                        imprimeMenuCadastro(listaUsuarios, sc);
                        break;
                    case 2:
                        estaLogado = imprimeMenuLogin(listaUsuarios, gerente, sc);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Opcao invalida. Tente novamente");
                        break;
                }
                
            }
            
            else {
                if (estaLogado == 0) { // menu gerente
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
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Opcao invalida. Tente novamente");
                                    break;
                            }
                            break;
                        case 2: // aba de sala
                            break;
                        case 3: // aba de sessao
                            break;
                        case 4: // aba de relatorios
                            break;
                        case 5: // sair
                            estaLogado = -1;
                            break;
                        default:
                            System.out.println("Opcao invalida. Tente novamente");
                            break;
                    } 
                    
                }
                else if (estaLogado == 1) { // menu usuario
                    opcao = imprimeMenuUsuario(sc);
                    
                    switch(opcao) {
                        case 1: // aba para comprar ingressos
                            break;
                        case 2: // aba para comprar assinatura
                            break;
                        case 3: // aba para ver perfil
                            break;
                        case 4: // sair 
                            estaLogado = -1;
                            break;
                        default:
                            System.out.println("Opcao invalida. Tente novamente");
                            break;
                }
                }
                else if (estaLogado == 1) {
                    }
                else if (estaLogado == 1) {

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
        
        return opcao;
    }
    
    public static void imprimeMenuCadastro(ArrayList<Usuario> listaUsuarios, Scanner sc) {
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
        
        for (Usuario usuarioTemporario : listaUsuarios) {
            if (loginUsuario.matches(usuarioTemporario.getLoginPessoa())) {
                System.out.println("Erro no Cadastro. Esse usuario ja esta cadastrado");
                System.out.println();
                break;
            }
        }
        
        System.out.println("Usuario cadastrado com sucesso!");
        System.out.println("Login: " + loginUsuario);
        System.out.println("Senha: " + senhaUsuario);
        System.out.println();
        Usuario usuario = new Usuario(nomeUsuario, loginUsuario, senhaUsuario, idadeUsuario);
        listaUsuarios.add(usuario);
    }    
    
    public static int imprimeMenuLogin(ArrayList<Usuario> listaUsuarios, Gerente gerente, Scanner sc) {
        String loginTemporario;
        String senhaTemporaria;
        
        System.out.println("LOGIN");
        System.out.printf("Digite um usuario: ");
        loginTemporario = sc.nextLine();
        System.out.printf("Digite uma senha: ");
        senhaTemporaria = sc.nextLine();
                
        if (loginTemporario.matches(gerente.getLoginPessoa()) && senhaTemporaria.matches(gerente.getSenhaPessoa())) {
            System.out.println("Sucesso no Login!");
            System.out.println();
            
            return 0;
        }
        else {
            for (Usuario usuarioTemporario : listaUsuarios) {
                if (loginTemporario.matches(usuarioTemporario.getLoginPessoa()) && senhaTemporaria.matches(usuarioTemporario.getSenhaPessoa())) {
                    System.out.println("Sucesso no Login! Bem-vindo!");
                    System.out.println();
                    return 1;
                }
            }
        }   
        
        System.out.println("Erro no login. Usuario ou senha incorretos");
        System.out.println();
        return -1;

    }
    
    public static int imprimeMenuGerente(Scanner sc) {
        int opcao;
        
        System.out.println("MENU DO GERENTE");
        System.out.println("(1) Filme");
        System.out.println("(2) Sala");
        System.out.println("(3) Sessao");
        System.out.println("(4) Exibir Relatorios");
        System.out.println("(5) Sair");

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
        System.out.printf("Digite o nome do filme a ser removido: ");
        nomeFilme = sc.nextLine();

        Filme filme = gerente.buscarFilme(nomeFilme);
        
        if (filme != null) {
            System.out.printf("Digite o motivo de exclusao do filme: ");
            motivoExclusaoFilme = sc.nextLine();

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

}
