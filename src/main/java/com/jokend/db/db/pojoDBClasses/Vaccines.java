package com.jokend.db.db.pojoDBClasses;


public class Vaccines {

  private long virusId;
  private long vaccineId;
  private long maxAge;
  private long efficiency;


  public long getVirusId() {
    return virusId;
  }

  public void setVirusId(long virusId) {
    this.virusId = virusId;
  }


  public long getVaccineId() {
    return vaccineId;
  }

  public void setVaccineId(long vaccineId) {
    this.vaccineId = vaccineId;
  }


  public long getMaxAge() {
    return maxAge;
  }

  public void setMaxAge(long maxAge) {
    this.maxAge = maxAge;
  }


  public long getEfficiency() {
    return efficiency;
  }

  public void setEfficiency(long efficiency) {
    this.efficiency = efficiency;
  }

}
