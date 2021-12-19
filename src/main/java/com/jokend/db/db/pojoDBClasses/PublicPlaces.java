package com.jokend.db.db.pojoDBClasses;


public class PublicPlaces {

  private long id;
  private String pClass;
  private String district;
  private String isWorking;
  private long capacity;
  private long area;
  private long avrTimeVisitor;
  private long avrTimeStaff;
  private long restrictionsLevel;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getpClass() {
    return pClass;
  }

  public void setClass(String pClass) {
    this.pClass = pClass;
  }


  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }


  public String getIsWorking() {
    return isWorking;
  }

  public void setIsWorking(String isWorking) {
    this.isWorking = isWorking;
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


  public long getAvrTimeVisitor() {
    return avrTimeVisitor;
  }

  public void setAvrTimeVisitor(long avrTimeVisitor) {
    this.avrTimeVisitor = avrTimeVisitor;
  }


  public long getAvrTimeStaff() {
    return avrTimeStaff;
  }

  public void setAvrTimeStaff(long avrTimeStaff) {
    this.avrTimeStaff = avrTimeStaff;
  }


  public long getRestrictionsLevel() {
    return restrictionsLevel;
  }

  public void setRestrictionsLevel(long restrictionsLevel) {
    this.restrictionsLevel = restrictionsLevel;
  }

}
