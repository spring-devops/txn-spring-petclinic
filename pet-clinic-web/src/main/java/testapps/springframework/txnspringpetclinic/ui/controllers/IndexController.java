package testapps.springframework.txnspringpetclinic.ui.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import testapps.springframework.txnspringpetclinic.ui.resolvers.JspUrlService;
import testapps.springframework.txnspringpetclinic.ui.resolvers.ThymeLeafUrlService;

@Controller
public class IndexController {

    private final ThymeLeafUrlService thymeLeafUrlService;
    private final JspUrlService jspUrlService;

    public IndexController(ThymeLeafUrlService thymeLeafUrlService, JspUrlService jspUrlService) {
        this.thymeLeafUrlService = thymeLeafUrlService;
        this.jspUrlService = jspUrlService;
    }

    @RequestMapping({"/","","/index.html","/index.htm"})
    public String index(){
        /*System.out.println(">>>> Returning " + jspUrlService.getUrl("index"));
        return jspUrlService.getUrl("index");*/
        return thymeLeafUrlService.getUrl("index");
    }

    @RequestMapping({"/oups",})
    public String error(){
        /*System.out.println(">>>> Returning " + jspUrlService.getUrl("index"));
        return jspUrlService.getUrl("index");*/
        return thymeLeafUrlService.getUrl("oups");
    }
}
