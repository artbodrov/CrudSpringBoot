package h8me.CrudSpringBoot.services;

import h8me.CrudSpringBoot.models.Label;
import h8me.CrudSpringBoot.repositories.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class LabelService {

   private final LabelRepository labelRepository;

    @Autowired
    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public List<Label> findAll() {
        return labelRepository.findAll();
    }

    public Label findOne(int id) {
        Optional<Label> foundLabel = labelRepository.findById(id);
        return foundLabel.orElse(null);
    }

    @Transactional
    public void save(Label label) {
        labelRepository.save(label);
    }

    @Transactional
    public void update(int id, Label updatedLabel) {
        updatedLabel.setId(id);
        labelRepository.save(updatedLabel);
    }

    @Transactional
    public void delete(int id) {
        labelRepository.deleteById(id);
    }
}
