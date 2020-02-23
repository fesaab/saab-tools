package com.saab.tools.finance.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saab.tools.finance.api.GatewayResponse;
import com.saab.tools.finance.api.TransactionResponse;
import com.saab.tools.finance.entity.Transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FinanceHandler {

    public Object listTransactions() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        headers.put("X-Custom-Header", "application/json");
        try {

            TransactionResponse response = new TransactionResponse();
            response.getTransactionList().add(
                    Transaction
                            .builder()
                            .date(new Date(2020, Calendar.FEBRUARY, 13))
                            .category("Mercado")
                            .name("Woolworths")
                            .type("EXPENSE")
                            .value(new BigDecimal("784.12").setScale(2, RoundingMode.HALF_EVEN))
                            .build());
            response.getTransactionList().add(
                    Transaction
                            .builder()
                            .date(new Date(2020, Calendar.FEBRUARY, 13))
                            .category("Lazer")
                            .name("Almoço de domingo no Waterfront")
                            .type("EXPENSE")
                            .value(new BigDecimal("240.00").setScale(2, RoundingMode.HALF_EVEN))
                            .build());

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
            return new GatewayResponse(json, headers, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return new GatewayResponse(String.format("{ \"error\": \"%s\"}", e.getMessage()), headers, 500);
        }
    }

}
