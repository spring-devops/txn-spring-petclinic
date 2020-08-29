package testapps.springframework.txnspringpetclinic.data.services;

public interface GenericIdService<T, K> {
    public T getNewId(K objectToInspect);
}
