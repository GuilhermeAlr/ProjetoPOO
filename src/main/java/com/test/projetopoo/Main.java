package projetopoo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Cinema cinema = new Cinema("GIG CINEMAS");
        Gerente gerente = new Gerente("Nome do Admin", "admin", "123", cinema);
        
        //modificar diretorio para padrão (?)
        String caminhoDiretotio = "C:\\Users\\User\\Documents\\NetBeansProjects\\ProjetoPOO";
        
        //carrega todos os dados dos arquivos e coloca nos ArraysList
        carregarDados(caminhoDiretotio, cinema, gerente);
        
        //teste da abertura dos arquivos (tirar depois)
        File arquivo = new File("Sessoes.csv"); 

        if (arquivo.exists() && arquivo.isFile()) {
            System.out.println("Conteúdo do arquivo:");
            printarDados(arquivo);
        } else {
            System.out.println("Arquivo não encontrado.");
        }

        Scanner sc = new Scanner(System.in);
        boolean estaRodando = true;
        Pessoa pessoa = null;
        int opcao, opcaoMenuGerente;

        while (estaRodando) {
            if (pessoa == null) { // menu nao logado
                opcao = imprimeMenuNaoLogado(cinema, sc);

                switch (opcao) {
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
                        break;
                }

            } else {
                if (pessoa instanceof Gerente) { // menu do gerente
                    opcao = imprimeMenuGerente(sc);

                    switch (opcao) {
                        case 1: // aba de filmes 
                            opcaoMenuGerente = imprimeMenuGerenteFilme(sc);

                            switch (opcaoMenuGerente) {
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
                                    break;
                            }
                            break;
                        case 2: // aba de sala
                            opcaoMenuGerente = imprimeMenuGerenteSala(sc);

                            switch (opcaoMenuGerente) {
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
                                    break;
                            }
                            break;
                        case 3: // aba de sessao
                            opcaoMenuGerente = imprimeMenuGerenteSessao(sc);

                            switch (opcaoMenuGerente) {
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
                                    break;
                            }
                            break;
                        case 4: // aba de promocao
                            opcaoMenuGerente = imprimeMenuGerentePromocao(sc);

                            switch (opcaoMenuGerente) {
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
                                    break;
                            }

                            break;
                        case 5: // aba de relatorios
                            opcaoMenuGerente = imprimeMenuGerenteRelatorio(sc);

                            switch (opcaoMenuGerente) {
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
                            System.out.println("- Erro: opcao invalida. Tente novamente!");
                            break;
                    }

                } else if (pessoa instanceof Usuario) { // menu do usuario
                    opcao = imprimeMenuUsuario(sc);

                    switch (opcao) {
                        case 1: // aba para comprar ingressos
                            imprimeMenuUsuarioComprarIngresso((Usuario) pessoa, gerente, sc);
                            break;
                        case 2: // aba para comprar assinatura
                            pessoa = imprimeMenuUsuarioComprarAssinatura((Usuario) pessoa, gerente, sc);
                            break;
                        case 3: // aba para ver perfil
                            imprimeMenuUsuarioPerfil((Usuario) pessoa);
                            sc.nextLine();
                            break;
                        case 4: // sair 
                            pessoa = null;
                            break;
                        default:
                            System.out.println("- Erro: opcao invalida. Tente novamente!");
                            break;
                    }
                }
            }
        }

        sc.close();
    }

    public static int imprimeMenuNaoLogado(Cinema cinema, Scanner sc) {
        int opcao = 0;
        boolean continuaLaco = true;

        System.out.println(cinema.getNomeCinema());
        System.out.println("Bem Vindo!");
        System.out.println("");
        System.out.println("(1) Cadastro");
        System.out.println("(2) Login");
        System.out.println("(3) Sair");

        do {
            try {
                System.out.printf("Entre uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
                continuaLaco = false;

            } catch (NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
            }
        } while (continuaLaco);

        System.out.println();
        return opcao;
    }

//*USUÁRIO*
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
    
    //cadastra os dados do usuario no arquivo
    private static void cadastrarUsuarioArquivo(Usuario usuario) {
        //caminho do arquivo de usuários
        String arquivoUsuario = "Usuarios.csv";

        //cria/abre o arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoUsuario, true))) {
            //cria o cabeçalho do arquivo se ele estiver vazio
            if (new java.io.File(arquivoUsuario).length() == 0) {
                bw.write("Nome,Login,Senha,Idade\n");
            }

            //insere os dados do usuario
            bw.write(usuario.getNomePessoa() + ","
                    + usuario.getLoginPessoa() + ","
                    + usuario.getSenhaPessoa() + ","
                    + usuario.getIdadeUsuario() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //carrega os dados dos usuarios
    public static void carregarUsuarios(File arquivoUsuario, Gerente gerente) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoUsuario))) {
            String linha;
            br.readLine(); //ignora o cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    String nome = dados[0];
                    String login = dados[1];
                    String senha = dados[2];
                    int idade = Integer.parseInt(dados[3]);

                    gerente.getListaUsuarios().add(new Usuario(nome, login, senha, idade));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static Pessoa imprimeMenuLogin(ArrayList<Usuario> listaUsuarios, Gerente gerente, Scanner sc) {
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

//*FILME* 
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
        String arquivoFilme = "Filmes.csv";

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

    public static void carregarFilmes(File arquivo, Cinema cinema) {
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void imprimeMenuGerenteEdicaoFilme(Gerente gerente, Scanner sc) {
        int opcao = 0;
        boolean continuaLaco = true;
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

            do {
                try {
                    System.out.printf("Entre uma opcao: ");
                    opcao = Integer.parseInt(sc.nextLine());
                    continuaLaco = false;

                } catch (NumberFormatException e) {
                    System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
                }
            } while (continuaLaco);
            System.out.println();;

            switch (opcao) {
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
                            editarFilmeArquivo(filme);
                            System.out.println("Filme editado com sucesso!");
                        } else {
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
                        editarFilmeArquivo(filme);
                        System.out.println("Filme editado com sucesso!");
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
                        editarFilmeArquivo(filme);
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
                        editarFilmeArquivo(filme);
                        System.out.println("Filme editado com sucesso!");
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
                        editarFilmeArquivo(filme);
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

    private static void editarFilmeArquivo(Filme filmeNovo) {
        String arquivoFilme = "Filmes.csv";

        try {
            File arquivoOriginal = new File(arquivoFilme);
            File arquivoTemporario = new File("FilmesTemporarios.csv");

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
                        if (nome.equalsIgnoreCase(filmeNovo.getNomeFilme())) {
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

    public static void imprimeMenuGerenteRemocaoFilme(Gerente gerente, Scanner sc) {
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
        String caminhoArquivo = "Filmes.csv";
        String arquivosExcluidos = "FilmesIndisponiveis.csv";

        try {
            File arquivoOriginal = new File(caminhoArquivo);
            File arquivoTemporario = new File("FilmesTemporarios.csv");

            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bwTemporario = new BufferedWriter(new FileWriter(arquivoTemporario)); BufferedWriter bwExcluidos = new BufferedWriter(new FileWriter(arquivosExcluidos, true))
                    ) {
                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    // Copiar o cabeçalho diretamente
                    if (cabecalho) {
                        bwTemporario.write(linha);
                        bwTemporario.newLine();
                        if (new File(arquivosExcluidos).length() == 0) {
                            // Adiciona cabeçalho ao arquivo de excluídos se estiver vazio
                            bwExcluidos.write("Titulo,Sinopse,Classificacao,Genero,Duracao,MotivoExclusao\n");
                        }
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",");
                    if (dados.length == 5) {
                        String nome = dados[0];

                        //se for o filme selecionado adiciona em FilmesIndisponiveis
                        if (nome.equalsIgnoreCase(filme.getNomeFilme())) {
                            bwExcluidos.write(filme.getNomeFilme() + ","
                                    + filme.getSinopseFilme() + ","
                                    + filme.getClassificacaoFilme() + ","
                                    + filme.getGeneroFilme() + ","
                                    + filme.getDuracaoFilme() + ","
                                    + motivoExclusao);
                            bwExcluidos.newLine();
                        } else {
                            //se nao copia a linha para o arquivo temporario
                            bwTemporario.write(linha);
                            bwTemporario.newLine();
                        }
                    }
                }
            }

            //substitui original -> temporário
            if (arquivoOriginal.delete()) {
                arquivoTemporario.renameTo(arquivoOriginal);
            } else {
                System.out.println("Erro ao substituir o arquivo original.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void imprimeListaFilmes(Cinema cinema) {
        for (Filme f : cinema.getListaFilmes()) {
            if (!(f instanceof FilmeIndisponivel)) {
                System.out.println(f.toString());
            }
        }
    }

    private static Filme buscarFilme(String nomeFilme, ArrayList<Filme> listaFilmes) {
        for (Filme filmeTemporario : listaFilmes) {
            if (nomeFilme.equals(filmeTemporario.getNomeFilme())) {
                return filmeTemporario;
            }
        }

        return null;
    }

//*SALA*
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

        // verifica se o tipo de tela eh valido
        if (tipoTelaString.equalsIgnoreCase("2D")) {
            tipoTela = false;
        } else if (tipoTelaString.equalsIgnoreCase("3D")) {
            tipoTela = true;
        } else {
            System.out.println("- Erro: tipo de tela invalido. Tente novamente!");
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
        String caminhoArquivo = "Salas.csv";

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

    public static void carregarSalas(File arquivo, Cinema cinema) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 3) {
                    int numero = Integer.parseInt(dados[0]);
                    int assentos = Integer.parseInt(dados[1]);
                    boolean tela = Boolean.parseBoolean(dados[1]);

                    cinema.getListaSalas().add(new Sala(numero, assentos, tela));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void imprimeMenuGerenteEdicaoSala(Gerente gerente, Scanner sc) {
        int opcao = 0;
        boolean continuaLaco = true;
        int nroSala;
        String confirmacao;

        System.out.println("EDITAR SALA");
        imprimeListaSalas(gerente.getCinema());
        System.out.printf("Digite o numero da sala a ser alterada: ");
        nroSala = Integer.parseInt(sc.nextLine());
        System.out.println();

        // busca sala e checa se ha alguma sessao cadastrada com aquela sala 
        Sala sala = gerente.buscarSala(nroSala);

        if (sala != null && !(gerente.buscarSessaoComSala(sala))) {
            System.out.println("Parametros que podem ser alterados: ");
            System.out.println("(1) Numero da Sala");
            System.out.println("(2) Numero de Assentos");
            System.out.println("(3) Tipo de Tela");
            System.out.print("Escolha um parametro: ");

            do {
                try {
                    System.out.printf("Entre uma opcao: ");
                    opcao = Integer.parseInt(sc.nextLine());
                    continuaLaco = false;

                } catch (NumberFormatException e) {
                    System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
                }
            } while (continuaLaco);
            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o numero da sala novo: ");
                    int nroSalaNovo = Integer.parseInt(sc.nextLine());
                    System.out.println();

                    System.out.println("- Numero da Sala Antigo: " + sala.getNroSala());
                    System.out.println("- Numero da Sala Novo: " + nroSalaNovo);

                    System.out.print("Confirmar edicao (Sim ou Nao): ");
                    confirmacao = sc.nextLine();

                    if (confirmacao.equalsIgnoreCase("Sim")) {
                        if (gerente.editarSala(sala, nroSalaNovo, -1, null)) {
                            editarSalaArquivo(sala);
                            System.out.println("Sala editada com sucesso!");
                        } else {
                            System.out.println("Erro na edicao: numero da sala ja esta cadastrado. Tente novamente!");
                        }
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
                        editarSalaArquivo(sala);
                        System.out.println("Sala editada com sucesso!");
                    }
                    break;
                case 3:
                    System.out.printf("Digite o tipo de tela novo (2D ou 3D): ");
                    String tipoTelaString = sc.nextLine();
                    System.out.println();

                    boolean tipoTelaNovo;
                    if (tipoTelaString.equalsIgnoreCase("2D")) {
                        tipoTelaNovo = false;
                    } else if (tipoTelaString.equalsIgnoreCase("3D")) {
                        tipoTelaNovo = true;
                    } else {
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
                        editarSalaArquivo(sala);
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

    private static void editarSalaArquivo(Sala salaNova) {
        String arquivoSalas = "Salas.csv";

        try {
            File arquivoOriginal = new File(arquivoSalas);
            File arquivoTemporario = new File("SalasTemporarias.csv");

            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    // Copiar cabeçalho diretamente
                    if (cabecalho) {
                        bw.write(linha);
                        bw.newLine();
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",");
                    if (dados.length == 3) {
                        int nroSala = Integer.parseInt(dados[0]);

                        // Substituir a linha correspondente ao filme editado
                        if (nroSala == salaNova.getNroSala()) {
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

            // Substituir o arquivo original pelo temporário
            if (arquivoOriginal.delete()) {
                arquivoTemporario.renameTo(arquivoOriginal);
            } else {
                System.out.println("Erro ao substituir o arquivo original.");
            }
        } catch (IOException e) {
        }

    }

    public static void imprimeMenuGerenteRemocaoSala(Gerente gerente, Scanner sc) {
        int nroSala;
        String confirmacao;

        System.out.println("REMOCAO DE SALA");
        imprimeListaSalas(gerente.getCinema());
        System.out.printf("Digite o numero da sala a ser removida: ");
        nroSala = Integer.parseInt(sc.nextLine());

        // busca sala e checa se ha alguma sessao cadastrada com aquela sala 
        Sala sala = gerente.buscarSala(nroSala);

        if (sala != null && !(gerente.buscarSessaoComSala(sala))) {
            System.out.print("Confirmar remocao da sala (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                gerente.removerSala(sala);
                removerSalaArquivo(sala);
                System.out.println("Sala removida com sucesso!");
            }
        } else {
            System.out.println("- Erro na edicao: sala nao encontrada ou sala com sessao cadastrada. Tente novamente!");
        }
        sc.nextLine();
    }

    private static boolean removerSalaArquivo(Sala salaRemovida) {
        String caminhoArquivo = "Salas.csv"; // O arquivo onde as salas estão armazenadas
        boolean sucesso = false;

        try {
            File arquivoOriginal = new File(caminhoArquivo);
            File arquivoTemporario = new File("Salas_temp.csv");

            try (
                    BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario))) {
                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    // Copiar cabeçalho diretamente
                    if (cabecalho) {
                        bw.write(linha);
                        bw.newLine();
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",");
                    if (dados.length == 3) { // Supondo que a sala tenha 3 atributos principais: numero, assentos e tipo de tela
                        int nroSala = Integer.parseInt(dados[0]);

                        // Ignorar a linha correspondente à sala removida
                        if (nroSala != salaRemovida.getNroSala()) {
                            bw.write(linha);
                            bw.newLine();
                        } else {
                            sucesso = true;
                        }
                    }
                }
            }

            // Substituir o arquivo original pelo temporário
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

    public static void imprimeListaSalas(Cinema cinema) {
        for (Sala s : cinema.getListaSalas()) {
            System.out.println(s.toString());
        }
    }

    public static void printarDados(File arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            // Lê e imprime cada linha do arquivo
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao ler o arquivo.");
        }
    }

    public static void carregarDados(String caminhoDiretorio, Cinema cinema, Gerente gerente) {
        File diretorio = new File(caminhoDiretorio);

        if (diretorio.exists() && diretorio.isDirectory()) {
            // Listar todos os arquivos no diretório (tirar dps)
            File[] arquivos = diretorio.listFiles((dir, nome) -> nome.endsWith(".csv"));

            // Para cada arquivo CSV encontrado, carregar os dados
            for (File arquivo : arquivos) {
                if (arquivo.isFile()) {
                    System.out.println("Carregando arquivo: " + arquivo.getName());
                    if (arquivo.getName().startsWith("Usuarios")) {
                        carregarUsuarios(arquivo, gerente);
                    } else if (arquivo.getName().startsWith("Salas")) {
                        carregarSalas(arquivo, cinema);
                    } else if (arquivo.getName().startsWith("Sessoes")) {
                        carregarSessoes(arquivo, cinema);
                    } else if (arquivo.getName().startsWith("Filmes")) {
                        carregarFilmes(arquivo, cinema);
                        /*} else if (arquivo.getName().startsWith("ingressos")) {
                        carregarIngressos(arquivo, gerente);*/
                    }
                }
            }
        } else {
            System.out.println("Diretório não encontrado: " + caminhoDiretorio);
        }
    }

    // Carregar salas
    // Carregar sessões
    public static void carregarSessoes(File arquivo, Cinema cinema) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            br.readLine(); // Ignorar o cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 6) {
                    //int codigo = Integer.parseInt(dados[0]);
                    LocalDateTime diaHorario = LocalDateTime.parse(dados[0]);
                    //boolean listaAssentos = Boolean.parseBoolean(dados[2]);
                    double preco = Double.parseDouble(dados[1]);
                    boolean comPromocao = Boolean.parseBoolean(dados[2]);
                    double porcentagem = Double.parseDouble(dados[3]);
                    Sala sala = cinema.getListaSalas().get(Integer.parseInt(dados[4]));
                    Filme filme = cinema.getListaFilmes().get(Integer.parseInt(dados[5]));

                    cinema.getListaSessoes().add(new Sessao(diaHorario, preco, comPromocao, porcentagem, sala, filme));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao ler o arquivo CSV de sessões.");
        }
    }

    private static void cadastrarSessaoArquivo(Sessao sessao) {
        // caminho do arquivo de sessões
        String caminhoArquivo = "Sessoes.csv";

        // cria/abre o arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            // cria o cabeçalho do arquivo se ele estiver vazio
            if (new java.io.File(caminhoArquivo).length() == 0) {
                bw.write("Codigo,DiaHorario,ListaAssentos,Preco,Promocao,Porcentagem,Sala,Filme\n");
            }

            // escreve os dados do usuário
            bw.write(sessao.getCodigoSessao() + ","
                    + sessao.getDiaHorarioSessao() + ","
                    + Arrays.toString(sessao.getListaAssentos()) + ","
                    + sessao.getPrecoSessao() + ","
                    + sessao.getComPromocao() + ","
                    + sessao.getPorcentagemPromocional() + ","
                    + sessao.getSalaSessao().getNroSala() + ","
                    + sessao.getFilmeSessao().getNomeFilme() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int imprimeMenuGerente(Scanner sc) {
        int opcao = 0;
        boolean continuaLaco = true;

        System.out.println("MENU DO GERENTE");
        System.out.println("(1) Filme");
        System.out.println("(2) Sala");
        System.out.println("(3) Sessao");
        System.out.println("(4) Promocao");
        System.out.println("(5) Exibir Relatorios");
        System.out.println("(6) Sair");

        do {
            try {
                System.out.printf("Entre uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
                continuaLaco = false;

            } catch (NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
            }
        } while (continuaLaco);

        System.out.println();
        return opcao;
    }

    public static int imprimeMenuGerenteFilme(Scanner sc) {
        int opcao = 0;
        boolean continuaLaco = true;

        System.out.println("FILME");
        System.out.println("(1) Cadastrar Filme");
        System.out.println("(2) Editar Filme");
        System.out.println("(3) Remover Filme");
        System.out.println("(4) Listar Filmes");
        System.out.println("(5) Sair");

        do {
            try {
                System.out.printf("Entre uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
                continuaLaco = false;

            } catch (NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
            }
        } while (continuaLaco);

        System.out.println();
        return opcao;
    }

    public static int imprimeMenuGerenteSala(Scanner sc) {
        int opcao = 0;
        boolean continuaLaco = true;

        System.out.println("SALA");
        System.out.println("(1) Cadastrar Sala");
        System.out.println("(2) Editar Sala");
        System.out.println("(3) Remover Sala");
        System.out.println("(4) Listar Salas");
        System.out.println("(5) Sair");

        do {
            try {
                System.out.printf("Entre uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
                continuaLaco = false;

            } catch (NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
            }
        } while (continuaLaco);

        System.out.println();
        return opcao;
    }

    public static int imprimeMenuGerenteSessao(Scanner sc) {
        int opcao = 0;
        boolean continuaLaco = true;

        System.out.println("SESSAO");
        System.out.println("(1) Cadastrar Sessao");
        System.out.println("(2) Editar Sessao");
        System.out.println("(3) Remover Sessao");
        System.out.println("(4) Listar Sessoes");
        System.out.println("(5) Sair");

        do {
            try {
                System.out.printf("Entre uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
                continuaLaco = false;

            } catch (NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
            }
        } while (continuaLaco);

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
                        cadastrarSessaoArquivo(sessaoTemporaria);
                        System.out.println("Sessao adicionada com sucesso");
                    } else {
                        System.out.println("Erro ao adicionar a sessao.");
                        System.out.println("Possiveis problemas: dia e horario coincidem com outra sessao ou sessao +18 antes das 20h.");
                        Sessao.decrementaQuantidadeSessoes();
                    }
                } else {
                    Sessao.decrementaQuantidadeSessoes();
                }
            } else {
                System.out.println("Sala nao encontrada");
            }
        } else {
            System.out.println("Filme nao encontrado");
        }

        System.out.println();

    }

    public static void imprimeMenuGerenteEdicaoSessao(Gerente gerente, Scanner sc) {
        int opcao = 0;
        boolean continuaLaco = true;
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

            do {
                try {
                    System.out.printf("Entre uma opcao: ");
                    opcao = Integer.parseInt(sc.nextLine());
                    continuaLaco = false;

                } catch (NumberFormatException e) {
                    System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
                }
            } while (continuaLaco);
            System.out.println();

            switch (opcao) {
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
                            editarSessaoArquivo(sessao);
                        }
                    } else {
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
                            editarSessaoArquivo(sessao);
                        }
                    } else {
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
                            editarSessaoArquivo(sessao);
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
                            editarSessaoArquivo(sessao);
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
                        editarSessaoArquivo(sessao);
                    }
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        } else {
            System.out.println("Sessao nao encontrada");
        }

        System.out.println();

    }
    
    private static void editarSessaoArquivo(Sessao sessaoNova) {
        String arquivoSessao = "Sessoes.csv";

        try {
            File arquivoOriginal = new File(arquivoSessao);
            File arquivoTemporario = new File("SessoesTemporarias.csv");

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
                        int codigo = Integer.parseInt(dados[0]);

                        if (codigo == sessaoNova.getCodigoSessao()) {
                            bw.write(sessaoNova.getCodigoSessao() + ","
                                    + sessaoNova.getDiaHorarioSessao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + ","
                                    + sessaoNova.getPrecoSessao() + ","
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

    public static void imprimeMenuGerenteRemocaoSessao(Gerente gerente, Scanner sc) {
        int codigoSessao;
        String motivoExclusaoSessao;
        String confirmacao;

        System.out.println("REMOCAO DE SESSAO");
        imprimeListaSessoes(gerente.getCinema());
        System.out.printf("Digite o codigo da sessao a ser removida: ");
        codigoSessao = Integer.parseInt(sc.nextLine());

        Sessao sessao = gerente.buscarSessao(codigoSessao);

        if (sessao != null) {

            System.out.printf("Digite o motivo de exclusao da sessao: ");
            motivoExclusaoSessao = sc.nextLine();

            System.out.print("Confirmar remocao da sessao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.removerSessao(sessao, motivoExclusaoSessao)) {
                    removerSessaoArquivo(sessao, motivoExclusaoSessao);
                    System.out.println("Sessao removida com sucesso");
                } else {
                    System.out.println("Sessao ja foi removida");
                }
            }
        } else {
            System.out.println("Sessao nao encontrada");
        }

        System.out.println();
    }
    
    private static void removerSessaoArquivo(Sessao sessao, String motivoExclusao) {
        String arquivoSessao = "Sessoes.csv";
        String arquivoExclusao = "SessoesIndisponiveis.csv";

        try {
            File arquivoOriginal = new File(arquivoSessao);
            File arquivoTemporario = new File("SessoesTemporarias.csv");

            try (BufferedReader br = new BufferedReader(new FileReader(arquivoOriginal)); BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoTemporario)); BufferedWriter bwExclusao = new BufferedWriter(new FileWriter(arquivoExclusao, true))) {

                String linha;
                boolean cabecalho = true;

                while ((linha = br.readLine()) != null) {
                    if (cabecalho) {
                        bw.write(linha);
                        bw.newLine();
                        if (new File(arquivoExclusao).length() == 0) {
                            bwExclusao.write("Titulo,Sinopse,Classificacao,Genero,Duracao,MotivoExclusao\n");
                        }
                        cabecalho = false;
                        continue;
                    }

                    String[] dados = linha.split(",");
                    if (dados.length == 5) {

                        if (dados[0].equals(String.valueOf(sessao.getCodigoSessao()))) {
                            bwExclusao.write(
                                    sessao.getCodigoSessao() + ","
                                    + sessao.getDiaHorarioSessao() + ","
                                    + sessao.getPrecoSessao() + ","
                                    + sessao.getSalaSessao().getNroSala() + ","
                                    + sessao.getFilmeSessao().getNomeFilme() + ","
                                    + motivoExclusao
                            );
                            bwExclusao.newLine();
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


    public static void imprimeListaSessoes(Cinema cinema) {
        for (Sessao s : cinema.getListaSessoes()) {
            if (!(s instanceof SessaoIndisponivel)) {
                System.out.println(s.toString());
            }
        }
    }

    public static int imprimeMenuGerentePromocao(Scanner sc) {
        int opcao = 0;
        boolean continuaLaco = true;

        System.out.println("PROMOCAO");
        System.out.println("(1) Cadastrar Promocao");
        System.out.println("(2) Editar Promocao");
        System.out.println("(3) Remover Promocao");
        System.out.println("(4) Sair");

        do {
            try {
                System.out.printf("Entre uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
                continuaLaco = false;

            } catch (NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
            }
        } while (continuaLaco);

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

            porcentagemPromocional = porcentagemPromocional / 100.00;

            System.out.print("Confirmar adicao da promocao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.adicionarPromocao(sessao, porcentagemPromocional)) {
                    System.out.println("Promocao adicionada com sucesso");
                } else {
                    System.out.println("Erro ao adicionar promocao. Promocao ja existe");
                }
            }
        } else {
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
            porcentagemPromocionalNova = porcentagemPromocionalNova / 100.00;
            System.out.println();

            System.out.println("- Promocao Antiga: " + sessao.getPorcentagemPromocional() * 100 + "%");
            System.out.println("- Promocao Nova: " + porcentagemPromocionalNova * 100 + "%");

            System.out.print("Confirmar edicao da promocao (Sim ou Nao): ");
            confirmacao = sc.nextLine();

            if (confirmacao.equalsIgnoreCase("Sim")) {
                if (gerente.editarPromocao(sessao, porcentagemPromocionalNova)) {
                    System.out.println("Promocao editada com sucesso");
                } else {
                    System.out.println("Erro ao editar promocao. Sessao nao possui promocao");
                }
            }
        } else {
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
                } else {
                    System.out.println("Sessao nao possui promocao");
                }
            }
        } else {
            System.out.println("Sessao nao encontrada");
        }

        System.out.println();
    }

    public static int imprimeMenuGerenteRelatorio(Scanner sc) {
        int opcao = 0;
        boolean continuaLaco = true;

        System.out.println("RELATORIO");
        System.out.println("(1) Filmes");
        System.out.println("(2) Sessoes");
        System.out.println("(3) Sala");
        System.out.println("(4) Usuarios");
        System.out.println("(5) Sair");

        do {
            try {
                System.out.printf("Entre uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
                continuaLaco = false;

            } catch (NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
            }
        } while (continuaLaco);

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
        int opcao = 0;
        boolean continuaLaco = true;

        System.out.println("MENU DO USUARIO");
        System.out.println("(1) Comprar Ingresso");
        System.out.println("(2) Comprar Assinatura");
        System.out.println("(3) Ver perfil");
        System.out.println("(4) Sair");

        do {
            try {
                System.out.print("Digite uma opcao: ");
                opcao = Integer.parseInt(sc.nextLine());
                continuaLaco = false;

            } catch (NumberFormatException e) {
                System.out.println("- Erro: a opcao deve ser um numero inteiro. Tente novamente!");
            }
        } while (continuaLaco);

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
                    } else {
                        System.out.println("Erro ao comprar ingresso");
                    }
                }
            } else {
                System.out.println("Sessao nao encontrada");
            }
        } else {
            System.out.println("Filme nao encontrado");
        }

        System.out.println();

    }

    public static Usuario imprimeMenuUsuarioComprarAssinatura(Usuario usuario, Gerente gerente, Scanner sc) { // VERIFICAR ISSO
        System.out.println("ASSINATURA");

        if (usuario instanceof UsuarioAssinante) {
            System.out.println("Voce ja possui uma assinatura");
            sc.nextLine();
        } else {
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
