package testapps.springframework.txnspringpetclinic.ui.resolvers;

import org.springframework.stereotype.Service;

@Service
public class JspUrlService implements GenericUrlGenerator<String, String>{

    private final String jspPrefix = "jsps/" ;

    @Override
    public String getViewName() {
        return jspPrefix + "*";
    }

    @Override
    public String getUrl(String resourceName) {
        return jspPrefix + ((resourceName != null) ? resourceName : "") ;
    }
}
