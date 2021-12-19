package com.jokend.db.db.pojoDBClasses;


public class Humans {

  private long inn;
  private String status;
  private java.sql.Timestamp birthday;
  private String district;
  private String remedy;


  public long getInn() {
    return inn;
  }

  public void setInn(long inn) {
    this.inn = inn;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public java.sql.Timestamp getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Timestamp birthday) {
    this.birthday = birthday;
  }


  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }


  public String getRemedy() {
    return remedy;
  }

  public void setRemedy(String remedy) {
    this.remedy = remedy;
  }

}
