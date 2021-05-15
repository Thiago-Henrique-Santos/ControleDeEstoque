package model;

import java.util.ArrayList;
import java.util.List;

public class Compra {
    
    //Criando os atributos
    private Integer idCompra = 0;
    private Cliente clienteResponsavel;
    //Os próximos 3 atributos fazem parte da data da compra
    private Integer dia;
    private Integer mes;
    private Integer ano;
    private Float valorDaCompra;
    //Relacionamento para os produtos
    private List<Produto> produtosComprados = new ArrayList<>();

    //Métodos getter e setter dos atributos
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Cliente getClienteResponsavel() {
        return clienteResponsavel;
    }

    public void setClienteResponsavel(Cliente clienteResponsavel) {
        this.clienteResponsavel = clienteResponsavel;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Float getValorDaCompra() {
        return valorDaCompra;
    }

    public void setValorDaCompra(Float valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }

    public List<Produto> getProdutosComprados() {
        return produtosComprados;
    }

    public void setProdutosComprados(List<Produto> produtosComprados) {
        this.produtosComprados = produtosComprados;
    }
    
    //Métodos de add (criado à mão)
    public void addAllProdutosComprados(List<Produto> produtosComprados){
        this.produtosComprados.addAll(produtosComprados);
    }
    
    //Métodos comportamentais
    public int[][] getQuantidadeCadaProduto(){
        
        //Guardando quantos tipos de produtos há
        int contadorProdutos = 0;
        //Ver lista de produtos
        List<Produto> lista_produtos = produtosComprados;
        //Verificando quantidade de tipos de produtos
        for (int i = 0; i < lista_produtos.size(); i++) {
            Produto produto = lista_produtos.get(i);
            List<Integer> codigoProduto = new ArrayList();
            //Recebendo, o id de todos os produtos que já passou
            codigoProduto.add(produto.getIdProduto());
            if (i > 0) {
                //Verificando se está repetindo, ou se é um novo produto
                for (int j = 0; j < codigoProduto.size(); j++) {
                    if (codigoProduto.get(j) != produto.getIdProduto()) {
                        contadorProdutos++;
                    }
                }
            }else{
                contadorProdutos++;
            }
        }
        
        //Guardando quantidade de cada produto
        /*
        Na primeira coluna guarda os ids dos produtos
        Na segunda coluna guarda a quantidade do produto
        */
        int[][] quantidadeCadaProduto = new int [contadorProdutos][2];
        //Guardando quantidade de cada produto (variável que fica se atualizando)
        int contadorCadaProduto = 0;
        //Verificando quantidade de cada produto
        for (int j = 0; j < contadorProdutos; j++) {
            //Guardando id do produto que está sendo verificado no momento
            Produto produto = lista_produtos.get(j);
            for (int i = 0; i < lista_produtos.size(); i++) {
                //Guardando produto que está sendo passado no índice i
                Produto produtoAtual = lista_produtos.get(i);
                //Verificando quantidade de um produto
                if (i == 0) {
                    contadorCadaProduto++;
                }else{
                    if (produto.getIdProduto() == produtoAtual.getIdProduto()) {
                        contadorCadaProduto++;
                    }
                }
            }
            
            //Guardando a quantidade de cada produto, na matriz
            for (int k = 0; k < 2; k++) {
                if ((k%2)!=0) {
                    quantidadeCadaProduto[j][k] = produto.getIdProduto();
                }else{
                    quantidadeCadaProduto[j][k] = contadorCadaProduto;
                }
            }
        }
        
        return quantidadeCadaProduto;
        
    }
    
    
}
