package com.examples.homework.controller;

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
    public ResponseEntity<PolicyResponse> calculatePremium(@RequestBody PolicyRequest request) throws Exception {

        PolicyResponse response = calculator.calculate(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
