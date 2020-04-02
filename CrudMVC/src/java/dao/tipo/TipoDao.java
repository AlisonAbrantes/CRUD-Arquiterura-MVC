/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.tipo;

import conexao.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Tipo;

/**
 *
 * @author profe
 */
public class TipoDao implements ITipodao {

    private static final String SELECT_ALL = "SELECT * FROM tipo where descricao ilike ?;";
    private static final String BUSCAR = "SELECT * FROM tipo WHERE id=?;";

    private Object pstmt;
    private Connection conexao;

    @Override
    public ArrayList<Tipo> listar(Tipo tipo) {

        //cria uma array de obJ Tipo
        ArrayList<Tipo> listaTipo = new ArrayList<Tipo>();

        try {

            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            
            
            pstmt.setString(1, "%" + tipo.getDescricao() + "%");
            
            //executa
            ResultSet rs = pstmt.executeQuery();
            
            

            while (rs.next()) {
                //a cada loop
                Tipo novoTipo = new Tipo();
                novoTipo.setId(rs.getInt("id"));
                novoTipo.setDescricao(rs.getString("descricao"));

                //add na lista
                listaTipo.add(novoTipo);
            }
            return listaTipo;

        } catch (Exception ex) {
            
            return listaTipo;

        } finally {
                       
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void buscar(Tipo tipo) {

        try {
            //Conexao
            conexao = ConectaBanco.getConexao();
            //cria comando SQL
            PreparedStatement pstmt = conexao.prepareStatement(BUSCAR);

            pstmt.setInt(1, tipo.getId());
            //executa
            ResultSet rs = pstmt.executeQuery();

            // como a query ira retornar somente um registro, faremos o NEXT
            rs.next();

            tipo.setDescricao(rs.getString("descricao"));
         

        } catch (Exception e) {

            //
            
        } finally {
            
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(TipoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
