package com.jokend.db.db.services;

import com.jokend.db.db.pojoDBClasses.Illness;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface illnessService {
    @Transactional
    public ArrayList<Illness> getIllnessByInjured(Long INN);
    @Transactional
    public void addIllness(Illness newIllness);
    @Transactional
    public void setStatus(String status);
}
