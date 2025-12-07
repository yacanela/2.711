package org.example;

import java.util.Objects;

public class Payment {
    private String fio;
    private int day;
    private int month;
    private int year;
    private int sum;

    public Payment(String fio, int day, int month, int year, int sum) {
        this.fio = fio;
        this.day = day;
        this.month = month;
        this.year = year;
        this.sum = sum;
    }

    public String getFio() {
        return fio;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getSum() {
        return sum;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Payment other = (Payment) obj;
        return day == other.day &&
                month == other.month &&
                year == other.year &&
                sum == other.sum &&
                Objects.equals(fio, other.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, day, month, year, sum);
    }

    @Override
    public String toString() {
        int rub = sum / 100;
        int kop = sum % 100;
        return String.format("Payer: %s, data: %d.%d.%d sum: %d rub. %02d kop.",
                fio, day, month, year, rub, kop);
    }
}
