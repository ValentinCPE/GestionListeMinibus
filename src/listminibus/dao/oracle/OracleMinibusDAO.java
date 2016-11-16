/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listminibus.dao.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import listminibus.dao.IMinibusDAO;
import listminibus.modele.Minibus;

/**
 *
 * @author valentin
 */
public class OracleMinibusDAO implements IMinibusDAO{
    private static DataSource datas;
    private static Connection connexionBD;
    
    @Override
    public void setDataSource(DataSource ds) {
        this.datas = ds;
    }

    @Override
    public void setConnection(Connection c) {
        this.connexionBD = c;
    }

    @Override
    public List<Minibus> getLesMinibus() {
        ResultSet rset = null;
        Statement stmt = null;
        List<Minibus> listeMinibus = null;
        try{
            stmt = connexionBD.createStatement();
            listeMinibus = new ArrayList<>();
            rset = stmt.executeQuery("SELECT * FROM MINIBUS");
            while(rset.next()){
                listeMinibus.add(new Minibus(rset.getInt("NOMINIBUS"),rset.getInt("CAPACITE")));
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }finally{
            try{
                if(stmt!=null){
                    stmt.close();
                }
                if(rset!=null){
                    rset.close();
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
        }
        return listeMinibus;
    }

    @Override
    public void creerMinibus(int num, int cap) {
        PreparedStatement pstm = null;
        try{
            pstm = connexionBD.prepareStatement("INSERT INTO MINIBUS VALUES(?,?)");
            pstm.setInt(1, num);
            pstm.setInt(2, cap);
            pstm.executeUpdate();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }finally{
            try {
                pstm.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    public void supprimerMinibus(int num) {
        PreparedStatement pstm = null;
        try{
            pstm = connexionBD.prepareStatement("DELETE FROM MINIBUS WHERE NOMINIBUS=?");
            pstm.setInt(1, num);
            pstm.executeUpdate();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    
}
