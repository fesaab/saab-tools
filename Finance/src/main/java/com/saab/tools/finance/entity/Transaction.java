package com.saab.tools.finance.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Getter @Setter
    private Date date;

    @Getter @Setter
    private String category;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private BigDecimal value;

    @Getter @Setter
    private String type; // EXPENSE or INCOME

}
