package com.jokend.db.db.services;

import com.jokend.db.db.pojoDBClasses.District;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface DistrictService {
    @Transactional
    public District getDistrict(String name);

    @Transactional
    public ArrayList<District> getDistricts();
}
