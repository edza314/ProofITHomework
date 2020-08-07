package com.examples.homework.controller.api;

import java.util.ArrayList;
import java.util.List;

public class PolicyObject {

    private List<PolicySubObject> policySubObjects;

    public List<PolicySubObject> getPolicySubObjects() {
        if (policySubObjects == null) {
            policySubObjects = new ArrayList<>();
            return policySubObjects;
        }
        return policySubObjects;
    }

}
