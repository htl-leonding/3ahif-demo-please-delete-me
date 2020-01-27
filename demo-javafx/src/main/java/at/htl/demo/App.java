package at.htl.demo;

import at.htl.demo.jdbc.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JavaFX App
 * @author Thomas W. Stütz
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        DataSource ds = Database.getDatasource();
        try (Connection conn = ds.getConnection()) {
            String sql = "create table test (id int primary key)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       // launch();
    }

}