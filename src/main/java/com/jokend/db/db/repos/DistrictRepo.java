package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepo extends JpaRepository<District,String> {
}
