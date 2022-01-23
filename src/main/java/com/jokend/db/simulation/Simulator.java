package com.jokend.db.simulation;

import com.jokend.db.db.pojoDBClasses.*;
import com.jokend.db.db.repos.VaccinationRepo;
import com.jokend.db.db.serviceImpls.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Stream;

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
    @Autowired
    private PublicPlaceService placeService;
    @Autowired
    private StaffService staffService;
    //REMOVE
    private Virus testVirus = new Virus();

    public void startSimulation(){
        configTestVirus();
        LocalDateTime time = LocalDateTime.of(2021,1,1,8,0);
        clearTables();
        ArrayList<Humans> humans = humansService.getHumans();
        ArrayList<PublicPlaces> publicPlaces = placeService.getPlaces();

        //main simulation circle
        while(humansService.getDiedHuman().longValue() != humansService.getAllHumansCount().longValue()){
            try {
                while (speed == 0);
                Thread.sleep(10000/speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ArrayList<DangerousPlace> dangerousPlaces = new ArrayList<>();
            java.sql.Time finalTime = java.sql.Time.valueOf(LocalTime.from(time));
            humans.forEach(human->{
                if(human.getStatus().equals("infected")){
                    Integer place = humansService.getPlaceByHumansINNAndTime(human.getInn(), finalTime);
                    ArrayList<Long> humansInDanger = humansService.getHumansINNByPlaceAndTime(place, finalTime);
                    humansInDanger.forEach(humanINN ->{
                        Humans humanInDanger = getHumanByINN(humanINN, humans);
                        if(isInfected(humanInDanger, testVirus, getPublicPlaceById(place, publicPlaces))){
                            humanInDanger.setStatus("infected");
                            //addNewIllnessCreation
                        }
                    });
                }
            });
            time = time.plusMinutes(30);
        }

    }
    private boolean isInfected(Humans human, Virus virus, PublicPlaces place){
        Remedies remedy = remedyService.getRemedy(human.getRemedy());
        District district = districtService.getDistrict(human.getDistrict());
        double res = (virus.getInfectiousness() * place.getAvrTimeVisitor() * place.getCapacity())/(remedy.getEfficiency() * district.getLivingStandard());
        System.out.println(res);
        return true;
    }

    private Humans getHumanByINN(long INN, ArrayList<Humans> humans){
        List<Humans> ans = (List<Humans>) humans.stream().filter(hum -> hum.getInn() == INN);
        return ans.get(0);
    }


    private PublicPlaces getPublicPlaceById(Integer ID, ArrayList<PublicPlaces> publicPlaces){
        List<PublicPlaces> ans = (List<PublicPlaces>) publicPlaces.stream().filter(places -> places.getId() == ID);
        return ans.get(0);
    }

    //REMOVE
    private void configTestVirus(){
        testVirus.setVirusId("test");
        testVirus.setAsymptomaticProb(1);
        testVirus.setIncubationPeriod(10);
        testVirus.setInfectiousness(1);
        testVirus.setMortality(1);
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
