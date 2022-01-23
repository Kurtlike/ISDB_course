package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Movings;
import com.jokend.db.db.pojoDBClasses.MovingsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MovingsRepo extends JpaRepository<Movings, MovingsKey> {

    @Modifying
    @Query(value = "DELETE FROM movings",nativeQuery=true)
    public void deleteAll();
}
