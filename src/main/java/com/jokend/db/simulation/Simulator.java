package com.jokend.db.simulation;

import com.jokend.db.db.pojoDBClasses.*;
import com.jokend.db.db.repos.VaccinationRepo;
import com.jokend.db.db.serviceImpls.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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
    @Autowired
    private IllnessService illnessService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private MovingsService movingsService;
    public void startSimulation(){
        clearTables();
        ArrayList<Humans> humans = humansService.getHumans();
        int iter = 0;
        while(humansService.getDiedHuman().longValue() != humansService.getAllHumansCount().longValue()){
            try {
                while (speed == 0);
                Thread.sleep(10000/speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int currIter = iter;
            for(int i = iter; i < iter + 10; i++){
                if(i < humans.size()){
                    humansService.setStatus("died",humans.get(i).getInn());
                    currIter++;
                }
            }
            iter = currIter;

        }

    }
    private boolean isInfected(Humans human, Virus virus, PublicPlaces place){
        Remedies remedy = remedyService.getRemedy(human.getRemedy());
        District district = districtService.getDistrict(human.getDistrict());
        double res = (virus.getInfectiousness() * place.getAvrTimeVisitor() * place.getCapacity())/(remedy.getEfficiency() * district.getLivingStandard());
        System.out.println(res);
        return true;
    }
    private void clearTables(){
        humansService.resetStatuses();
        vaccinesService.deleteAll();
        virusService.deleteAll();
        vaccinationService.deleteAll();
        illnessService.deleteAll();
        movingsService.deleteAll();
    }

}
