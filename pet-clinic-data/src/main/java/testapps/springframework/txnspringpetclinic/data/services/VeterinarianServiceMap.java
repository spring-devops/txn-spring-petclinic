package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Veterinarian;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;

public class VeterinarianServiceMap extends AbstractMapService<Veterinarian, Long> implements GenericEntityService <Veterinarian, Long>{
    @Override
    protected Long getNewId() {
        return 0l;
    }

    @Override
    protected Long getObjectId(Veterinarian veterinarian) {
        return veterinarian.getId();
    }
}
