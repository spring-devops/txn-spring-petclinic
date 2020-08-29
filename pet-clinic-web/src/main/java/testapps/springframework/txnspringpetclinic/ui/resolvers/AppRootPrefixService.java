package testapps.springframework.txnspringpetclinic.ui.resolvers;

import org.springframework.stereotype.Service;

@Service
public class AppRootPrefixService implements GenericRootPrefix<String>{

    private final String rootPrefix = "classpath:/templates/";

    @Override
    public String getRootUrlPrefix() {
        return rootPrefix;
    }
}
