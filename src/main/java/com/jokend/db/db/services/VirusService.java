package com.jokend.db.db.services;

import com.jokend.db.db.pojoDBClasses.Virus;
import com.jokend.db.pojoAnswers.VirusAnswer;

import javax.transaction.Transactional;

public interface VirusService {
    @Transactional
    public void addVirus(Virus virus);
    @Transactional
    public Virus getVirusByID(Long virusId);
}
