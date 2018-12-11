/*
Created by: Andrew Howard
File name: AddRow.java

Uses a SQL prepared statement to add a trade into the Derby Database.

Pulls Name and Net from Text Fields

Date and Time are acquired by the LocalDate.now() and LocalTime.not() methods; Both from the SQL Library
 */
package Main;

import static Main.Main.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


public class AddRow {


  public static void addRow(String stockTicker, int netTradeValue) {

    LocalDate date = LocalDate.now();
    Date dateSQL = Date.valueOf(date);

    LocalTime time = LocalTime.now();
    Time timeSQL = Time.valueOf(time);

    try {

      Connection connection = getConnection();

      PreparedStatement added = connection.prepareStatement(
          "INSERT INTO TRADES (TRADEDATE, TRADETIME, TRADETICKER, TRADENET) VALUES (?,?,?,?)");

      added.setDate(1, dateSQL);
      added.setTime(2, timeSQL);
      added.setString(3, stockTicker);
      added.setInt(4, netTradeValue);

      added.executeUpdate();

    } catch (Exception e) {
      System.out.println(e);
    } finally {
      System.out.println("Completed");
    }

  }
}