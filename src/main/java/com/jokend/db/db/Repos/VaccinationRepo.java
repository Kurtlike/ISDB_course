package com.jokend.db.db.Repos;

import com.jokend.db.db.pojoDBClasses.Vaccination;
import com.jokend.db.db.pojoDBClasses.VaccinationKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepo extends JpaRepository<Vaccination, VaccinationKey> {
}
