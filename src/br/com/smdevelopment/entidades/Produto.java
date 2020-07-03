
package br.com.smdevelopment.entidades;

public class Produto {
    private int codigo;
    private String nome;
    private String categoria;
    private float peso;
    private int unidade;
    private float valor;

    public Produto() {
    }
    
    public Produto(String nome, String categoria, String peso, String unidade, String valor) {
    
        this.nome = nome;
        this.categoria = categoria;
        this.unidade = Integer.parseInt(unidade);
        this.valor = Float.parseFloat(valor);
        this.peso = Float.parseFloat(peso);
        
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
