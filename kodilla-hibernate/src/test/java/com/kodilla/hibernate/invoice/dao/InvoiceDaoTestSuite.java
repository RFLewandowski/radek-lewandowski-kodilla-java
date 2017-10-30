package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void ShouldSaveInvoiceDao() {

        //Given
        Product pomidorek = new Product("pomidorek");
        Product ogorek = new Product("ogorek");

        BigDecimal dummyPrice = new BigDecimal(2.0);
        BigDecimal dummyValue = new BigDecimal(1.0);

        Item item1 = new Item(pomidorek, dummyPrice, 1, dummyValue);
        Item item2 = new Item(ogorek, dummyPrice, 2, dummyValue);
        Item item3 = new Item(pomidorek, dummyPrice, 3, dummyValue);
        Item item4 = new Item(ogorek, dummyPrice, 19, dummyValue);

        Invoice invoice = new Invoice("DummyInvoice");

        invoice.getItems()
                .add(item1);
        invoice.getItems()
                .add(item2);
        invoice.getItems()
                .add(item3);
        invoice.getItems()
                .add(item4);

        //When
        invoiceDao.save(invoice);
        int invoiceID = invoice.getId();

        //Then
        Assert.assertNotEquals(0, invoiceID);

        //CleanUp

        //to be done


    }
}
