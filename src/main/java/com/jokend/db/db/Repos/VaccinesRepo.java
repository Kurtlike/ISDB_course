package com.jokend.db.db.Repos;

import com.jokend.db.db.pojoDBClasses.Vaccines;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinesRepo extends JpaRepository<Vaccines, Long> {
}
