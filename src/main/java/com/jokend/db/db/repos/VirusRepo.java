package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Virus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VirusRepo extends JpaRepository<Virus, Long> {
    @Modifying
    @Query(value = "insert into virus (mortality, incubation_period, asymptomatic_prob, infectiousness) VALUES (:mortality, (interval '1' hour)* :inkPeriod, :asymProb, :inf)",nativeQuery=true)
    public void addVirus(Integer mortality, Integer inkPeriod, Integer asymProb, Integer inf);
}
