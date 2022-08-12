package h8me.CrudSpringBoot.controllers;

import h8me.CrudSpringBoot.models.Course;
import h8me.CrudSpringBoot.models.Student;
import h8me.CrudSpringBoot.services.CourseServise;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class CourseController {

    private final CourseServise courseServise;

    public CourseController(CourseServise courseServise) {
        this.courseServise = courseServise;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("course", courseServise.findAll());
        return "course/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("course", courseServise.findOne(id));
        return "course/show";
    }

    @GetMapping("/new")
    public String newCourse(@ModelAttribute("course") Course course) {
        return "course/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("course") @Valid Course course,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "course/new";

        courseServise.save(course);
        return "redirect:/course";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("course", courseServise.findOne(id));
        return "course/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("course") @Valid Course course, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "course/edit";

        courseServise.update(id, course);
        return "redirect:/course";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        courseServise.delete(id);
        return "redirect:/course";
    }

}
