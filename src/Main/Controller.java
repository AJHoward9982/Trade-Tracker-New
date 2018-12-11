/*
Created by: Andrew Howard
File name: Controller.java

Controls the JavaFX scene using Action Events

Connects button events to actions such as "DeleteSelected" and "ClearList"

 */
package Main;

import java.sql.Date;
import java.sql.Time;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Controller {

  public Button addButton;
  public TextField stockTicker;
  public TextField netTradeValue;

  /*
  Gets the Text and Int values in the Text Fields
  Uses them to enter data into the Derby Database by using the AddRow class
   */
  public void addStockPressed() {
    //addButton.setText("HI");      Here To test the button action

    String stv = stockTicker.getText();                   //Gets text from name field
    int ntv = Integer.parseInt(netTradeValue.getText());  //gets int from net field

    AddRow.addRow(stv, ntv);

    ObservableList<Trade> updatedTradeList = GetAllTrades.getAllTrades();
    populateTable(updatedTradeList);

  }

  /*
  Deletes all entries from the Derby Database by using the ClearList class
   */
  public void clearListPressed() {
    ClearList.clearList();

    ObservableList<Trade> updatedTradeList = GetAllTrades.getAllTrades();
    populateTable(updatedTradeList);
  }


  @FXML
  private Button deleteButton;
  @FXML
  private TableColumn<Trade, Date> col_date;
  @FXML
  private TableColumn<Trade, Time> col_time;
  @FXML
  private TableColumn<Trade, String> col_ticker;
  @FXML
  private TableColumn<Trade, Integer> col_net;

  @FXML
  private ColorPicker colorPicker;
  @FXML
  private GridPane backdrop;

  @FXML
  private TableView<Trade> stockTable;

  @FXML
  private void initialize() throws Exception {
    col_date.setCellValueFactory(new PropertyValueFactory<Trade, Date>("date"));
    col_time.setCellValueFactory(new PropertyValueFactory<Trade, Time>("time"));
    col_ticker.setCellValueFactory(new PropertyValueFactory<Trade, String>("ticker"));
    col_net.setCellValueFactory(new PropertyValueFactory<Trade, Integer>("net"));
    ObservableList<Trade> tradeList = GetAllTrades.getAllTrades();
    populateTable(tradeList);

  }

  /*
  Displays all of the Derby Table entries in a JavaFX TableView

  Gets run after Add,Delete,and ClearList are pressed to update the table to show the new values.
   */
  private void populateTable(ObservableList<Trade> tradeList) {
    stockTable.setItems(tradeList);
  }

  /*
  Calls the DeleteSelected Class to remove the highlighted entry from the Derby Database
   */
  public void deleteButtonPressed(ActionEvent actionEvent) {

    Trade trade = stockTable.getSelectionModel().getSelectedItem();

    Date date = trade.getDate();
    Time time = trade.getTime();

    //System.out.println(date +"-----------------"+ time);

    DeleteSelected.deleteSelected(date, time);

    ObservableList<Trade> updatedTradeList = GetAllTrades.getAllTrades();
    populateTable(updatedTradeList);

  }

  /*
  Changes the backdrop color as decided by the color picker selection
   */
  public void changeColor(ActionEvent actionEvent) {
    Color color = colorPicker.getValue();
    backdrop.setStyle(
        "-fx-background-color: " + String.format("#%02X%02X%02X", (int) (color.getRed() * 255),
            (int) (color.getGreen() * 255), (int) (color.getBlue() * 255)));
  }
}
