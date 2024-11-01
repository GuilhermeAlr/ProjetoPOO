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
        int opcao;
        
        while(estaRodando) {
            if(estaLogado == -1) {
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
                if (estaLogado == 0) {
                    opcao = imprimeMenuGerente(sc);
                    
                    switch(opcao) {
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
                        default:
                            System.out.println("Opcao invalida. Tente novamente");
                            break;

                    } 
                    
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
        
        System.out.println("MENU GERENTE");
        System.out.println("(1) Cadastro de Filme");
        System.out.println("(2) Edicao de Filme");
        System.out.println("(3) Remocao de Filme");
        System.out.println("(4) Lista de Filmes");
        
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
        
        System.out.println("EDICAO DE FILME");
        System.out.printf("Digite o nome do filme a ser alterado: ");
        nomeFilme = sc.nextLine();
        System.out.println();
        
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
                
                if (gerente.editarFilme(nomeFilme, nomeNovo, "", -1, "", -1))
                    System.out.println("Nome do filme alterado de " + nomeFilme + " para " + nomeNovo);
                else 
                    System.out.println("Erro na edicao do filme");
                break;
            case 2:
                System.out.printf("Digite a sinopse nova: ");
                String sinopseNova = sc.nextLine();
                
                if (gerente.editarFilme(nomeFilme, "", sinopseNova, -1, "", -1))
                    System.out.println("Sucesso na edicao");
                else 
                    System.out.println("Erro na edicao do filme");
                break;
            case 3:
                System.out.printf("Digite a classificacao indicativa nova: ");
                int classificacaoNova = Integer.parseInt(sc.nextLine());
                
                if (gerente.editarFilme(nomeFilme, "", "", classificacaoNova, "", -1))
                    System.out.println("Sucesso na edicao");
                else 
                    System.out.println("Erro na edicao do filme");
                break;
            case 4:
                System.out.printf("Digite o genero nova: ");
                String generoNovo = sc.nextLine();
                
                if (gerente.editarFilme(nomeFilme, "", "", -1, generoNovo, -1))
                    System.out.println("Sucesso na edicao");
                else 
                    System.out.println("Erro na edicao do filme");
                break;
            case 5: 
                System.out.printf("Digite a duracao nova: ");
                int duracaoNova = Integer.parseInt(sc.nextLine());
                
                if (gerente.editarFilme(nomeFilme, "", "", -1, "", duracaoNova))
                    System.out.println("Sucesso na edicao");
                else 
                    System.out.println("Erro na edicao do filme");
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }
        
        System.out.println();
       
    }
    
    public static void imprimeMenuGerenteRemocaoFilme(Gerente gerente, Scanner sc) {
        String nomeFilme;
        String motivoExclusaoFilme;
        
        System.out.println("REMOCAO DE FILME");
        System.out.printf("Digite o nome do filme a ser removido: ");
        nomeFilme = sc.nextLine();
        System.out.printf("Digite o motivo de exclusao do filme: ");
        motivoExclusaoFilme = sc.nextLine();
        
        if (gerente.removerFilme(nomeFilme, motivoExclusaoFilme)) {
            System.out.println("Remocao com sucesso");
        }
        else {
            System.out.println("Erro na remocao");
        }
        
        System.out.println();
    }
    
    public static void imprimeListaFilmes(Cinema cinema) {
        
        System.out.println("Lista de Filmes!");
        
        for (Filme filme : cinema.getListaFilmes()) {
            if (!(filme instanceof FilmeIndisponivel)) {
                System.out.println(filme.toString());
                System.out.println();
            }
        }
    }
    
}
