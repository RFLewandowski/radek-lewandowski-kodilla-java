package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyEmployeeFacadeTestSuite {

    CompanyEmployeeFacade companyEmployeeFacade;

    Employee johnSmith = null;
    Employee stephanieClarckson = null;
    Employee lindaKovalsky = null;

    Company softwareMachine = null;
    Company dataMaesters = null;
    Company greyMatter = null;

    @Test
    public void ShouldFindCompanybyPartOfName() {
        //Given&When
        List<Company> actualComapany = companyEmployeeFacade.findCompanyByPartOfName("Grey");
        //Then
        Assert.assertEquals(greyMatter.getName(), actualComapany.get(0).getName());
    }

    @Test
    public void ShouldFindEmployeebyPartOfName() {
        //Given&When
        List<Employee> actualEmployee = companyEmployeeFacade.findEmployeeByPartOfName("Smith");
        //Then
        Assert.assertEquals(johnSmith.getLastname(), actualEmployee.get(0).getLastname());
    }


    @Before
    public void setUp() {
        johnSmith = new Employee("John", "Smith");
        stephanieClarckson = new Employee("Stephanie", "Clarckson");
        lindaKovalsky = new Employee("Linda", "Kovalsky");

        softwareMachine = new Company("Software Machine");
        dataMaesters = new Company("Data Maesters");
        greyMatter = new Company("Grey Matter");
    }

    @After
    public void tearDown() {
        try {
            companyEmployeeFacade.getCompanyDao().delete(softwareMachine);
            companyEmployeeFacade.getCompanyDao().delete(dataMaesters);
            companyEmployeeFacade.getCompanyDao().delete(greyMatter);

            companyEmployeeFacade.getEmployeeDao().delete(johnSmith);
            companyEmployeeFacade.getEmployeeDao().delete(stephanieClarckson);
            companyEmployeeFacade.getEmployeeDao().delete(lindaKovalsky);
        } catch (Exception e) {
            //do nothing
        }
    }

}