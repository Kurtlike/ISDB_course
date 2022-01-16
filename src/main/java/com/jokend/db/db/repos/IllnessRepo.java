package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Illness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IllnessRepo extends JpaRepository<Illness,Long> {

    @Modifying
    @Query(value = "DELETE FROM illness",nativeQuery=true)
    public void deleteAll();
}
