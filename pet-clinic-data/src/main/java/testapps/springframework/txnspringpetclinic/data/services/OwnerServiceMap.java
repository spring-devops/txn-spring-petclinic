package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Owner;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdService;

public class OwnerServiceMap extends AbstractMapService <Owner, Long> implements GenericEntityService<Owner, Long>{

    private final MapIdService<Owner> mapIdService;

    public OwnerServiceMap(MapIdService mapIdService) {
        this.mapIdService = mapIdService;
    }

    @Override
    protected Long getNewId() {
        return mapIdService.getNewId(map);
    }

    @Override
    protected Long getObjectId(Owner owner) {
        return owner.getId();
    }

    /*public void deleteById (Long id) {
        super.deleteById(id);
    }*/
}
