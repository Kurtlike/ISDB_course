package com.jokend.db.db.serviceImpls;

import com.jokend.db.db.repos.HumansRepo;
import com.jokend.db.db.repos.IllnessRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class IllnessService {
    @Autowired
    private IllnessRepo illnessRepo;
    public void deleteAll(){illnessRepo.deleteAll();};
}
