package com.examples.homework.strategies;

import com.examples.homework.controller.api.PolicySubObject;

import java.util.List;

public interface Strategy {

    Double calculateValue(List<PolicySubObject> subobjects);

}
