package com.examples.homework.strategies.impl;


import com.examples.homework.controller.api.PolicySubObject;
import com.examples.homework.enums.RiskType;
import com.examples.homework.strategies.Strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class FireStrategy implements Strategy {
    private static final Double DEFAULT_COEFFICENT = 0.014;
    private static final Double MAX_COEFFICENT = 0.024;
    private static final Double SUM_INSURED_THRESHOLD = 100.0;
    private static final RiskType RISK_TYPE = RiskType.FIRE;




    @Override
    public Double calculateValue(List<PolicySubObject> subobjects) {


        Double totalInsuredSum = subobjects
                .stream()
                .filter(i -> i.getRiskType() == RISK_TYPE)
                .map(i -> i.getSumInsured())
                .collect(Collectors.summingDouble(Double::doubleValue));


        Double unroundedValue;

        if (totalInsuredSum >=0) {
            if (totalInsuredSum > SUM_INSURED_THRESHOLD) {
                unroundedValue = totalInsuredSum * MAX_COEFFICENT;
            } else {
                unroundedValue = totalInsuredSum * DEFAULT_COEFFICENT;
            }
        }else{
            unroundedValue = 0.00;
        }


        BigDecimal bd = new BigDecimal(Double.toString(unroundedValue));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
