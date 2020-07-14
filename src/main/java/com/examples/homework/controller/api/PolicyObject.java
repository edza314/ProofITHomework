package com.examples.homework.controller.api;

import java.util.ArrayList;
import java.util.List;

public class PolicyObject {
    String objectName;
    List<PolicySubObject> policySubObjects;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<PolicySubObject> getPolicySubObjects() {
        if(policySubObjects == null){
            policySubObjects = new ArrayList<>();
            return policySubObjects;
        }
        return policySubObjects;
    }

    public void setPolicySubObjects(List<PolicySubObject> policySubObjects) {
        this.policySubObjects = policySubObjects;
    }
}
