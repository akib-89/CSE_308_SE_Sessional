/*
 * Copyright (c) 2022, Akibur Rahman
 * All rights reserved
 */

package com.company.problem1;

import com.company.problem1.management.ManagementSystem;
import com.company.problem1.management.ManagementSystemBuilder;

/*
* Client class for the management system demo
* */
public class Main {

    public static void main(String[] args) {
	// write your code here
        // take the input
        // create the object of the management system
        ManagementSystem system = ManagementSystemBuilder.getManagementSystem("Deluxe","Cellular", 5);
        system.displayInformation();
        System.out.println(system.getTotalYearlyCost());
    }
}
