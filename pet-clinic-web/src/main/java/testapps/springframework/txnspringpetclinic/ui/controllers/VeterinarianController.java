package testapps.springframework.txnspringpetclinic.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import testapps.springframework.txnspringpetclinic.ui.resolvers.ThymeLeafUrlService;

@Controller
public class VeterinarianController {

    private final ThymeLeafUrlService thymeLeafUrlService;

    public VeterinarianController(ThymeLeafUrlService thymeLeafUrlService) {
        this.thymeLeafUrlService = thymeLeafUrlService;
    }

    @RequestMapping({"/vets","/vets/index","/vets/index.html", "/vets/index.aspx"})
    public String listVets() {
        return this.thymeLeafUrlService.getUrl("vets/index") ;
    }
}
