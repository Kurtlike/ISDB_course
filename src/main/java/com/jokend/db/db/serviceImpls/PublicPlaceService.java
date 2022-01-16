package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.repos.PublicPlaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Repository
public class PublicPlaceService {
    @Autowired
    private PublicPlaceRepo publicPlaceRepo;
}
