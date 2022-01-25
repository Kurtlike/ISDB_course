package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.PublicTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface PublicTransportRepo extends JpaRepository<PublicTransport, Long> {
    @Query(value = "SELECT * FROM public_transport",nativeQuery=true)
    ArrayList<PublicTransport> getTransport();
}
