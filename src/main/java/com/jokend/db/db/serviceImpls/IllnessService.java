package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.repos.HumansRepo;
import com.jokend.db.db.repos.IllnessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Repository
public class IllnessService {
    @Autowired
    private IllnessRepo illnessRepo;
    public void deleteAll(){illnessRepo.deleteAll();};
}
