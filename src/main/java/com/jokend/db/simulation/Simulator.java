package com.jokend.db.simulation;

import com.jokend.db.db.repos.VaccinationRepo;
import com.jokend.db.db.serviceImpls.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Simulator {
    @Getter
    @Setter
    private int speed = 1;
    @Autowired
    private Curfew curfew;
    @Autowired
    private VirusService virusService;
    @Autowired
    private HumansService humansService;
    @Autowired
    private RemedyService remedyService;
    @Autowired
    private VaccinesService vaccinesService;
    @Autowired
    private VaccinationService vaccinationService;
    public void startSimulation(){

    }
    public void endSimulation(){
        humansService.resetStatuses();
        vaccinesService.deleteAll();
        virusService.deleteAll();
        vaccinationService.deleteAll();
    }

}
