package ecommerce;

import java.util.Scanner;



public class Menu {
	
	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		while(true) {
			
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
	            System.out.println("                                                     ");
			
	            opcao = leia.nextInt();
	            
	            if(opcao == 8) {
	            	System.out.println("Livraria Tuliip - Cultivando conhecimento, uma página de cada vez");
	            	sobre();
	            	leia.close();
	            	System.exit(0);
	            }
	            
	            switch (opcao) {
	            
	            case 1:
	            	System.out.println("Adicionar livro\n\n");
	            	
	            	break;
	            	
	            case 2:
	            	System.out.println("Remover livro\n\n");
	            	
	            	break;
	            	
	            case 3:
	            	System.out.println("Atualizar infromações do livro\n\n");
	            	
	            	break;
	            	
	            case 4:
	            	System.out.println("Buscar livro por título\n\n");
	            	
	            	break;
	            	
	            case 5:
	            	System.out.println("Processar pagamento\n\n");
	            	
	            	break;
	            	
	            case 6:
	            	System.out.println("Reembolsar pagamento\n\n");
	            	
	            	break;
	            	
	            case 7:
	            	System.out.println("Consultar estoque\n\n");
	            	
	            	break;
	            	default:
	            		System.out.println("\nOpção inválida!");
	            
	            }
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
		System.out.println("github.com?conteudoGeneration");
		System.out.println("****************************************************");

		
	}
}
