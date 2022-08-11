package h8me.CrudSpringBoot.controllers;

import h8me.CrudSpringBoot.models.Student;
import h8me.CrudSpringBoot.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("student", studentService.findAll());
        return "student/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.findOne(id));
        return "student/show";
    }

    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student") Student student) {
        return "student/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("student") @Valid Student student,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "student/new";

        studentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("student", studentService.findOne(id));
        return "student/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "student/edit";

        studentService.update(id, student);
        return "redirect:/student";
    }

    public String delete(@PathVariable("id") int id){
        studentService.delete(id);
        return "redirect:/student";
    }

}