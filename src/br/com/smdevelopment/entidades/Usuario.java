
package br.com.smdevelopment.entidades;

import br.com.smdevelopment.tratamento.RetirarCaracteres;

public class Usuario {
    
    private int id;
    private String nome;
    private byte[] imagem;
    private String email;
    private String telefone;
    private String cpf;
    private String usuario;
    private String senha;

    public Usuario() {
    }
    
    public Usuario(String usuario, String senha){

        this.usuario = usuario;
        this.senha = senha;
        
    }
    
    public Usuario(String nome, byte[] imagem, String email,String telefone, String cpf,
            String usuario, String senha){

        this.nome = nome;
        this.imagem = imagem;
        this.email = email;
        this.cpf = RetirarCaracteres.retirarCaracteresEspesciais(cpf);
        this.telefone = RetirarCaracteres.retirarCaracteresEspesciais(telefone);
        this.usuario = usuario;
        this.senha = senha;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
