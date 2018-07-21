package com.moneyTap.bitcoin.Repository;

import com.moneyTap.bitcoin.Constants.GlobalConstant;
import com.moneyTap.bitcoin.CustomResponse.CustomResponseBody;
import com.moneyTap.bitcoin.Generics.Generic;
import com.moneyTap.bitcoin.Persistence.BitcoinInformation;
import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class BitcoinRepository implements BitcoinDAO {
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    public CustomResponseBody getCustomeResponseBody(
            final BitcoinInformation bitcoinInformation,
            final int underSpecifiedTime) {
        final CustomResponseBody customResponseBody = new CustomResponseBody();
        final int lookUpIndex = GlobalConstant.TOTAL_BITCOIN_VALUES - underSpecifiedTime;
        final double[] subArrayBitcoinValues = Arrays.copyOfRange(
                bitcoinInformation.getBitcoinValues(), lookUpIndex, GlobalConstant.TOTAL_BITCOIN_VALUES);
        final Double medianForRetrievedBitcoins = Generic.getMedianOfArray(subArrayBitcoinValues);

        customResponseBody.setAverage(bitcoinInformation.getAverageBitcoinVales()[lookUpIndex]);
        customResponseBody.setMedian(medianForRetrievedBitcoins);

        logger.log(Level.INFO, "The Final Result is " + customResponseBody);

        return customResponseBody;
    }
}
