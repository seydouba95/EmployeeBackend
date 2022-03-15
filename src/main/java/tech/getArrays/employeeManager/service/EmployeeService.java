package tech.getArrays.employeeManager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getArrays.employeeManager.exception.UserNotFoundException;
import tech.getArrays.employeeManager.model.Employee;
import tech.getArrays.employeeManager.repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

 @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
      employee.setEmployeeCode(UUID.randomUUID().toString());
      return employeeRepository.save(employee);

    }

    public List<Employee> findAllEmployees(){
     return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
     return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
     return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + "was not found"));
    }

    public void deleteEmployee(Long id){
     employeeRepository.deleteEmployeeById(id);
    }
}
