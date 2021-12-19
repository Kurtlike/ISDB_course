package com.jokend.db.db.pojoDBClasses;


public class Staff {

  private long inn;
  private long placeId;
  private java.sql.Time startTime;
  private java.sql.Time endTime;


  public long getInn() {
    return inn;
  }

  public void setInn(long inn) {
    this.inn = inn;
  }


  public long getPlaceId() {
    return placeId;
  }

  public void setPlaceId(long placeId) {
    this.placeId = placeId;
  }


  public java.sql.Time getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Time startTime) {
    this.startTime = startTime;
  }


  public java.sql.Time getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Time endTime) {
    this.endTime = endTime;
  }

}
