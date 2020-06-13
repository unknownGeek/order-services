package app;

import service.consumer.ConsumerServiceImpl;
import service.filters.CORSFilter;
import service.lookup.LookupServiceImpl;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/services")
public class OrderServices extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    private LookupServiceImpl lookupService;

    private ConsumerServiceImpl consumerService;

    public OrderServices() {
        this.lookupService = new LookupServiceImpl();
        this.consumerService = new ConsumerServiceImpl();
        singletons.add(lookupService);
        singletons.add(consumerService);
    }

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(CORSFilter.class);
        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}