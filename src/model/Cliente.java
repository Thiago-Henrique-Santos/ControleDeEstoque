package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    
    //Criando os atributos
    private Integer idCliente = 0;
    private String nomeCliente;
    private String email;
    private String telefone;
    //Próximos 3 atributos são de endereço
    private int numeroCasa;
    private String rua;
    private String bairro;
    private Float valorTotalGasto = 0f;
    private List<Produto> totalProdutos = new ArrayList<>();
    
    //Métodos getter e setter dos atributos
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Float getValorTotalGasto() {
        return valorTotalGasto;
    }

    public void setValorTotalGasto(Float valorTotalGasto) {
        this.valorTotalGasto = valorTotalGasto;
    }

    public List<Produto> getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(List<Produto> totalProdutos) {
        this.totalProdutos = totalProdutos;
    }
    
    //Métodos add
    public void addAllTotalProduto(List<Produto> totalProdutos){
        this.totalProdutos.addAll(totalProdutos);
    }
    
}
