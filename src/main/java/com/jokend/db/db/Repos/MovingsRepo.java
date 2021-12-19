package com.jokend.db.db.Repos;

import com.jokend.db.db.pojoDBClasses.MovingsKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovingsRepo extends JpaRepository<MovingsRepo, MovingsKey> {
}
