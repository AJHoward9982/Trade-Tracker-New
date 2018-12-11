# Trade-Tracker
The purpose of 'Trade tracker' is to keep a log of all stock trades done

Info stored:
<br/>   *Date of trade
<br/>   *Time of trade
<br/>   *Stock name
<br/>   *Net value of trade
  
The information is stored inside of a Derby database and displayed through a GUI built in JavaFX using the Gluon Scene Builder.

[Guidelines followed](https://docs.google.com/spreadsheets/d/1jENM7TZuNQ6QU18a7-_6MhX7dkCNMOk96_2df9_rvi4/edit?usp=sharing)

# Demo Gif

​![Demo](https://github.com/AJHoward9982/Trade-Tracker-New/blob/master/DEMO-GIF.gif)

# Database Table Example

| | Date | Time | Stock Name | Profit/Loss |
|---------------| ------------- | ------------- | ------------- | ------------- |
|Desc.| Date the trade was made| Time the trade was made  | 5-letter Identifier  | Positive or Negative integer  |
|Ex.| 2018-4-3  | 02:43:12  | ADRW  | 42  |
