package backend.DataService;

import backend.Bean.Employee;
import backend.Bean.Service;
import backend.DTO.EmployeeDto;
import backend.DTO.ServiceDto;
import backend.Resource.EmployeeResource;
import backend.Resource.ServiceResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeDataService {
    private HashMap<Integer, Employee> employees = new HashMap<>();
    public void createInitialCars() {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Max");
        e1.setLongitude("teadf");
        e1.setLatitude("adfdsa");
        this.employees.put(e1.getId(), e1);
        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Jan");
        e2.setLongitude("tedsfdfsadfadf");
        e2.setLatitude("adfasfddasfdsa");
        this.employees.put(e2.getId(), e2);
    }

    public List<EmployeeResource> getEmployeeResources() {
        List<EmployeeResource> result = new ArrayList<>();
        for (Employee cemployee : employees.values()) {
            EmployeeResource cResource = convertEmployeeToEmployeeResource(cemployee);
            result.add(cResource);
        }
        return result;
    }

    private EmployeeResource convertEmployeeToEmployeeResource(Employee cEmployee) {
        EmployeeResource employeeResource=new EmployeeResource();
        employeeResource.setId(cEmployee.getId());
        employeeResource.setName(cEmployee.getName());
        employeeResource.setLongitude(cEmployee.getLongitude());
        employeeResource.setLatitude(cEmployee.getLatitude());
        return employeeResource;
    }

    public EmployeeResource addEmployee(EmployeeDto employeeDto) {
        Employee newEmployee = new Employee();
        newEmployee.setId(this.employees.size() + 1);
        newEmployee.setName(employeeDto.getName());
        newEmployee.setLatitude(employeeDto.getLatitude());
        newEmployee.setLongitude(employeeDto.getLongitude());
        this.employees.put(newEmployee.getId(), newEmployee);
        return convertEmployeeToEmployeeResource(newEmployee);
    }
}
