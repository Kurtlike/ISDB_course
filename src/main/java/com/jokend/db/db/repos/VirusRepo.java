package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Virus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirusRepo extends JpaRepository<Virus, Long> {
}
