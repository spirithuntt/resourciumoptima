package com.resourciumoptima.service;

import com.resourciumoptima.domain.Equipement;
import com.resourciumoptima.repository.EquipementRepository;

public class EquipementService {

    private final EquipementRepository equipementRepository;

    public EquipementService(EquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }
    public Equipement createEquipement(Equipement equipement) {
        validate(equipement);
        return equipementRepository.save(equipement);
    }
    
    private void validate(Equipement equipement) {
        if(equipement == null || equipement.getName() == null){
            throw new IllegalArgumentException("All fields needed");
        }
    }

    public Equipement updateEquipement(Equipement equipement) {
        validate(equipement);
        equipementRepository.update(equipement);
        return equipement;
    }

    public Equipement getEquipementById(int id) {
        return equipementRepository.findById(id);
    }


}
