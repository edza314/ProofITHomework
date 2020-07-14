package com.examples.homework.service.impl;

import com.examples.homework.controller.api.PolicyRequest;
import com.examples.homework.controller.api.PolicyResponse;
import com.examples.homework.controller.api.PolicySubObject;
import com.examples.homework.strategies.Strategy;
import com.examples.homework.strategies.impl.FireStrategy;
import com.examples.homework.service.Calculator;
import com.examples.homework.strategies.impl.TheftStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PremiumCalculator implements Calculator {


    @Override
    public PolicyResponse calculate(PolicyRequest request) {

        PolicyResponse response = new PolicyResponse();

        List<PolicySubObject> policySubObjects =
                request.getPolicy().getPolicyObjects()
                        .stream()
                        .filter(i -> i.getPolicySubObjects().size() > 0)
                        .flatMap(i -> i.getPolicySubObjects().stream())
                        .collect(Collectors.toList());

        Strategy strategy = new FireStrategy();
        Double premiumFire = strategy.calculateValue(policySubObjects);
        strategy = new TheftStrategy();
        Double premiumTheft = strategy.calculateValue(policySubObjects);

        response.setPremium(premiumFire + premiumTheft);

        return response;
    }



}
