package h8me.CrudSpringBoot.repositories;

import h8me.CrudSpringBoot.models.Label;
import org.springframework.data.jpa.repository.JpaRepository;




public interface LabelRepository extends JpaRepository <Label, Integer>{
}
