package testapps.springframework.txnspringpetclinic.data.services;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.model.Owner;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdService;

@Service
public class OwnerServiceMap extends AbstractMapService <Owner, Long> implements OwnerCrudService {

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

    @Override
    protected void setObjectId(Owner owner, Long aLong) {
        owner.setId(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }

/*public void deleteById (Long id) {
        super.deleteById(id);
    }*/
}
