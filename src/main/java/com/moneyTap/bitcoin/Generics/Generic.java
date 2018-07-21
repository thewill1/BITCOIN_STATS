package com.moneyTap.bitcoin.Generics;
import com.moneyTap.bitcoin.Constants.GlobalConstant;

import java.util.Arrays;

public class Generic {
    public static double getMedianOfArray(final double[] array) {
        final int lengthOfArray = array.length;
        final int lookUpIndexForMedian = lengthOfArray/2;

        Arrays.sort(array);

        return (lengthOfArray % 2) == 0
                ? (array[lookUpIndexForMedian -1] + array[lookUpIndexForMedian])/2
                : array[lookUpIndexForMedian];
    }

    public static String printArrayValues(final double[] array) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < GlobalConstant.TOTAL_BITCOIN_VALUES; index++) {
            stringBuilder.append(array[index] + " , ");
        }

        return stringBuilder.toString();
    }
}
