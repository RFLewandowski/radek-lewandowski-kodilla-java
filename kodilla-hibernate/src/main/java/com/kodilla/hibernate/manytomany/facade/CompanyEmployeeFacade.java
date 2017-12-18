package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class CompanyEmployeeFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public CompanyEmployeeFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    List<Company> findCompanyByPartOfName(String partOfName) {
        partOfName = "%" + partOfName + "%";
        return companyDao.findCompanyByPartOfName(partOfName);
    }

    List<Employee> findEmployeeByPartOfName(String partOfName) {
        partOfName = "%" + partOfName + "%";
        return employeeDao.findEmployeeByPartOfName(partOfName);
    }
}
