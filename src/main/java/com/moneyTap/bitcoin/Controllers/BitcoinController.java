package com.moneyTap.bitcoin.Controllers;

import com.moneyTap.bitcoin.CustomResponse.CustomResponseBody;
import com.moneyTap.bitcoin.Services.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class BitcoinController {

    @Autowired
    private BitcoinService bitcoinService;

    @RequestMapping("/cryptoDetails")
    public CustomResponseBody getBitcoinAdditionalDetailsUnderSpecifiedTime(
            final @RequestParam("underSpecifiedTime") Integer underSpecifiedTime) {
        final Timestamp requestedTimestamp = new Timestamp(System.currentTimeMillis());

        return bitcoinService.getCustomeResponseBodyUnderSpecifiedTime(
                requestedTimestamp.getTime(), underSpecifiedTime);
    }
}
