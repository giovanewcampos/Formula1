/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class PaisDao {

    public static boolean inserir(String sigla, String nome) {
        String sql = "INSERT INTO pais (sigla, nome) VALUES (?, ?)";
        try {
            PreparedStatement ps = Conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, sigla);
            ps.setString(2, nome);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        boolean resultado = inserir("BR", "Brasil");
        if (resultado){
            JOptionPane.showMessageDialog(null, "Boa meu Consagrado, deu certo!");
        }else{
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static List<String[]> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
