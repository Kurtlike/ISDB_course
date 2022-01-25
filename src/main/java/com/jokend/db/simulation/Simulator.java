package com.jokend.db.simulation;

import com.jokend.db.db.pojoDBClasses.*;
import com.jokend.db.db.repos.VaccinationRepo;
import com.jokend.db.db.serviceImpls.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.sql.Time;
import java.sql.Timestamp;
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
    private int speed = 10000;
    @Autowired
    private Curfew curfew;
    @Autowired
    private VirusService virusService;
    @Autowired
    private HumansService humansService;
    @Autowired
    private FamiliesService familiesService;
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
    private PublicTransportService transportService;
    @Autowired
    private StaffService staffService;
    @Getter
    LocalDateTime time = LocalDateTime.of(2021,1,1,8,0);
    //REMOVE
    private Virus testVirus = new Virus();

    public void startSimulation(){
        clearTables();
        configTestVirus();
        virusService.addVirus(testVirus);
        time = LocalDateTime.of(2021,1,1,8,0);
        ArrayList<Humans> humans = humansService.getHumans();
        ArrayList<PublicTransport> transports = transportService.getTransport();
        ArrayList<PublicPlaces> publicPlaces = placeService.getPlaces();
        ArrayList<Staff> staff = staffService.getStaff();
        ArrayList<Illness> illnesses = new ArrayList<>();
        humans.get(1).setStatus("infected");
        humansService.setStatus("infected", humans.get(1).getInn());
        illnesses.add(createIllness(time, Long.parseLong(testVirus.getVirusId()), humans.get(1).getInn(), -1, Long.valueOf(-1), "incubation"));
        //main simulation circle
        while(humansService.getDiedHuman().longValue() != humansService.getAllHumansCount().longValue()){
            try {
                while (speed == 0);
                Thread.sleep(10000/speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ArrayList<Movings> moves = new ArrayList<>();
            ArrayList<DangerousPlace> dangerousPlaces = new ArrayList<>();
            java.sql.Time finalTime = java.sql.Time.valueOf(LocalTime.from(time));
            LocalDateTime finalTime1 = time;
            humans.forEach(human->{
                if(!human.getStatus().equals("dead")) {
                    Staff presPerson = getStaffByINN(human.getInn(), staff);
                    Movings move = new Movings();
                    if (presPerson != null && (presPerson.getStartTime().equals(java.sql.Time.valueOf(LocalTime.from(finalTime1.plusMinutes(30)))) || presPerson.getEndTime().equals(java.sql.Time.valueOf(LocalTime.from(finalTime1))))) {
                        if(!human.getDistrict().equals(getPublicPlaceById(presPerson.getPlaceId(), publicPlaces).getDistrict())) {
                            PublicTransport trans = getPublicTransport(human.getDistrict(), getPublicPlaceById(presPerson.getPlaceId(), publicPlaces).getDistrict(), transports);
                            move.setPublicTransport(trans.getId());
                            move.setInn(human.getInn());
                            move.setDate(Timestamp.valueOf(finalTime1.plusMinutes(trans.getPeriod() * Math.round(30 / trans.getPeriod()))));
                            moves.add(move);
                            //movingService.add(move);
                        }
                    }
                    if (contagiousCheck(human, illnesses)) {
                        //System.out.println("Жертвы человека с ИНН " + human.getInn() + ":");
                        Long place = humansService.getPlaceByHumansINNAndTime(human.getInn(), finalTime);
                        if(place != null) {
                            ArrayList<Long> humansInDanger = humansService.getHumansINNByPlaceAndTime(place, finalTime);
                            humansInDanger.forEach(humanINN -> {
                                Humans humanInDanger = getHuman(humanINN, humans);
                                if (humanInDanger.getStatus().equals("ok") && isInfected(humanInDanger, testVirus, getPublicPlaceById(place, publicPlaces))) {
                                    humanInDanger.setStatus("infected");
                                    humansService.setStatus("infected", humanINN);
                                    Long virusId = findVirusId(human, illnesses);
                                    illnesses.add(createIllness(finalTime1, virusId, humanInDanger.getInn(), human.getInn(), place, "incubation"));
                                    System.out.println("\tЗаражён на работе: " + humanINN);
                                }
                            });
                        }else if (presPerson != null && !presPerson.getStartTime().equals(java.sql.Time.valueOf(LocalTime.from(finalTime1.plusMinutes(30)))) && !presPerson.getEndTime().equals(java.sql.Time.valueOf(LocalTime.from(finalTime1)))){
                            ArrayList<Long> humansInDanger = familiesService.getFamiliesMembersById(familiesService.getFamiliesByINN(presPerson.getInn()).getId());
                            humansInDanger.forEach(humanINN -> {
                                Humans humanInDanger = getHuman(humanINN, humans);
                                if (humanInDanger.getStatus().equals("ok") && isInfected(humanInDanger, testVirus)) {
                                    humanInDanger.setStatus("infected");
                                    humansService.setStatus("infected", humanINN);
                                    Long virusId = findVirusId(human, illnesses);
                                    illnesses.add(createIllness(finalTime1, virusId, humanInDanger.getInn(), human.getInn(), Long.valueOf(-1), "incubation"));
                                    System.out.println("\tЗаражён в семье: " + humanINN);
                                    //addNewIllnessCreation
                                }
                            });
                        }
                    }
                }
            });
            moves.forEach(move -> {
                if(contagiousCheck(getHuman(move.getInn(), humans), illnesses)){
                    ArrayList<Long> humansInDanger = getDangerBus(move, moves);
                    humansInDanger.forEach(humanINN -> {
                        Humans humanInDanger = getHuman(humanINN, humans);
                        if (humanInDanger.getStatus().equals("ok") && isInfected(humanInDanger, testVirus)) {
                            humanInDanger.setStatus("infected");
                            humansService.setStatus("infected", humanINN);
                            Long virusId = findVirusId(getHuman(move.getInn(), humans), illnesses);
                            illnesses.add(createIllness(finalTime1, virusId, humanInDanger.getInn(), move.getInn(), Long.valueOf(-1), "incubation"));
                            System.out.println("\tЗаражён в транспорте: " + humanINN);
                            //addNewIllnessCreation
                        }
                    });
                }
            });
            illnesses.forEach(illness -> {
                if(illness.getStatus().equals("incubation") && Timestamp.valueOf((finalTime1.minusDays(testVirus.getIncubationPeriod()))).getTime() > (illness.getDateOfInfection()).getTime()){
                    illness.setStatus("contagious");
                }
                if(illness.getStatus().equals("contagious") && Timestamp.valueOf((finalTime1.minusDays(testVirus.getIncubationPeriod() * 3))).getTime() > (illness.getDateOfInfection()).getTime()){
                    if(Math.random() > 0.1 * testVirus.getMortality()){
                        getHuman(illness.getInnInjured(), humans).setStatus("ok");
                        illness.setStatus("healthy");
                        humansService.setStatus("ok", illness.getInnInjured());
                    }else{
                        getHuman(illness.getInnInjured(), humans).setStatus("died");
                        illness.setStatus("died");
                        humansService.setStatus("died", illness.getInnInjured());
                    }
                }
            });
            time = time.plusMinutes(30);
            System.out.println(time.toString());
        }

    }

    private Illness createIllness(LocalDateTime finalTime, Long virusId, long inn, long inn1, Long place, String status) {
        Illness ans = new Illness();
        ans.setStatus(status);
        ans.setDateOfInfection(Timestamp.valueOf(finalTime));
        ans.setVirusId(virusId);
        ans.setInnInjured(inn);
        ans.setInnCarrier(inn1);
        ans.setPlaceTransmission(place);
        return ans;
    }

    private Long findVirusId(Humans human, ArrayList<Illness> illnesses) {
        Long ans = new Long(0);
        for(Illness check : illnesses){
            if(check.getInnCarrier() == human.getInn()){
                return check.getVirusId();
            }
        }
        return ans;
    }

    private boolean contagiousCheck(Humans human, ArrayList<Illness> illnesses){
        try {
            return human.getStatus().equals("infected") && getIllness(human, illnesses).getStatus().equals("contagious");
        }catch (NullPointerException e){
            return false;
        }
    }

    private Illness getIllness(Humans human, ArrayList<Illness> illnesses) {
        for(Illness ans : illnesses){
            if(ans.getInnInjured() == human.getInn()){
                return ans;
            }
        }
        return null;
    }

    private ArrayList<Long> getDangerBus(Movings move, ArrayList<Movings> moves) {
        ArrayList<Long> ans = new ArrayList<>();
        for(Movings check : moves){
            if(check.getDate().equals(move.getDate()) && check.getPublicTransport() == move.getPublicTransport()){
                ans.add(check.getInn());
            }
        }
        return ans;
    }

    private boolean isInfected(Humans human, Virus virus) {
        return Math.random() < 0.01;
    }

    private boolean isInfected(Humans human, Virus virus, PublicPlaces place){
        //Remedies remedy = remedyService.getRemedy(human.getRemedy());
        District district = districtService.getDistrict(human.getDistrict());
        //double res = (virus.getInfectiousness() * /*place.getAvrTimeVisitor() **/ place.getCapacity())/(place.getArea() * /*remedy.getEfficiency() **/ district.getLivingStandard());
        //System.out.println(res);
        return Math.random() < 0.01;
    }

    private PublicPlaces getPublicPlaceById(Long ID, ArrayList<PublicPlaces> publicPlaces){
        for(PublicPlaces ans : publicPlaces){
            if(ans.getId() == ID){
                return ans;
            }
        }
        return null;
    }

    private PublicTransport getPublicTransport(String Dis1, String Dis2, ArrayList<PublicTransport> publicTransports){
        for(PublicTransport ans : publicTransports){
            System.out.println(ans.getDistrict_1() + " " + ans.getDistrict_2());
            if((ans.getDistrict_1().equals(Dis1) && ans.getDistrict_2().equals(Dis2))||(ans.getDistrict_2().equals(Dis1) && ans.getDistrict_1().equals(Dis2))){
                return ans;
            }
        }
        return null;
    }

    private Staff getStaffByINN(long INN, ArrayList<Staff> staff){
        for(Staff ans : staff){
            if(ans.getInn() == INN){
                return ans;
            }
        }
        return null;
    }

    private Humans getHuman(long INN, ArrayList<Humans> humans){
        for(Humans ans : humans){
            if(ans.getInn() == INN){
                return ans;
            }
        }
        return null;
    }

    //REMOVE
    private void configTestVirus(){
        testVirus.setVirusId("1");
        testVirus.setAsymptomaticProb(1);
        testVirus.setIncubationPeriod(1);
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
