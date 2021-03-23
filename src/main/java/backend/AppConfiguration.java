package backend;

import backend.DataService.EmployeeDataService;
import backend.DataService.ServiceDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public ServiceDataService createSerDataService() {
        ServiceDataService d = new ServiceDataService();
        d.createInitialCars();
        return d;
    }

    @Bean
    public EmployeeDataService createEmpDataService() {
        EmployeeDataService d = new EmployeeDataService();
        d.createInitialCars();
        return d;
    }
}

