package com.akademia.detyrajpa;

import com.akademia.detyrajpa.dao.EmployeeRepository;
import com.akademia.detyrajpa.dao.SalaryRepository;
import com.akademia.detyrajpa.dao.impl.*;
import com.akademia.detyrajpa.entity.compositeprimarykeys.SalaryEntityId;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;

@RequiredArgsConstructor
@SpringBootApplication
public class DetyraJpaApplication implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(DetyraJpaApplication.class);

    private final EmployeeRepositoryImpl employeeRepository;
    private final SalaryRepositoryImpl salaryRepository;
    private final TitleRepositoryImpl titleRepository;
    private final DepartmentRepositoryImpl departmentRepository;
    private final DepartmentManagerRepositoryImpl departmentManagerRepository;
    private final DepartmentEmployeeRepositoryImpl departmentEmployeeRepository;


    public static void main(String[] args) {
        SpringApplication.run(DetyraJpaApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
         logger.info("these are the employees: {}",employeeRepository.findAll(1,10,"firstName",true));
     //   logger.info("these are the salaries: {}", salaryRepository.findAll(10, 10, "salary", false));
    //    SalaryEntityId salaryEntityId = new SalaryEntityId(10001, LocalDate.of(1986, 6, 26));
      //  logger.info("result: {} ", salaryRepository.findById(salaryEntityId));

       // logger.info("these are the departments: {}",departmentRepository.findAll(1,999,"deptName",true));
       // logger.info("these are the employees hired before the date : {}",employeeRepository.getEmployeeAfterHireDate(LocalDate.of(1992,12,18)));
       // logger.info("these are the employees with salary greater than: {} : {}",5000,employeeRepository.getEmployeeWithSalaryGreaterThan(5000));
       // logger.info("these are the employees with {} as title : {}", "senior engineer", employeeRepository.getAllEmployeesWithTitle("senior engineer"));
        //logger.info("{}",salaryRepository.getLatestSalaryForAllEmployees());
        // logger.info("These are the avarage salaries : {}", departmentEmployeeRepository.getAvarageSalaryPerDepartment());
        //logger.info("For the {} department, there are {} employees","Marketing",employeeRepository.getEmployeesNumberPerDepartment("Marketing"));
    }

}
