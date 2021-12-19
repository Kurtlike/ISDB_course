package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Humans;
import com.jokend.db.db.repos.HumansRepo;
import com.jokend.db.db.services.HumansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Repository
public class HumansServiceImpls implements HumansService {
    @Autowired
    private HumansRepo humansRepo;
    @Override
    public Humans getHuman(Long INN) {
        return null;
    }
    public Long getDiedHuman(){
        return humansRepo.getDiedHumansCount();
    }
    public Long getRegularPeople(){
        return  humansRepo.getRegularHumansCount();
    }


}
