package com.jokend.db.pojoAnswers;

import lombok.Getter;
import lombok.Setter;

public class StatisticAnswer {
    public StatisticAnswer(long vaccinated, long regular, long infected, long died) {
        this.vaccinated = vaccinated;
        this.regular = regular;
        this.infected = infected;
        this.died = died;
    }
    @Getter
    @Setter
    private long vaccinated;
    @Getter
    @Setter
    private long regular;
    @Getter
    @Setter
    private long infected;
    @Getter
    @Setter
    private long died;

}
