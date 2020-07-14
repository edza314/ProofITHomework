package com.examples.homework.controller.api;

import com.examples.homework.enums.PolicyStatus;

import java.util.ArrayList;
import java.util.List;

public class Policy {
    String policyNumber;
    PolicyStatus policyStatus;
    List<PolicyObject> policyObjects;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public PolicyStatus getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(PolicyStatus policyStatus) {
        this.policyStatus = policyStatus;
    }

    public List<PolicyObject> getPolicyObjects() {
        if(policyObjects == null){
            policyObjects = new ArrayList<>();
            return policyObjects;
        }
        return policyObjects;
    }

    public void setPolicyObjects(List<PolicyObject> policyObjects) {
        this.policyObjects = policyObjects;
    }
}
