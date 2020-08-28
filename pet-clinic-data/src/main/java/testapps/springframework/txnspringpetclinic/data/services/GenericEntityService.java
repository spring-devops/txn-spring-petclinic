package testapps.springframework.txnspringpetclinic.data.services;

import java.util.Set;

public interface GenericEntityService<T, K> {
        T findById(K id);

        T save(T t);

        Set<T> finadAll();
}
