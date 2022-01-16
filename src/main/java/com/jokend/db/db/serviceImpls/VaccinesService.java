package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Vaccines;
import com.jokend.db.db.repos.VaccinesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class VaccinesService {
    @Autowired
    private VaccinesRepo vaccinesRepo;

    public void addVaccine(Vaccines vaccine) {vaccinesRepo.addVaccines(vaccine.getVirusId(),vaccine.getVaccineId(), vaccine.getMaxAge(), vaccine.getEfficiency());}
    public ArrayList<Vaccines> getVaccines() {
        return vaccinesRepo.getVaccines();
    }
    public ArrayList<Vaccines> getVaccinesFromVirus(Long virusId) {
        return null;
    }
    public void deleteAll(){vaccinesRepo.deleteAll();}

}
