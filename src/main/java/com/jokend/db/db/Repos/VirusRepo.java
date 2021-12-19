package com.jokend.db.db.Repos;

import com.jokend.db.db.pojoDBClasses.Virus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirusRepo extends JpaRepository<Virus, Long> {
}
