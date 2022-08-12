package h8me.CrudSpringBoot.controllers;

import h8me.CrudSpringBoot.models.Lesson;
import h8me.CrudSpringBoot.services.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;


    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;

    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("lesson", lessonService.findAll());

        return "lesson/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("lesson", lessonService.findOne(id));
        return "lesson/show";
    }

    @GetMapping("/new")
    public String newLesson(@ModelAttribute("lesson") Lesson lesson) {
        return "lesson/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("lesson") @Valid Lesson lesson,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "lesson/new";

        lessonService.save(lesson);
        return "redirect:/lesson";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("lesson", lessonService.findOne(id));
        return "lesson/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("leeson") @Valid Lesson lesson, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "lesson/edit";

        lessonService.update(id, lesson);
        return "redirect:/lesson";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        lessonService.delete(id);
        return "redirect:/lesson";
    }

}
