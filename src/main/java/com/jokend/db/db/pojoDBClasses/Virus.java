package com.jokend.db.db.pojoDBClasses;

public class Virus {

  private long virusId;
  private long mortality;
  private long incubationPeriod;
  private long asymptomaticProb;


  public long getVirusId() {
    return virusId;
  }

  public void setVirusId(long virusId) {
    this.virusId = virusId;
  }


  public long getMortality() {
    return mortality;
  }

  public void setMortality(long mortality) {
    this.mortality = mortality;
  }


  public long getIncubationPeriod() {
    return incubationPeriod;
  }

  public void setIncubationPeriod(long incubationPeriod) {
    this.incubationPeriod = incubationPeriod;
  }


  public long getAsymptomaticProb() {
    return asymptomaticProb;
  }

  public void setAsymptomaticProb(long asymptomaticProb) {
    this.asymptomaticProb = asymptomaticProb;
  }

}
