package com.examples.homework.strategies.impl;


import com.examples.homework.controller.api.PolicySubObject;
import com.examples.homework.enums.RiskType;
import com.examples.homework.strategies.Strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FireStrategy implements Strategy {
    private static final BigDecimal DEFAULT_COEFFICIENT = new BigDecimal(0.014);
    private static final BigDecimal MAX_COEFFICIENT = new BigDecimal(0.024);
    private static final BigDecimal SUM_INSURED_THRESHOLD = new BigDecimal(100.0);
    private static final RiskType RISK_TYPE = RiskType.FIRE;

    @Override
    public BigDecimal calculateValue(List<PolicySubObject> subObjects) {
        BigDecimal totalInsuredSum = subObjects
                .stream()
                .filter(i -> i.getRiskType() == RISK_TYPE)
                .map(PolicySubObject::getSumInsured)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        totalInsuredSum = calculateBasedOnCoefficient(totalInsuredSum);
        return doRounding(totalInsuredSum);
    }

    @Override
    public BigDecimal calculateBasedOnCoefficient(BigDecimal value) {
        return value.compareTo(SUM_INSURED_THRESHOLD) > 0 ? value.multiply(MAX_COEFFICIENT) : value.multiply(DEFAULT_COEFFICIENT);
    }

    @Override
    public BigDecimal doRounding(BigDecimal value) {
        //return value.setScale(2, RoundingMode.HALF_UP);
        return value.compareTo(BigDecimal.ZERO) > 0 ? value.setScale(2, RoundingMode.HALF_UP) : BigDecimal.valueOf(0.00);
    }
}
