package com.jokend.db.db.services;

import com.jokend.db.db.pojoDBClasses.Humans;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface HumansService {
    @Transactional
    public Humans getHuman(Long INN);

    @Transactional
    public Integer getHumansNumberByDistrictAndStatus(String district, String status);
}
