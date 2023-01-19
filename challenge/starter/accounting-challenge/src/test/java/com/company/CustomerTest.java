package com.company;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void shouldGetTheBalanceByAddingRecordValue(){
        Customer cust = new Customer();

        int t=1;
        for(int i =0; i<5;i++) {
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(i);
            accountRecord.setChargeDate("Day "+i);
            cust.getCharges().add(accountRecord);
        }
        assertEquals(10,cust.getBalance());
    }

    @Test
    public void shouldReturnCorrectToString(){
        Customer cust = new Customer();
        cust.setName("Ron");
        cust.setId(1);
        for(int i =0; i<5;i++) {
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(i);
            accountRecord.setChargeDate("Day "+i);
            cust.getCharges().add(accountRecord);
        }
        assertEquals( "Customer ID = 1 Customer name = Ron Customer balance = 10", cust.toString());
    }
}
