
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Cliente;
import model.Compra;
import model.Produto;

public class App {
    
    //adicionando lista de objetos das classes
    /*
        As listas são estáticas, pois o método "main" é estático, e como irámos
        usá-las dentro do método "main", elas precisam ser estáticas.
    */
    static List<Cliente> lista_cliente = new ArrayList<>();
    static List<Produto> lista_produto = new ArrayList<>();
    static List<Compra> lista_compra = new ArrayList<>();
    //variável scanner
    static Scanner scan = new Scanner(System.in);
    //variável para criar um id para os objetos
    static int idCliente = 0;
    static int idProduto = 0;
    static int idCompra = 0;
    //variáveis para separar compras, por ter que ir adicionando produtos
    static int novaCompra = 0;
    static int iniciandoCompra = 0;
    
    //Método principal
    public static void main(String[] args) {
        /**********************************
            *Não está sendo utilizado*
        **********************************/
    }
    
    //========================================================================================================================
    //Métodos que serão usados
    /************************
    =========================
    *Crinado funcionalidades*
    =========================
    ************************/
    //*****Métodos para os clientes*****
    public static int cadastrarCliente(String nome, String email, String telefone, String bairro, String rua, int numeroCasa){
        
        //Salvando informações para os atributos do cadastro
        idCliente++;
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        cliente.setNomeCliente(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setBairro(bairro);
        cliente.setRua(rua);
        cliente.setNumeroCasa(numeroCasa);
        
        //Cadastrando
        lista_cliente.add(cliente);
        
        //Retornando o ID do cliente, para ser mostrado no JOptionPane, ao ser
        //cadastrado
        return idCliente;
        
    }
    
    //Este método servirá para a função de busca em atualizar Cliente 
    //e para consultar Cliente
    public static Cliente buscarCliente(int codigo){
        
        //Buscando Cliente
        for (int i = 0; i < lista_cliente.size(); i++) {
            Cliente cliente = lista_cliente.get(i);
            //Veridficando se é o cliente escolhido
            if (cliente.getIdCliente() == codigo) {
                return cliente;
            }
        }
        
        return null;
        
    }
    
    public static void atualizarCliente(int codigo, String nome, String email, String telefone, String bairro, String rua, int numeroCasa){
        
        //Buscando Cliente
        for (int i = 0; i < lista_cliente.size(); i++) {
            Cliente cliente = lista_cliente.get(i);
            //Veridficando se é o cliente escolhido
            if (cliente.getIdCliente() == codigo) {
                //Salvando informações para os atributos do cadastro
                Cliente saveClient = new Cliente();
                saveClient.setIdCliente(codigo);
                saveClient.setNomeCliente(nome);
                saveClient.setEmail(email);
                saveClient.setTelefone(telefone);
                saveClient.setBairro(bairro);
                saveClient.setRua(rua);
                saveClient.setNumeroCasa(numeroCasa);

                //Atualizando
                lista_cliente.set(i, saveClient);
            }
        }
        
    }
    
    public static boolean excluirCliente(int codigo){
        
        //Variável para verificar se o cliente foi encontrado
        boolean foiExcluido = false;
        //Buscando cliente
        for (int i = 0; i < lista_cliente.size(); i++) {
            Cliente cliente = lista_cliente.get(i);
            //Veridficando se é o cliente escolhido
            if (cliente.getIdCliente() == codigo) {
                lista_cliente.remove(i);
                foiExcluido = true;
            }
        }
        
        //Retornando se foi excluído, ou não
        return foiExcluido;
        
    }
    
    //**********************************
    //*****Métodos para os produtos*****
    public static int cadastrarProduto(String nome, float preco, int estoque){
        
        //Salvando informações para os atributos do cadastro
        idProduto++;
        Produto produto = new Produto();
        produto.setIdProduto(idProduto);
        produto.setNomeProduto(nome);
        produto.setPreco(preco);
        produto.setQuantidadeEmEstoque(estoque);
        
        //Cadastrando produto
        lista_produto.add(produto);
        
        //Retornando o id do produto, para poder mostrar no software
        return idProduto;
        
    }
    
    public static Produto buscarProduto(int codigo){
        
        for (int i = 0; i < lista_produto.size(); i++) {
            Produto produto = lista_produto.get(i);
            //Veridficando se é o cliente escolhido
            if (produto.getIdProduto() == codigo) {
                return produto;
            }
        }
        
        return null;
        
    }
    
    public static boolean excluirProduto(int codigo){
        
        //Variável para verificar se o produto foi encontrado
        boolean foiExcluido = false;
        //Buscando produto
        for (int i = 0; i < lista_produto.size(); i++) {
            Produto produto = lista_produto.get(i);
            //Veridficando se é o produto escolhido
            if (produto.getIdProduto() == codigo) {
                lista_produto.remove(i);
                foiExcluido = true;
            }
        }
        
        //Retornando se foi excluído, ou não
        return foiExcluido;
        
    }
    
    public static void atualizarProduto(int codigo, String nome, float preco, int estoque){
        
        //Buscando produto
        for (int i = 0; i < lista_produto.size(); i++) {
            Produto produto = lista_produto.get(i);
            //Veridficando se é o produto escolhido
            if (produto.getIdProduto() == codigo) {
                //Salvando informações para os atributos do cadastro
                Produto salvarProduto = new Produto();
                salvarProduto.setIdProduto(codigo);
                salvarProduto.setNomeProduto(nome);
                salvarProduto.setPreco(preco);
                salvarProduto.setQuantidadeEmEstoque(estoque);

                //Atualizando
                lista_produto.set(i, salvarProduto);
            }
        }
        
    }
    
    //*********************************
    //*****Métodos para as compras*****
    public static boolean adicionarItem(int codigo, int quantidade){
        
        //Objeto de Produto para ver se há a qauntidade
        Produto analiseProduct = new Produto();
        //Obejto de Produto para dar baixa no estoque
        Produto baixaNoEstoque = new Produto();
        
        //Buscando produto
        for (int i = 0; i < lista_produto.size(); i++) {
            //"(codigo-1)", pois o código será sempre 1 acima do i.
            if(i == (codigo-1)){
                analiseProduct = lista_produto.get(i);
            }
        }
        //Verificando se há a quantidade desejada do produto
        //Se não houver, já retornar "false"
        //Senão, irá continuar o resto do código que adiciona o produto
        if (analiseProduct.getQuantidadeEmEstoque() < quantidade) {
            return false;
        }
        //Criando variável para armazenar uma compra
        Compra newBuy = new Compra();
        //Colocando quantidade de produtos
        for (int i = 0; i < quantidade; i++) {
            //buscando o produto que será colocado
            for (int j = 0; j < lista_produto.size(); j++) {
                //verificando se é o produto selecionado
                if(j == (codigo-1)){
                    //Gravando produto (precisa ser uma lista, para poder adicionar em uma lista)
                    List<Produto> newProduct = new ArrayList<>();
                    newProduct.add(lista_produto.get(j));
                    //Colocando um novo produto na compra
                    newBuy.addAllProdutosComprados(newProduct);
                    
                    //Pegando o objeto para dar baixa no estoque
                    baixaNoEstoque = lista_produto.get(j);
                }
            }
        }
        //Verificando se está em iniciando uma nova compra uma nova compra
        if(iniciandoCompra == 0){
            //Gerando um id para a compra atual
            idCompra++;
            newBuy.setIdCompra(idCompra);
            //Aumentando o "novaCompra", que será usado para verificar se
            //está cadastrando uma compra. Quando estiver, ele será maior
            //que o "idCompra", por 1 unidade.
            novaCompra+=2;
            //criando nova compra, na lista de compra
            lista_compra.add(newBuy);
            
            //Dando baixa no estoque
            baixaNoEstoque.setQuantidadeEmEstoque(baixaNoEstoque.getQuantidadeEmEstoque() - quantidade);
            for (int j = 0; j < lista_produto.size(); j++) {
                //verificando se é o produto selecionado
                if(j == (codigo-1)){
                    lista_produto.set(j, baixaNoEstoque);
                }
            }
            //Aumentando o iniciando compra para não ficar 0, assim quando não iniciar, ir para a próxima verificação
            iniciandoCompra++;
            //retornando que o produto foi adicionado
            return true;
        }else if(novaCompra == (idCompra+1)){
            //Buscando local de armazenamento desta compra
            for (int i = 0; i < lista_compra.size(); i++) {
                //Verificando se é a compra sendo cadastrada
                if(i == (idCompra-1)){
                    //Salvando as adição
                    List<Produto> gettingProducts = new ArrayList<>();
                    gettingProducts.addAll(newBuy.getProdutosComprados());//O addAll adiciona mais de 1 item à lista, de uma vez (adicionaTodos)
                    //Atualizando produtos da compra
                    Compra nowBuy = new Compra();
                    nowBuy.setProdutosComprados(gettingProducts);
                    //Cadastrando produtos à compra
                    lista_compra.get(i).getProdutosComprados().addAll(nowBuy.getProdutosComprados());
                    
                    //Limpando listas de atualização, como a compra já foi atualizada
                    gettingProducts.clear();
                }
            }
            
            //Dando baixa no estoque
            baixaNoEstoque.setQuantidadeEmEstoque(baixaNoEstoque.getQuantidadeEmEstoque() - quantidade);
            for (int j = 0; j < lista_produto.size(); j++) {
                //verificando se é o produto selecionado
                if(j == (codigo-1)){
                    lista_produto.set(j, baixaNoEstoque);
                }
            }
            
            //Retornando que o produto foi adicionado
            return true;
        }
        //Retorna falso caso dê algum erro, de não entrar em nenhuma compra
        return false;
        
    }
    
    public static Compra cadastrarCompra(int codigoCliente, int dia, int mes, int ano){
        
        //Resetando "iniciandoCompra", para poder iniciar outra novamente
        iniciandoCompra = 0;
        //Igualando "novaCompra" ao valor do "idCompra" (estará no último valor, incrementado para  o último cadastro)
        //para não dar erro ao iniciar uma compra, no método "adicionarItem"
        novaCompra = idCompra;
        //variável para soma do valor da compra
        float somaValorCompra = 0;
        //variável para ver o tamanho da lista de produtos da compra desejada
        int tamanhoListaProdutos_Compra = 0;
        
        //Buscando compra desejada, para pegar o tamanho da lista de produto dela
        for (int i = 0; i < lista_compra.size(); i++) {
            //Verificando se é a compra desejada e fazendo o necessário, se for a compra desejada
            if (lista_compra.get(i).getIdCompra() == idCompra) {
                tamanhoListaProdutos_Compra = lista_compra.get(i).getProdutosComprados().size();
            }
        }
        //Fazendo cálculo do valor da compra
        for (int i = 0; i < tamanhoListaProdutos_Compra; i++) {
            //"idCompra-1", pois o id da compra é sem 1 a mais do que está na posição da lista
            //pois a lista começa em 0, e o id em 1
            float precoProdutoAtual = lista_compra.get((idCompra-1)).getProdutosComprados().get(i).getPreco();
            somaValorCompra = somaValorCompra + precoProdutoAtual;
        }
        
        //Achando cliente para registrar
        Cliente responsavel = null;
        for (int i = 0; i < lista_cliente.size(); i++) {
            Cliente atualizandoObjeto = lista_cliente.get(i);
            if (atualizandoObjeto.getIdCliente() == codigoCliente) {
                responsavel = atualizandoObjeto;
            }
        }
        
        //Objeto para salvar informações da compra, antes de adiconar à lista
        Compra compra = new Compra();
        //Buscando o objeto na lista de compra, pelo id de quando iniciou o cadastro de itens nele
        for (int i = 0; i < lista_compra.size(); i++) {
            //Verificando se é a compra desejada
            if (lista_compra.get(i).getIdCompra() == idCompra) {
                //Salvando valores da compra
                compra.setClienteResponsavel(responsavel);
                compra.setIdCompra(idCompra);
                compra.setDia(dia);
                compra.setMes(mes);
                compra.setAno(ano);
                compra.getProdutosComprados().addAll(lista_compra.get(i).getProdutosComprados());
                compra.setValorDaCompra(somaValorCompra);
                //Cadastrando compra
                lista_compra.set(i, compra);
            }
        }
        //Retornando id da compra
        return compra;
        
    }
    
    public static Compra buscarCompra(int codigo){
        
        for (int i = 0; i < lista_compra.size(); i++) {
            Compra compra = lista_compra.get(i);
            //Veridficando se é a compra escolhida
            if (compra.getIdCompra() == codigo) {
                return compra;
            }
        }
        return null;
        
    }
    
    public static Compra atualizarItem(int codigoCompra, int codigoProduto, int quantidade){
        
        //Controladores da remoção do produto
        int quantidade_itensProdutos = 0;
        int removendo = 0;
        //Objeto para fazer as alterações na compra
        Compra att_compra = null;
        //Buscar compra
        for (int i = 0; i < lista_compra.size(); i++) {
            Compra compra = lista_compra.get(i);
            //Veridficando se é a compra escolhida
            if (compra.getIdCompra() == codigoCompra) {
                //Colocando a compra na variável de atualização
                att_compra = lista_compra.get(i);
                //Contando a quantidade de ítens do produto sendo atualizado, na lista de produtos comprados
                for (int j = 0; j < att_compra.getProdutosComprados().size(); j++) {
                    int codigo_produtoAtual = att_compra.getProdutosComprados().get(j).getIdProduto();
                    if(codigo_produtoAtual == codigoProduto){
                       quantidade_itensProdutos++;
                    }
                }
                //Loop para verificar valor da variável "j"
                //O valor máximo deste loop é o mesmo que a quantidade de itens do produto, em atualização
                //para garantir que pegará todos os produtos
                for (int k = 0; k < quantidade_itensProdutos; k++) {
                    //Ver se todos os produtos já foram removido
                    //Se já foram, parar o loop, para seguir o programa,
                    //assim deixando-o mais rápido
                    if(removendo == quantidade_itensProdutos){
                        break;
                    }
                    int j = 0;
                    //Se a variável j acabar atingindo o valor da lista de todos os produtos comprados
                    //menos 1 (onde o loop acabaria)ou maior, e não tiverem sido removidos todos os produtos
                    //ela volta a 0, para poder rodar na lista, até remover todos os ítens
                    if((j == ((att_compra.getProdutosComprados().size()) - 1) || j > ((att_compra.getProdutosComprados().size()) - 1)) && removendo < quantidade_itensProdutos) {
                        j = 0;
                    }
                    //Excluindo na lista de produtos comprados todos os produtos do tipo que irá ser atualizado
                    for (j = 0; j < att_compra.getProdutosComprados().size(); j++) {
                        int codigo_produtoAtual = att_compra.getProdutosComprados().get(j).getIdProduto();
                        if(codigo_produtoAtual == codigoProduto){
                           att_compra.getProdutosComprados().remove(j);
                           removendo++;
                        }
                    }
                }
            }
        }
        
        //Dando baixa no preço, da remoção de todos os produtos
        //Variável para guardar o preço do produto
        float preco_produto = 0f;
        //Achando o produto
        for (int i = 0; i < lista_produto.size(); i++) {
            Produto produtoLoop = lista_produto.get(i);
            if(produtoLoop.getIdProduto() == codigoProduto){
                //Pegar o preço do produto
                preco_produto = produtoLoop.getPreco();
            }
        }
        //Achando o valor total a ser retirado, no preço (preço do produto * quantidade removida)
        float total_retirar = (preco_produto*removendo);
        //Pegando valor total da compra, sem a redução
        float valorTotal_compra_semReducao = att_compra.getValorDaCompra();
        //Calculando valor da compra, com a redução
        float valorTotal_compra_comReducao = (valorTotal_compra_semReducao - total_retirar);
        
        //Pegando o produto, que está sendo a quantidade está sendo alterada
        Produto produtoDaAtualizacao = null;
        for (int i = 0; i < lista_produto.size(); i++) {
            Produto produto = lista_produto.get(i);
            if (produto.getIdProduto() == codigoProduto) {
                produtoDaAtualizacao = produto;
            }
        }
        //Adicionando o produto, na lista, novamente, com a quantidade exata
        for (int i = 0; i < quantidade; i++) {
            att_compra.getProdutosComprados().add(produtoDaAtualizacao);
        }
        
        //Dando alta no preço, para colocar o preço correto, com a adição da quantidade exta de produtos
        //Calculando o valor a ser adicionado
        float valor_adicionar = (preco_produto*quantidade);
        //Calculando valor final da compra, após a atualização
        float valorFinal_Compra = (valorTotal_compra_comReducao + valor_adicionar);
        //Atualizando valor da compra
        att_compra.setValorDaCompra(valorFinal_Compra);
        
        return att_compra;
        
    }
    
    public static boolean excluirCompra(int codigo){
        
        //Buscando compra
        for (int i = 0; i < lista_compra.size(); i++) {
            if (lista_compra.get(i).getIdCompra() == codigo) {
                //Removendo compra
                lista_compra.remove(i);
                return true;
            }
        }
        
        return false;
        
    }
    
    //Métodos auxiliares (getters & setters)
    public static List<Produto> getLista_Produtos(){
        return lista_produto;
    }
    
}
