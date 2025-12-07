package org.example;

import java.util.Arrays;

public class FinanceReportProcessor {

    public static FinanceReport getPaymentsByLastName(FinanceReport otchet, char bukva) {
        if (otchet == null) return new FinanceReport("", 1, 1, 2000);

        Payment[] res = new Payment[otchet.getKolvoPlatezh()];
        int s = 0;

        for (int i = 0; i < otchet.getKolvoPlatezh(); i++) {
            Payment plat = otchet.getPlat(i);
            String[] namePart = plat.getFio().split(" ");
            if (namePart.length > 0 && namePart[0].toLowerCase().charAt(0) ==
                    Character.toLowerCase(bukva)) {
                res[s++] = new Payment(plat.getFio(), plat.getDay(),
                        plat.getMonth(), plat.getYear(), plat.getSum());
            }
        }

        Payment[] otfiltr = Arrays.copyOf(res, s);
        return new FinanceReport(otchet.getAvtor(), otchet.getDataDay(),
                otchet.getDataMonth(), otchet.getDataYear(), otfiltr);
    }

    public static FinanceReport getPaymentsLessThanAmount(FinanceReport otchet, int maxSum) {
        if (otchet == null) return new FinanceReport("", 1, 1, 2000);

        Payment[] res = new Payment[otchet.getKolvoPlatezh()];
        int s = 0;

        for (int i = 0; i < otchet.getKolvoPlatezh(); i++) {
            Payment plat = otchet.getPlat(i);
            if (plat.getSum() < maxSum) {
                res[s++] = new Payment(plat.getFio(), plat.getDay(),
                        plat.getMonth(), plat.getYear(), plat.getSum());
            }
        }

        Payment[] otfiltr = Arrays.copyOf(res, s);
        return new FinanceReport(otchet.getAvtor(), otchet.getDataDay(),
                otchet.getDataMonth(), otchet.getDataYear(), otfiltr);
    }
}
