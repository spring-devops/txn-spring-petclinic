package testapps.springframework.txnspringpetclinic.data.model;

public class BaseEntityLong implements GenericBaseEntity<Long> {
    Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
