/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class PaisDao {

    public static boolean inserir(String sigla, String nome) {
        String sql = "INSERT INTO pais (sigl, nome) VALUES (?, ?)";
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

    public static boolean alterar(String sigla, String nome) {
        String sql = "UPDATE pais SET nome = ? WHERE sigla = ?";
        try {
            PreparedStatement ps = Conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, sigla);
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /*
        public static void main(String[] args) {
        boolean resultado = inserir("BR", "Brasil");
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Boa meu Consagrado, deu certo!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
    public static void main(String[] args) {
        boolean resultado = alterar("BR", "Brazil");
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Deu certo Piazão!");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena, você falhou!");
        }
    }

*/
   public static List<String[]> consultar() {
        List<String[]> resultados = new ArrayList<>();
        String sql = "SELECT sigla, nome FROM pais";
        PreparedStatement ps;
        try {
            ps = Conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String[] linha = new String[2];
                linha[0] = rs.getString("sigla");
                linha[1] = rs.getString("nome");
                resultados.add(linha);
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(PaisDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
