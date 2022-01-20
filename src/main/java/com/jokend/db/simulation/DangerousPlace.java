package com.jokend.db.simulation;

import com.jokend.db.db.pojoDBClasses.PublicPlaces;
import com.jokend.db.db.pojoDBClasses.Virus;

import java.util.ArrayList;

public class DangerousPlace {
    public DangerousPlace() {
        viruses = new ArrayList<>();
    }
    public PublicPlaces place;
    public ArrayList<Virus> viruses;
}
