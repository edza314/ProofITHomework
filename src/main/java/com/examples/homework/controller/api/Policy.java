package com.examples.homework.controller.api;

        import java.util.ArrayList;
        import java.util.List;

public class Policy {

    private List<PolicyObject> policyObjects;

    public List<PolicyObject> getPolicyObjects() {
        if (policyObjects == null) {
            policyObjects = new ArrayList<>();
            return policyObjects;
        }
        return policyObjects;
    }

}
