package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.Repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClasseServiceImpl implements ClasseService{

    @Autowired
    private ClasseRepository classeRepository;

    @Override
    public Classe saveClasse(Classe classe) {
        return classeRepository.save(classe);
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
    public Classe updateClasse(Long id, Classe classe) {
        if (classeRepository.existsById(id)) {
            classe.setId(id);
            return classeRepository.save(classe);
        }
        return null;
    }

    @Override
    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }


    @Override
    public List<Apprenant> getApprenantsByClasse(Long classeId) {
        Classe classe = classeRepository.findById(classeId).orElse(null);
        return (classe != null) ? classe.getApprenants() : null;
    }
}
