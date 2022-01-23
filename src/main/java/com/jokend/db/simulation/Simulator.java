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
        ArrayList<Staff> staff = staffService.getStaff();

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
            LocalDateTime finalTime1 = time;
            humans.forEach(human->{
                if(!human.getStatus().equals("dead")) {
                    if (human.getStatus().equals("infected") /*add incubation time check*/) {
                        Integer place = humansService.getPlaceByHumansINNAndTime(human.getInn(), finalTime);
                        if(place != null) {
                            ArrayList<Long> humansInDanger = humansService.getHumansINNByPlaceAndTime(place, finalTime);
                            humansInDanger.forEach(humanINN -> {
                                Humans humanInDanger = humansService.getHuman(humanINN);
                                if (humanInDanger.getStatus().equals("ok") && isInfected(humanInDanger, testVirus, getPublicPlaceById(place, publicPlaces))) {
                                    humanInDanger.setStatus("infected");
                                    //addNewIllnessCreation
                                }
                            });
                        }
                    }
                    if (getStaffByINN(human.getInn(), staff).getStartTime().equals(java.sql.Time.valueOf(LocalTime.from(finalTime1.plusMinutes(30))))) {
                        //addMoving();
                    }
                }
            });
            time = time.plusMinutes(30);
        }

    }
    private boolean isInfected(Humans human, Virus virus, PublicPlaces place){
        Remedies remedy = remedyService.getRemedy(human.getRemedy());
        District district = districtService.getDistrict(human.getDistrict());
        double res = (virus.getInfectiousness() * place.getAvrTimeVisitor() * place.getCapacity())/(place.getArea() * remedy.getEfficiency() * district.getLivingStandard());
        System.out.println(res);
        return true;
    }

    private PublicPlaces getPublicPlaceById(Integer ID, ArrayList<PublicPlaces> publicPlaces){
        List<PublicPlaces> ans = (List<PublicPlaces>) publicPlaces.stream().filter(places -> places.getId() == ID);
        return ans.get(0);
    }

    private Staff getStaffByINN(long INN, ArrayList<Staff> staff){
        List<Staff> ans = (List<Staff>) staff.stream().filter(stf -> stf.getInn() == INN);
        return ans.get(0);
    }

    //REMOVE
    private void configTestVirus(){
        testVirus.setVirusId("1");
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
