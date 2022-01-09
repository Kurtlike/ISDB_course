package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Vaccines;
import com.jokend.db.db.repos.VaccinesRepo;
import com.jokend.db.db.repos.VirusRepo;
import com.jokend.db.db.services.VaccinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class VaccinesServiceImpl implements VaccinesService {
    @Autowired
    private VaccinesRepo vaccinesRepo;

    @Override
    public void addVaccine(Vaccines vaccine) {
        vaccinesRepo.addVaccines(vaccine.getVirusId(),vaccine.getVaccineId(), vaccine.getMaxAge(), vaccine.getEfficiency());
    }

    @Override
    public ArrayList<Vaccines> getVaccines() {
        return vaccinesRepo.getVaccines();
    }

    @Override
    public ArrayList<Vaccines> getVaccinesFromVirus(Long virusId) {
        return null;
    }
}
