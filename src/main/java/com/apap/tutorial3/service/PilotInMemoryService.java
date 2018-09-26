package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import com.apap.tutorial3.model.PilotModel;

import org.springframework.stereotype.Service;

@Service
public class PilotInMemoryService implements PilotService {
    private List<PilotModel> archivePilot;
    public PilotInMemoryService() {
        archivePilot = new ArrayList<>();
    }

    @Override
    public void addPilot(PilotModel pilot) {
        archivePilot.add(pilot);
    }

    @Override
    public List<PilotModel> getPilotList() {
        return archivePilot;
    }

    @Override
    public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
        for (PilotModel pilot : archivePilot) {
            if (pilot.getLicenseNumber().equals(licenseNumber)) return pilot;
        }
        return null;
    }

    public Boolean deletePilot(String id) {
        return archivePilot.removeIf(pilot -> pilot.getId().equals(id));
    }
    
}