package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Remedies;
import com.jokend.db.db.repos.RemediesRepo;
import com.jokend.db.db.repos.VaccinesRepo;
import com.jokend.db.db.services.RemediesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class RemedyServiceImpl implements RemediesService {
    @Autowired
    private RemediesRepo remediesRepo;

    @Override
    public ArrayList<Remedies> getRemedies() {
        return remediesRepo.getRemedies();
    }
    @Override
    public Remedies getRemedy(String name) {
        return null;
    }

    @Override
    public void addRemedy(Remedies remedies) {
        remediesRepo.addRemedy(remedies.getName(), remedies.getEfficiency(), remedies.getComfortable());
    }
}
