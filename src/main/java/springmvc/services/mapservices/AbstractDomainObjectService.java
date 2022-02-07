package springmvc.services.mapservices;

import springmvc.domain.Customer;
import springmvc.domain.DomainObject;

import java.util.*;

public abstract class AbstractDomainObjectService {
    protected Map<Integer, DomainObject> domainObjects;


    public AbstractDomainObjectService() {
        domainObjects = new HashMap<>();
    }

    public List<DomainObject> all(){
        return new ArrayList<>(domainObjects.values());
    }
    public DomainObject getById(Integer id){
        return domainObjects.get(id);
    }

    public DomainObject saveOrUpdate(DomainObject domainObject) {
        if(domainObject != null) {
            if (domainObject.getId() == null)
                domainObject.setId(getNext());
            domainObjects.put(domainObject.getId(), domainObject);
            return domainObject;
        }
        else{
            throw new RuntimeException("Object Can't be null!");
        }
    }

    public Integer getNext() {
        if(domainObjects.size() == 0)
            return 1;
        return Collections.max(domainObjects.keySet()) + 1;
    }

    public void delete(Integer id){
        domainObjects.remove(id);
    }
}
