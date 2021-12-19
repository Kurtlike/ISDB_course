package com.jokend.db.db.pojoDBClasses;


public class Vaccination {

  private long vaccineId;
  private long inn;
  private java.sql.Timestamp date;


  public long getVaccineId() {
    return vaccineId;
  }

  public void setVaccineId(long vaccineId) {
    this.vaccineId = vaccineId;
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
