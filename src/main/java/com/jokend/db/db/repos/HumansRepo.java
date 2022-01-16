package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Humans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface HumansRepo extends JpaRepository<Humans,Long> {

    @Query(value = "SELECT count(*) FROM humans WHERE status = 'died';",nativeQuery=true)
    Long getDiedHumansCount();

    @Query(value = "SELECT count(*) FROM humans WHERE status = 'vaccinated';",nativeQuery=true)
    Long getVaccinatedHumansCount();

    @Query(value = "SELECT count(*) FROM humans WHERE status = 'infected';",nativeQuery=true)
    Long getInfectedHumansCount();

    @Query(value = "SELECT count(*) FROM humans WHERE status = 'ok';",nativeQuery=true)
    Long getRegularHumansCount();

    @Query(value = "SELECT count(*) FROM humans WHERE status = :status AND district = :district ;",nativeQuery=true)
    Integer getHumansNumberByDistrictAndStatus(String district, String status);
    @Modifying
    @Query(value = "UPDATE humans SET status = 'ok';",nativeQuery=true)
    Integer resetStatuses();
}
