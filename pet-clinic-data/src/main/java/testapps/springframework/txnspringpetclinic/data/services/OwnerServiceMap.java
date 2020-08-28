package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Owner;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;

public class OwnerServiceMap extends AbstractMapService <Owner, Long> implements GenericEntityService<Owner, Long>{
    @Override
    protected Long getNewId() {
        return 0l;
    }

    @Override
    protected Long getObjectId(Owner owner) {
        return owner.getId();
    }

    /*public void deleteById (Long id) {
        super.deleteById(id);
    }*/
}
