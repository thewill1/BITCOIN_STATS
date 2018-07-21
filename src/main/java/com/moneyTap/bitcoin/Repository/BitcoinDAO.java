package com.moneyTap.bitcoin.Repository;

import com.moneyTap.bitcoin.CustomResponse.CustomResponseBody;
import com.moneyTap.bitcoin.Persistence.BitcoinInformation;

public interface BitcoinDAO {
    CustomResponseBody getCustomeResponseBody(
            final BitcoinInformation bitcoinInformation,
            final int underSpecifiedTime);
}
