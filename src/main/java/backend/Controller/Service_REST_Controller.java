package backend.Controller;

import backend.DTO.ServiceDto;
import backend.DataService.ServiceDataService;
import backend.Resource.ServiceResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Service_REST_Controller {

    @Autowired
    public ServiceDataService serviceDataService;

    @RequestMapping(value ="/services", method = RequestMethod.GET)
    public HttpEntity<List<ServiceResource>> getAllServices() {
        List<ServiceResource> serviceResources = serviceDataService.getServiceResources();
        return new HttpEntity<>(serviceResources);
    }

    @RequestMapping(value ="/services", method = RequestMethod.POST)
    public ServiceResource addService(@RequestBody ServiceDto serviceDto) {
        return serviceDataService.addService(serviceDto);
    }


    @RequestMapping(value ="/services/{serviceId}", method = RequestMethod.PUT)
    public ServiceResource editService(@PathVariable int serviceId, @RequestBody ServiceDto serviceDto) {
        return serviceDataService.editService(serviceId, serviceDto);
    }

    @RequestMapping(value ="/services/{serviceId}", method = RequestMethod.GET)
    public ServiceResource getService(@PathVariable int serviceId) {
        return serviceDataService.getServiceResourceWithId(serviceId);
    }

    @RequestMapping(value ="/services/{serviceId}", method = RequestMethod.DELETE)
    public void deleteService(@PathVariable int serviceId) {
        serviceDataService.deletServiceResourceWithId(serviceId);
    }
}
