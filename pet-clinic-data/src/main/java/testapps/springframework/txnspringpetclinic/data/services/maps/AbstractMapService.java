package testapps.springframework.txnspringpetclinic.data.services.maps;

import java.util.*;

public abstract class AbstractMapService <T, ID> {
    protected Map<ID, T> map = new HashMap<ID, T>();

    protected abstract ID getNewId() ;

    protected abstract ID getObjectId(T t) ;

    protected abstract void setObjectId(T t, ID id) ;

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T t) {
        ID id = getObjectId(t);
        if (id == null) id = getNewId();
        setObjectId(t, id);
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

    @Override
    public String toString() {
        StringBuilder toStringValue = new StringBuilder();
        toStringValue.append("AbstractMapService >>>> Dump for: " + map.hashCode() + ", Size: " + map.size() +  "\n");
        for (ID mapId: map.keySet()){
            toStringValue.append("Class: " + map.get(mapId).getClass().getName() + ", ID: " + mapId.toString() + ", Value: " + map.get(mapId).toString() + "\n");
        }
        return toStringValue.toString();
    }

}
