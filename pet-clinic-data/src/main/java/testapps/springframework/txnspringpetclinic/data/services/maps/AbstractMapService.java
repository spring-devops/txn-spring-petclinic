package testapps.springframework.txnspringpetclinic.data.services.maps;

import java.util.*;

public abstract class AbstractMapService <T, ID> {
    protected Map<ID, T> map = new HashMap<ID, T>();

    protected abstract ID getNewId() ;

    protected abstract ID getObjectId(T t) ;

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T t) {
        ID id = getObjectId(t);
        if (id == null) id = getNewId();
        map.put(id, t);
        return t;
    }

    public Set<T> findAll() {
        return new HashSet<T>(map.values());
    }

    public void delete (T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t)) ;
        /* for (ID id: map.keySet()){
            if (Objects.equals(map.get(id), t)) map.remove(id) ;
        } */
    }

    public void deleteById (ID id) {
        map.remove(id);
    }

    public boolean isIdUnique(ID id) {
        for (ID mapId: map.keySet()){
            if (Objects.equals(id, mapId)) return false ;
        }
        return true;
    }
}
