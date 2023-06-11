package com.shishir.expression.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rule")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "type")
    private String type;
    @Column(name = "expression")
    private String expression;
    @Column(name = "bean_name")
    private String beanName;
    @Column(name = "method_name")
    private String methodName;
}
