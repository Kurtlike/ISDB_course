package com.jokend.db.db.Services;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface FamiliesService {
    @Transactional
    public ArrayList<Long> getRelatives(Long INN);
    @Transactional
    public ArrayList<Long> getFamilyMembers(Long FamilyId);
}
