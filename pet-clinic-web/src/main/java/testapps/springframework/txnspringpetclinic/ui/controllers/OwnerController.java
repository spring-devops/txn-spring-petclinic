package testapps.springframework.txnspringpetclinic.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import testapps.springframework.txnspringpetclinic.ui.resolvers.ThymeLeafUrlService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final ThymeLeafUrlService thymeLeafUrlService;

    public OwnerController(ThymeLeafUrlService thymeLeafUrlService) {
        this.thymeLeafUrlService = thymeLeafUrlService;
    }

    @RequestMapping({"", "/", "/index.html"})
    public String listOwners() {
        return thymeLeafUrlService.getUrl("owners/index.html");
    }
}
