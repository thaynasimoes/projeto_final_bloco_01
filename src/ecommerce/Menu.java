package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import livraria.model.Livro;
import livraria.model.CD;
import livraria.model.Pagamento;
import livraria.model.Produto;
import ecommerce.repository.LivroRepository;
import ecommerce.repository.CDRepository;

public class Menu {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        
        LivroRepository livroRepo = new LivroRepository();
        CDRepository cdRepo = new CDRepository();

        Pagamento pagamento = null;
        
        int opcao = 0;
        while (true) {
            System.out.println("********************************************************");
            System.out.println("                                                     ");
            System.out.println("                     LIVRARIA TULIP                  ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Adicionar livro                      ");
            System.out.println("            2 - Remover livro                        ");
            System.out.println("            3 - Atualizar informações do livro       ");
            System.out.println("            4 - Buscar livro por título              ");
            System.out.println("            5 - Processar pagamento                  ");
            System.out.println("            6 - Reembolsar pagamento                 ");
            System.out.println("            7 - Consultar estoque                    ");
            System.out.println("            8 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
                        
            try {
                opcao = leia.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite valores inteiros! ");
                leia.nextLine();
            }
            
            if (opcao == 8) {
                System.out.println("Livraria Tuliip - Cultivando conhecimento, uma página de cada vez");
                sobre();
                leia.close();
                System.exit(0);
            }
            
            switch (opcao) {
                case 1:
                    System.out.println("Adicionar livro\n\n");
                    System.out.println("Informe o título do livro: ");
                    leia.nextLine(); 
                    String titulo = leia.nextLine();
                    System.out.println("Informe o autor do livro: ");
                    String autor = leia.nextLine();
                    System.out.println("Informe a categoria do livro: ");
                    String categoria = leia.nextLine();
                    System.out.println("Informe o preço do livro: ");
                    double preco = leia.nextDouble();
                    System.out.println("Informe a quantidade no estoque: ");
                    int quantidade = leia.nextInt();

                    Livro livro = new Livro(titulo, autor, categoria, preco, quantidade);
                    livroRepo.adicionar(livro);
                    System.out.println("Livro adicionado com sucesso!");
                    livro.visualizar();
                    keyPress();
                    break;

                case 2:
                    System.out.println("Remover livro\n\n");
                    System.out.println("Informe o título do livro a ser removido: ");
                    leia.nextLine();
                    String tituloRemover = leia.nextLine();
                    livroRepo.remover(tituloRemover);
                    keyPress();
                    break;

                
                case 3:
                    System.out.println("Atualizar informações do livro\n\n");
                    System.out.println("Informe o título do livro a ser atualizado: ");
                    leia.nextLine();  
                    String tituloAtualizar = leia.nextLine();
                    Produto produtoAtualizar = livroRepo.buscarPorTitulo(tituloAtualizar);
                    if (produtoAtualizar != null) {
                        if (produtoAtualizar instanceof Livro) {
                            Livro livroAtualizar = (Livro) produtoAtualizar;
                            System.out.println("Informe o novo título do livro: ");
                            String novoTitulo = leia.nextLine();
                            System.out.println("Informe o novo autor do livro: ");
                            String novoAutor = leia.nextLine();
                            System.out.println("Informe a nova categoria do livro: ");
                            String novaCategoria = leia.nextLine();
                            System.out.println("Informe o novo preço do livro: ");
                            double novoPreco = leia.nextDouble();
                            System.out.println("Informe a nova quantidade no estoque: ");
                            int novaQuantidade = leia.nextInt();

                            livroAtualizar.setTitulo(novoTitulo);
                            livroAtualizar.setAutor(novoAutor);
                            livroAtualizar.setCategoria(novaCategoria);
                            livroAtualizar.setPreco(novoPreco);
                            livroAtualizar.setQuantidadeEstoque(novaQuantidade);

                            livroRepo.atualizar(livroAtualizar);
                            System.out.println("Informações do livro atualizadas com sucesso!");
                        } else {
                            System.out.println("Produto não é um livro.");
                        }
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    keyPress();
                    break;


                case 4:
                    System.out.println("Buscar livro por título\n\n");
                    System.out.println("Informe o título do livro: ");
                    leia.nextLine();  
                    String tituloBuscar = leia.nextLine();
                    Produto produtoEncontrado = livroRepo.buscarPorTitulo(tituloBuscar);
                    if (produtoEncontrado != null) {
                        produtoEncontrado.visualizar();
                    }else {
                    	System.out.println("Esse livro não foi encontrado!");
                    }
                    keyPress();
                    break;

                case 5:
                    System.out.println("Processar pagamento\n\n");
                    System.out.println("Informe o valor do pagamento: ");
                    double valorPagamento = leia.nextDouble();
                    pagamento = new Pagamento(valorPagamento, false);
                    if (pagamento.processarPagamento()) {
                        System.out.println("Pagamento processado com sucesso!");
                    } else {
                        System.out.println("Falha ao processar o pagamento.");
                    }
                    keyPress();
                    break;

                case 6:
                    System.out.println("Reembolsar pagamento\n\n");
                    if (pagamento != null) {
                        pagamento.reembolsarPagamento();
                    } else {
                        System.out.println("Nenhum pagamento encontrado para reembolso.");
                    }
                    keyPress();
                    break;

                case 7:
                    System.out.println("Consultar estoque\n\n");
                    System.out.println("Livros no estoque:");
                    for (Produto p : livroRepo.listarTodos()) {
                        p.visualizar();
                    }
                    System.out.println("CDs no estoque:");
                    for (Produto p : cdRepo.listarTodos()) {
                        p.visualizar();
                    }
                    keyPress();
                    break;

                default:
                    System.out.println("\nOpção inválida!");
                    keyPress();
                    break;
            }
        }
    }

    public static void keyPress() {
        try {
            System.out.println("Pressione Enter para continuar...");
            System.in.read();
        } catch (IOException e) {
            System.out.println("Você pressionou uma tecla diferente de Enter!");
        }
    }

    public static void sobre() {
        System.out.println("****************************************************");
        System.out.println("Projeto desenvolvido por: ");
        System.out.println("Thayná Pereira Simões - thayna.pereira2402@gmail.com");
        System.out.println("https://github.com/thaynasimoes");
        System.out.println("****************************************************");
        System.out.println("Com base em: ");
        System.out.println("Generation Brasil - generation#generation.org");
        System.out.println("****************************************************");
    }
}
