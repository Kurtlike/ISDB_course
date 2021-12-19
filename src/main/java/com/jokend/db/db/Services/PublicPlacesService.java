package com.jokend.db.db.Services;

import com.jokend.db.db.pojoDBClasses.PublicPlaces;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface PublicPlacesService {
    @Transactional
    public ArrayList<PublicPlaces> getPublicPlaces();
    @Transactional
    public PublicPlaces getPublicPlace(Long id);
}
