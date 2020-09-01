package testapps.springframework.txnspringpetclinic.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import testapps.springframework.txnspringpetclinic.data.services.VeterinarianCrudService;
import testapps.springframework.txnspringpetclinic.ui.resolvers.ThymeLeafUrlService;

@Controller
public class VeterinarianController {

    private final ThymeLeafUrlService thymeLeafUrlService;

    public VeterinarianController(ThymeLeafUrlService thymeLeafUrlService, VeterinarianCrudService veterinarianCrudService) {
        this.thymeLeafUrlService = thymeLeafUrlService;
        this.veterinarianCrudService = veterinarianCrudService;
    }

    private final VeterinarianCrudService veterinarianCrudService;

    @RequestMapping({"/vets","/vets/index","/vets/index.html", "/vets/index.aspx"})
    public String listVets(Model model) {
        model.addAttribute("vets", veterinarianCrudService.findAll());
        return this.thymeLeafUrlService.getUrl("vets/index") ;
    }
}
