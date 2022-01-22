package com.oracle.vending.machine.service;

import com.oracle.vending.machine.exception.NotEnoughChangeException;
import com.oracle.vending.machine.model.Change;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    @BeforeEach
    void setUp() {
    }
    private final CalculatorServiceImpl calculatorService= new CalculatorServiceImpl();

    @Test
    @DisplayName("test_change_is_calculated")
    void testGetChange() {
        Change machine = new Change();
        machine.setPnd2(3);
        machine.setPnd1(2);
        machine.setPs50(10);
        machine.setPs20(20);
        machine.setPs10(10);
        machine.setPs5(10);
        machine.setPs2(10);
        machine.setPs1(20);

        Change customer = new Change();
        customer.setPnd1(1);
        customer.setPs20(2);
        Change change = calculatorService.getChange(machine,customer,1.25F);
        assertEquals(1,change.getPs10());
        assertEquals(1,change.getPs5());
        assertEquals(0,change.getPnd1());
        assertEquals(0,change.getPnd2());
        assertEquals(0,change.getPs50());
        assertEquals(15,change.getTotal());
    }

    @Test
    @DisplayName("test_change_returned_when_out_of_5p")
    void testGetChangeNo5p() {
        Change machine = new Change();
        machine.setPnd2(3);
        machine.setPnd1(2);
        machine.setPs50(10);
        machine.setPs20(20);
        machine.setPs10(10);
        machine.setPs2(10);
        machine.setPs1(20);

        Change customer = new Change();
        customer.setPnd1(1);
        customer.setPs20(2);
        Change change = calculatorService.getChange(machine,customer,1.25F);
        assertEquals(15,change.getTotal());
        assertEquals(1,change.getPs10());
        assertEquals(2,change.getPs2());
        assertEquals(1,change.getPs1());
        assertEquals(0,change.getPnd2());
        assertEquals(0,change.getPs50());

    }

    @Test
    @DisplayName("test_change_when_machine_is_out_of_change")
    void testGetChangeWithException() {
        Change machine = new Change();
        machine.setPnd2(3);
        machine.setPnd1(2);
        machine.setPs50(10);


        Change customer = new Change();
        customer.setPnd1(1);
        customer.setPs20(2);
        NotEnoughChangeException exception = assertThrows(NotEnoughChangeException.class,
                ()-> calculatorService.getChange(machine,customer,1.25F),"Machine is out of Change. Please try again with exact change!!");
        assertTrue(exception.getMessage().contains("Machine is out of Change. Please try again with exact change!!"));

    }
}