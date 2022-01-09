package com.jokend.db.db.services;

import com.jokend.db.db.pojoDBClasses.Vaccines;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface VaccinesService {
    @Transactional
    public void addVaccine(Vaccines vaccine);
    @Transactional
    public ArrayList<Vaccines> getVaccines();
    @Transactional
    public ArrayList<Vaccines> getVaccinesFromVirus(Long virusId);
}
