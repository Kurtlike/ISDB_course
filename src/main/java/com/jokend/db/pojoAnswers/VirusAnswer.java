package com.jokend.db.pojoAnswers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VirusAnswer {
    private Integer mortality;
    private Integer incubationPeriod;
    private Integer asymptomaticProb;
    private Integer infectiousness;
}
