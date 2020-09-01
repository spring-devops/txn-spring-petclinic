package testapps.springframework.txnspringpetclinic.data.services;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.model.Veterinarian;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdService;

@Service
public class VeterinarianServiceMap extends AbstractMapService<Veterinarian, Long> implements VeterinarianCrudService {

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

    @Override
    protected void setObjectId(Veterinarian veterinarian, Long aLong) {
        veterinarian.setId(aLong);
    }
}
