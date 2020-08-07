package com.examples.homework.strategies;

import com.examples.homework.controller.api.PolicySubObject;

import java.math.BigDecimal;
import java.util.List;

public interface Strategy {

    BigDecimal calculateValue(List<PolicySubObject> subObjects);

    BigDecimal calculateBasedOnCoefficient(BigDecimal value);

    BigDecimal doRounding(BigDecimal value);
}
