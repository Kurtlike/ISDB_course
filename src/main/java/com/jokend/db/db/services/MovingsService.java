package com.jokend.db.db.services;

import com.jokend.db.db.pojoDBClasses.Movings;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface MovingsService {
    @Transactional
    public ArrayList<Long> getINNsInThisMoving(Integer publicTransportId, java.sql.Timestamp date);
    @Transactional
    public void addMoving(Movings moving);
    @Transactional
    public void addPassenger(Long INN);
}
