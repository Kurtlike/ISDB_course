package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.Humans;
import com.jokend.db.db.pojoDBClasses.PublicPlaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface PublicPlaceRepo extends JpaRepository<PublicPlaces, Long> {
    @Query(value = "SELECT * FROM public_places;",nativeQuery=true)
    ArrayList<PublicPlaces> getPlaces();
}
