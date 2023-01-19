package com.company;

import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
      
       //Creating a List that would hold the profile for each Customer
        List<Customer> custommCustomers = new ArrayList<>();
        HashMap<Integer, Customer> hash = new HashMap<>();
        int l=0;
        for(String[] arr: customerData){
        	if(!hash.containsKey(Integer.parseInt(arr[0]))) {
        		l=Integer.parseInt(arr[0])-1;
        		custommCustomers.add(new Customer());
        		hash.put(Integer.parseInt(arr[0]), custommCustomers.get(l));
        		custommCustomers.get(l).setId(Integer.parseInt(arr[0]));
        		custommCustomers.get(l).setName(arr[1]);
        		AccountRecord accountRecord = new AccountRecord();
        		accountRecord.setCharge(Integer.parseInt(arr[2]));
        		accountRecord.setChargeDate(arr[3]);
        		custommCustomers.get(l).getCharges().add(accountRecord);
        	}else {
        		Customer holderCustomer = hash.get(Integer.parseInt(arr[0]));
        		AccountRecord accountRecord = new AccountRecord();
        		accountRecord.setCharge(Integer.parseInt(arr[2]));
        		accountRecord.setChargeDate(arr[3]);
        		holderCustomer.getCharges().add(accountRecord);
        	}

        }
        for(Customer cus: custommCustomers) {
        	System.out.println(cus.toString());
        }
        
        System.out.println("\nPositive accounts:");
        for(Customer custom: custommCustomers) {
        	if(custom.getBalance()>0) {
        		System.out.println(custom.getName());
        	}
        }
        System.out.println();
        System.out.println("Negative accounts:");
        for(Customer custom: custommCustomers) {
        	if(custom.getBalance()<0) {
        		System.out.println(custom.getName());
        	}
        }
    }
}
