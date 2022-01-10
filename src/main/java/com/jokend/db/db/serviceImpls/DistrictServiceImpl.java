package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.District;
import com.jokend.db.db.repos.DistrictRepo;
import com.jokend.db.db.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepo districtRepo;
    @Override
    public District getDistrict(String name) {
        return null;
    }

    @Override
    public ArrayList<District> getDistricts() {
        return districtRepo.getDistricts();
    }
}
