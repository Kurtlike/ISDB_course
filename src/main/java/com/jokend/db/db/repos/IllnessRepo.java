package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepo extends JpaRepository<Illness,Long> {
}
