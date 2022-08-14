package h8me.CrudSpringBoot.controllers;

import h8me.CrudSpringBoot.models.Course;
import h8me.CrudSpringBoot.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;

    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("course", courseService.findAll());

        return "course/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("course", courseService.findOne(id));
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

        courseService.save(course);
        return "redirect:/course";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id) {
        model.addAttribute("course", courseService.findOne(id));
        return "course/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("course") @Valid Course course, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "course/edit";

        courseService.update(id, course);
        return "redirect:/course";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        courseService.delete(id);
        return "redirect:/course";
    }

}
