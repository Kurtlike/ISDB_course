package com.jokend.db.db.pojoDBClasses;

public class PublicTransport {

  private long id;
  private String district1;
  private String district2;
  private String type;
  private long capacity;
  private long area;
  private long period;
  private java.sql.Time startTime;
  private java.sql.Time endTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDistrict1() {
    return district1;
  }

  public void setDistrict1(String district1) {
    this.district1 = district1;
  }


  public String getDistrict2() {
    return district2;
  }

  public void setDistrict2(String district2) {
    this.district2 = district2;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public long getCapacity() {
    return capacity;
  }

  public void setCapacity(long capacity) {
    this.capacity = capacity;
  }


  public long getArea() {
    return area;
  }

  public void setArea(long area) {
    this.area = area;
  }


  public long getPeriod() {
    return period;
  }

  public void setPeriod(long period) {
    this.period = period;
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
