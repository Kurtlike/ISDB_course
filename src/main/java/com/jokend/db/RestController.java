package com.jokend.db;

import com.jokend.db.db.pojoDBClasses.District;
import com.jokend.db.db.pojoDBClasses.Remedies;
import com.jokend.db.db.pojoDBClasses.Vaccines;
import com.jokend.db.db.pojoDBClasses.Virus;
import com.jokend.db.db.serviceImpls.*;
import com.jokend.db.pojoAnswers.*;
import com.jokend.db.simulation.Simulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private HumansService humansService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private VirusService virusService;
    @Autowired
    private VaccinesService vaccinesService;
    @Autowired
    private RemedyService remedyService;
    @Autowired
    private Simulator simulator;
    @GetMapping(value = "/getViruses")
    public ArrayList<Virus> getViruses(){
        return virusService.getViruses();
    }

    @GetMapping(value = "/getVaccines")
    public ArrayList<Vaccines> getVaccines(){
        return vaccinesService.getVaccines();
    }

    @GetMapping(value = "/getRemedies")
    public ArrayList<Remedies> getRemedies(){
        return remedyService.getRemedies();
    }
    @GetMapping(value = "/getHumanStatistic")
    public StatisticAnswer getHumanStatistic(){
        return new StatisticAnswer(humansService.getVaccinatedHumansCount(), humansService.getRegularPeople(), humansService.getInfectedHumansCount(), humansService.getDiedHuman());
    }
    @GetMapping(value = "/getDate")
    public StringAnswer getDate(){
        return new StringAnswer(simulator.getTime().toLocalDate().toString());
    }
    @GetMapping(value = "/getMapStatistic")
    public ArrayList<DistrictStatisticAnswer> getMapStatistic(){
        ArrayList<DistrictStatisticAnswer> districtsAnswers = new ArrayList<>();
        ArrayList<District> districts = districtService.getDistricts();
        districts.forEach((el)->{
            districtsAnswers.add(new DistrictStatisticAnswer(el.getName(),
                    humansService.getHumansNumberByDistrictAndStatus(el.getName(), "vaccinated"),
                    humansService.getHumansNumberByDistrictAndStatus(el.getName(), "ok"),
                    humansService.getHumansNumberByDistrictAndStatus(el.getName(), "infected"),
                    humansService.getHumansNumberByDistrictAndStatus(el.getName(), "died")));
        });
        return districtsAnswers;
    }
    @PostMapping(value = "/addVirus")
    public void addVirus(@RequestBody Virus virus){
        virusService.addVirus(virus);
    }

    @PostMapping(value = "/addVaccine")
    public void addVirus(@RequestBody Vaccines vaccines){
        vaccinesService.addVaccine(vaccines);
    }

    @PostMapping(value = "/addRemedy")
    public void addRemedy(@RequestBody Remedies remedy){
        remedyService.addRemedy(remedy);
    }

    @PostMapping(value = "/setCurrentRemedy")
    public void setCurrentRemedy(@RequestBody Remedies remedy){
        System.out.println(remedy.getName());
    }

    @PostMapping(value = "/setCurrentCufrew")
    public void setCurrentRemedy(@RequestBody Curfew curfew){
        System.out.println(curfew.getCurfew());
    }

    @GetMapping(value = "/startSimulation")
    public void startSimulation(){
        simulator.startSimulation();
    }
    @PostMapping(value = "/changeSpeed")
    public void startSimulation(@RequestBody IntegerAnswer speed){
        simulator.setSpeed(speed.getValue());
    }
}