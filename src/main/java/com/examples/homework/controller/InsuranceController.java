package com.examples.homework.controller;

import com.examples.homework.controller.api.Policy;
import com.examples.homework.controller.api.PolicyRequest;
import com.examples.homework.controller.api.PolicyResponse;
import com.examples.homework.service.impl.PremiumCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InsuranceController {

    @Autowired
    private PremiumCalculator calculator;

    @PostMapping(value = "/calculatepremium",produces = "application/json")
    public ResponseEntity<PolicyResponse> calculatePremium(@RequestBody PolicyRequest request) {
        //TODO
        //Validate request validate that policy have atleast 1 object

        PolicyResponse response = calculator.calculate(request);

        //Handle response: based on that decided what HttpStatus will be returned + if we need to return errors

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
