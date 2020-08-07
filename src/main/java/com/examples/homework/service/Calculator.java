package com.examples.homework.service;

import com.examples.homework.controller.api.PolicyRequest;
import com.examples.homework.controller.api.PolicyResponse;

public interface Calculator {
    PolicyResponse calculate(PolicyRequest request);
}
