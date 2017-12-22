package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
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
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao = null;
    @Autowired
    private EmployeeDao employeeDao = null;

    private Employee johnSmith = null;
    private Employee stephanieClarckson = null;
    private Employee lindaKovalsky = null;

    private Company softwareMachine = null;
    private Company dataMaesters = null;
    private Company greyMatter = null;

    @Before
    public void setUp() throws Exception {
        johnSmith = new Employee("John", "Smith");
        stephanieClarckson = new Employee("Stephanie", "Clarckson");
        lindaKovalsky = new Employee("Linda", "Kovalsky");

        softwareMachine = new Company("Software Machine");
        dataMaesters = new Company("Data Maesters");
        greyMatter = new Company("Grey Matter");
    }

    @After
    public void tearDown() throws Exception {
        companyDao.delete(softwareMachine);
        companyDao.delete(dataMaesters);
        companyDao.delete(greyMatter);

        employeeDao.delete(johnSmith);
        employeeDao.delete(stephanieClarckson);
        employeeDao.delete(lindaKovalsky);
    }

    @Test
    public void Should_SaveManyEmployeesToManyCompanies() {
        //Given
        softwareMachine.getEmployees()
                .add(johnSmith);
        dataMaesters.getEmployees()
                .add(stephanieClarckson);
        dataMaesters.getEmployees()
                .add(lindaKovalsky);
        greyMatter.getEmployees()
                .add(johnSmith);
        greyMatter.getEmployees()
                .add(lindaKovalsky);

        johnSmith.getCompanies()
                .add(softwareMachine);
        johnSmith.getCompanies()
                .add(greyMatter);
        stephanieClarckson.getCompanies()
                .add(dataMaesters);
        lindaKovalsky.getCompanies()
                .add(dataMaesters);
        lindaKovalsky.getCompanies()
                .add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);
    }

    @Test
    public void Should_FindEmployeesByLastname() {
        //Given
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        //When
        List<Employee> actualEmployee = employeeDao.retrieveEmployeesWithLastnameEqual("Smith");

        //Then
        try {
            Assert.assertEquals(johnSmith.getFirstname(), actualEmployee.get(0).getFirstname());
            Assert.assertEquals(1, actualEmployee.size());
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void Should_FindCompanyiesByFirstLetters() {
        //Given
        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        //When
        List<Company> greyCompany = companyDao.retrieveCompaniesWithFirstLettersEqualTo("Gre");

        //Then
        try {
            Assert.assertEquals(1, greyCompany.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}