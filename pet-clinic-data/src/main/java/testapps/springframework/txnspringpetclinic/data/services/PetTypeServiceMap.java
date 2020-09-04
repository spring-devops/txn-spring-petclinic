package testapps.springframework.txnspringpetclinic.data.services;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.model.PetType;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapLongIdService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdLongService;

@Service
public class PetTypeServiceMap extends AbstractMapLongIdService<PetType> implements PetTypeCrudService {

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
