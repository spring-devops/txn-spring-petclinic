package testapps.springframework.txnspringpetclinic.data.services;

import testapps.springframework.txnspringpetclinic.data.model.Speciality;
import testapps.springframework.txnspringpetclinic.data.services.maps.AbstractMapLongIdService;
import testapps.springframework.txnspringpetclinic.data.services.maps.MapIdLongService;

public class SpecialtyServiceMap extends AbstractMapLongIdService<Speciality> implements SpecialityCrudService{

    public SpecialtyServiceMap(MapIdLongService<Speciality> mapIdLongService) {
        super(mapIdLongService);
    }

    @Override
    protected Long getObjectId(Speciality speciality) {
        return speciality.getId();
    }

    @Override
    protected void setObjectId(Speciality speciality, Long aLong) {
        speciality.setId(aLong);
    }
}
