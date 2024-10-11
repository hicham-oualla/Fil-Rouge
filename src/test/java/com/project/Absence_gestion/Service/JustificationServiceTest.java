package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.Model.Justification;
import com.project.Absence_gestion.Repository.AbesenceRepository;
import com.project.Absence_gestion.Repository.JustificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class JustificationServiceTest {

    @Mock
    private JustificationRepository justificationRepository;

    @Mock
    private AbesenceRepository absenceRepository;

    @InjectMocks
    private JustificationService justificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveJustification_Success() throws IOException {
        // Mock absence
        Long absenceId = 1L;
        Absence absence = new Absence();
        absence.setId(absenceId);

        // Mock MultipartFile
        MultipartFile file = mock(MultipartFile.class);
        when(file.getOriginalFilename()).thenReturn("justification.pdf");
        when(file.getContentType()).thenReturn("application/pdf");
        when(file.getBytes()).thenReturn(new byte[]{1, 2, 3});

        // Mock repository
        when(absenceRepository.findById(absenceId)).thenReturn(Optional.of(absence));
        when(justificationRepository.save(any(Justification.class))).thenReturn(new Justification());

        // Call the method to test
        justificationService.saveJustification(absenceId, file);

        // Verify interactions and ensure the repository methods were called
        verify(absenceRepository, times(1)).findById(absenceId);
        verify(justificationRepository, times(1)).save(any(Justification.class));
    }

    @Test
    void testSaveJustification_AbsenceNotFound() throws IOException {
        Long absenceId = 1L;
        MultipartFile file = mock(MultipartFile.class);

        when(absenceRepository.findById(absenceId)).thenReturn(Optional.empty());

        // Assert that the method throws a RuntimeException when absence is not found
        assertThrows(RuntimeException.class, () -> justificationService.saveJustification(absenceId, file));

        verify(absenceRepository, times(1)).findById(absenceId);
        verify(justificationRepository, never()).save(any(Justification.class));
    }

    @Test
    void testGetJustificationByAbsenceId_Success() {
        Long absenceId = 1L;
        Justification justification = new Justification();
        justification.setId(1L);

        // Mock repository
        when(justificationRepository.findByAbsenceId(absenceId)).thenReturn(Optional.of(justification));

        // Call the method to test
        Justification foundJustification = justificationService.getJustificationByAbsenceId(absenceId);

        // Verify the result
        assertNotNull(foundJustification);
        assertEquals(justification.getId(), foundJustification.getId());

        verify(justificationRepository, times(1)).findByAbsenceId(absenceId);
    }

    @Test
    void testGetJustificationByAbsenceId_NotFound() {
        Long absenceId = 1L;

        // Mock repository
        when(justificationRepository.findByAbsenceId(absenceId)).thenReturn(Optional.empty());

        // Assert that the method throws a RuntimeException when justification is not found
        assertThrows(RuntimeException.class, () -> justificationService.getJustificationByAbsenceId(absenceId));

        verify(justificationRepository, times(1)).findByAbsenceId(absenceId);
    }
}
