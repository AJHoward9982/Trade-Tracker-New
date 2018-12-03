package Main;




import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.DepthTest;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

  public Button addButton;
  public TextField stockTicker;
  public TextField netTradeValue;

  public void addStockPressed() {
    //addButton.setText("HI");      Here To test the button action

    String stv = stockTicker.getText();                   //Gets text from name field
    int ntv = Integer.parseInt(netTradeValue.getText());  //gets int from net field

    AddRow.addRow(stv, ntv);

    ObservableList<Trade> updatedTradeList = GetAllTrades.getAllTrades();
    populateTable(updatedTradeList);

  }


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
  private TableView<Trade> stockTable;

  @FXML
  private void initialize() throws Exception{
    col_date.setCellValueFactory(new PropertyValueFactory<Trade, Date>("date"));
    col_time.setCellValueFactory(new PropertyValueFactory<Trade, Time>("time"));
    col_ticker.setCellValueFactory(new PropertyValueFactory<Trade, String>("ticker"));
    col_net.setCellValueFactory(new PropertyValueFactory<Trade, Integer>("net"));
    ObservableList<Trade> tradeList = GetAllTrades.getAllTrades();
    populateTable(tradeList);

  }

  private void populateTable(ObservableList<Trade> tradeList) {
    stockTable.setItems(tradeList);
  }

  public void deleteButtonPressed(ActionEvent actionEvent) {

    Trade trade = stockTable.getSelectionModel().getSelectedItem();

    Date date = trade.getDate();
    Time time = trade.getTime();

    //System.out.println(date +"-----------------"+ time);

    DeleteSelected.deleteSelected(date,time);

    ObservableList<Trade> updatedTradeList = GetAllTrades.getAllTrades();
    populateTable(updatedTradeList);

  }
}
