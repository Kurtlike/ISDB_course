package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Vaccination;
import com.jokend.db.db.pojoDBClasses.VaccinationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VaccinationRepo extends JpaRepository<Vaccination, VaccinationKey> {
    @Modifying
    @Query(value = "DELETE FROM vaccination",nativeQuery=true)
    public void deleteAll();
}
