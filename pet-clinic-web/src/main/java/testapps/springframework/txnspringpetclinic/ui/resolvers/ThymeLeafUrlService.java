package testapps.springframework.txnspringpetclinic.ui.resolvers;

import org.springframework.stereotype.Service;

@Service
public class ThymeLeafUrlService implements GenericUrlGenerator<String, String>{

    private final String thymeLeafPrefix = "thymeleaf/";

    @Override
    public String getViewName() {
        return thymeLeafPrefix + "*";
    }

    @Override
    public String getUrl(String resourceName) {
        return thymeLeafPrefix + ((resourceName != null) ? resourceName : "") ;
    }
}
