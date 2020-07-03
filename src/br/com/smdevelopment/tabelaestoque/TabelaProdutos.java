
package br.com.smdevelopment.tabelaestoque;

import br.com.smdevelopment.dao.ModuloConexao;
import br.com.smdevelopment.entidades.Produto;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TabelaProdutos {
    
    private int unidade;
    private float valor;
    private float peso;
    DefaultTableModel tabelaMod;
    
    public void mostrarDados(JTable tblProdutos){
        
        ModuloConexao mod = new ModuloConexao();
        tabelaMod = (DefaultTableModel) tblProdutos.getModel();
        for(Produto produto: mod.listarProduto()){
        tabelaMod.addRow(new Object[]{
        produto.getCodigo(),
        produto.getNome(),
        produto.getCategoria(),
        produto.getPeso(),
        produto.getUnidade(),
        produto.getValor()
        });
        }
    }
    
    public void inserirDados(JTable tblProdutos, String nome, String categoria, String peso, String unidade, String valor){
        
        this.unidade = Integer.parseInt(unidade);
        this.valor = Float.parseFloat(valor);
        this.peso = Float.parseFloat(peso);
        try {
            Connection con = ModuloConexao.conectar();
            String sql 
                    = "insert into produtos(nome, categoria, peso, unidade, preco) values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, nome);
            pst.setString(2, categoria);
            pst.setFloat(3, this.peso);
            pst.setInt(4, this.unidade);
            pst.setFloat(5, this.valor);
            pst.executeUpdate();
            
            tabelaMod = (DefaultTableModel) tblProdutos.getModel();
            
            tabelaMod.addRow(new Object[]{nome, categoria, peso, unidade, valor});
            
            JOptionPane.showMessageDialog(null, "Produto cadastrado!");
            
        } catch (SQLException ex) {
            Logger.getLogger(TabelaProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
