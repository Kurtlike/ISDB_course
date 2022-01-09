package com.jokend.db;

import com.jokend.db.db.pojoDBClasses.Remedies;
import com.jokend.db.db.pojoDBClasses.Vaccines;
import com.jokend.db.db.pojoDBClasses.Virus;
import com.jokend.db.db.serviceImpls.HumansServiceImpl;
import com.jokend.db.db.serviceImpls.RemedyServiceImpl;
import com.jokend.db.db.serviceImpls.VaccinesServiceImpl;
import com.jokend.db.db.serviceImpls.VirusServiceImpl;
import com.jokend.db.pojoAnswers.Curfew;
import com.jokend.db.pojoAnswers.DistrictStatisticAnswer;
import com.jokend.db.pojoAnswers.StatisticAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private HumansServiceImpl humansService;
    @Autowired
    private VirusServiceImpl virusService;
    @Autowired
    private VaccinesServiceImpl vaccinesService;
    @Autowired
    private RemedyServiceImpl remedyService;
    int tic = 6;
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
        tic+=3;
        return new StatisticAnswer(2L *tic,humansService.getRegularPeople(),tic* 2L, humansService.getDiedHuman());
    }
    @GetMapping(value = "/getMapStatistic")
    public ArrayList<DistrictStatisticAnswer> getMapStatistic(){
        ArrayList<DistrictStatisticAnswer> districtsAnswers = new ArrayList<>();
        districtsAnswers.add(new DistrictStatisticAnswer("A0", tic*10,11000/3 -tic,tic/3,0));
        districtsAnswers.add(new DistrictStatisticAnswer("B0", tic*2/3,9000/3 -tic,tic*2/3,tic/3));
        districtsAnswers.add(new DistrictStatisticAnswer("C0", tic/3,8000/3 -tic,tic*2/3,10*tic));
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
}