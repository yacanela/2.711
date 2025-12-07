package org.example;

public class FinanceReport {
    private Payment[] payments;
    private String avtor;
    private int dataDay;
    private int dataMonth;
    private int dataYear;

    public FinanceReport(String reporterName, int reportDay, int reportMonth, int reportYear) {
        this.avtor = reporterName;
        this.dataDay = dataDay;
        this.dataMonth = dataMonth;
        this.dataYear = dataYear;
        this.payments = new Payment[0];
    }

    public FinanceReport(String avtor, int dataDay, int dataMonth,
                         int dataYear, Payment[] payments)  {
        this.avtor = avtor;
        this.dataDay = dataDay;
        this.dataMonth = dataMonth;
        this.dataYear = dataYear;

        if (payments == null) {
            this.payments = new Payment[0];
        } else {
            this.payments = payments;
        }
    }

    public FinanceReport(FinanceReport other) {
        this.avtor = other.avtor;
        this.dataDay = other.dataDay;
        this.dataMonth = other.dataMonth;
        this.dataYear = other.dataYear;

        this.payments = new Payment[other.payments.length];
        for (int i = 0; i < other.payments.length; i++) {
            Payment plat = other.payments[i];
            this.payments[i] = new Payment(plat.getFio(), plat.getDay(),
                    plat.getMonth(), plat.getYear(), plat.getSum());
        }
    }

    public String getAvtor() {
        return avtor;
    }
    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }

    public int getDataDay() {
        return dataDay;
    }
    public void setDataDay(int dataDay) {
        this.dataDay = dataDay;
    }

    public int getDataMonth() {
        return dataMonth;
    }
    public void setDataMonth(int dataMonth) {
        this.dataMonth = dataMonth;
    }

    public int getDataYear() {
        return dataYear;
    }
    public void setDataYear(int dataYear) {
        this.dataYear = dataYear;
    }

    public int getKolvoPlatezh() {
        return payments.length;
    }

    public Payment getPlat(int index) {
        if (index < 0 || index >= payments.length) {
            throw new IndexOutOfBoundsException("incorrect index");
        }
        return payments[index];
    }

    public void setPlat(int index, Payment plat) {
        if (index >= 0 && index < payments.length) {
            payments[index] = plat;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Author: ").append(avtor)
                .append(", date: ").append(dataDay).append(".").append(dataMonth).append(".").append(dataYear)
                .append(", Payments: [\n");

        for (int i = 0; i < payments.length; i++) {
            sb.append("  ").append(payments[i].toString());
            if (i < payments.length - 1) {
                sb.append(",\n");
            }
        }

        if (payments.length > 0) {
            sb.append("\n");
        }
        sb.append("]]");

        return sb.toString();
    }
}
