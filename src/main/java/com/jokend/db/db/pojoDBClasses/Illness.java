package com.jokend.db.db.pojoDBClasses;

public class Illness {

  private long id;
  private java.sql.Timestamp dateOfInfection;
  private long virusId;
  private long innInjured;
  private long innCarrier;
  private long placeTransmission;
  private String status;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public java.sql.Timestamp getDateOfInfection() {
    return dateOfInfection;
  }

  public void setDateOfInfection(java.sql.Timestamp dateOfInfection) {
    this.dateOfInfection = dateOfInfection;
  }


  public long getVirusId() {
    return virusId;
  }

  public void setVirusId(long virusId) {
    this.virusId = virusId;
  }


  public long getInnInjured() {
    return innInjured;
  }

  public void setInnInjured(long innInjured) {
    this.innInjured = innInjured;
  }


  public long getInnCarrier() {
    return innCarrier;
  }

  public void setInnCarrier(long innCarrier) {
    this.innCarrier = innCarrier;
  }


  public long getPlaceTransmission() {
    return placeTransmission;
  }

  public void setPlaceTransmission(long placeTransmission) {
    this.placeTransmission = placeTransmission;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
