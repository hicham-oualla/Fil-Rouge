package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.JustificationRetard;
import com.project.Absence_gestion.Model.Retard;
import com.project.Absence_gestion.Repository.JustificationRetardRepository;
import com.project.Absence_gestion.Repository.RetardRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.*;

class JustificationRetardServiceTest {

    @Mock
    private JustificationRetardRepository justificationRetardRepository;

    @Mock
    private RetardRepository retardRepository;

    @Mock
    private MultipartFile file;

    @InjectMocks
    private JustificationRetardService justificationRetardService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveJustificationRetard_SuccessfulSave() throws IOException {
        // Mock data
        Long retardId = 1L;
        Retard retard = new Retard();
        retard.setId(retardId);

        when(retardRepository.findById(retardId)).thenReturn(Optional.of(retard));
        when(file.getOriginalFilename()).thenReturn("justification.pdf");
        when(file.getContentType()).thenReturn("application/pdf");
        when(file.getBytes()).thenReturn(new byte[]{1, 2, 3});

        // Act
        justificationRetardService.saveJustificationRetard(retardId, file);

        // Verify the repository save call
        verify(justificationRetardRepository, times(1)).save(any(JustificationRetard.class));
    }

    @Test
    void saveJustificationRetard_RetardNotFound() {
        // Mock data
        Long retardId = 1L;

        when(retardRepository.findById(retardId)).thenReturn(Optional.empty());

        // Assert that the correct exception is thrown
        assertThrows(RuntimeException.class, () -> justificationRetardService.saveJustificationRetard(retardId, file));

        // Verify that the repository save is never called
        verify(justificationRetardRepository, never()).save(any(JustificationRetard.class));
    }

    @Test
    void getJustificationRetardByRetardId_Successful() {
        // Mock data
        Long retardId = 1L;
        JustificationRetard justificationRetard = new JustificationRetard();
        justificationRetard.setId(1L);

        when(justificationRetardRepository.findByRetardId(retardId)).thenReturn(Optional.of(justificationRetard));

        // Act
        JustificationRetard result = justificationRetardService.getJustificationRetardByRetardId(retardId);

        // Verify
        verify(justificationRetardRepository, times(1)).findByRetardId(retardId);
    }

    @Test
    void getJustificationRetardByRetardId_NotFound() {
        // Mock data
        Long retardId = 1L;

        when(justificationRetardRepository.findByRetardId(retardId)).thenReturn(Optional.empty());

        // Assert that the correct exception is thrown
        assertThrows(RuntimeException.class, () -> justificationRetardService.getJustificationRetardByRetardId(retardId));
    }
}
