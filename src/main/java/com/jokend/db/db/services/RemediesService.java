package com.jokend.db.db.services;
import com.jokend.db.db.pojoDBClasses.Remedies;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface RemediesService {
    @Transactional
    public ArrayList<Remedies> getRemedies();
    @Transactional
    public Remedies getRemedy(String name);
    @Transactional
    public void addRemedy(Remedies remedies);
}
