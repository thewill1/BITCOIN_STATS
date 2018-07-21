package com.moneyTap.bitcoin.Persistence;

import com.moneyTap.bitcoin.Constants.GlobalConstant;
import com.moneyTap.bitcoin.Generics.Generic;
import com.moneyTap.bitcoin.Response.Data;
import com.moneyTap.bitcoin.Response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class BitcoinInformation {
    private volatile double[] bitcoinValues = new double[GlobalConstant.TOTAL_BITCOIN_VALUES];
    private volatile double[] averageBitcoinVales = new double[GlobalConstant.TOTAL_BITCOIN_VALUES];
    private volatile long currentTimeStamp;
    private double currentBitcoinValuesUpdatedSum;

    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    @Autowired
    private RestTemplate restTemplate;

    public double[] getBitcoinValues() {
        return bitcoinValues;
    }

    public void setBitcoinValues(final double[] bitcoinValues) {
        this.bitcoinValues = bitcoinValues;
    }

    public double[] getAverageBitcoinVales() {
        return averageBitcoinVales;
    }

    public void setAverageBitcoinVales(final double[] averageBitcoinVales) {
        this.averageBitcoinVales = averageBitcoinVales;
    }

    public long getCurrentTimeStamp() {
        return currentTimeStamp;
    }

    public void setCurrentTimeStamp(final long currentTimeStamp) {
        this.currentTimeStamp = currentTimeStamp;
    }

    @PostConstruct
    public void init() {
        final ResponseEntity<ResponseBody> responseEntity = restTemplate.getForEntity(
                GlobalConstant.BITCOIN_API_URL, ResponseBody.class);
        final ResponseBody responseBody = responseEntity.getBody();

        currentTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();

        setBicoinValuesFromApiResponse(responseBody);

        setAverageBitcoinValuesForIndexsesFromBitcoinValues();
    }

    private void setBicoinValuesFromApiResponse(final ResponseBody responseBody) {
        bitcoinValues = responseBody.getDataList()
                .stream()
                .mapToDouble(data -> data.getOpen())
                .toArray();

        logger.log(Level.INFO, "[" + Generic.printArrayValues(bitcoinValues) + "]");
    }

    private void setAverageBitcoinValuesForIndexsesFromBitcoinValues() {
        double sum = 0;
        int count = 0;

        for (int index = GlobalConstant.TOTAL_BITCOIN_VALUES - 1; index >= 0; index--) {
            sum = sum + bitcoinValues[index];
            averageBitcoinVales[index] = sum / (++count);
        }

        logger.log(Level.INFO, "[" + Generic.printArrayValues(averageBitcoinVales) + "]");
    }

    public void update(long minuteDifference) {
        final ResponseEntity<ResponseBody> responseEntity = restTemplate.getForEntity(
                GlobalConstant.BITCOIN_API_URL + "&limit=" + minuteDifference,
                ResponseBody.class);
        final ResponseBody responseBody = responseEntity.getBody();

        currentTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();

        updateBitcoinValues((int) minuteDifference, responseBody.getDataList());

        updateAverageBitcoinValues((int) minuteDifference);

        this.currentBitcoinValuesUpdatedSum = 0;
    }

    private void updateBitcoinValues(
            final int minuteDifference,
            final List<Data> dataList) {
        logger.log(Level.INFO, "[" + Generic.printArrayValues(this.bitcoinValues) + "]");

        int index;

        for (index = 0; index < GlobalConstant.TOTAL_BITCOIN_VALUES - minuteDifference; index++) {
            bitcoinValues[index] = bitcoinValues[index + minuteDifference];
        }

        int count = 0;

        for (final Data data : dataList) {
            if (count == 0) {
                count++;
                continue;
            }

            count++;

            bitcoinValues[index++] = data.getOpen();
            currentBitcoinValuesUpdatedSum = currentBitcoinValuesUpdatedSum + data.getOpen();
        }

        logger.log(Level.INFO, "[" + Generic.printArrayValues(this.bitcoinValues) + "]");
    }

    private void updateAverageBitcoinValues(final int minuteDifference) {
        logger.log(Level.INFO, "[" + Generic.printArrayValues(this.averageBitcoinVales) + "]");

        final double previousBitcoinValuesSum = getPreviousBitcoinValueSum(minuteDifference);
        final double currentUpdatedBitcoinSum = this.currentBitcoinValuesUpdatedSum;
        final double differenceInSum = currentUpdatedBitcoinSum - previousBitcoinValuesSum;

        for (int index = 0; index < GlobalConstant.TOTAL_BITCOIN_VALUES - minuteDifference - 1; index++) {
            averageBitcoinVales[index] = (averageBitcoinVales[index + minuteDifference]
                    * (GlobalConstant.TOTAL_BITCOIN_VALUES - index - minuteDifference) + currentUpdatedBitcoinSum)
                    / (GlobalConstant.TOTAL_BITCOIN_VALUES - index) ;
        }

        double currentSum = 0;

        for (int index = GlobalConstant.TOTAL_BITCOIN_VALUES - 1;
             index >= GlobalConstant.TOTAL_BITCOIN_VALUES - minuteDifference - 1; index--) {
            currentSum = currentSum + bitcoinValues[index];
            averageBitcoinVales[index] = currentSum / (GlobalConstant.TOTAL_BITCOIN_VALUES - index);
        }

        logger.log(Level.INFO, "[" + Generic.printArrayValues(this.averageBitcoinVales) + "]");
    }

    private double getPreviousBitcoinValueSum(final int minuteDifference) {
        return bitcoinValues[GlobalConstant.TOTAL_BITCOIN_VALUES - 1] * GlobalConstant.TOTAL_BITCOIN_VALUES
                - bitcoinValues[GlobalConstant.TOTAL_BITCOIN_VALUES - 1 - minuteDifference] * (GlobalConstant.TOTAL_BITCOIN_VALUES - minuteDifference);
    }

}
