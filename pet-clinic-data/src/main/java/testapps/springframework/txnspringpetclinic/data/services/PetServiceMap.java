package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Pet;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements GenericEntityService<Pet, Long>{

    @Override
    protected Long getNewId() {
        return 0l;
    }

    @Override
    protected Long getObjectId(Pet pet) {
        return pet.getId();
    }
}
