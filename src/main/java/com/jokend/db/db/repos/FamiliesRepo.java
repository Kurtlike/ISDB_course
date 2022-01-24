package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Families;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface FamiliesRepo extends JpaRepository<Families,Long> {
    @Query(value = "SELECT * FROM families\n" +
            "\tWHERE inn = :inn",nativeQuery=true)
    Families getFamiliesByInn(Long inn);

    @Query(value = "SELECT humans.inn FROM humans\n" +
            "\tJOIN families ON families.inn = humans.inn\n"+
            "\tWHERE families.id = :Id",nativeQuery=true)
    ArrayList<Long> getFamiliesMembersById(Long Id);
}
