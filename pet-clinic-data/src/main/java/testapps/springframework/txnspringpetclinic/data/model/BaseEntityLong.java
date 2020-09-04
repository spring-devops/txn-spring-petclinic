package testapps.springframework.txnspringpetclinic.data.model;

public abstract class BaseEntityLong implements GenericBaseEntity<Long> {
    Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public abstract boolean isValidEntity () ;
}
