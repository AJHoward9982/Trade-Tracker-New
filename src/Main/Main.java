package Main;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Trade Tracker");
    primaryStage.setScene(new Scene(root, 1000, 600));
    primaryStage.setResizable(false);
    primaryStage.show();
    root.getStylesheets().add("Trade.css");
  }


  public static void main(String[] args) throws Exception {
    getConnection();
    launch(args);

  }

  public static Connection getConnection() {
    try {
      String DATABASE_URL = "jdbc:derby:C:\\Users\\trobi\\OneDrive - Florida Gulf Coast University\\IntelliJ Projects\\Trade Tracker\\lib\\guiDB";

      Connection connection = DriverManager.getConnection(DATABASE_URL);
      System.out.println("Connection Established");
      return connection;
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }
}