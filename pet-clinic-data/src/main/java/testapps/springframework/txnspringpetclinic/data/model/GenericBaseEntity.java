package testapps.springframework.txnspringpetclinic.data.model;

public interface GenericBaseEntity<T> {
    public T getId();
    public void setId(T t);
    public String partialToString();
    public boolean isValid();
}
