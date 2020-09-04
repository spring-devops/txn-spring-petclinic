package testapps.springframework.txnspringpetclinic.data.services;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.model.Owner;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapLongIdService;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdLongService;

@Service
public class OwnerServiceMap extends AbstractMapLongIdService<Owner> implements OwnerCrudService {

    public OwnerServiceMap(MapIdLongService<Owner> mapIdLongService) {
        super (mapIdLongService);
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
