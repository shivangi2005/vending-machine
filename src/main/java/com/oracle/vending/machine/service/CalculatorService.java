package com.oracle.vending.machine.service;

import com.oracle.vending.machine.model.Change;

public interface CalculatorService {
    Change getChange(Change machine, Change customer, float price);

}
