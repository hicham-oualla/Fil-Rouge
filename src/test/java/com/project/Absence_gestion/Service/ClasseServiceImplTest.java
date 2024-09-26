package com.project.Absence_gestion.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.Repository.ClasseRepository;
import com.project.Absence_gestion.Service.ClasseServiceImpl;
import com.project.Absence_gestion.dto.Classedto;
import com.project.Absence_gestion.mapper.ClassMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

    public class ClasseServiceImplTest {

        @Mock
        private ClasseRepository classeRepository;

        @Mock
        private ClassMapper classMapper;

        @InjectMocks
        private ClasseServiceImpl classeServiceImpl;

        @BeforeEach
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        public void testSaveClasse() {
            // Arrange
            Classedto classedto = new Classedto(); // Set up DTO properties as needed
            Classe classeEntity = new Classe();    // Set up entity properties as needed
            when(classMapper.toEntity(classedto)).thenReturn(classeEntity);
            when(classeRepository.save(classeEntity)).thenReturn(classeEntity);
            when(classMapper.toDto(classeEntity)).thenReturn(classedto);

            // Act
            Classedto result = classeServiceImpl.saveClasse(classedto);

            // Assert
            assertNotNull(result);
            verify(classeRepository).save(classeEntity);
            verify(classMapper).toEntity(classedto);
            verify(classMapper).toDto(classeEntity);
        }

        @Test
        public void testGetAllClasses() {
            // Arrange
            Classe classe1 = new Classe();  // Set up entity properties as needed
            Classe classe2 = new Classe();  // Set up entity properties as needed
            List<Classe> classeList = Arrays.asList(classe1, classe2);
            when(classeRepository.findAll()).thenReturn(classeList);

            // Act
            List<Classe> result = classeServiceImpl.getAllClasses();

            // Assert
            assertEquals(2, result.size());
            verify(classeRepository).findAll();
        }

        @Test
        public void testGetClasseById() {
            // Arrange
            Long id = 1L;
            Classe classe = new Classe();  // Set up entity properties as needed
            when(classeRepository.findById(id)).thenReturn(Optional.of(classe));

            // Act
            Classe result = classeServiceImpl.getClasseById(id);

            // Assert
            assertNotNull(result);
            assertEquals(classe, result);
            verify(classeRepository).findById(id);
        }

        @Test
        public void testUpdateClasse() {
            // Arrange
            Long id = 1L;
            Classedto classedto = new Classedto();  // Set up DTO properties as needed
            Classe classe = new Classe();           // Set up entity properties as needed
            when(classeRepository.findById(id)).thenReturn(Optional.of(classe));
            when(classMapper.partialUpdate(classedto, classe)).thenReturn(classe);
            when(classeRepository.save(classe)).thenReturn(classe);
            when(classMapper.toDto(classe)).thenReturn(classedto);

            // Act
            Classedto result = classeServiceImpl.updateClasse(id, classedto);

            // Assert
            assertNotNull(result);
            verify(classeRepository).findById(id);
            verify(classeRepository).save(classe);
            verify(classMapper).partialUpdate(classedto, classe);
        }

        @Test
        public void testDeleteClasse() {
            // Arrange
            Long id = 1L;

            // Act
            classeServiceImpl.deleteClasse(id);

            // Assert
            verify(classeRepository).deleteById(id);
        }
    }
