package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Remedies;
import com.jokend.db.db.repos.RemediesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class RemedyService  {
    @Autowired
    private RemediesRepo remediesRepo;

    public ArrayList<Remedies> getRemedies() {
        return remediesRepo.getRemedies();
    }

    public Remedies getRemedy(String name) {
        return null;
    }

    public void addRemedy(Remedies remedies) {
        remediesRepo.addRemedy(remedies.getName(), remedies.getEfficiency(), remedies.getComfortable());
    }
}
