package com.jokend.db.pojoAnswers;

public class StatisticAnswer {
    public StatisticAnswer(int vaccinated, int regular, int infected, int died) {
        this.vaccinated = vaccinated;
        this.regular = regular;
        this.infected = infected;
        this.died = died;
    }

    private int vaccinated;
    private int regular;
    private int infected;
    private int died;

    public int getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(int vaccinated) {
        this.vaccinated = vaccinated;
    }

    public int getRegular() {
        return regular;
    }

    public void setRegular(int regular) {
        this.regular = regular;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public int getDied() {
        return died;
    }

    public void setDied(int died) {
        this.died = died;
    }
}
