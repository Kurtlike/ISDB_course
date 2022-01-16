package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Families;
import com.jokend.db.db.repos.FamiliesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class FamiliesService {
    @Autowired
    private FamiliesRepo familiesRepo;
    public ArrayList<Families> getFamiliesByINN(Long inn){
        return familiesRepo.getFamiliesByInn(inn);
    }
}
