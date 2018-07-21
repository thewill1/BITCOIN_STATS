package com.moneyTap.bitcoin.Constants;

import org.springframework.beans.factory.annotation.Value;

public class GlobalConstant {
    public static final int HOURS_IN_A_DAY = 24;
    public static final int MINUTES_IN_AN_HOUR  = 60;
    public static final int TOTAL_BITCOIN_VALUES = GlobalConstant.HOURS_IN_A_DAY * GlobalConstant.MINUTES_IN_AN_HOUR + 1;
    public static final int SECONDS_IN_A_MINUTE = 60;

    @Value("${cryptoCurrency.bitcoin.api}")
    public static final String BITCOIN_API_URL = null;
}
