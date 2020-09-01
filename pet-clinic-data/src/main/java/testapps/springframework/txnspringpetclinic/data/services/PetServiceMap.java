package testapps.springframework.txnspringpetclinic.data.services;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.model.Pet;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdService;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetCrudService {

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

    @Override
    protected void setObjectId(Pet pet, Long aLong) {
        pet.setId(aLong);
    }
}
