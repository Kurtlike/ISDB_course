package com.jokend.db.db.services;

import com.jokend.db.db.pojoDBClasses.Vaccination;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface VaccinationService {
    @Transactional
    public ArrayList<Vaccination> getVaccinationsByINN(Long INN);
    @Transactional
    public void setVaccination(Vaccination vac);
}
