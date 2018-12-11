/*
Created by: Andrew Howard
File name: DeleteSelected.java

Deletes a specified trade from the Derby Database using a SQL Prepared Statement

This Class is more complicated than ClearList as it requires pulling the user selection and
finding it in the Derby Database.

The trade is selected using a where statement to cross reference the date and time
of the trade selected in the table view.

Using the Date and Time of the Trade creates a Pseudo Key assuming that you did not place two trades
at the exact same time on the exact same day.

If you double click this will result in two trades that have the same Date and Time.
This could be fixed by adding a dedicated key per trade that would not be displayed,
but I believe that for a simple application and proof of concept this is a sufficient method.

This will be changed in further iterations
 */
package Main;

import static Main.Main.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

public class DeleteSelected {

  public static void deleteSelected(Date dateToDelete, Time timeToDelete) {
    try {

      Connection connection = getConnection();
      String sql = "DELETE FROM TRADES WHERE TRADEDATE = '" + dateToDelete + "' AND TRADETIME ='"
          + timeToDelete + "'";
      PreparedStatement deleted = connection.prepareStatement(sql);

      deleted.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    } finally {
      System.out.println("Completed");
    }
  }
}
