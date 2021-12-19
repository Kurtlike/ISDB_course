package com.jokend.db.db.Services;

import com.jokend.db.db.pojoDBClasses.Humans;

import javax.transaction.Transactional;

public interface HumansService {
    @Transactional
    public Humans getHuman(Long INN);
}
