package com.jokend.db.db.pojoDBClasses;


public class Movings {

  private long publicTransport;
  private long inn;
  private java.sql.Timestamp date;


  public long getPublicTransport() {
    return publicTransport;
  }

  public void setPublicTransport(long publicTransport) {
    this.publicTransport = publicTransport;
  }


  public long getInn() {
    return inn;
  }

  public void setInn(long inn) {
    this.inn = inn;
  }


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }

}
