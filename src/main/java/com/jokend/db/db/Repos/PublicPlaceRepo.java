package com.jokend.db.db.Repos;

import com.jokend.db.db.pojoDBClasses.PublicPlaces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicPlaceRepo extends JpaRepository<PublicPlaces, Long> {
}
