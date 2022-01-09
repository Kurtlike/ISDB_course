package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Virus;
import com.jokend.db.db.repos.VirusRepo;
import com.jokend.db.db.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class VirusServiceImpl implements VirusService {
    @Autowired
    private VirusRepo virusRepo;
    @Override
    public void addVirus(Virus virus) {
        virusRepo.addVirus(virus.getVirusId(), virus.getMortality(), virus.getIncubationPeriod(), virus.getAsymptomaticProb(), virus.getInfectiousness());
    }

    @Override
    public ArrayList<Virus> getViruses() {
        return virusRepo.getViruses();
    }

    @Override
    public Virus getVirusByID(Long virusId) {
        return null;
    }
}
