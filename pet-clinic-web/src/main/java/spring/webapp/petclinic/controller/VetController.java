package spring.webapp.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.webapp.petclinic.servies.VetService;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/","/vets/index","vets/index.html" , "/vets.html"})
    public String vetList(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
