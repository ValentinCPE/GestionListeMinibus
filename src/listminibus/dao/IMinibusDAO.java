/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listminibus.dao;

import java.sql.Connection;
import java.util.List;
import javax.sql.DataSource;
import listminibus.modele.Minibus;

/**
 *
 * @author valentin
 */
public interface IMinibusDAO {
    public abstract void setDataSource(DataSource ds);
    public abstract void setConnection(Connection c);
    public abstract List<Minibus> getLesMinibus();
}
