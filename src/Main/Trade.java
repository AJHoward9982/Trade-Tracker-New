/*
Created by: Andrew Howard
File name: Trade.java

Defines the trade object
When a trade is pulled from the Derby Database, this is what interprets it to be placed into the table
 */
package Main;

import java.sql.Date;
import java.sql.Time;

public class Trade {

  private Date date;
  private Time time;
  private String ticker;
  private Integer net;

  public Trade() {

  }

  public Trade(Date date, Time time, String ticker, Integer net) {
    this.date = date;
    this.time = time;
    this.ticker = ticker;
    this.net = net;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Time getTime() {
    return time;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  public Integer getNet() {
    return net;
  }

  public void setNet(Integer net) {
    this.net = net;
  }
}
