package com.jokend.db.pojoAnswers;

public class DistrictsAnswer {
    public DistrictsAnswer(String name, int vaccinated, int regular, int infected, int died) {
        this.name = name;
        this.vaccinated = vaccinated;
        this.regular = regular;
        this.infected = infected;
        this.died = died;
    }

    private String name;
    private int vaccinated;
    private int regular;
    private int infected;
    private int died;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
