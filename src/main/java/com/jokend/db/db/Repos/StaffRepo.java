package com.jokend.db.db.Repos;

import com.jokend.db.db.pojoDBClasses.Staff;
import com.jokend.db.db.pojoDBClasses.StaffKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Staff, StaffKey> {
}
