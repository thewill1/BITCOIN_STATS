package com.moneyTap.bitcoin.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBody {

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Aggregated")
    private Boolean aggregated;

    @JsonProperty("Data")
    private List<Data> dataList;

    @JsonProperty("TimeTo")
    private long timeTo;

    @JsonProperty("TimeFrom")
    private long timeFrom;

    @JsonProperty("FirstValueInArray")
    private Boolean firstValueInArray;

    @JsonProperty("ConversionType")
    private Conversion conversionType;


    public String getResponse() {
        return response;
    }

    public void setResponse(final String response) {
        this.response = response;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Boolean getAggregated() {
        return aggregated;
    }

    public void setAggregated(final Boolean aggregated) {
        this.aggregated = aggregated;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(final List<Data> dataList) {
        this.dataList = dataList;
    }

    public long getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(final long timeTo) {
        this.timeTo = timeTo;
    }

    public long getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(final long timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Boolean getFirstValueInArray() {
        return firstValueInArray;
    }

    public void setFirstValueInArray(final Boolean firstValueInArray) {
        this.firstValueInArray = firstValueInArray;
    }

    public Conversion getConversionType() {
        return conversionType;
    }

    public void setConversionType(final Conversion conversionType) {
        this.conversionType = conversionType;
    }
}
