package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Remedies;
import com.jokend.db.db.pojoDBClasses.Vaccines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface RemediesRepo extends JpaRepository<Remedies, String> {
    @Modifying
    @Query(value = "insert into remedies (name, efficiency, comfortable) VALUES (:name, :efficiency, :comfortable)",nativeQuery=true)
    public void addRemedy(String name, Integer efficiency, Integer comfortable);

    @Query(value = "SELECT * FROM remedies",nativeQuery=true)
    public ArrayList<Remedies> getRemedies();
}
