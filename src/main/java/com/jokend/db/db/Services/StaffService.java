package com.jokend.db.db.Services;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface StaffService {
    @Transactional
    public ArrayList<Integer> getStaffFromPublicPlace(Long publicPlaceId);
}
