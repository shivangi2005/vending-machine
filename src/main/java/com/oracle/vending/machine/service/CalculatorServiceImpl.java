package com.oracle.vending.machine.service;

import com.oracle.vending.machine.exception.NotEnoughChangeException;
import com.oracle.vending.machine.model.Change;


public class CalculatorServiceImpl implements CalculatorService{

    @Override
    public Change getChange(Change machine, Change customer, float price) {
        Change returnChange = new Change();
        updateMachineCash(machine,customer);
        long change = customer.getTotal() - (int)(price*100);
        int val;
        if(machine.getPnd2()>0 && change >= 200){
            change = getValue(machine,returnChange,change,200);
        }
        if(machine.getPnd1()>0 && change >= 100){
            change = getValue(machine,returnChange,change,100);
        }
        if(machine.getPs50()>0 && change >= 50){
            change = getValue(machine,returnChange,change,50);
        }
        if(machine.getPs20()>0 && change >= 20){
            change = getValue(machine,returnChange,change,20);
        }
        if(machine.getPs10()>0 && change >= 10){
            change = getValue(machine,returnChange,change,10);
        }
        if(machine.getPs5()>0 && change >= 5){
            change = getValue(machine,returnChange,change,5);
        }
        if(machine.getPs2()>0 && change >= 2){
            change = getValue(machine,returnChange,change,2);
        }
        if(machine.getPs1()>0 && change >= 1){
            change = getValue(machine,returnChange,change,1);
        }
        if(change > 0){
            throw new NotEnoughChangeException("Machine is out of Change. Please try again with exact change!!");
        }
        return returnChange;
    }

    private long getValue(Change machine, Change returnChange, long change, int coinVal){
        int val = 0;
        switch(coinVal){
            case 200:
                val = (int)change/coinVal;
                if(machine.getPnd2() >= val){
                    returnChange.setPnd2(val);
                    machine.subPnd2(val);
                }
                break;
            case 100:
                val = (int)change/coinVal;
                if(machine.getPnd1() >= val){
                    returnChange.setPnd1(val);
                    machine.subPnd1(val);
                }
                break;
            case 50:
                val = (int)change/coinVal;
                if(machine.getPs50() >= val){
                    returnChange.setPs50(val);
                    machine.subPs50(val);
                }
                break;
            case 20:
                val = (int)change/coinVal;
                if(machine.getPs20() >= val){
                    returnChange.setPs20(val);
                    machine.subPs20(val);
                }
                break;
            case 10:
                val = (int)change/coinVal;
                if(machine.getPs10() >= val){
                    returnChange.setPs10(val);
                    machine.subPs10(val);
                }
                break;
            case 5:
                val = (int)change/coinVal;
                if(machine.getPs5() >= val){
                    returnChange.setPs5(val);
                    machine.subPs5(val);
                }
                break;
            case 2:
                val = (int)change/coinVal;
                if(machine.getPs2() >= val){
                    returnChange.setPs2(val);
                    machine.subPs2(val);
                }
                break;
            case 1:
                val = (int)change/coinVal;
                if(machine.getPs1() >= val){
                    returnChange.setPs1(val);
                    machine.subPs1(val);
                }
                break;
        }
        return change - val * (long)coinVal;

    }

    private void updateMachineCash(Change machine, Change customer) {
        machine.addPnd1(customer.getPnd1());
        machine.addPnd2(customer.getPnd2());
        machine.addPs50(customer.getPs50());
        machine.addPs20(customer.getPs20());
        machine.addPs10(customer.getPs10());
        machine.addPs5(customer.getPs5());
        machine.addPs2(customer.getPs2());
        machine.addPs1(customer.getPs1());
    }
}
