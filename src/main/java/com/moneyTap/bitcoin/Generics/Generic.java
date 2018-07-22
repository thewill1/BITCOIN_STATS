package com.moneyTap.bitcoin.Generics;
import com.moneyTap.bitcoin.Constants.GlobalConstant;

import java.util.Arrays;

public class Generic {
    public static <T extends Number> double getMedianOfArray(final T[] array) {
        final int lengthOfArray = array.length;
        final int lookUpIndexForMedian = lengthOfArray/2;

        Arrays.sort(array);

        return (lengthOfArray % 2) == 0
                ? (array[lookUpIndexForMedian -1].doubleValue() + array[lookUpIndexForMedian].doubleValue())/2
                : array[lookUpIndexForMedian].doubleValue();
    }

    public static <T extends Number> String printArrayValues(final T[] array) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < GlobalConstant.TOTAL_BITCOIN_VALUES; index++) {
            stringBuilder.append(array[index] + " , ");
        }

        return stringBuilder.toString();
    }
}
