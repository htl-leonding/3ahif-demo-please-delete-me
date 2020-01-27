package at.htl.demo.jdbc;

import org.apache.derby.jdbc.ClientDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public static DataSource getDatasource() {
        ClientDataSource dataSource = new ClientDataSource();
        dataSource.setDatabaseName("db");
        dataSource.setUser("app");
        dataSource.setPassword("app");
        return dataSource;
    }

    public void foo() {
        DataSource ds = getDatasource();
        try (Connection conn = ds.getConnection()) {
            String sql = "select xy from yz where name = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "Hansi");
                ResultSet rs = ps.executeQuery();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
