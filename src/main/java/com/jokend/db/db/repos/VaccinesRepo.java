package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Vaccines;
import com.jokend.db.db.pojoDBClasses.Virus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface VaccinesRepo extends JpaRepository<Vaccines, Long> {
    @Modifying
    @Query(value = "insert into vaccines (virus_id, vaccine_id, max_age, efficiency) VALUES (:virusId, :vaccineId, :maxAge, :efficiency)",nativeQuery=true)
    public void addVaccines(String virusId, String vaccineId, Integer maxAge, Integer efficiency);

    @Query(value = "SELECT * FROM vaccines",nativeQuery=true)
    public ArrayList<Vaccines> getVaccines();
}
