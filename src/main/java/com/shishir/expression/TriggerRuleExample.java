package com.shishir.expression;

import com.shishir.expression.entity.Rule;
import com.shishir.expression.entity.RuleRepository;
import com.shishir.expression.entity.Vehicle;
import com.shishir.expression.entity.VehicleRepository;
import com.shishir.expression.util.RuleEvaluationComponent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class TriggerRuleExample {
    private final VehicleRepository vehicleRepository;
    private final RuleRepository ruleRepository;
    private final RuleEvaluationComponent ruleEvaluationComponent;

    public TriggerRuleExample(VehicleRepository vehicleRepository, RuleRepository ruleRepository, RuleEvaluationComponent ruleEvaluationComponent) {
        this.vehicleRepository = vehicleRepository;
        this.ruleRepository = ruleRepository;
        this.ruleEvaluationComponent = ruleEvaluationComponent;
    }

    @PostConstruct
    public void initData() {
        this.initVehicle();
        this.initRule();

        this.triggerRule();
    }

    private void triggerRule(){
        List<Vehicle> fourWheelers = vehicleRepository.findAllByType("FOUR_WHEELER");
        fourWheelers.forEach(vehicle -> {
            List<Rule> rules = ruleRepository.findAllByType("FOUR_WHEELER");
            rules.forEach(rule -> {
                try {
                    ruleEvaluationComponent.evaluateRuleAndPerformAction(vehicle, rule);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
    }

    private void initVehicle() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setCode("FW00001");
        vehicle1.setType("FOUR_WHEELER");
        vehicle1.setPurchaseYear(2019);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setCode("FW00002");
        vehicle2.setType("FOUR_WHEELER");
        vehicle2.setPurchaseYear(2009);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        vehicleRepository.saveAll(vehicles);
    }

    private void initRule() {
        Rule rule1 = new Rule();
        rule1.setType("FOUR_WHEELER");
        rule1.setExpression("purchaseYear > 2010");
        rule1.setBeanName("FourWheelerLatestPurchase");
        rule1.setMethodName("performAction");

        Rule rule2 = new Rule();
        rule2.setType("TWO_WHEELER");
        rule2.setExpression("purchaseYear > 2010");
        rule2.setBeanName("TwoWheelerLatestPurchase");
        rule2.setMethodName("process");

        List<Rule> rules = new ArrayList<>();
        rules.add(rule1);
        rules.add(rule2);

        ruleRepository.saveAll(rules);
    }

}
