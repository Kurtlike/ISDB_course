package com.jokend.db.db.services;

import com.jokend.db.db.pojoDBClasses.PublicTransport;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface PublicTransportService {
    @Transactional
    public ArrayList<PublicTransport> getPublicTransports();
    @Transactional
    public PublicTransport getPublicTransport(Long id);
}
