package com.jokend.db.db.Services;

import com.jokend.db.db.pojoDBClasses.Vaccines;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface VaccinesService {
    @Transactional
    public void addVaccine(Vaccines vaccine);
    @Transactional
    public ArrayList<Vaccines> getVaccinesFromVirus(Long virusId);
}
