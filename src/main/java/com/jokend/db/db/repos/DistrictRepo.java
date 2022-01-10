package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface DistrictRepo extends JpaRepository<District,String> {
    @Query(value = "SELECT * FROM district",nativeQuery=true)
    public ArrayList<District> getDistricts();
}
