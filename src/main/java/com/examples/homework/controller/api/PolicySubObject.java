package com.examples.homework.controller.api;

import com.examples.homework.enums.RiskType;

import java.math.BigDecimal;

public class PolicySubObject {

    private BigDecimal sumInsured;
    private RiskType riskType;

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }
}

