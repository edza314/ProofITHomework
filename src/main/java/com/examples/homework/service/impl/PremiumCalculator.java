package com.examples.homework.service.impl;

import com.examples.homework.controller.api.PolicyRequest;
import com.examples.homework.controller.api.PolicyResponse;
import com.examples.homework.controller.api.PolicySubObject;
import com.examples.homework.service.Calculator;
import com.examples.homework.strategies.impl.FireStrategy;
import com.examples.homework.strategies.impl.TheftStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PremiumCalculator implements Calculator {

    private List<Function<List<PolicySubObject>, BigDecimal>> allStrategies = new ArrayList<>();

    {
        allStrategies.add(new FireStrategy()::calculateValue);
        allStrategies.add(new TheftStrategy()::calculateValue);
    }

    @Override
    public PolicyResponse calculate(PolicyRequest request) {

        PolicyResponse response = new PolicyResponse();
        try {
            List<PolicySubObject> policySubObjects = getPolicySubObjectsListFromRequest(request);

            BigDecimal premium = allStrategies.stream()
                    .map(i -> i.apply(policySubObjects))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            response.setPremium(premium);
        } catch (Exception e) {
            e.getMessage();
        }

        return response;
    }

    private List<PolicySubObject> getPolicySubObjectsListFromRequest(PolicyRequest request) {
        return request.getPolicy().getPolicyObjects()
                .stream()
                .filter(i -> i.getPolicySubObjects().size() > 0)
                .flatMap(i -> i.getPolicySubObjects().stream())
                .collect(Collectors.toList());
    }
}
