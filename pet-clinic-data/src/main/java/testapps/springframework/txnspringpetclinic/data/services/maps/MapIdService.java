package testapps.springframework.txnspringpetclinic.data.services.maps;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.services.GenericIdService;

import java.util.Map;
import java.util.Set;

@Service
public class MapIdService <K> implements GenericIdService <Long, Map<Long, K>> {
    private Long currentValue = 0l;
    @Override
    public synchronized Long getNewId(Map<Long, K> objectToInspect) {
        Set<Long> allIDs = objectToInspect.keySet() ;
        Long returnId = 0l; //getMaxId (allIDs) + 1l;
        if (returnId <= currentValue)
            returnId ++ ;
        currentValue = returnId;
        return returnId;
    }

    private Long getMaxId (Set<Long> allIDs) {
        Long returnVal = 0l;
        for (Long nextKey: allIDs) { if (nextKey > returnVal) returnVal = nextKey;}
        return returnVal;
    }
}
