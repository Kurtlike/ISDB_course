package com.jokend.db.db.services;

import com.jokend.db.db.pojoDBClasses.Virus;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface VirusService {
    @Transactional
    public void addVirus(Virus virus);
    @Transactional
    public ArrayList<Virus> getViruses();
    @Transactional
    public Virus getVirusByID(Long virusId);
}
