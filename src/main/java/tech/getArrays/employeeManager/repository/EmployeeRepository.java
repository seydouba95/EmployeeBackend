package tech.getArrays.employeeManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getArrays.employeeManager.model.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    void deleteEmployeeById(long id);

  Optional<Employee> findEmployeeById(Long id);




}
