package backend.DataService;


import backend.Bean.Service;
import backend.DTO.ServiceDto;
import backend.Resource.ServiceResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServiceDataService {
    private HashMap<Integer, Service> services = new HashMap<>();
    public void createInitialCars() {
        Service s1 = new Service();
        s1.setId(1);
        s1.setName("Service1");
        s1.setDate("11.11.2020");
        s1.setLongitude("Andorf 13");
        s1.setEmployeeId(1);
        this.services.put(s1.getId(), s1);
        Service s2 = new Service();
        s2.setId(2);
        s2.setName("Service2");
        s2.setDate("12.10.2021");
        s2.setLongitude("Diersbach 13");
        s2.setEmployeeId(2);
        this.services.put(s2.getId(), s2);
    }

    public List<ServiceResource> getServiceResources() {
        List<ServiceResource> result = new ArrayList<>();
        for (Service cservice : services.values()) {
            ServiceResource cResource = convertServiceToServiceResource(cservice);
            result.add(cResource);
        }
        return result;
    }

    public ServiceResource getServiceResourceWithId(int id) {
        return convertServiceToServiceResource(services.get(id));
    }
    public void deletServiceResourceWithId(int id) {
        this.services.remove(id);
    }

    private ServiceResource convertServiceToServiceResource(Service cService) {
        ServiceResource serviceResource = new ServiceResource();
        serviceResource.setId(cService.getId());
        serviceResource.setName(cService.getName());
        serviceResource.setDate(cService.getDate());
        serviceResource.setEmployeeId(cService.getEmployeeId());
        serviceResource.setLatitude(cService.getLatitude());
        serviceResource.setLongitude(cService.getLongitude());
        return serviceResource;
    }

    public ServiceResource addService(ServiceDto carDto) {
        Service newService = new Service();
        newService.setId(this.services.size() + 1);
        newService.setName(carDto.getName());
        newService.setDate(carDto.getDate());
        newService.setEmployeeId(carDto.getEmployeeId());
        newService.setLatitude(carDto.getLatitude());
        newService.setLongitude(carDto.getLongitude());
        this.services.put(newService.getId(), newService);
        return convertServiceToServiceResource(newService);
    }

    public ServiceResource editService(int id,ServiceDto serviceDto){
        Service servicetoChange=services.get(id);
        servicetoChange.setName(serviceDto.getName());
        servicetoChange.setDate(serviceDto.getDate());
        servicetoChange.setEmployeeId(serviceDto.getEmployeeId());
        servicetoChange.setLongitude(serviceDto.getLongitude());
        servicetoChange.setLatitude(serviceDto.getLatitude());
        return convertServiceToServiceResource(servicetoChange);
    }
}