package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Humans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface HumansRepo extends JpaRepository<Humans,Long> {

    @Query(value = "SELECT count(*) FROM humans WHERE  status = 'died';",nativeQuery=true)
    public Long getDiedHumansCount();

    @Query(value = "SELECT count(*) FROM humans WHERE  status = 'ok';",nativeQuery=true)
    public Long getRegularHumansCount();

}
