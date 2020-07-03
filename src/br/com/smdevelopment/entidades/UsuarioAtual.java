
package br.com.smdevelopment.entidades;

public class UsuarioAtual {
    
    private static int id;
    private static String nome;
    private static byte[] imagem;
    private static String email;
    private static String telefone;
    private static String cpf;
    private static String usuario;
    private static String senha;

    public UsuarioAtual() {
    }
    
    public UsuarioAtual(String usuario, String senha){

        UsuarioAtual.usuario = usuario;
        UsuarioAtual.senha = senha;
        
    }
    
    public UsuarioAtual(String nome, byte[] imagem, String email,String telefone, String cpf,
            String usuario, String senha){

        UsuarioAtual.nome = nome;
        UsuarioAtual.imagem = imagem;
        UsuarioAtual.email = email;
        UsuarioAtual.cpf = cpf;
        UsuarioAtual.telefone = telefone;
        UsuarioAtual.usuario = usuario;
        UsuarioAtual.senha = senha;
        
    }

    public static byte[] getImagem() {
        return imagem;
    }

    public static void setImagem(byte[] imagem) {
        UsuarioAtual.imagem = imagem;
    }
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UsuarioAtual.id = id;
    }

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        UsuarioAtual.nome = nome;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        UsuarioAtual.email = email;
    }

    public static String getCpf() {
        return cpf;
    }

    public static void setCpf(String cpf) {
        UsuarioAtual.cpf = cpf;
    }

    public static String getTelefone() {
        return telefone;
    }

    public static void setTelefone(String telefone) {
        UsuarioAtual.telefone = telefone;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        UsuarioAtual.usuario = usuario;
    }

    public static String getSenha() {
        return senha;
    }

    public static void setSenha(String senha) {
        UsuarioAtual.senha = senha;
    }
    
    
    
}
