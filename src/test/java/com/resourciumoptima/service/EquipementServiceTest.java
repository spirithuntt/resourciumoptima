
package com.resourciumoptima.service;

import com.resourciumoptima.domain.Equipement;
import com.resourciumoptima.repository.EquipementRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class EquipementServiceTest {


    // createEquipement method saves a valid equipement
    @Test
    public void test_createEquipement_savesValidEquipement() {
        // Arrange
        EquipementRepository mockRepository = mock(EquipementRepository.class);
        EquipementService equipementService = new EquipementService(mockRepository);
        Equipement equipement = new Equipement();
        equipement.setName("Test Equipement");

        // Act
        Equipement result = equipementService.createEquipement(equipement);

        // Assert
        verify(mockRepository, times(1)).save(equipement);
        assertEquals(equipement, result);
    }

    // updateEquipement method updates a valid equipement
    @Test
    public void test_updateEquipement_updatesValidEquipement() {
        // Arrange
        EquipementRepository mockRepository = mock(EquipementRepository.class);
        EquipementService equipementService = new EquipementService(mockRepository);
        Equipement equipement = new Equipement();
        equipement.setId(1);
        equipement.setName("Test Equipement");

        // Act
        Equipement result = equipementService.updateEquipement(equipement);

        // Assert
        verify(mockRepository, times(1)).update(equipement);
        assertEquals(equipement, result);
    }

    // getEquipementById method returns an existing equipement
    @Test
    public void test_getEquipementById_returnsExistingEquipement() {
        // Arrange
        EquipementRepository mockRepository = mock(EquipementRepository.class);
        EquipementService equipementService = new EquipementService(mockRepository);
        Equipement equipement = new Equipement();
        equipement.setId(1);
        equipement.setName("Test Equipement");
        when(mockRepository.findById(1)).thenReturn(equipement);

        // Act
        Equipement result = equipementService.getEquipementById(1);

        // Assert
        assertEquals(equipement, result);
    }

    // validate method throws an IllegalArgumentException when equipement or name is null
    @Test
    public void test_validate_throwsIllegalArgumentExceptionWhenEquipementOrNameIsNull() {
        // Arrange
        EquipementService equipementService = new EquipementService(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            equipementService.validate(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Equipement equipement = new Equipement();
            equipementService.validate(equipement);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Equipement equipement = new Equipement();
            equipement.setName(null);
            equipementService.validate(equipement);
        });
    }

    // createEquipement method throws an exception when equipement is null
    @Test
    public void test_createEquipement_throwsExceptionWhenEquipementIsNull() {
        // Arrange
        EquipementService equipementService = new EquipementService(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            equipementService.createEquipement(null);
        });
    }

    // createEquipement method throws an exception when equipement name is null
    @Test
    public void test_createEquipement_throwsExceptionWhenEquipementNameIsNull() {
        // Arrange
        EquipementService equipementService = new EquipementService(null);
        Equipement equipement = new Equipement();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            equipementService.createEquipement(equipement);
        });
    }

    // updateEquipement method throws an exception when equipement is null
    @Test
    public void test_updateEquipement_throwsExceptionWhenEquipementIsNull() {
        // Arrange
        EquipementService equipementService = new EquipementService(null);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            equipementService.updateEquipement(null);
        });
    }

    // updateEquipement method throws an exception when equipement name is null
    @Test
    public void test_updateEquipement_throwsExceptionWhenEquipementNameIsNull() {
        // Arrange
        EquipementService equipementService = new EquipementService(null);
        Equipement equipement = new Equipement();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            equipementService.updateEquipement(equipement);
        });
    }

    // getEquipementById method returns null when equipement id does not exist
    @Test
    public void test_getEquipementById_returnsNullWhenEquipementIdDoesNotExist() {
        // Arrange
        EquipementRepository mockRepository = mock(EquipementRepository.class);
        EquipementService equipementService = new EquipementService(mockRepository);
        when(mockRepository.findById(1)).thenReturn(null);

        // Act
        Equipement result = equipementService.getEquipementById(1);

        // Assert
        assertNull(result);
    }

    // EquipementRepository.save method is called once when createEquipement method is called
    @Test
    public void test_createEquipement_callsSaveMethodOnce() {
        // Arrange
        EquipementRepository mockRepository = mock(EquipementRepository.class);
        EquipementService equipementService = new EquipementService(mockRepository);
        Equipement equipement = new Equipement();
        equipement.setName("Test Equipement");

        // Act
        equipementService.createEquipement(equipement);

        // Assert
        verify(mockRepository, times(1)).save(equipement);
    }

}