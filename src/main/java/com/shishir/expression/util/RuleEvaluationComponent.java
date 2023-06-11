package com.shishir.expression.util;

import com.shishir.expression.entity.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class RuleEvaluationComponent {

    private final ExpressionParser expressionParser;
    private final ApplicationContext applicationContext;

    @Autowired
    public RuleEvaluationComponent(ApplicationContext applicationContext) {
        this.expressionParser = new SpelExpressionParser();
        this.applicationContext = applicationContext;
    }

    public void evaluateRuleAndPerformAction(Object ruleOn, Rule rule) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Expression expression = expressionParser.parseExpression(rule.getExpression());
        EvaluationContext context = new StandardEvaluationContext(ruleOn);
        boolean result = Boolean.TRUE.equals(expression.getValue(context, Boolean.class));

        if (result) {
            Object bean = applicationContext.getBean(rule.getBeanName());
            Method method = bean.getClass().getMethod(null!=rule.getMethodName()?rule.getMethodName():"process");
            method.invoke(bean);
        }
    }
}

