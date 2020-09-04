package testapps.springframework.txnspringpetclinic.data.services;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.model.Veterinarian;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapLongIdService;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdLongService;

@Service
public class VeterinarianServiceMapBased extends AbstractMapLongIdService<Veterinarian> implements VeterinarianCrudService {

    public VeterinarianServiceMapBased(MapIdLongService<Veterinarian> mapIdLongService) {
        super(mapIdLongService);
    }

    @Override
    protected Long getObjectId(Veterinarian veterinarian) {
        return veterinarian.getId();
    }

    @Override
    protected void setObjectId(Veterinarian veterinarian, Long aLong) {
        veterinarian.setId(aLong);
    }
}
