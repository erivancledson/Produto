package TelaPrincipal;



import Produto.Produto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TelaPrincipal {
    
    private static ArrayList<Produto> ListaDProduto = new ArrayList<Produto>();

	public static void main(String args[]) throws IOException {

		Menu();

	}

	private static void Menu() throws IOException {
		String tela = "1) Cadastrar Produto" + "\n2) Listar Produto" 
			   +"\n3) Alterar Produto" +"\n4) Apagar Produto" 	+ "\n5) Deletar Produtos" + 
                            "\n6) Recupera Informação" + "\n7) Sair";

		String opcao = "";
		do {

			opcao = Entrada(tela);

			if (opcao.equals("1")) {
				cadastroProduto();
				
			} else if (opcao.equals("2")) {
				ListaProduto();
			          
             } else if (opcao.equals("3")){
                            alterarProduto();
                        }
                        else if(opcao.equals("4")){
                            apagarProduto();
                        }
                        else if (opcao.equals("5")){
                            deletarProdutos();
                        }
                        else if (opcao.equals("6")){
                            recuperarProdutos();
                        }

		} while (!opcao.equals("7"));
	}
                         // entrada de dados pelo usuario e cadastra os mesmo em ListaDProduto
	private static void cadastroProduto() {

		String nome = Entrada("PRODUTO");
		double PrecoComprado = Double.parseDouble(Entrada("VALOR COMPRA"));
		double precoVenda = Double.parseDouble(Entrada("VALOR VENDA"));
                String informacaoProduto = Entrada("INFORMAÇÃO DO PRODUTO");
                String informacaoTecnicas = Entrada("INFORMAÇÕES TÉCNICAS");

		Produto produto = new Produto(nome, PrecoComprado, precoVenda, informacaoProduto,informacaoTecnicas);

		ListaDProduto.add(produto);

	}
                       // lista e armazena no txt todos os produtos
        
	private static void ListaProduto() throws IOException {
            
                  if(ListaDProduto.isEmpty()){
                  SaidaDados("Nenhum produto cadastrado");
                  return;
                  }
                  
            
		FileWriter arq = new FileWriter("lista_produto.txt"); // cria o arquivo
																// será criado o
																// arquivo para
																// armazenar os
																// dados
		PrintWriter gravarArq = new PrintWriter(arq); // imprimi no arquivo 
														// dados.

		String relatorio = "";

		gravarArq.printf("+--LISTA DE PRODUTOS--+\r\n");

		for (int i = 0; i < ListaDProduto.size(); i++) {
			Produto Lista = ListaDProduto.get(i);
			

			gravarArq.printf(
					" - |Codigo: %d |NOME: %s | VALOR COMPRA: %s | VALOR VENDA: %s | INFORMAÇÕES DO PRODUTO: %s | INFORMAÇÕES TÉCNICAS: %s\r\n",
					Lista.getCodigo(), Lista.getNome(), Lista.getPrecoComprado(),
					Lista.getPrecoVenda(), Lista.getInformacaoProduto(), Lista.getInformacaoTecnicas()); // formatação dos dados no arquivos
                              
											

			

			relatorio += "\nCódigo: " + Lista.getCodigo() +
                                     "\nNome: " + Lista.getNome() +
				     "\nValor de Compra: " +  Lista.getPrecoComprado() + 
                                     "\nValor de Venda: " +  Lista.getPrecoVenda() +
                                     "\nInformações do Produto: " + Lista.getInformacaoProduto() +
                                     "\nInformações Técnicas: " + Lista.getInformacaoTecnicas() +
                                     "\n------------------------------------------------";

		}
                
                

		gravarArq.printf("+------FIM------+\r\n");
		gravarArq.close();

		SaidaDados(relatorio);

	}
           
             
             private static void alterarProduto(){
                 if(ListaDProduto.size() == 0){
                     SaidaDados("Nehum produto foi cadastrado!!");
                     return;
                 }
                 
                 String pesquisar = Entrada("Informe o nome do produto que deseja alterar: ");
                 
                 for(int i =0; i < ListaDProduto.size();i++){
                     Produto alterarNome = ListaDProduto.get(i);
                     
                     if(pesquisar.equalsIgnoreCase(alterarNome.getNome())){
                         String nomeNovo = Entrada("Informe o novo nome do produto: ");
                         
                         alterarNome.setNome(nomeNovo);
                         break;
                     }
                     
                     
                 }
                      SaidaDados("Nome alterado com sucesso!!");

             }
        
              // apagar um produto por vez
                public static void apagarProduto(){
                    if(ListaDProduto.size() == 0){
                        SaidaDados("Nehum produto cadastrado!!");
                        return;
                    }
                    
                    String pesquisarNome = Entrada("Informe o nome do produto que deseja deletar: ");
                    for(int i =0; i < ListaDProduto.size(); i++){
                        
                        Produto produtoProcurado = ListaDProduto.get(i);
                        
                        if(pesquisarNome.equalsIgnoreCase(produtoProcurado.getNome())){
                            ListaDProduto.remove(i);
                            SaidaDados("Produto deletado com sucesso!!");
                        }
                         
                    }
                    
                }

        
        
        
        
        
               // deleta todos os produtos
         public static void deletarProdutos(){
             if(ListaDProduto.isEmpty()){
                  SaidaDados("Nenhum produto cadastrado");
                  return;
                  }     
                          ListaDProduto.clear();
                          SaidaDados("Todos produto deletado com sucesso");
                          
         
         }
               // depois que o programa é fechado e aberto novamente ele exibi o cadastro do txt
          private static void recuperarProdutos(){
      		String exibi = "";
    		String nomeArq = "lista_produto.txt"; 
    															
    		String linha = "";
    		File arq = new File(nomeArq);

    		// Arquivo existe
    		if (arq.exists()) {
    			exibi = "RELATORIO";
    			try {
    				exibi += "";
    				// abrindo arquivo para leitura
    				FileReader abrindo = new FileReader(nomeArq);
    				// leitor do arquivo
    				BufferedReader leitor = new BufferedReader(abrindo);
    				while (true) {
    					linha = leitor.readLine();
    					if (linha == null)
    						break;
    					exibi += linha + "\n";

    				}
    				leitor.close();
    			}

    			catch (Exception erro) {
    			}
    			JOptionPane.showMessageDialog(null, exibi, "LISTA DE PRODUTOS"
    					+ "...", 1);
    		}
    		// Se nao existir
    		else
    			JOptionPane.showMessageDialog(null, "Arquivo nao" + " existe!",
    					"Erro", 0);
    	}
         
         //entrada de dados
         public static String Entrada(String entrar){
             return JOptionPane.showInputDialog(entrar);
         }
         
           // saida de dados na tela
         private static void SaidaDados(String saida){
        JOptionPane.showMessageDialog(null, saida);
    }
         
         
}
