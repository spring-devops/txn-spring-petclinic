package testapps.springframework.txnspringpetclinic.data.services.maps;

public abstract class AbstractMapLongIdService<T> extends AbstractMapService<T, Long> {

    private final MapIdLongService<T> mapIdLongService;

    public AbstractMapLongIdService(MapIdLongService<T> mapIdLongService) {
        this.mapIdLongService = mapIdLongService;
    }

    @Override
    protected Long getNewId() {
        return this.mapIdLongService.getNewId(map) ;
    }
}
