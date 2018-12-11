package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GetAllTrades {

  public static ObservableList<Trade> getAllTrades() {
    String sql = "SELECT * FROM TRADES";
    Connection connection = Main.getConnection();
    try {
      PreparedStatement pst = connection.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      ObservableList<Trade> tradeList = getTradeObjects(rs);
      return tradeList;

    } catch (Exception e) {
      System.out.println(e);
    }

    return null;
  }

  private static ObservableList<Trade> getTradeObjects(ResultSet rs)
      throws ClassNotFoundException, SQLException {

    try {
      ObservableList<Trade> tradeList = FXCollections.observableArrayList();

      while (rs.next()) {
        Trade trd = new Trade();
        trd.setDate(rs.getDate("TRADEDATE"));
        trd.setTime(rs.getTime("TRADETIME"));
        trd.setTicker(rs.getString("TRADETICKER"));
        trd.setNet(rs.getInt("TRADENET"));
        tradeList.add(trd);
      }
      return tradeList;
    } catch (Exception e) {
      System.out.println(e);
      throw e;
    }
  }

}
