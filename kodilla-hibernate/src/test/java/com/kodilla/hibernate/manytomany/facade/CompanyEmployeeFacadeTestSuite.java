package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.ManageEmployeesAndCompanies;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyEmployeeFacadeTestSuite {

    @Autowired
    private CompanyEmployeeFacade companyEmployeeFacade;

    @Autowired
    private ManageEmployeesAndCompanies empAndCompManager;

    private CompanyDao companyDao = null;
    private EmployeeDao employeeDao = null;

    private Employee johnSmith = null;
    private Company greyMatter = null;

    @Test
    public void ShouldFindCompanybyPartOfName() {
        //Given
        companyDao.save(greyMatter);
        // When
        List<Company> actualComapany = companyEmployeeFacade.findCompanyByPartOfName("Gre");
        //Then
        Assert.assertEquals(greyMatter.getName(), actualComapany.get(0).getName());
    }

    @Test
    public void ShouldFindEmployeebyPartOfName() {
        //Given
        employeeDao.save(johnSmith);
        // When
        List<Employee> actualEmployee = companyEmployeeFacade.findEmployeeByPartOfName("mith");
        //Then
        System.out.println("test");
        Assert.assertEquals(johnSmith.getLastname(), actualEmployee.get(0).getLastname());
    }


    @Before
    public void setUp() {
        empAndCompManager.setUp();

        johnSmith = empAndCompManager.getJohnSmith();
        greyMatter = empAndCompManager.getGreyMatter();

        companyDao = empAndCompManager.getCompanyDao();
        employeeDao = empAndCompManager.getEmployeeDao();
    }

    @After
    public void tearDown() throws Exception {
        empAndCompManager.tearDown();
    }

}