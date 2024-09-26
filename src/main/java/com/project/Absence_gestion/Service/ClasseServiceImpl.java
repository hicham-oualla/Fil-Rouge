package com.project.Absence_gestion.Service;


import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.Repository.ClasseRepository;
import com.project.Absence_gestion.dto.Classedto;
import com.project.Absence_gestion.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClasseServiceImpl implements ClasseService{

    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    ClassMapper classMapper;


    @Override
    public Classedto saveClasse(Classedto classe) {
        Classe classe1 = classMapper.toEntity(classe);
        return classMapper.toDto(classeRepository.save(classe1));
    }

    @Override
    public List<Classe> getAllClasses() {

        return classeRepository.findAll();
    }

    @Override
    public Classe getClasseById(Long id) {
        return classeRepository.findById(id).orElse(null);
    }

    @Override
    public Classedto updateClasse(Long id, Classedto classe) {
       Classe classe1 =  classeRepository.findById(id).orElse(null);
       classMapper.partialUpdate(classe,classe1);
       Classe classeUpdated = classeRepository.save(classe1);
       return classMapper.toDto(classeUpdated);
    }

    @Override
    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }


}
