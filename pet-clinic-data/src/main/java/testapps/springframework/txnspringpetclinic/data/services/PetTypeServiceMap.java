package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.PetType;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapLongIdService;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdLongService;

public class PetTypeServiceMap extends AbstractMapLongIdService<PetType> implements PetTYpeCrudService{

    public PetTypeServiceMap(MapIdLongService<PetType> mapIdLongService) {
        super(mapIdLongService);
    }

    @Override
    protected Long getObjectId(PetType petType) {
        return petType.getId();
    }

    @Override
    protected void setObjectId(PetType petType, Long aLong) {
        petType.setId(aLong);
    }
}
