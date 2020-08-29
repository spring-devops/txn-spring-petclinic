package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Veterinarian;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdService;

public class VeterinarianServiceMap extends AbstractMapService<Veterinarian, Long> implements GenericEntityService <Veterinarian, Long>{

    private final MapIdService<Veterinarian> mapIdService;

    public VeterinarianServiceMap(MapIdService<Veterinarian> mapIdService) {
        this.mapIdService = mapIdService;
    }

    @Override
    protected Long getNewId() {
        return this.mapIdService.getNewId(map) ;
    }

    @Override
    protected Long getObjectId(Veterinarian veterinarian) {
        return veterinarian.getId();
    }
}
