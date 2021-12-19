package com.jokend.db;

import com.jokend.db.db.serviceImpls.HumansServiceImpls;
import com.jokend.db.pojoAnswers.DistrictsAnswer;
import com.jokend.db.pojoAnswers.StatisticAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@CrossOrigin
@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private HumansServiceImpls humansService;
    int tic = 6;
    @GetMapping(value = "/getViruses")
    public ArrayList<String> getViruses(){
        ArrayList<String> viruses= new ArrayList<>();
        viruses.add("c_19");
        viruses.add("c_20");
        viruses.add("cs_1");
        return viruses;
    }

    @GetMapping(value = "/getVaccines")
    public ArrayList<String> getVaccines(){
        ArrayList<String> vaccines= new ArrayList<>();
        vaccines.add("c_19_vac");
        vaccines.add("c_20_vac");
        return vaccines;
    }

    @GetMapping(value = "/getRemedies")
    public ArrayList<String> getRemedies(){
        ArrayList<String> remedies= new ArrayList<>();
        remedies.add("нет");
        remedies.add("маска");
        remedies.add("перчатки");
        remedies.add("противогаз");
        remedies.add("химкостюм");
        return remedies;
    }
    @GetMapping(value = "/getHumanStatistic")
    public StatisticAnswer getHumanStatistic(){
        tic+=3;
        return new StatisticAnswer(2L *tic,humansService.getRegularPeople(),tic* 2L, humansService.getDiedHuman());
    }
    @GetMapping(value = "/getMapStatistic")
    public ArrayList<DistrictsAnswer> getMapStatistic(){
        ArrayList<DistrictsAnswer> districtsAnswers = new ArrayList<>();
        districtsAnswers.add(new DistrictsAnswer("A0", tic*2/3,11000/3 -tic,tic/3,4*tic/3));
        districtsAnswers.add(new DistrictsAnswer("B0", tic*2/3,9000/3 -tic,tic*2/3,tic/3));
        districtsAnswers.add(new DistrictsAnswer("C0", tic*10/3,8000/3 -tic,tic*2/3,2*tic/3));
        return districtsAnswers;
    }
}
