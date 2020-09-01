package testapps.springframework.txnspringpetclinic.data.services.maps;

import org.springframework.stereotype.Service;
import testapps.springframework.txnspringpetclinic.data.services.GenericIdService;

import java.util.Map;
import java.util.Set;

@Service
public class MapIdService <K> implements GenericIdService <Long, Map<Long, K>> {

    //Note: We can implement a separate sequence for each MAP INSTANCE that gets passed. However for purposes of example, we can share the same seed with all maps
    //Conversely we can have this class as a prototype and then each ID series will be unique to the instance of the Service that creates it
    private Long currentValue = 0l;
    @Override
    public synchronized Long getNewId(Map<Long, K> objectToInspect) {
        Set<Long> allIDs = objectToInspect.keySet() ;
        Long returnId = 0l; //getMaxId (allIDs) + 1l;
        //Initialize from 1 at the onset
        if (allIDs == null || allIDs.size() == 0) returnId = 1l;
        else returnId = getMaxId(allIDs) ;
        if (returnId <= currentValue)
            returnId = currentValue + 1 ;
        currentValue = returnId;
        System.out.println("MapIdService >>>> Returning next ID: " + returnId + " for Map: " + objectToInspect.hashCode() + ", Current ID is set to: " + currentValue);
        return returnId;
    }

    private Long getMaxId (Set<Long> allIDs) {
        Long returnVal = 0l;
        for (Long nextKey: allIDs) { if (nextKey > returnVal) returnVal = nextKey;}
        return returnVal;
    }
}
