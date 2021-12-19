package com.jokend.db.db.Services;

import com.jokend.db.db.pojoDBClasses.Virus;
import javax.transaction.Transactional;

public interface VirusService {
    @Transactional
    public void addVirus(Virus virus);
    @Transactional
    public Virus getVirusByID(Long virusId);
}
