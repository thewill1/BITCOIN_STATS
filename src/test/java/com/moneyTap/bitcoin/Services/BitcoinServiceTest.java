package com.moneyTap.bitcoin.Services;

import com.moneyTap.bitcoin.CustomResponse.CustomResponseBody;
import com.moneyTap.bitcoin.Persistence.BitcoinInformation;
import com.moneyTap.bitcoin.Repository.BitcoinDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;

@RunWith(MockitoJUnitRunner.class)
public class BitcoinServiceTest {

    @Mock
    private BitcoinDAO bitcoinDAO;

    @Mock
    private BitcoinInformation bitcoinInformation;

    @InjectMocks
    private BitcoinService bitcoinService;

    @Test
    public void getCustomeResponseBodyUnderSpecifiedTimeWhenNoTimeLag() {
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        final long requestedTimestampValue = timestamp.getTime();
        final int underSpecifiedTime = 2;

        when(bitcoinDAO.getCustomeResponseBody(bitcoinInformation, Integer.valueOf(2))).thenReturn(
                new CustomResponseBody(100d, 100d));

        final CustomResponseBody customResponseBody = bitcoinService.getCustomeResponseBodyUnderSpecifiedTime(
                requestedTimestampValue, underSpecifiedTime);

        verify(bitcoinDAO, times(1)).getCustomeResponseBody(bitcoinInformation, Integer.valueOf(2));
        assertTrue("Both are not equal", customResponseBody.equals(new CustomResponseBody(100d, 100d)));
    }

    @Test
    public void getCustomeResponseBodyUnderSpecifiedTimeWhenSomeTimeLag() {
        final Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        final long requestedTimestampValue = timestamp.getTime() + 1000*2;
        final int underSpecifiedTime = 2;

        when(bitcoinDAO.getCustomeResponseBody(bitcoinInformation, Integer.valueOf(2))).thenReturn(
                new CustomResponseBody(50d, 50d));

        final CustomResponseBody customResponseBody = bitcoinService.getCustomeResponseBodyUnderSpecifiedTime(
                requestedTimestampValue, underSpecifiedTime);

        verify(bitcoinInformation, atMost(1)).update(anyInt());
        verify(bitcoinInformation, atMost(1)).init();
        assertFalse("Both are equal", customResponseBody.equals(new CustomResponseBody(100d, 100d)));
    }
}