package com.saab.tools.finance.api;

import com.saab.tools.finance.entity.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class TransactionResponse {

    @Getter @Setter
    private List<Transaction> transactionList;

    public TransactionResponse() {
        this.transactionList = new ArrayList<>();
    }

}
