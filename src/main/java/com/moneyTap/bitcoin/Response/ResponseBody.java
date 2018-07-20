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

    public String getResponse() {
        return Response;
    }

    public void setResponse(final String response) {
        Response = response;
    }

    public String getType() {
        return Type;
    }

    public void setType(final String type) {
        Type = type;
    }

    public Boolean getAggregated() {
        return Aggregated;
    }

    public void setAggregated(final Boolean aggregated) {
        Aggregated = aggregated;
    }

    public List<Data> getData() {
        return Data;
    }

    public void setData(final List<Data> data) {
        Data = data;
    }

    public long getTimeTo() {
        return TimeTo;
    }

    public void setTimeTo(final long timeTo) {
        TimeTo = timeTo;
    }

    public long getTimeFrom() {
        return TimeFrom;
    }

    public void setTimeFrom(final long timeFrom) {
        TimeFrom = timeFrom;
    }

    public Boolean getFirstValueInArray() {
        return FirstValueInArray;
    }

    public void setFirstValueInArray(final Boolean firstValueInArray) {
        FirstValueInArray = firstValueInArray;
    }

    public Conversion getConversionType() {
        return ConversionType;
    }

    public void setConversionType(final Conversion conversionType) {
        ConversionType = conversionType;
    }
}
