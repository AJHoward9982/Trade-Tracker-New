/*
Created by: Andrew Howard
File name: ClearList.java

Clear list Deletes all trades from the Derby Database using a Prepared Statement

This Class is a more simple version of the Delete Class in that there is no need to specify the trade.
 */
package Main;

import static Main.Main.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClearList {

  public static void clearList() {

    try {

      Connection connection = getConnection();

      PreparedStatement added = connection.prepareStatement("delete from TRADES");
      added.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    } finally {
      System.out.println("Clear Completed");
    }

  }
}
