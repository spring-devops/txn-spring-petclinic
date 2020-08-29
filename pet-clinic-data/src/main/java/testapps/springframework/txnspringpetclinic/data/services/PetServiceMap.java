package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Pet;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements GenericEntityService<Pet, Long>{

    private final MapIdService<Pet> mapIdService;

    public PetServiceMap(MapIdService mapIdService) {
        this.mapIdService = mapIdService;
    }

    @Override
    protected Long getNewId() {
        return mapIdService.getNewId(map);
    }

    @Override
    protected Long getObjectId(Pet pet) {
        return pet.getId();
    }
}
