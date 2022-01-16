package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Families;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface FamiliesRepo extends JpaRepository<Families,Long> {
    public ArrayList<Families> getFamiliesByInn(Long inn);
}
