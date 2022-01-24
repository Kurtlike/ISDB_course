package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Humans;
import com.jokend.db.db.repos.HumansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class HumansService  {
    @Autowired
    private HumansRepo humansRepo;

    public Humans getHuman(Long INN) {
        return humansRepo.getHumanBYINN(INN);
    }

    public Integer getHumansNumberByDistrictAndStatus(String district, String status) {
        return humansRepo.getHumansNumberByDistrictAndStatus(district, status);
    }
    public Long getAliveHumansCount(){return humansRepo.getAliveHumansCount();}
    public Long getDiedHuman(){
        return humansRepo.getDiedHumansCount();
    }
    public Long getRegularPeople(){
        return  humansRepo.getRegularHumansCount();
    }
    public Long getVaccinatedHumansCount(){return humansRepo.getVaccinatedHumansCount();}
    public Long getInfectedHumansCount(){return humansRepo.getInfectedHumansCount();}
    public void resetStatuses(){humansRepo.resetStatuses();}
    public ArrayList<Humans> getHumans(){return humansRepo.getHumans();}
    public Long getAllHumansCount(){return humansRepo.getAllHumansCount();}
    public void setStatus(String status,Long INN){humansRepo.setStatus(status,INN);}
    public ArrayList<Long> getHumansINNByPlaceAndTime(Integer place, Time time){ return  humansRepo.getHumansINNByPlaceAndTime(place, time);}
    public Integer getPlaceByHumansINNAndTime(Long INN, Time time){ return  humansRepo.getPlaceByHumansINNAndTime(INN, time);}
}
