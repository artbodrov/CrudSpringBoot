package h8me.CrudSpringBoot.controllers;

import h8me.CrudSpringBoot.models.Label;
import h8me.CrudSpringBoot.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/labels")
public class LabelController {

    private final LabelService labelService;

    @Autowired
    public LabelController( LabelService labelService) {
        this.labelService = labelService;

    }

@GetMapping("")
    public String index() {

        return "labels/new";
    }
/*    @GetMapping("/new")
    public String newLabel(@ModelAttribute("label") Label label) {
        return "label/new";
    }*/

    @PostMapping("/new/create")
    public String createName(@ModelAttribute("label") @Valid Label label,
                         BindingResult bindingResult) {
    /*    if (bindingResult.hasErrors())
            return "new";
*/
        labelService.save(label);
        return "redirect:/labels";
    }

}
