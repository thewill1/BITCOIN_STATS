package com.moneyTap.bitcoin.Response;

import java.util.List;

public class ResponseBody {
    private String Response;
    private String Type;
    private Boolean Aggregated;
    private List<Data> Data;
    private long TimeTo;
    private long TimeFrom;
    private Boolean FirstValueInArray;
    private Conversion ConversionType;
}
