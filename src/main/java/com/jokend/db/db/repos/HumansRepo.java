package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Humans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public interface HumansRepo extends JpaRepository<Humans,Long> {

    @Query(value = "SELECT count(*) FROM humans WHERE status = 'died';",nativeQuery=true)
    Long getDiedHumansCount();

    @Query(value = "SELECT count(*) FROM humans WHERE status = 'vaccinated';",nativeQuery=true)
    Long getVaccinatedHumansCount();

    @Query(value = "SELECT count(*) FROM humans WHERE status = 'infected';",nativeQuery=true)
    Long getInfectedHumansCount();

    @Query(value = "SELECT count(*) FROM humans WHERE status = 'ok';",nativeQuery=true)
    Long getRegularHumansCount();
    @Query(value = "SELECT count(*) FROM humans WHERE status != 'died';",nativeQuery=true)
    Long getAliveHumansCount();
    @Query(value = "SELECT count(*) FROM humans WHERE status = :status AND district = :district ;",nativeQuery=true)
    Integer getHumansNumberByDistrictAndStatus(String district, String status);
    @Modifying
    @Query(value = "UPDATE humans SET status = 'ok';",nativeQuery=true)
    Integer resetStatuses();
    @Query(value = "SELECT * FROM humans;",nativeQuery=true)
    ArrayList<Humans> getHumans();
    @Query(value = "SELECT * FROM humans WHERE inn = :INN ;",nativeQuery=true)
    Humans getHumanBYINN(Long INN);
    @Query(value = "SELECT count(*) FROM humans;",nativeQuery=true)
    Long getAllHumansCount();
    @Modifying
    @Query(value = "UPDATE humans SET status = :status WHERE inn = :INN ;",nativeQuery=true)
    void setStatus(String status,Long INN);

    @Query(value = "SELECT humans.inn FROM humans\n" +
            "\tJOIN staff ON humans.inn = staff.inn\n" +
            "\tJOIN public_places on place_id = id\n" +
            "\tWHERE start_time < :time \n" +
            "\t\tAND end_time > :time\n" +
            "\t\tAND place_id = :place;",nativeQuery=true)
    ArrayList<Long> getHumansINNByPlaceAndTime(Integer place, Time time);

    @Query(value = "SELECT place_id FROM public_places\n" +
            "\tJOIN staff ON place_id = id\n" +
            "\tJOIN humans ON humans.inn = staff.inn\n" +
            "\tWHERE start_time < :time \n" +
            "\t\tAND end_time > :time\n" +
            "\t\tAND humans.inn = :ID;",nativeQuery=true)
    Integer getPlaceByHumansINNAndTime(long ID, Time time);
}
