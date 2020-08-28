package testapps.springframework.txnspringpetclinic.data.services;

import java.util.Set;

public interface GenericEntityService<T, ID> {
        public T findById(ID id);

        public T save(T t);

        public Set<T> findAll();

        public void delete (T t);

        public void deleteById (ID id);
}
