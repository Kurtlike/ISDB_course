package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Humans;
import com.jokend.db.db.repos.HumansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Repository
public class HumansService  {
    @Autowired
    private HumansRepo humansRepo;

    public Humans getHuman(Long INN) {
        return null;
    }

    public Integer getHumansNumberByDistrictAndStatus(String district, String status) {
        return humansRepo.getHumansNumberByDistrictAndStatus(district, status);
    }

    public Long getDiedHuman(){
        return humansRepo.getDiedHumansCount();
    }
    public Long getRegularPeople(){
        return  humansRepo.getRegularHumansCount();
    }
    public Long getVaccinatedHumansCount(){return humansRepo.getVaccinatedHumansCount();}
    public Long getInfectedHumansCount(){return humansRepo.getInfectedHumansCount();}
    public void resetStatuses(){humansRepo.resetStatuses();}
}
