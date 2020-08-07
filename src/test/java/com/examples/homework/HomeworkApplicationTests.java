package com.examples.homework;

import com.examples.homework.controller.api.*;
import com.examples.homework.enums.RiskType;
import com.examples.homework.service.impl.PremiumCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HomeworkUnitTests {

    // Homework example 1
    @Test
    void calculatePremiumTest1() {
        BigDecimal expectedPremium = BigDecimal.valueOf(2.28);

        PremiumCalculator calculator = new PremiumCalculator();

        PolicyRequest request = new PolicyRequest();

        Policy policy = new Policy();

        request.setPolicy(policy);

        PolicyObject policyObject = new PolicyObject();

        policy.getPolicyObjects().add(policyObject);

        PolicySubObject policySubObject1 = new PolicySubObject();
        policySubObject1.setRiskType(RiskType.FIRE);
        policySubObject1.setSumInsured(BigDecimal.valueOf(100.00));

        PolicySubObject policySubObject2 = new PolicySubObject();
        policySubObject2.setRiskType(RiskType.THEFT);
        policySubObject2.setSumInsured(BigDecimal.valueOf(8.00));

        policyObject.getPolicySubObjects().add(policySubObject1);
        policyObject.getPolicySubObjects().add(policySubObject2);

        PolicyResponse response = calculator.calculate(request);

        assertEquals(expectedPremium, response.getPremium());
    }

    // Homework example 2
    @Test
    void calculatePremiumTest2() {
        BigDecimal expectedPremium = BigDecimal.valueOf(17.13);
        PremiumCalculator calculator = new PremiumCalculator();

        PolicyRequest request = new PolicyRequest();

        Policy policy = new Policy();

        request.setPolicy(policy);

        PolicyObject policyObject = new PolicyObject();

        policy.getPolicyObjects().add(policyObject);

        PolicySubObject policySubObject1 = new PolicySubObject();
        policySubObject1.setRiskType(RiskType.FIRE);
        policySubObject1.setSumInsured(BigDecimal.valueOf(500.00));

        PolicySubObject policySubObject2 = new PolicySubObject();
        policySubObject2.setRiskType(RiskType.THEFT);
        policySubObject2.setSumInsured(BigDecimal.valueOf(102.51));

        policyObject.getPolicySubObjects().add(policySubObject1);
        policyObject.getPolicySubObjects().add(policySubObject2);

        PolicyResponse response = calculator.calculate(request);

        assertEquals(expectedPremium, response.getPremium());
    }

    // Negative value
    @Test
    void calculatePremiumTest3() {

        BigDecimal expectedPremium = BigDecimal.valueOf(0.00);
        PremiumCalculator calculator = new PremiumCalculator();

        PolicyRequest request = new PolicyRequest();

        Policy policy = new Policy();

        request.setPolicy(policy);

        PolicyObject policyObject = new PolicyObject();

        policy.getPolicyObjects().add(policyObject);

        PolicySubObject policySubObject1 = new PolicySubObject();
        policySubObject1.setRiskType(RiskType.FIRE);
        policySubObject1.setSumInsured(BigDecimal.valueOf(-500.00));

        PolicySubObject policySubObject2 = new PolicySubObject();
        policySubObject2.setRiskType(RiskType.THEFT);
        policySubObject2.setSumInsured(BigDecimal.valueOf(-102.51));

        policyObject.getPolicySubObjects().add(policySubObject1);
        policyObject.getPolicySubObjects().add(policySubObject2);

        PolicyResponse response = calculator.calculate(request);

        assertEquals(expectedPremium, response.getPremium());
    }

    // Do not have policy object
    @Test
    void calculatePremiumTest4() {
        PremiumCalculator calculator = new PremiumCalculator();

        PolicyRequest request = new PolicyRequest();

        PolicyObject policyObject = new PolicyObject();

        PolicySubObject policySubObject1 = new PolicySubObject();
        policySubObject1.setRiskType(RiskType.FIRE);
        policySubObject1.setSumInsured(null);

        PolicySubObject policySubObject2 = new PolicySubObject();
        policySubObject2.setRiskType(RiskType.THEFT);
        policySubObject2.setSumInsured(null);

        policyObject.getPolicySubObjects().add(policySubObject1);
        policyObject.getPolicySubObjects().add(policySubObject2);

        PolicyResponse response = calculator.calculate(request);

        assertNull(response.getPremium());
    }

    // Do not have policy subObjects
    @Test
    void calculatePremiumTest5() {
        BigDecimal expectedPremium = BigDecimal.valueOf(0.00);
        PremiumCalculator calculator = new PremiumCalculator();

        PolicyRequest request = new PolicyRequest();

        Policy policy = new Policy();

        request.setPolicy(policy);

        PolicyObject policyObject = new PolicyObject();

        policy.getPolicyObjects().add(policyObject);

        PolicyResponse response = calculator.calculate(request);

        assertEquals(expectedPremium, response.getPremium());
    }

}
