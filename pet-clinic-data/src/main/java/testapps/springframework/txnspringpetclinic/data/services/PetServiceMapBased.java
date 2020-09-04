package testapps.springframework.txnspringpetclinic.data.services;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.model.Pet;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapLongIdService;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdLongService;

@Service
public class PetServiceMapBased extends AbstractMapLongIdService<Pet> implements PetCrudService {

   public PetServiceMapBased(MapIdLongService<Pet> mapIdLongService) {
        super(mapIdLongService);
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
