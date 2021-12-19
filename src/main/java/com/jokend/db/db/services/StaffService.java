package com.jokend.db.db.services;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface StaffService {
    @Transactional
    public ArrayList<Integer> getStaffFromPublicPlace(Long publicPlaceId);
}
