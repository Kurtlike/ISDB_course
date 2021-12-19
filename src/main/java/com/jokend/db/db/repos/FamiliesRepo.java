package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Families;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliesRepo extends JpaRepository<Families,Long> {
}
