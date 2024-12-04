package projetopoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.io.*;

// comando para compilar o codigo: no diretorio da pasta projetopoo, javac projetopoo/*.java
// comando para rodar o codigo: java projetopoo.Main
public class Main {

    public static void main(String[] args) {
        Cinema cinema = new Cinema("GIG CINEMAS");
        Gerente gerente = new Gerente("Nome do Admin", "admin", "123", cinema);

        carregarDados("arquivos", cinema, gerente, null);

        Scanner sc = new Scanner(System.in);
        boolean estaRodando = true;
        Pessoa pessoa = null;
        int opcao, opcaoMenuGerente;

        limpaConsole();
        while (estaRodando) {
            if (pessoa == null) { // menu nao logado
                opcao = imprimeMenuNaoLogado(cinema, sc);

                switch (opcao) {
                    case 1:
                        limpaConsole();
                        imprimeMenuCadastro(gerente.getListaUsuarios(), gerente, sc);
                        break;
                    case 2:
                        limpaConsole();
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
            } else {
                if (pessoa instanceof Gerente) { // menu do gerente
                    opcao = imprimeMenuGerente(sc);

                    switch (opcao) {
                        case 1: // aba de filmes 
                            limpaConsole();
                            opcaoMenuGerente = imprimeMenuGerenteFilme(sc);

                            switch (opcaoMenuGerente) {
                                case 1:
                                    limpaConsole();
                                    imprimeMenuGerenteCadastroFilme(gerente, sc);
                                    break;
                                case 2:
                                    limpaConsole();
                                    imprimeMenuGerenteEdicaoFilme(gerente, sc);
                                    break;
                                case 3:
                                    limpaConsole();
                                    imprimeMenuGerenteRemocaoFilme(gerente, sc);
                                    break;
                                case 4:
                                    limpaConsole();
                                    System.out.println("LISTA DE FILMES");
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
                            limpaConsole();
                            opcaoMenuGerente = imprimeMenuGerenteSala(sc);

                            switch (opcaoMenuGerente) {
                                case 1:
                                    limpaConsole();
                                    imprimeMenuGerenteCadastroSala(gerente, sc);
                                    break;
                                case 2:
                                    limpaConsole();
                                    imprimeMenuGerenteEdicaoSala(gerente, sc);
                                    break;
                                case 3:
                                    limpaConsole();
                                    imprimeMenuGerenteRemocaoSala(gerente, sc);
                                    break;
                                case 4:
                                    limpaConsole();
                                    System.out.println("LISTA DE SALAS");
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
                            limpaConsole();
                            opcaoMenuGerente = imprimeMenuGerenteSessao(sc);

                            switch (opcaoMenuGerente) {
                                case 1:
                                    limpaConsole();
                                    imprimeMenuGerenteCadastroSessao(gerente, sc);
                                    break;
                                case 2:
                                    limpaConsole();
                                    imprimeMenuGerenteEdicaoSessao(gerente, sc);
                                    break;
                                case 3:
                                    limpaConsole();
                                    imprimeMenuGerenteRemocaoSessao(gerente, sc);
                                    break;
                                case 4:
                                    limpaConsole();
                                    System.out.println("LISTA DE SESSOES");
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
                            limpaConsole();
                            opcaoMenuGerente = imprimeMenuGerentePromocao(sc);

                            switch (opcaoMenuGerente) {
                                case 1:
                                    limpaConsole();
                                    imprimeMenuGerenteCadastroPromocao(gerente, sc);
                                    break;
                                case 2:
                                    limpaConsole();
                                    imprimeMenuGerenteEdicaoPromocao(gerente, sc);
                                    break;
                                case 3:
                                    limpaConsole();
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
                            limpaConsole();
                            opcaoMenuGerente = imprimeMenuGerenteRelatorio(sc);

                            switch (opcaoMenuGerente) {
                                case 1:
                                    limpaConsole();
                                    imprimeMenuGerenteRelatorioFilmes(gerente, cinema);
                                    sc.nextLine();
                                    break;
                                case 2:
                                    limpaConsole();
                                    imprimeMenuGerenteRelatorioSessoes(gerente, cinema);
                                    sc.nextLine();
                                    break;
                                case 3:
                                    limpaConsole();
                                    imprimeMenuGerenteRelatorioSalas(gerente, cinema);
                                    sc.nextLine();
                                    break;
                                case 4:
                                    limpaConsole();
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
                } else if (pessoa instanceof Usuario) { // menu do usuario
                    carregarDados("arquivos", cinema, gerente, (Usuario) pessoa);
                    limpaConsole();
                    opcao = imprimeMenuUsuario(sc);

                    switch (opcao) {
                        case 1: // aba para comprar ingressos
                            limpaConsole();
                            imprimeMenuUsuarioComprarIngresso((Usuario) pessoa, gerente, sc);
                            break;
                        case 2: // aba para comprar assinatura
                            limpaConsole();
                            pessoa = imprimeMenuUsuarioComprarAssinatura((Usuario) pessoa, gerente, sc);
                            break;
                        case 3: // aba para ver perfil
                            limpaConsole();
                            imprimeMenuUsuarioPerfil((Usuario) pessoa);
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

    public static void carregarDados(String caminhoDiretorio, Cinema cinema, Gerente gerente, Usuario usuario) {
        File diretorio = new File(caminhoDiretorio);

        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] arquivos = diretorio.listFiles((dir, nome) -> nome.endsWith(".csv"));

            // Para cada arquivo CSV encontrado, carregar os dados
            for (File arquivo : arquivos) {
                if (arquivo.isFile()) {
                    if (arquivo.getName().startsWith("Usuarios") && usuario == null) {
                        carregarUsuariosArquivo(arquivo, gerente);
                    } else if (arquivo.getName().startsWith("Salas") && usuario == null) {
                        carregarSalasArquivo(arquivo, cinema);
                    } else if (arquivo.getName().startsWith("Sessoes") && usuario == null) {
                        carregarSessoesArquivo(arquivo, cinema);
                    } else if (arquivo.getName().startsWith("Filmes") && usuario == null) {
                        carregarFilmesArquivo(arquivo, cinema);
                    } else if (arquivo.getName().startsWith("Ingressos") && usuario != null) {
                        carregarIngressos(arquivo, cinema, usuario);
                    }
                }
            }
        } else {
            System.out.println("Diretorio nao encontrado: " + caminhoDiretorio);
        }
    }

    private static int imprimeMenuNaoLogado(Cinema cinema, Scanner sc) {
        int opcao = 0;

        System.out.println(cinema.getNomeCinema());
        System.out.println("Bem Vindo!\n");
        System.out.println("(1) Cadastro");
        System.out.println("(2) Login");
        System.out.println("(3) Sair");

        try {
            System.out.printf("Entre uma opcao: ");
            opcao = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("- Erro: a opcao deve ser um numero.");
        }

        return opcao;
    }

    private static void imprimeMenuCadastro(ArrayList<Usuario> listaUsuarios, Gerente gerente, Scanner sc) {
        String nomeUsuario;
        String loginUsuario;
        String senhaUsuario;
        int idadeUsuario = 0;

        System.out.println("CADASTRO");

        try {
            System.out.printf("Digite seu nome: ");
            nomeUsuario = sc.nextLine();
            excecaoStringVazia(nomeUsuario);
            System.out.printf("Digite um usuario: ");
            loginUsuario = sc.nextLine();
            excecaoStringVazia(loginUsuario);
            System.out.printf("Digite uma senha: ");
            senhaUsuario = sc.nextLine();
            excecaoStringVazia(senhaUsuario);

        } catch (IllegalArgumentException i) {
            System.err.println("- Erro: o dado inserido deve conter numeros ou algarismos. Tente novamente!");
            sc.nextLine();
            return;
        }
        
        
        try {
            System.out.printf("Digite sua idade: ");
            idadeUsuario = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(idadeUsuario);
        } catch (NumberFormatException e) {
            System.err.println("- Erro: a idade deve ser um numero. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException i) {
            System.err.println("- Erro: a idade deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return;
        }

        System.out.println();

        if (buscarUsuario(loginUsuario, listaUsuarios) == null) {
            Usuario usuario = new Usuario(nomeUsuario, loginUsuario, senhaUsuario, idadeUsuario);
            listaUsuarios.add(usuario);

            cadastrarUsuarioArquivo(usuario);

            System.out.println("Usuario cadastrado com sucesso!");
            System.out.println("- Nome: " + nomeUsuario);
            System.out.println("- Idade: " + idadeUsuario);
            System.out.println("- Login: " + loginUsuario);
            System.out.println("- Senha: " + senhaUsuario);
        } else {
            System.out.println("- Erro no cadastro: usuario ja esta cadastrado. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void cadastrarUsuarioArquivo(Usuario usuario) {
        //caminho do arquivo de usuários
        String arquivoUsuario = "arquivos/Usuarios.csv";

        //cria/abre o arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoUsuario, true))) {
            //cria o cabeçalho do arquivo se ele estiver vazio
            if (new java.io.File(arquivoUsuario).length() == 0) {
                bw.write("Nome,Login,Senha,Idade,Assinante\n");
            }

            //insere os dados do usuario
            bw.write(usuario.getNomePessoa() + ","
                    + usuario.getLoginPessoa() + ","
                    + usuario.getSenhaPessoa() + ","
                    + usuario.getIdadeUsuario() + ","
                    + "false" + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarUsuariosArquivo(File arquivoUsuario, Gerente gerente) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoUsuario))) {
            String linha;
            br.readLine(); //ignora o cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    String nome = dados[0];
                    String login = dados[1];
                    String senha = dados[2];
                    int idade = Integer.parseInt(dados[3]);

                    gerente.getListaUsuarios().add(new Usuario(nome, login, senha, idade));
                }

                if (dados.length == 5) {
                    String nome = dados[0];
                    String login = dados[1];
                    String senha = dados[2];
                    int idade = Integer.parseInt(dados[3]);

                    gerente.getListaUsuarios().add(new UsuarioAssinante(nome, login, senha, idade));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodo que busca o login do usuario no arraylist de usuarios e o retorna
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

        } catch (NumberFormatException e) {
            System.err.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
        }

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
        } catch (NumberFormatException e) {
            System.err.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
        }

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

        try {
            System.out.print("- Nome: ");
            nomeFilme = sc.nextLine();
            excecaoStringVazia(nomeFilme);
        } catch (IllegalArgumentException e) {
            System.err.println("- Erro no cadastro: o nome do filme deve conter letras ou algarismos. Tente novamente!");
            sc.nextLine();
            return;
        }
        
        
        try {
            System.out.print("- Sinopse: ");
            sinopseFilme = sc.nextLine();
            excecaoStringVazia(sinopseFilme);
        } catch (IllegalArgumentException e) {
            System.err.println("- Erro no cadastro: a sinopse do filme deve conter letras ou algarismos. Tente novamente!");
            sc.nextLine();
            return;
        }
        
        
        try {
            System.out.println("Opcoes de classificacao indicativa: \'livre\', \'10\', \'12\', \'14\', \'16\', \'18\'");
            System.out.print("- Classificacao Indicativa: ");
            classificacaoFilmeString = sc.nextLine();
            classificacaoFilme = excecaoClassificacaoIndicativa(classificacaoFilmeString);
        } catch (IllegalArgumentException e) {
            System.err.println("- Erro no cadastro: a classificacao deve ser uma das opcoes acima. Tente novamente!");
            sc.nextLine();
            return;
        }

        
        try {
        	System.out.print("- Genero: ");
            generoFilme = sc.nextLine();
            excecaoStringVazia(generoFilme);
        } catch (IllegalArgumentException e) {
            System.err.println("- Erro no cadastro: o genero do filme deve conter letras ou algarismos. Tente novamente!");
            sc.nextLine();
            return;
        }
               
        try {
            System.out.print("- Duracao (em minutos): ");
            duracaoFilme = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(duracaoFilme);
        } catch (NumberFormatException e) {
            System.err.println("- Erro: a duracao deve ser um numero. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException e) {
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
            if (gerente.adicionarFilme(filmeTemporario)) {
                cadastrarFilmeArquivo(filmeTemporario);
                System.out.println("Filme adicionado com sucesso!");
            } else {
                System.out.println("- Erro no cadastro: filme ja existe no catalogo. Tente novamente!");
            }
        }

        sc.nextLine();
    }

    private static void cadastrarFilmeArquivo(Filme filme) {
        String arquivoFilme = "arquivos/Filmes.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoFilme, true))) {
            if (new java.io.File(arquivoFilme).length() == 0) {
                bw.write("Titulo,Sinopse,Classificacao,Genero,Duracao\n");
            }

            bw.write(filme.getNomeFilme() + ","
                    + filme.getSinopseFilme() + ","
                    + filme.getClassificacaoFilme() + ","
                    + filme.getGeneroFilme() + ","
                    + filme.getDuracaoFilme() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarFilmesArquivo(File arquivo, Cinema cinema) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    String nome = dados[0];
                    String sinopse = dados[1];
                    int classificao = Integer.parseInt(dados[2]);
                    String genero = dados[3];
                    int duracao = Integer.parseInt(dados[4]);

                    cinema.getListaFilmes().add(new Filme(nome, sinopse, classificao, genero, duracao));
                }

                if (dados.length == 6) {
                    String nome = dados[0];
                    String sinopse = dados[1];
                    int classificao = Integer.parseInt(dados[2]);
                    String genero = dados[3];
                    int duracao = Integer.parseInt(dados[4]);
                    String motivoExclusao = dados[5];

                    cinema.getListaFilmes().add(new FilmeIndisponivel(nome, sinopse, classificao, genero, duracao, motivoExclusao));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            } catch (NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
                sc.nextLine();
                return;
            }
            System.out.println();;

            switch (opcao) {
                case 1:
                    String nomeNovo;

                    System.out.print("Digite o nome novo: ");
                    nomeNovo = sc.nextLine();
                    System.out.println();

                    System.out.println("- Nome Antigo: " + filme.getNomeFilme());
                    System.out.println("- Nome Novo: " + nomeNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        String nomeAntigo = filme.getNomeFilme();
                        filme.setNomeFilme(nomeFilme);
                        if (gerente.editarFilme(filme, nomeNovo, "", -1, "", -1)) {
                            editarFilmeArquivo(filme, nomeAntigo);
                            System.out.println("Filme editado com sucesso!");
                        } else {
                            System.out.println("- Erro na edicao: nome novo do filme ja esta cadastrado. Tente novamente!");
                        }
                    }
                    break;
                case 2:
                    String sinopseNova;

                    System.out.printf("Digite a sinopse nova: ");
                    sinopseNova = sc.nextLine();
                    System.out.println();

                    System.out.println("Sinopse Antiga: " + filme.getSinopseFilme());
                    System.out.println("Sinopse Nova: " + sinopseNova);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        String nomeAntigo = filme.getNomeFilme();
                        filme.setNomeFilme(nomeFilme);
                        gerente.editarFilme(filme, "", sinopseNova, -1, "", -1);
                        editarFilmeArquivo(filme, nomeAntigo);
                        System.out.println("Filme editado com sucesso!");
                    }
                    break;
                case 3:
                    int classificacaoNova;
                    String classificacaoFilmeString;

                    try {
                        System.out.println("Opcoes de classificacao indicativa: \'livre\', \'10\', \'12\', \'14\', \'16\', \'18\'");
                        System.out.print("Digite a classificacao indicativa nova: ");
                        classificacaoFilmeString = sc.nextLine();
                        classificacaoNova = excecaoClassificacaoIndicativa(classificacaoFilmeString);
                    } catch (IllegalArgumentException e) {
                        System.err.println("- Erro na edicao: a classificacao deve ser uma das opcoes acima. Tente novamente!");
                        sc.nextLine();
                        return;
                    }
                    System.out.println();

                    System.out.println("- Classificacao Indicativa Antiga: " + filme.getClassificacaoFilme());
                    System.out.println("- Classificacao Indicativa Nova: " + classificacaoNova);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        String nomeAntigo = filme.getNomeFilme();
                        filme.setNomeFilme(nomeFilme);
                        gerente.editarFilme(filme, "", "", classificacaoNova, "", -1);
                        editarFilmeArquivo(filme, nomeAntigo);
                        System.out.println("Filme editado com sucesso!");
                    }
                    break;
                case 4:
                    String generoNovo;

                    System.out.printf("Digite o genero novo: ");
                    generoNovo = sc.nextLine();
                    System.out.println();

                    System.out.println("- Genero Antigo: " + filme.getGeneroFilme());
                    System.out.println("- Genero Novo: " + generoNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        String nomeAntigo = filme.getNomeFilme();
                        filme.setNomeFilme(nomeFilme);
                        gerente.editarFilme(filme, "", "", -1, generoNovo, -1);
                        editarFilmeArquivo(filme, nomeAntigo);
                        System.out.println("Filme editado com sucesso!");
                    }
                    break;
                case 5:
                    int duracaoNova = 0;

                    try {
                        System.out.printf("Digite a duracao nova: ");
                        duracaoNova = Integer.parseInt(sc.nextLine());
                        excecaoNumerosNegativos(duracaoNova);
                    } catch (NumberFormatException e) {
                        System.err.println("- Erro na edicao: a duracao nova deve ser um numero inteiro. Tente novamente!");
                        sc.nextLine();
                        return;
                    } catch (IllegalArgumentException e) {
                        System.err.println("- Erro na edicao: a duracao nova deve ser um numero positivo. Tente novamente!");
                        sc.nextLine();
                        return;
                    }
                    System.out.println();

                    System.out.println("- Duracao Antiga: " + filme.getDuracaoFilme());
                    System.out.println("- Genero Novo: " + duracaoNova);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        String nomeAntigo = filme.getNomeFilme();
                        filme.setNomeFilme(nomeFilme);
                        gerente.editarFilme(filme, "", "", -1, "", duracaoNova);
                        editarFilmeArquivo(filme, nomeAntigo);
                        System.out.println("Filme editado com sucesso!");
                    }
                    break;
                default:
                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                    break;
            }
        } else {
            System.out.println("- Erro na edicao: filme nao encontrado ou filme com sessao cadastrada. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void editarFilmeArquivo(Filme filmeNovo, String nomeAntigo) {
        String arquivoFilme = "arquivos/Filmes.csv";

        try {
            File arquivoOriginal = new File(arquivoFilme);
            File arquivoTemporario = new File("arquivos/FilmesTemporarios.csv");

            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    //copiar cabeçalho
                    if (cabecalho) {
                        bw.write(linha);
                        bw.newLine();
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",");
                    if (dados.length == 5) {
                        String nome = dados[0];

                        //faz a substituicao linha -> filme novo
                        if (nome.equalsIgnoreCase(nomeAntigo)) {
                            bw.write(filmeNovo.getNomeFilme() + ","
                                    + filmeNovo.getSinopseFilme() + ","
                                    + filmeNovo.getClassificacaoFilme() + ","
                                    + filmeNovo.getGeneroFilme() + ","
                                    + filmeNovo.getDuracaoFilme());
                            bw.newLine();
                        } else {
                            bw.write(linha);
                            bw.newLine();
                        }
                    } else {
                        System.out.println("Linha nao encontrada no arquivo: " + linha);
                    }
                }
            }

            //substitui origial -> temporario
            if (arquivoOriginal.delete()) {
                arquivoTemporario.renameTo(arquivoOriginal);
            } else {
                System.out.println("Erro ao substituir o arquivo original");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                excluirFilmeArquivo(filme, motivoExclusaoFilme);
                gerente.removerFilme(filme, motivoExclusaoFilme);
                System.out.println("Filme removido com sucesso!");
            }
        } else {
            System.out.println("- Erro na remocao: filme nao encontrado ou filme com sessao cadastrada. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void excluirFilmeArquivo(Filme filme, String motivoExclusao) {
        String caminhoArquivo = "arquivos/Filmes.csv";

        try {
            File arquivoOriginal = new File(caminhoArquivo);
            File arquivoTemporario = new File("arquivos/FilmesTemporarios.csv");

            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bwTemporario = new BufferedWriter(new FileWriter(arquivoTemporario));) {
                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    if (cabecalho) {
                        bwTemporario.write(linha);
                        bwTemporario.newLine();
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",");
                    if (dados.length == 5) {
                        String nome = dados[0];

                        if (nome.equalsIgnoreCase(filme.getNomeFilme())) {
                            bwTemporario.write(filme.getNomeFilme() + ","
                                    + filme.getSinopseFilme() + ","
                                    + filme.getClassificacaoFilme() + ","
                                    + filme.getGeneroFilme() + ","
                                    + filme.getDuracaoFilme() + ","
                                    + motivoExclusao);
                            bwTemporario.newLine();
                        } else {
                            bwTemporario.write(linha);
                            bwTemporario.newLine();
                        }
                    }
                }
            }

            if (arquivoOriginal.delete()) {
                arquivoTemporario.renameTo(arquivoOriginal);
            } else {
                System.out.println("Erro ao substituir o arquivo original.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void imprimeListaFilmes(Cinema cinema) {
        for (Filme f : cinema.getListaFilmes()) {
            if (!(f instanceof FilmeIndisponivel)) {
                System.out.println(f.toString());
            }
        }
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
        } catch (NumberFormatException e) {
            System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
        }

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
        } catch (NumberFormatException e) {
            System.err.println("- Erro: o numero da sala deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException e) {
            System.err.println("- Erro: o numero da sala deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return;
        }

        try {
            System.out.print("- Numero de Assentos: ");
            nroAssentos = Integer.parseInt(sc.nextLine());
            excecaoNroAssentos(nroAssentos);
        } catch (NumberFormatException e) {
            System.err.println("- Erro: o numero de assentos deve ser um numero. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException e) {
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
            if (gerente.adicionarSala(salaTemporaria)) {
                cadastrarSalaArquivo(salaTemporaria);
                System.out.println("Sala adicionada com sucesso!");
            } else {
                System.out.println("- Erro no cadastro: sala ja existe. Tente novamente!");
            }
        }
        sc.nextLine();
    }

    private static void cadastrarSalaArquivo(Sala sala) {
        String caminhoArquivo = "arquivos/Salas.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            if (new java.io.File(caminhoArquivo).length() == 0) {
                bw.write("Numero,Assentos,Tela\n");
            }

            bw.write(sala.getNroSala() + ","
                    + sala.getNroAssentos() + ","
                    + sala.getTipoTela() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarSalasArquivo(File arquivo, Cinema cinema) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {
                    int numero = Integer.parseInt(dados[0]);
                    int assentos = Integer.parseInt(dados[1]);
                    boolean tela = Boolean.parseBoolean(dados[2]);

                    cinema.getListaSalas().add(new Sala(numero, assentos, tela));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void imprimeMenuGerenteEdicaoSala(Gerente gerente, Scanner sc) {
        int opcao = 0;
        int nroSala = 0;
        String confirmacao;

        System.out.println("EDITAR SALA");
        imprimeListaSalas(gerente.getCinema());

        try {
            System.out.printf("Digite o numero da sala a ser removida: ");
            nroSala = Integer.parseInt(sc.nextLine());
            excecaoNumerosNegativos(nroSala);
        } catch (NumberFormatException e) {
            System.err.println("- Erro: o numero da sala  deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException e) {
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
            System.out.print("Escolha um parametro: ");

            try {
                System.out.printf("Entre uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
                sc.nextLine();
                return;
            }
            System.out.println();

            switch (opcao) {
                case 1:
                    int nroSalaNovo = 0;

                    try {
                        System.out.print("Digite o numero da sala novo: ");
                        nroSalaNovo = Integer.parseInt(sc.nextLine());
                        excecaoNumerosNegativos(nroSalaNovo);
                    } catch (NumberFormatException e) {
                        System.err.println("- Erro: o numero novo da sala deve ser um numero. Tente novamente!");
                        sc.nextLine();
                        return;
                    } catch (IllegalArgumentException e) {
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
                        int numeroAntigoSala = sala.getNroSala();
                        sala.setNroSala(nroSala);
                        if (gerente.editarSala(sala, nroSalaNovo, -1, null)) {
                            editarSalaArquivo(sala, numeroAntigoSala);
                            System.out.println("Sala editada com sucesso!");
                        } else {
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
                    } catch (NumberFormatException e) {
                        System.err.println("- Erro: o novo numero de assentos deve ser um numero inteiro. Tente novamente!");
                        sc.nextLine();
                        return;
                    } catch (IllegalArgumentException e) {
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
                        int numeroAntigoSala = sala.getNroSala();
                        sala.setNroSala(nroSala);
                        gerente.editarSala(sala, 0, nroAssentosNovo, null);
                        editarSalaArquivo(sala, numeroAntigoSala);
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
                        int numeroAntigoSala = sala.getNroSala();
                        sala.setNroSala(nroSala);
                        gerente.editarSala(sala, 0, -1, tipoTelaNovo);
                        editarSalaArquivo(sala, numeroAntigoSala);
                        System.out.println("Sala editada com sucesso!");
                    }
                    break;
                default:
                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                    break;
            }
        } else {
            System.out.println("- Erro na edicao: sala nao encontrada ou sala com sessao cadastrada. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void editarSalaArquivo(Sala salaNova, int numeroAntigoSala) {
        String arquivoSalas = "arquivos/Salas.csv";

        try {
            File arquivoOriginal = new File(arquivoSalas);
            File arquivoTemporario = new File("arquivos/SalasTemporarias.csv");

            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    if (cabecalho) {
                        bw.write(linha);
                        bw.newLine();
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",");
                    if (dados.length == 3) {
                        int nroSala = Integer.parseInt(dados[0]);

                        if (nroSala == numeroAntigoSala) {
                            bw.write(salaNova.getNroSala() + ","
                                    + salaNova.getNroAssentos() + ","
                                    + (salaNova.getTipoTela() ? "3D" : "2D"));
                            bw.newLine();
                        } else {
                            bw.write(linha);
                            bw.newLine();
                        }
                    } else {
                        System.out.println("Linha inválida encontrada no arquivo: " + linha);
                    }
                }
            }

            if (arquivoOriginal.delete()) {
                arquivoTemporario.renameTo(arquivoOriginal);
            } else {
                System.out.println("Erro ao substituir o arquivo original.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        } catch (NumberFormatException e) {
            System.err.println("- Erro: o numero da sala  deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException e) {
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
                removerSalaArquivo(sala);
                gerente.removerSala(sala);
                System.out.println("Sala removida com sucesso!");
            }
        } else {
            System.out.println("- Erro na remocao: sala nao encontrada ou sala com sessao cadastrada. Tente novamente!");
        }
        sc.nextLine();
    }

    private static boolean removerSalaArquivo(Sala salaRemovida) {
        String caminhoArquivo = "arquivos/Salas.csv"; // O arquivo onde as salas estão armazenadas
        boolean sucesso = false;

        try {
            File arquivoOriginal = new File(caminhoArquivo);
            File arquivoTemporario = new File("arquivos/SalasTemporarias.csv");

            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    if (cabecalho) {
                        bw.write(linha);
                        bw.newLine();
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",");
                    if (dados.length == 3) {
                        int nroSala = Integer.parseInt(dados[0]);

                        if (nroSala != salaRemovida.getNroSala()) {
                            bw.write(linha);
                            bw.newLine();
                        } else {
                            sucesso = true;
                        }
                    }
                }
            }

            if (arquivoOriginal.delete()) {
                arquivoTemporario.renameTo(arquivoOriginal);
            } else {
                System.out.println("Erro ao substituir o arquivo original.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sucesso;
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
        } catch(NumberFormatException e) {
            System.err.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
        }
        
        System.out.println();
        return opcao;
    }

    private static void imprimeMenuGerenteCadastroSessao(Gerente gerente, Scanner sc) {
        String nomeFilme;
        Filme filmeSessao; 
        int nroSala = 0;
        int codigoSessao = 0;
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
                    System.out.print("- Codigo da sessao: ");
                    codigoSessao = Integer.parseInt(sc.nextLine());
                    excecaoNumerosNegativos(precoSessao); 
                } catch(NumberFormatException e) {
                    System.err.println("- Erro: o codigo da sessao deve ser um numero double. Tente novamente!");
                    sc.nextLine();
                    return;
                } catch(IllegalArgumentException e) {
                    System.err.println("- Erro: o codigo da sessao deve ser um numero positivo. Tente novamente!");
                    sc.nextLine();
                    return;
                }
                
                if(gerente.buscarSessoes(codigoSessao)!= true) {
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
	                    sc.nextLine();
	                    return;
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
	
	                Sessao sessaoTemporaria = new Sessao(codigoSessao ,diaHorarioSessao, precoSessao, false, 1, salaSessao, filmeSessao); // conferir promocao
	
	                System.out.println(sessaoTemporaria.toString());
	                System.out.print("Confirmar adicao da sessao (Sim ou Nao): ");
	                confirmacao = sc.nextLine();
	
	                // confirma a criacao de uma sessao, checando condicoes de horario e classificacao indicativa
	                if (confirmacao.equalsIgnoreCase("Sim")) {
	                    if (gerente.adicionarSessao(sessaoTemporaria)) {
	                        cadastrarSessaoArquivo(sessaoTemporaria);
	                        System.out.println("Sessao adicionada com sucesso!");
	                    }
	                    else {
	                        System.out.println("- Erro no cadastro. Tente novamente!");
	                        System.out.println("- Possiveis problemas: dia e horario coincidem com outra sessao ou sessao +18 antes das 20h.");
	                    }
	                }
                } else {
                    System.out.println("- Erro no cadastro: ja existe uma sessao com esse codigo. Tente novamente!");
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
    
     private static void cadastrarSessaoArquivo(Sessao sessao) {
        String caminhoArquivo = "arquivos/Sessoes.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            if (new java.io.File(caminhoArquivo).length() == 0) {
                bw.write("Codigo,DiaHorario,ListaAssentos,Preco,Promocao,Porcentagem,Sala,Filme\n");
            }

            String listaAssentos = String.join(";", Arrays.stream(sessao.getListaAssentos())
                                    .map(String::valueOf)
                                    .toArray(String[]::new));

            bw.write(sessao.getCodigoSessao() + ","
                    + sessao.getDiaHorarioSessao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ","
                    + listaAssentos + ","
                    + sessao.getPrecoSessao() + ","
                    + sessao.getComPromocao() + ","
                    + sessao.getPorcentagemPromocional() + ","
                    + sessao.getSalaSessao().getNroSala() + ","
                    + sessao.getFilmeSessao().getNomeFilme() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    public static void carregarSessoesArquivo(File arquivo, Cinema cinema) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            br.readLine();

            // Definir o formato da data de acordo com o padrão utilizado no arquivo
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 8 || dados.length == 9) {
                    int codigoSessao = Integer.parseInt(dados[0]);
                    LocalDateTime diaHorario = LocalDateTime.parse(dados[1], formatter);

                    // Número de assentos, baseado no tamanho do array no arquivo
                    String[] assentosStr = dados[2].split(";");
                    int nroAssentos = assentosStr.length;

                    double precoSessao = Double.parseDouble(dados[3]);
                    boolean comPromocao = Boolean.parseBoolean(dados[4]);
                    double porcentagemPromocional = Double.parseDouble(dados[5]);
                    int nroSala = Integer.parseInt(dados[6]);
                    String nomeFilme = dados[7];
                    String motivoExclusao = null;
                    
                    if(dados.length == 9) {
                   	    motivoExclusao = dados[8];
                    }
                    
                    // Procurar a sala correspondente
                    Sala sala = cinema.getListaSalas().stream()
                            .filter(s -> s.getNroSala() == nroSala)
                            .findFirst()
                            .orElse(null);

                    // Procurar o filme correspondente
                    Filme filme = cinema.getListaFilmes().stream()
                            .filter(f -> f.getNomeFilme().equalsIgnoreCase(nomeFilme))
                            .findFirst()
                            .orElse(null);

                    // Se a sala e o filme foram encontrados, criar a sessão
                    if (sala != null && filme != null) {
                    	if(motivoExclusao == null) {
	                    	Sessao sessao = new Sessao(codigoSessao, diaHorario, precoSessao, comPromocao, porcentagemPromocional, sala, filme);
	                        sessao.setListaAssentos(nroAssentos); // Configurar os assentos usando o método existente
	
	                        // Atualizar a lista de assentos conforme o arquivo
	                        for (int i = 0; i < assentosStr.length; i++) {
	                            if (!"null".equalsIgnoreCase(assentosStr[i])) {
	                                sessao.getListaAssentos()[i] = Boolean.valueOf(assentosStr[i]);
	                            }
	                        }
	
	                        cinema.getListaSessoes().add(sessao);
                    	}else {
	                    	Sessao sessao = new SessaoIndisponivel(codigoSessao, diaHorario, precoSessao, comPromocao, porcentagemPromocional, sala, filme, motivoExclusao);
	                        sessao.setListaAssentos(nroAssentos); // Configurar os assentos usando o método existente
	
	                        // Atualizar a lista de assentos conforme o arquivo
	                        for (int i = 0; i < assentosStr.length; i++) {
	                            if (!"null".equalsIgnoreCase(assentosStr[i])) {
	                                sessao.getListaAssentos()[i] = Boolean.valueOf(assentosStr[i]);
	                            }
	                        }
	
	                        cinema.getListaSessoes().add(sessao);
                    	                    		
                    		
                    	}
                    } 
                    
                    
                    else {
                        System.out.println("Erro: Sala ou Filme não encontrado para a sessão.");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar as sessões.");
        }
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
        } catch (NumberFormatException e) {
            System.err.println("- Erro: o o codigo da sessao deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException e) {
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
            } catch (NumberFormatException e) {
                System.err.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
            }
            System.out.println();

            switch (opcao) {
                case 1:
                    String nomeFilmeNovo;

                    imprimeListaFilmes(gerente.getCinema());
                    System.out.print("Digite o nome do filme novo: ");
                    nomeFilmeNovo = sc.nextLine();
                    System.out.println();

                    Filme filmeSessao = gerente.buscarFilme(nomeFilmeNovo);

                    if (filmeSessao != null) {
                        System.out.println("- Filme Antigo: " + sessao.getFilmeSessao().getNomeFilme());
                        System.out.println("- Filme Novo: " + nomeFilmeNovo);

                        System.out.print("Confirmar edicao (Sim ou Nao): ");
                        confirmacao = sc.nextLine();

                        if (confirmacao.equalsIgnoreCase("Sim")) {
                            gerente.editarSessao(sessao, null, null, -1, null, filmeSessao);
                            editarSessaoArquivo(sessao);
                            System.out.println("Sessao editada com sucesso!");
                        }
                    } else {
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
                    } catch (NumberFormatException e) {
                        System.err.println("- Erro: o novo numero da sala  deve ser um numero inteiro. Tente novamente!");
                        sc.nextLine();
                        return;
                    } catch (IllegalArgumentException e) {
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
                            editarSessaoArquivo(sessao);
                            System.out.println("Sessao editada com sucesso!");
                        }
                    } else {
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
                        } else {
                            editarSessaoArquivo(sessao);
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
                    } catch (DateTimeParseException e) {
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
                        } else {
                            editarSessaoArquivo(sessao);
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
                    } catch (NumberFormatException e) {
                        System.err.println("- Erro: o preco do filme deve ser um numero double. Tente novamente!");
                        sc.nextLine();
                        return;
                    } catch (IllegalArgumentException e) {
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
                        editarSessaoArquivo(sessao);
                        System.out.println("Sessao editada com sucesso!");
                    }
                    break;
                default:
                    System.out.println("- Erro: opcao invalida. Tente novamente!");
                    break;
            }
        } else {
            System.out.println("- Erro na edicao: sessao nao encontrada ou sessao com ingressos comprados. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void editarSessaoArquivo(Sessao sessaoNova) {
        String arquivoSessao = "arquivos/Sessoes.csv";

        try {
            File arquivoOriginal = new File(arquivoSessao);
            File arquivoTemporario = new File("arquivos/SessoesTemporarias.csv");

            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    if (cabecalho) {
                        bw.write(linha);
                        bw.newLine();
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",", 8);
                    if (dados.length == 8) {
                        int codigo = Integer.parseInt(dados[0]);

                        if (codigo == sessaoNova.getCodigoSessao()) {
                            String listaAssentos = String.join(";", Arrays.stream(sessaoNova.getListaAssentos())
                                    .map(String::valueOf)
                                    .toArray(String[]::new));

                            bw.write(sessaoNova.getCodigoSessao() + ","
                                    + sessaoNova.getDiaHorarioSessao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ","
                                    + listaAssentos + ","
                                    + sessaoNova.getPrecoSessao() + ","
                                    + sessaoNova.getComPromocao() + ","
                                    + sessaoNova.getPorcentagemPromocional() + ","
                                    + sessaoNova.getSalaSessao().getNroSala() + ","
                                    + sessaoNova.getFilmeSessao().getNomeFilme());
                            bw.newLine();
                        } else {
                            bw.write(linha);
                            bw.newLine();
                        }
                    } else {
                        System.out.println("Linha inválida no arquivo: " + linha);
                    }
                }
            }

            if (arquivoOriginal.delete()) {
                if (!arquivoTemporario.renameTo(arquivoOriginal)) {
                    System.out.println("Erro ao renomear o arquivo temporário para o original.");
                }
            } else {
                System.out.println("Erro ao deletar o arquivo original.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        } catch (NumberFormatException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return;
        }
        System.out.println();

        // busca sessão disponivel no cinema
        Sessao sessao = gerente.buscarSessao(codigoSessao);

        // se encontra sessao no catalogo e sessao nao possui ingressos vendidos, permite a remocao
        if (sessao != null && sessao.getAssentosDisponiveis() == sessao.getListaAssentos().length - 1) {
            System.out.printf("Digite o motivo de exclusao da sessao: ");
            motivoExclusaoSessao = sc.nextLine();

            System.out.print("Confirmar remocao da sessao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                gerente.removerSessao(sessao, motivoExclusaoSessao);
                removerSessaoArquivo(sessao, motivoExclusaoSessao);
                System.out.println("Sessao removida com sucesso!");
            }
        } else {
            System.out.println("- Erro na remocao: sessao nao encontrada ou sessao com ingressos comprados. Tente novamente!");
        }
        sc.nextLine();
    }

    private static void removerSessaoArquivo(Sessao sessao, String motivoExclusao) {
        String caminhoArquivo = "arquivos/Sessoes.csv";

        try {
            File arquivoOriginal = new File(caminhoArquivo);
            File arquivoTemporario = new File("arquivos/SessoesTemporarias.csv");

            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    if (cabecalho) {
                        bw.write(linha);
                        bw.newLine();
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",");
                    if (dados.length == 8) {
                        int codigoSessao = Integer.parseInt(dados[0]);

                        if (codigoSessao == sessao.getCodigoSessao()) {
                            bw.write(sessao.getCodigoSessao() + ","
                                    + sessao.getDiaHorarioSessao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ","
                                    + String.join(";", Arrays.stream(sessao.getListaAssentos())
                                            .map(String::valueOf).toArray(String[]::new)) + ","
                                    + sessao.getPrecoSessao() + ","
                                    + sessao.getComPromocao() + ","
                                    + sessao.getPorcentagemPromocional() + ","
                                    + sessao.getSalaSessao().getNroSala() + ","
                                    + sessao.getFilmeSessao().getNomeFilme() + ","
                                    + motivoExclusao);
                            bw.newLine();
                        } else {
                            bw.write(linha);
                            bw.newLine();
                        }
                    }
                }
            }

            if (arquivoOriginal.delete()) {
                if (!arquivoTemporario.renameTo(arquivoOriginal)) {
                    System.out.println("Erro ao renomear o arquivo temporário.");
                }
            } else {
                System.out.println("Erro ao excluir o arquivo original.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        } catch (NumberFormatException e) {
            System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
        }

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
        } catch (NumberFormatException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return;
        }
        System.out.println();

        // busca sessao no catalogo
        Sessao sessao = gerente.buscarSessao(codigoSessao);

        // se acha sessao no catalogo, permite o cadastro de promocao
        if (sessao != null) {
            // checa se promocao eh um valor entre 0 e 100
            try {
                System.out.print("Qual sera a porcentagem da promocao? ");
                porcentagemPromocional = Double.parseDouble(sc.nextLine());
                excecaoPorcentagemPromocional(porcentagemPromocional);
            } catch (NumberFormatException e) {
                System.err.println("- Erro: a porcentagem da promocao deve ser um numero. Tente novamente!");
                sc.nextLine();
                return;
            } catch (IllegalArgumentException e) {
                System.err.println("- Erro: a porcentagem da promocao deve ser um numero entre 0 e 100. Tente novamente!");
                sc.nextLine();
                return;
            }
            porcentagemPromocional = porcentagemPromocional / 100.00;
            System.out.println();

            System.out.print("Confirmar adicao da promocao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.adicionarPromocao(sessao, porcentagemPromocional)) {
                    cadastrarPromocaoArquivo(codigoSessao, porcentagemPromocional);
                    System.out.println("Promocao adicionada com sucesso!");
                } else {
                    System.out.println("- Erro no cadastro: promocao ja cadastrada. Tente novamente!");
                }
            }
        } else {
            System.out.println("- Erro no cadastro: sessao nao encontrada. Tente novamente!");
        }
        sc.nextLine();
    }

    public static void cadastrarPromocaoArquivo(int codigoSessao, double porcentagemPromocional) {
        String arquivoSessao = "arquivos/Sessoes.csv";
        String arquivoTemporario = "arquivos/SessoesTemporarias.csv";

        try (
                BufferedReader br = new BufferedReader(new FileReader(arquivoSessao)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
            String linha;
            boolean cabecalho = true;

            while ((linha = br.readLine()) != null) {
                if (cabecalho) {
                    bw.write(linha);
                    bw.newLine();
                    cabecalho = false;
                    continue;
                }

                String[] dados = linha.split(",", 8);

                if (dados.length == 8) {
                    int codigoAtual = Integer.parseInt(dados[0]);

                    if (codigoAtual == codigoSessao) {
                        dados[4] = "true";
                        dados[5] = String.valueOf(porcentagemPromocional);

                        bw.write(String.join(",", dados));
                    } else {
                        bw.write(linha);
                    }
                    bw.newLine();
                } else {
                    System.out.println("Linha invalida no arquivo: " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar promoção no arquivo.");
            return;
        }

        File original = new File(arquivoSessao);
        File temporario = new File(arquivoTemporario);

        if (original.delete()) {
            if (!temporario.renameTo(original)) {
                System.out.println("Erro ao renomear o arquivo temporario.");
            }
        } else {
            System.out.println("Erro ao deletar o arquivo original.");
        }
        System.out.println("Promocao atualizada no arquivo com sucesso.");
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
        } catch (NumberFormatException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero inteiro. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero positivo. Tente novamente!");
            sc.nextLine();
            return;
        }
        System.out.println();

        // busca sessao no catalogo
        Sessao sessao = gerente.buscarSessao(codigoSessao);

        // se acha sessao no catalogo, permite a edicao de promocao
        if (sessao != null) {
            // checa se promocao eh um valor entre 0 e 100
            try {
                System.out.print("Qual sera a porcentagem nova da promocao? ");
                porcentagemPromocionalNova = Double.parseDouble(sc.nextLine());
                excecaoPorcentagemPromocional(porcentagemPromocionalNova);
            } catch (NumberFormatException e) {
                System.err.println("- Erro: a porcentagem da promocao deve ser um numero. Tente novamente!");
                sc.nextLine();
                return;
            } catch (IllegalArgumentException e) {
                System.err.println("- Erro: a porcentagem da promocao deve ser um numero entre 0 e 100. Tente novamente!");
                sc.nextLine();
                return;
            }
            porcentagemPromocionalNova = porcentagemPromocionalNova / 100.00;
            System.out.println();

            System.out.println("- Promocao Antiga: " + sessao.getPorcentagemPromocional() * 100 + "%");
            System.out.println("- Promocao Nova: " + porcentagemPromocionalNova * 100 + "%");

            System.out.print("Confirmar edicao da promocao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.editarPromocao(sessao, porcentagemPromocionalNova)) {
                    File arquivoSessoes = new File("arquivos/Sessoes.csv");
                    editarPromocaoArquivo(arquivoSessoes, sessao);
                    System.out.println("Promocao editada com sucesso!");
                } else {
                    System.out.println("- Erro na edicao: sessao nao possui promocao. Tente novamente!");
                }
            }
        } else {
            System.out.println("- Erro na edicao: sessao nao encontrada. Tente novamente!");
        }
        sc.nextLine();
    }

    public static void editarPromocaoArquivo(File arquivo, Sessao sessaoEditada) {
        String arquivoTemporario = "arquivos/SessoesTemporarias.csv";

        try (
                BufferedReader br = new BufferedReader(new FileReader(arquivo)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
            String linha;
            boolean cabecalho = true;

            while ((linha = br.readLine()) != null) {
                if (cabecalho) {
                    bw.write(linha);
                    bw.newLine();
                    cabecalho = false;
                    continue;
                }

                String[] dados = linha.split(",", 8);

                if (dados.length == 8) {
                    int codigoSessao = Integer.parseInt(dados[0]);

                    if (codigoSessao == sessaoEditada.getCodigoSessao()) {
                        String listaAssentos = String.join(";", Arrays.stream(sessaoEditada.getListaAssentos())
                                .map(String::valueOf)
                                .toArray(String[]::new));

                        String linhaEditada = sessaoEditada.getCodigoSessao() + ","
                                + sessaoEditada.getDiaHorarioSessao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ","
                                + listaAssentos + ","
                                + sessaoEditada.getPrecoSessao() + ","
                                + sessaoEditada.getComPromocao() + ","
                                + sessaoEditada.getPorcentagemPromocional() + ","
                                + sessaoEditada.getSalaSessao().getNroSala() + ","
                                + sessaoEditada.getFilmeSessao().getNomeFilme();

                        bw.write(linhaEditada);
                    } else {
                        bw.write(linha);
                    }
                    bw.newLine();
                } else {
                    System.out.println("Linha invalida no arquivo: " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao editar a promocao no arquivo.");
            return;
        }

        // Substituir o arquivo original pelo temporário
        File arquivoOriginal = new File(arquivo.getPath());
        File arquivoTemp = new File(arquivoTemporario);

        if (arquivoOriginal.delete()) {
            if (!arquivoTemp.renameTo(arquivoOriginal)) {
                System.out.println("Erro ao renomear o arquivo temporario para o original.");
            }
        } else {
            System.out.println("Erro ao deletar o arquivo original.");
        }
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
        } catch (NumberFormatException e) {
            System.err.println("- Erro: o codigo da sessao deve ser um numero. Tente novamente!");
            sc.nextLine();
            return;
        } catch (IllegalArgumentException e) {
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
                    File arquivoSessoes = new File("arquivos/Sessoes.csv");
                    removerPromocaoArquivo(arquivoSessoes, sessao);
                    System.out.println("Promocao removida com sucesso!");
                } else {
                    System.out.println("- Erro na remocao: sessao nao possui promocao. Tente novamente!");
                }
            }
        } else {
            System.out.println("- Erro na remocao: sessao nao encontrada. Tente novamente!");
        }
        sc.nextLine();
    }

    public static void removerPromocaoArquivo(File arquivo, Sessao sessaoEditada) {
        String arquivoTemporario = "arquivos/SessoesTemporarias.csv";

        try (
                BufferedReader br = new BufferedReader(new FileReader(arquivo)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
            String linha;
            boolean cabecalho = true;

            while ((linha = br.readLine()) != null) {
                if (cabecalho) {
                    bw.write(linha);
                    bw.newLine();
                    cabecalho = false;
                    continue;
                }

                String[] dados = linha.split(",", 8);

                if (dados.length == 8) {
                    int codigoSessao = Integer.parseInt(dados[0]);

                    if (codigoSessao == sessaoEditada.getCodigoSessao()) {
                        String listaAssentos = String.join(";", Arrays.stream(sessaoEditada.getListaAssentos())
                                .map(String::valueOf)
                                .toArray(String[]::new));

                        String linhaAtualizada = sessaoEditada.getCodigoSessao() + ","
                                + sessaoEditada.getDiaHorarioSessao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ","
                                + listaAssentos + ","
                                + sessaoEditada.getPrecoSessao() + ","
                                + "false" + ","
                                + // Remove a promoção
                                "0.0" + ","
                                + // Remove a porcentagem da promoção
                                sessaoEditada.getSalaSessao().getNroSala() + ","
                                + sessaoEditada.getFilmeSessao().getNomeFilme();

                        bw.write(linhaAtualizada);
                    } else {
                        bw.write(linha);
                    }
                    bw.newLine();
                } else {
                    System.out.println("Linha invalida no arquivo: " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao remover a promocao no arquivo.");
            return;
        }

        File arquivoOriginal = new File(arquivo.getPath());
        File arquivoTemp = new File(arquivoTemporario);

        if (arquivoOriginal.delete()) {
            if (!arquivoTemp.renameTo(arquivoOriginal)) {
                System.out.println("Erro ao renomear o arquivo temporario para o original.");
            }
        } else {
            System.out.println("Erro ao deletar o arquivo original.");
        }
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
        } catch (NumberFormatException e) {
            System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
        }

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
        contarUsuariosAssinantes();
        System.out.println();
    }

    public static void contarUsuariosAssinantes() {
        String arquivoUsuarios = "arquivos/Usuarios.csv";
        int totalUsuarios = 0;
        int totalAssinantes = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoUsuarios))) {
            String linha;

            br.readLine();

            while ((linha = br.readLine()) != null) {
                totalUsuarios++;
                String[] dados = linha.split(",");

                // Verificar se o usuário é assinante
                if ("true".equalsIgnoreCase(dados[4])) {
                    totalAssinantes++;
                }
            }

            // Imprimir os resultados
            System.out.println("Usuarios cadastrados: " + totalUsuarios);
            System.out.println("Usuarios assinantes: " + totalAssinantes);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao ler o arquivo de usuários.");
        }
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
        } catch (NumberFormatException e) {
            System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
        }

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
            // imprime sessoes com o filme escolhido
            for (Sessao sessao : gerente.getCinema().getListaSessoes()) {
	                if (sessao.getFilmeSessao() == filme) {
	                		System.out.println(sessao.toString());
	                }
            }

            try {
                System.out.printf("Digite o codigo da sessao escolhida: ");
                codigoSessao = Integer.parseInt(sc.nextLine());
                excecaoNumerosNegativos(codigoSessao);
            } catch (NumberFormatException e) {
                System.err.println("- Erro: o codigo da sessao deve ser um numero inteiro. Tente novamente!");
                sc.nextLine();
                return;
            } catch (IllegalArgumentException e) {
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
                } catch (NumberFormatException e) {
                    System.err.println("- Erro: o numero de assento deve ser um numero. Tente novamente!");
                    sc.nextLine();
                    return;
                } catch (ArrayIndexOutOfBoundsException e) {
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
                    } catch (NumberFormatException e) {
                        System.err.println("- Erro: o numero de assento deve ser um numero. Tente novamente!");
                        sc.nextLine();
                        return;
                    } catch (ArrayIndexOutOfBoundsException e) {
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
                        File arquivoIngressos = new File("Ingressos.csv");
                        cadastrarIngressoArquivo(arquivoIngressos, usuario, ingresso);
                        System.out.println("Ingresso comprado com sucesso!");
                    } else {
                        System.out.println("- Erro na compra: idade menor que classificacao indicativa. Tente novamente!");
                    }
                }
            } else {
                System.out.println("- Erro na compra: sessao nao encontrada. Tente novamente!");
            }
        } else {
            System.out.println("- Erro na compra: filme nao encontrado. Tente novamente!");
        }
        sc.nextLine();
    }

    public static void cadastrarIngressoArquivo(File arquivo, Usuario usuario, Ingresso ingresso) {
        String arquivoUsuarios = "arquivos/Usuarios.csv"; 
        String arquivoIngressos = "arquivos/Ingressos.csv";
        String arquivoSessoes = "arquivos/Sessoes.csv";

        // Passo 1: Verificar se o usuário é assinante
        boolean isAssinante = false;
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoUsuarios))) {
            String linha;
            br.readLine(); // Ignorar o cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                // compara com o nome do usuario e analisa se é assinante
                if (dados[0].equals(usuario.getNomePessoa())) { 
                    isAssinante = "true".equalsIgnoreCase(dados[4]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao ler o arquivo de usuarios.");
            return;
        }

        // ajusta o preço do ingresso se o usuario for assinante
        double precoFinal = ingresso.getPrecoIngresso();
        if (isAssinante) {
            precoFinal *= 0.7;
        }

        //cadastra o ingresso no arquivo de ingressos
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoIngressos, true))) {
            if (new java.io.File(arquivoIngressos).length() == 0) {
                bw.write("Nome,CodigoSessao,NumeroAssento,Preco\n");
            }

            bw.write(usuario.getNomePessoa() + ","
                    + ingresso.getSessao().getCodigoSessao() + ","
                    + ingresso.getNroAssento() + ","
                    + precoFinal + "\n");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar o ingresso no arquivo.");
            return;
        }

        //atualizar o arquivo de sessoes para ocupar assentos
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoSessoes))) {
            StringBuilder sb = new StringBuilder();
            String linha;
            boolean atualizado = false;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                if (dados[0].equals(String.valueOf(ingresso.getSessao().getCodigoSessao()))) {
                    String[] assentos = dados[2].split(";");
                    int assentoSelecionado = ingresso.getNroAssento() - 1;

                    if ("false".equals(assentos[assentoSelecionado])) {
                        assentos[assentoSelecionado] = "true";
                        atualizado = true;
                    } else {
                        System.out.println("Assento ja ocupado.");
                    }

                    dados[2] = String.join(";", assentos);
                    linha = String.join(",", dados);
                }

                sb.append(linha).append("\n");
            }

            if (!atualizado) {
                System.out.println(" - Sessão nao encontrada ou assento ja ocupado.");
                return;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSessoes))) {
                bw.write(sb.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarIngressos(File arquivo, Cinema cinema, Usuario usuario) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    String nomeUsuario = dados[0];
                    int sessaoCodigo = Integer.parseInt(dados[1]);
                    int nroAssento = Integer.parseInt(dados[2]);
                    double precoIngresso = Double.parseDouble(dados[3]);

                    //verifica se o nome no arquivo corresponde ao nome do usuario atual
                    if (usuario.getNomePessoa().equalsIgnoreCase(nomeUsuario)) {
                        Sessao sessao = cinema.getListaSessoes().stream()
                                .filter(s -> s.getCodigoSessao() == sessaoCodigo)
                                .findFirst()
                                .orElse(null);

                        if (sessao != null) {
                            usuario.getIngressosComprados().add(new Ingresso(sessao, nroAssento, precoIngresso));
                        } else {
                            System.out.println("Sessão nao encontrada para o código: " + sessaoCodigo);
                        }
                    } else {
                        System.out.println("Nome no arquivo nao corresponde ao usuario logado: " + usuario.getNomePessoa());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar os ingressos.");
        }
    }

    private static Usuario imprimeMenuUsuarioComprarAssinatura(Usuario usuario, Gerente gerente, Scanner sc) {
        System.out.println("ASSINATURA");

        // checa se usuario ja e assinante
        if (usuario instanceof UsuarioAssinante) {
            System.out.println("Voce ja possui uma assinatura!");
        } // caso usuario nao seja, oferece opcao de se tornar assinante
        else {
            String confirmacao;

            System.out.println("O Cinema GIG oferece 30% de desconto para assinantes!");
            System.out.print("Deseja comprar uma assinatura (Sim ou Nao)? ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                int index = gerente.getListaUsuarios().indexOf(usuario);
                usuario = usuario.comprarAssinatura();
                gerente.getListaUsuarios().set(index, usuario);

                cadastrarUsuarioAssinanteArquivo((UsuarioAssinante) usuario);

                System.out.println("Assinatura comprada com sucesso!");
            }

        }
        sc.nextLine();
        return usuario;
    }

    private static void cadastrarUsuarioAssinanteArquivo(UsuarioAssinante usuario) {
        String arquivoFilme = "arquivos/Usuarios.csv";

        try {
            File arquivoOriginal = new File(arquivoFilme);
            File arquivoTemporario = new File("arquivos/UsuariosTemporarios.csv");

            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    if (cabecalho) {
                        bw.write(linha);
                        bw.newLine();
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",");
                    if (dados.length == 5) {
                        String nome = dados[0];

                        if (nome.equalsIgnoreCase(usuario.getNomePessoa())) {
                            bw.write(usuario.getNomePessoa() + ","
                                    + usuario.getLoginPessoa() + ","
                                    + usuario.getSenhaPessoa() + ","
                                    + usuario.getIdadeUsuario() + ","
                                    + "true");
                            bw.newLine();
                        } else {
                            bw.write(linha);
                            bw.newLine();
                        }
                    } else {
                        System.out.println("Linha nao encontrada no arquivo: " + linha);
                    }
                }
            }

            if (arquivoOriginal.delete()) {
                arquivoTemporario.renameTo(arquivoOriginal);
            } else {
                System.out.println("Erro ao substituir o arquivo original");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void imprimeMenuUsuarioPerfil(Usuario usuario) {
        String arquivoUsuario = "arquivos/Usuarios.csv";
        boolean isAssinante = false;
        int numeroIngressos = 0;
        int numeroIngressosAtual = 0;

        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoUsuario))) {
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
            	numeroIngressos++;
                String[] dados = linha.split(",");
                if (dados.length >= 5) {
                    String login = dados[1];
                    boolean assinante = Boolean.parseBoolean(dados[4]);

                    if (login.equalsIgnoreCase(usuario.getLoginPessoa())) {
                        isAssinante = assinante;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao verificar assinatura no arquivo.");
        }

        // Exibir informações do perfil
        System.out.println("PERFIL");
        System.out.println("Nome: " + usuario.getNomePessoa());
        System.out.println("Idade: " + usuario.getIdadeUsuario());
        System.out.println("Usuario: " + usuario.getLoginPessoa());
        System.out.println("Senha: " + usuario.getSenhaPessoa());
        System.out.println("Assinatura: " + (isAssinante ? "Sim" : "Nao"));

        // Exibir ingressos comprados
        System.out.println("Ingressos comprados: " + numeroIngressos);

        if (!usuario.getIngressosComprados().isEmpty()) {
            for (Ingresso ingressoComprado : usuario.getIngressosComprados()) {
            	if(numeroIngressosAtual < numeroIngressos) {
            		System.out.println(ingressoComprado.toString());
            	}
            	numeroIngressosAtual++;
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

    // metodos de excecao para simplificar o tratamento em outros metodos
    // aceita apenas numeros positivos - opção, códigos, idade, duração, nroSala
    private static <T extends Number & Comparable<T>> void excecaoNumerosNegativos(T numeroEntrada) throws IllegalArgumentException {
        if (numeroEntrada.doubleValue() < 0) {
            throw new IllegalArgumentException();
        }
    }

    // metodo que retorna a classificacao indicativa como numero inteiro 
    private static int excecaoClassificacaoIndicativa(String classificacaoFilmeString) throws IllegalArgumentException {
        if (classificacaoFilmeString.equalsIgnoreCase("livre")) {
            return 0;
        } else if (classificacaoFilmeString.equals("10")) {
            return 10;
        } else if (classificacaoFilmeString.equals("12")) {
            return 12;
        } else if (classificacaoFilmeString.equals("14")) {
            return 14;
        } else if (classificacaoFilmeString.equals("16")) {
            return 16;
        } else if (classificacaoFilmeString.equals("18")) {
            return 18;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    //entradas de uma sequencia de caracteres nao podem estar vazias
    private static void excecaoStringVazia(String string) throws IllegalArgumentException {
        if (string.equals("")){
        	throw new IllegalArgumentException(); 
        }
    }
    
    
    // numeros de assentos são obrigatoriamente definidos a partir de 30 - cadastro e edição de sala
    private static void excecaoNroAssentos(int numeroEntrada) throws IllegalArgumentException {
        if (numeroEntrada < 30) {
            throw new IllegalArgumentException();
        }
    }

    // checa se o tipo de tela eh igual a 2d ou 3d
    private static boolean excecaoTipoTela(String tipoTela) throws IllegalArgumentException {
        if (tipoTela.equalsIgnoreCase("2D")) {
            return false;
        } else if (tipoTela.equalsIgnoreCase("3D")) {
            return true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // aceita apenas numeros entre 0 e 100, caso contrário lança excecao - métodos de promoção
    private static void excecaoPorcentagemPromocional(double numeroEntrada) throws IllegalArgumentException {
        if (numeroEntrada <= 0 || numeroEntrada >= 100) {
            throw new IllegalArgumentException();
        }
    }

    private static void excecaoCompraIngresso(int numeroEntrada, Sessao sessao) throws ArrayIndexOutOfBoundsException {
        if (numeroEntrada < 0 || numeroEntrada > sessao.getSalaSessao().getNroAssentos()) {
            throw new ArrayIndexOutOfBoundsException("Número de assento fora do intervalo válido.");
        }
    }
}
