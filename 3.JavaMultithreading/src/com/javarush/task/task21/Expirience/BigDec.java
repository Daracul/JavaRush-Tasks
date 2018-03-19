package com.javarush.task.task21.Expirience;

import java.math.BigDecimal;

/**
 * Created by amalakhov on 13.06.2017.
 */
public class BigDec {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("34234.23423");
        bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP));

    }
}
