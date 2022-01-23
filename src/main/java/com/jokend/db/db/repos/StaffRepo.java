package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Humans;
import com.jokend.db.db.pojoDBClasses.Staff;
import com.jokend.db.db.pojoDBClasses.StaffKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface StaffRepo extends JpaRepository<Staff, StaffKey> {

    @Query(value = "SELECT * FROM staff;",nativeQuery=true)
    ArrayList<Staff> getStaff();
}
