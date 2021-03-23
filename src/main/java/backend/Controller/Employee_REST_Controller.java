package backend.Controller;



import backend.DTO.EmployeeDto;
import backend.DataService.EmployeeDataService;
import backend.Resource.EmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Employee_REST_Controller {

    @Autowired
    public EmployeeDataService employeeDataService;

    @RequestMapping(value ="/employees", method = RequestMethod.GET)
    public HttpEntity<List<EmployeeResource>> getAllEmployees() {
        List<EmployeeResource> employeeResources = employeeDataService.getEmployeeResources();
        return new HttpEntity<>(employeeResources);
    }

    @RequestMapping(value ="/employees", method = RequestMethod.POST)
    public EmployeeResource addEmployeee(@RequestBody EmployeeDto employeeDto) {
        return employeeDataService.addEmployee(employeeDto);
    }

}
