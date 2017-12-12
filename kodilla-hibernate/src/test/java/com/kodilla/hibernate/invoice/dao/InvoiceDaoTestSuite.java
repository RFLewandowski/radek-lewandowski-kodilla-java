package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.After;
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

    @Autowired
    ItemDao itemDao;

    @Autowired
    ProductDao productDao;

    @Test
    public void ShouldSaveInvoiceDao() {

        //Given
        Product pomidorek = new Product("pomidorek");
        Product ogorek = new Product("ogorek");

        BigDecimal dummyPrice = new BigDecimal(2.0);
        BigDecimal dummyValue = new BigDecimal(1.0);

//        productDao.save(pomidorek);
//        productDao.save(ogorek);

        Item item1 = new Item(dummyPrice, 1, dummyValue);
        Item item2 = new Item(dummyPrice, 2, dummyValue);
        Item item3 = new Item(dummyPrice, 3, dummyValue);
        Item item4 = new Item(dummyPrice, 19, dummyValue);

        item1.setProduct(ogorek);
        item2.setProduct(pomidorek);
        item3.setProduct(ogorek);
        item4.setProduct(pomidorek);

//        itemDao.save(item1);
//        itemDao.save(item2);
//        itemDao.save(item3);
//        itemDao.save(item4);

        Invoice invoice = new Invoice("DummyInvoice");

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

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
//        int invoiceID = invoice.getId();


//        itemDao.save(item1);
//        itemDao.save(item2);
//        itemDao.save(item3);
//        itemDao.save(item4);




        Object actualInvoiceIdReverenceInItemTable = itemDao
                .findAll()
                .get(0)
                .getInvoice();
        
        //Then
//        Assert.assertNotEquals(0, invoiceID);
        Assert.assertNotEquals(null, actualInvoiceIdReverenceInItemTable);
    }


//    @After
//    public void tearDown() throws Exception {
//        invoiceDao.deleteAll();
//    }
}