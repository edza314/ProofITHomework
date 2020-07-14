package com.examples.homework;

import com.examples.homework.controller.api.*;
import com.examples.homework.enums.RiskType;
import com.examples.homework.service.impl.PremiumCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class HomeworkUnitTests {

    @Test
    public void calculatePremiumTest1() {
        Double expectedPremium = 2.28;

        PremiumCalculator calculator = new PremiumCalculator();

        PolicyRequest request = new PolicyRequest();

        Policy policy = new Policy();

        request.setPolicy(policy);

        PolicyObject policyObject = new PolicyObject();

        policy.getPolicyObjects().add(policyObject);

        PolicySubObject policySubObject1 = new PolicySubObject();
        policySubObject1.setRiskType(RiskType.FIRE);
        policySubObject1.setSumInsured(100.00);

        
        PolicySubObject policySubObject2 = new PolicySubObject();
        policySubObject2.setRiskType(RiskType.THEFT);
        policySubObject2.setSumInsured(8.00);

        policyObject.getPolicySubObjects().add(policySubObject1);
        policyObject.getPolicySubObjects().add(policySubObject2);


        PolicyResponse response = calculator.calculate(request);


        assertEquals(expectedPremium, response.getPremium());
    }

    @Test
    public void calculatePremiumTest2() {
        Double expectedPremium = 17.13;

        PremiumCalculator calculator = new PremiumCalculator();

        PolicyRequest request = new PolicyRequest();

        Policy policy = new Policy();

        request.setPolicy(policy);

        PolicyObject policyObject = new PolicyObject();

        policy.getPolicyObjects().add(policyObject);

        PolicySubObject policySubObject1 = new PolicySubObject();
        policySubObject1.setRiskType(RiskType.FIRE);
        policySubObject1.setSumInsured(500.00);

        PolicySubObject policySubObject2 = new PolicySubObject();
        policySubObject2.setRiskType(RiskType.THEFT);
        policySubObject2.setSumInsured(102.51);

        policyObject.getPolicySubObjects().add(policySubObject1);
        policyObject.getPolicySubObjects().add(policySubObject2);


        PolicyResponse response = calculator.calculate(request);


        assertEquals(expectedPremium, response.getPremium());
    }

}
