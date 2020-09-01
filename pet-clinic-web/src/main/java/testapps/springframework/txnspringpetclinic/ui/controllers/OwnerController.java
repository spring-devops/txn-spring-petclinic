package testapps.springframework.txnspringpetclinic.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import testapps.springframework.txnspringpetclinic.data.services.OwnerCrudService;
import testapps.springframework.txnspringpetclinic.data.services.OwnerServiceMap;
import testapps.springframework.txnspringpetclinic.ui.resolvers.ThymeLeafUrlService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final ThymeLeafUrlService thymeLeafUrlService;

    public OwnerController(ThymeLeafUrlService thymeLeafUrlService, OwnerServiceMap ownerServiceMap) {
        this.thymeLeafUrlService = thymeLeafUrlService;
        this.ownerCrudService = ownerServiceMap;
    }

    private final OwnerCrudService ownerCrudService;

    @RequestMapping({"", "/", "/index.html"})
    public String listOwners(Model model) {

        model.addAttribute("owners", ownerCrudService.findAll());
        return thymeLeafUrlService.getUrl("owners/index.html");
    }
}
