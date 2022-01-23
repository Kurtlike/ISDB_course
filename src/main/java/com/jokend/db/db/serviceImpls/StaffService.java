package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.pojoDBClasses.Staff;
import com.jokend.db.db.repos.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
@Repository
public class StaffService {
    @Autowired
    private StaffRepo staffRepo;

    public ArrayList<Staff> getStaff() { return staffRepo.getStaff();
    }
}
