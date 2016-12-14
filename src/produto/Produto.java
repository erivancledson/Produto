package Produto;

public class Produto {
    // atributos
     private int codigo;
     private String nome;
     private double precoComprado;
     private double precoVenda;
     private String informacaoProduto;
     private String informacaoTecnicas;
     // cria o codigo automatico
     private static int contadorProduto =0; 
      
     // construtor default
      public Produto(){
          contadorProduto++;
          
          codigo = contadorProduto;
      }
          // construtor com argumentos
	public Produto(String nome, double precoComprado, double precoVenda, String informacaoProduto,String informacaoTecnicas) {
              
              contadorProduto++;
          
               codigo = contadorProduto;
          
		this.nome = nome;
		this.precoComprado = precoComprado;
		this.precoVenda = precoVenda;
              this.informacaoProduto = informacaoProduto;
              this.informacaoTecnicas = informacaoTecnicas;

	}
            // get e set
      public int getCodigo() {
		return codigo;
	}
      
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoComprado() {
		return precoComprado;
	}

	public void setPrecoComprado(double precoComprado) {
		this.precoComprado = precoComprado;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;

	}
      
       public String getInformacaoProduto() {
      return informacaoProduto;
  }

  public void setInformacaoProduto(String informacaoProduto) {
      this.informacaoProduto = informacaoProduto;
  }

  public String getInformacaoTecnicas() {
      return informacaoTecnicas;
  }

  public void setInformacaoTecnicas(String informacaoTecnicas) {
      this.informacaoTecnicas = informacaoTecnicas;
  }
}
