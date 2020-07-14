package com.examples.homework.service;

import com.examples.homework.controller.api.PolicyRequest;
import com.examples.homework.controller.api.PolicyResponse;

public interface Calculator {
    public PolicyResponse calculate(PolicyRequest request);
}
