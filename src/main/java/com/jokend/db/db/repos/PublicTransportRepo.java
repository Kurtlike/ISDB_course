package com.jokend.db.db.repos;

import com.jokend.db.db.pojoDBClasses.PublicTransport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicTransportRepo extends JpaRepository<PublicTransport, Long> {
}