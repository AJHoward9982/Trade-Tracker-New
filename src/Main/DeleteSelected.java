package Main;

import static Main.Main.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

public class DeleteSelected {
  public static void deleteSelected(Date dateToDelete , Time timeToDelete){
    try {

      Connection connection = getConnection();
      String sql = "DELETE FROM TRADES WHERE TRADEDATE = '" + dateToDelete + "' AND TRADETIME ='" + timeToDelete + "'";
      PreparedStatement deleted = connection.prepareStatement(sql);

      deleted.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    } finally {
      System.out.println("Completed");
    }
  }
}
