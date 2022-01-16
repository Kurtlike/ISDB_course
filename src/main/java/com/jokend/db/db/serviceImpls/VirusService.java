package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Virus;
import com.jokend.db.db.repos.VirusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class VirusService {
    @Autowired
    private VirusRepo virusRepo;

    public void addVirus(Virus virus) {
        virusRepo.addVirus(virus.getVirusId(), virus.getMortality(), virus.getIncubationPeriod(), virus.getAsymptomaticProb(), virus.getInfectiousness());
    }

    public ArrayList<Virus> getViruses() {
        return virusRepo.getViruses();
    }

    public Virus getVirusByID(Long virusId) {
        return null;
    }

    public boolean isEmpty(){
        return virusRepo.getViruses().size() == 0;
    }
    public void deleteAll(){virusRepo.deleteAll();};
}
