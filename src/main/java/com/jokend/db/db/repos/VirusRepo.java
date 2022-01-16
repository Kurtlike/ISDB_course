package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Virus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface VirusRepo extends JpaRepository<Virus, Long> {
    @Modifying
    @Query(value = "insert into virus (virus_id, mortality, incubation_period, asymptomatic_prob, infectiousness) VALUES (:virusId, :mortality, :inkPeriod, :asymProb, :inf)",nativeQuery=true)
    public void addVirus(String virusId, Integer mortality, Integer inkPeriod, Integer asymProb, Integer inf);

    @Query(value = "SELECT * FROM virus",nativeQuery=true)
    public ArrayList<Virus> getViruses();
    @Modifying
    @Query(value = "DELETE FROM virus",nativeQuery=true)
    public void deleteAll();
}
