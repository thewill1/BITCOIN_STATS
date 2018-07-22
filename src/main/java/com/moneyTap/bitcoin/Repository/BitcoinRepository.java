package com.moneyTap.bitcoin.Repository;

import com.moneyTap.bitcoin.Constants.GlobalConstant;
import com.moneyTap.bitcoin.CustomResponse.CustomResponseBody;
import com.moneyTap.bitcoin.Generics.Generic;
import com.moneyTap.bitcoin.Persistence.BitcoinInformation;
import org.springframework.stereotype.Repository;
import java.util.Arrays;

@Repository
public class BitcoinRepository implements BitcoinDAO {

    public CustomResponseBody getCustomeResponseBody(
            final BitcoinInformation bitcoinInformation,
            final int underSpecifiedTime) {
        final int lookUpIndex = GlobalConstant.TOTAL_BITCOIN_VALUES - underSpecifiedTime;
        final Double[] subArrayBitcoinValues = Arrays.copyOfRange(
                bitcoinInformation.getBitcoinValues(), lookUpIndex, GlobalConstant.TOTAL_BITCOIN_VALUES);
        final Double medianForRetrievedBitcoins = Generic.getMedianOfArray(subArrayBitcoinValues);

        return new CustomResponseBody(bitcoinInformation.getAverageBitcoinVales()[lookUpIndex], medianForRetrievedBitcoins);
    }
}
