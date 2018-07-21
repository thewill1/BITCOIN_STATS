package com.moneyTap.bitcoin.Services;

import com.moneyTap.bitcoin.Constants.GlobalConstant;
import com.moneyTap.bitcoin.CustomResponse.CustomResponseBody;
import com.moneyTap.bitcoin.Persistence.BitcoinInformation;
import com.moneyTap.bitcoin.Repository.BitcoinDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BitcoinService {
    private Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    @Autowired
    private BitcoinInformation bitcoinInformation;

    @Autowired
    private BitcoinDAO bitcoinDAO;

    public CustomResponseBody getCustomeResponseBodyUnderSpecifiedTime(
            final long requestedTimestampValue,
            final int underSpecifiedTime) {
        final long secondsLag = getSecondDifferenceBetweenTimestamps(requestedTimestampValue);

        if (secondsLag >= GlobalConstant.SECONDS_IN_A_MINUTE) {
            synchronized (BitcoinService.class) {
                if (secondsLag >= GlobalConstant.SECONDS_IN_A_MINUTE) {
                    long minuteDifference = secondsLag/GlobalConstant.SECONDS_IN_A_MINUTE;

                    updateOrInitBasedOnMinuteDifference(minuteDifference);
                }
            }
        }

        return bitcoinDAO.getCustomeResponseBody(bitcoinInformation, underSpecifiedTime);
    }

    private long getSecondDifferenceBetweenTimestamps(final long requestedTimestampValue) {
        return (requestedTimestampValue - bitcoinInformation.getCurrentTimeStamp())/1000;
    }

    private void updateOrInitBasedOnMinuteDifference(final long minuteDifference) {
        logger.log(Level.INFO, "The lag is " + minuteDifference + " minutes");

        if (minuteDifference < GlobalConstant.TOTAL_BITCOIN_VALUES) {
            bitcoinInformation.update(minuteDifference);
        } else {
            bitcoinInformation.init();
        }
    }
}
