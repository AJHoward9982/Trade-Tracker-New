/*
Created by: Andrew Howard
File name: Main.java

The purpose of 'Trade tracker' is to keep a log of all stock trades done

Info stored:
*Date of trade
*Time of trade
*Stock name
*Net value of trade

The information is stored inside of a Derby database and displayed through a GUI built in JavaFX using the Gluon Scene Builder.

 */
package Main;

import java.sql.Connection;
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
    primaryStage.setScene(new Scene(root, 1000, 600));   //setting startup resolution
    primaryStage.setResizable(false);                                 //disable scaling
    root.getStylesheets().add("Trade.css");                           //Call to css document
    primaryStage.show();
  }


  public static void main(String[] args) throws Exception {
    getConnection();
    launch(args);

  }


  /*
  Tests to ensure a connection to the database
   */
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