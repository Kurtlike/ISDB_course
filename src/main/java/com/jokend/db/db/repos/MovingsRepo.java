package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Movings;
import com.jokend.db.db.pojoDBClasses.MovingsKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovingsRepo extends JpaRepository<Movings, MovingsKey> {
}