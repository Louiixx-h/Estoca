
package br.com.smdevelopment.dao;
import br.com.smdevelopment.entidades.Produto;
import br.com.smdevelopment.entidades.Usuario;
import br.com.smdevelopment.entidades.UsuarioAtual;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModuloConexao {
    
        
    private static Connection con = null;

    private static final String URL = "jdbc:mysql://localhost:3306/loja";
    private static final String USR = "root";
    private static final String PASS = "";
    
    public static Connection conectar() throws SQLException{

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USR, PASS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return con;
    }
    
    public static boolean logar(UsuarioAtual usrAtual){
        
            String sql = "select * from usuario where nome_usuario=? and senha=?";
            boolean temUser = false;
        
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(sql);
        
            pst.setString(1, usrAtual.getUsuario());
            pst.setString(2, usrAtual.getSenha());
            
            ResultSet rs = pst.executeQuery();
            
      
            while(rs.next()){
                usrAtual.setId(rs.getInt("id_usuario"));
                usrAtual.setNome(rs.getString("nome"));
                usrAtual.setImagem(rs.getBytes("foto_usuario"));
                usrAtual.setEmail(rs.getString("email"));
                usrAtual.setTelefone(rs.getString("telefone"));
                usrAtual.setCpf(rs.getString("cpf"));
                usrAtual.setUsuario(rs.getString("nome_usuario"));
                usrAtual.setSenha(rs.getString("senha"));
                System.out.println(rs.getInt("id_usuario"));
                temUser = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
            temUser = false;
        }
        
        if(!temUser){
            
            JOptionPane.showMessageDialog(null, "Os campos estão incorretos!");
            
        }
        
        return temUser;
    }
    
    public static boolean cadastrar(Usuario usr){
        boolean enviado = false;
        try {
            Connection con = conectar();
            String sql =
                    "insert into usuario(nome, foto_usuario, email, telefone, cpf, nome_usuario, senha)"
                    + "values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            if(usr.getNome().equals("") || usr.getCpf().equals("") || usr.getUsuario().equals("") || usr.getSenha().equals("")){
                JOptionPane.showMessageDialog(null, "Preencha os campos vazios");
                enviado = false;
            }else {
                
                pst.setString(1, usr.getNome());
                pst.setBytes(2, usr.getImagem());
                pst.setString(3, usr.getEmail());
                pst.setString(4, usr.getTelefone());
                pst.setString(5, usr.getCpf());
                pst.setString(6, usr.getUsuario());
                pst.setString(7, usr.getSenha());

                pst.executeUpdate();
                enviado = true;
                
                JOptionPane.showMessageDialog(null, "Cadastro realizados com sucesso!");
        
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
            enviado = false;
        }
        
        return enviado;
    }
    
    public List<Produto> listarProduto(){
        
        Connection con;
        List<Produto> produtos = new ArrayList<>();
        ResultSet rs;
        
        try {
            con = conectar();
            String sql = "select * from produtos";
            PreparedStatement pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("cod_produto"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setPeso(rs.getFloat("peso"));
                produto.setUnidade(rs.getInt("unidade"));
                produto.setValor(rs.getFloat("preco"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModuloConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produtos;
    }
    
}
