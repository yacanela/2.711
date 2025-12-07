package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FinanceReportProcessorTest {

    @Test
    void testGetPaymentsByLastNameNullReport() {
        FinanceReport result = FinanceReportProcessor.getPaymentsByLastName(null, 'И');

        assertNotNull(result);
        assertEquals(0, result.getKolvoPlatezh());
    }

    @Test
    void testGetPaymentsByLastNameEmptyReport() {
        FinanceReport report = new FinanceReport("Автор", 1, 1, 2023);
        FinanceReport result = FinanceReportProcessor.getPaymentsByLastName(report, 'А');

        assertEquals(0, result.getKolvoPlatezh());
    }

    @Test
    void testGetPaymentsByLastNameMatching() {
        Payment[] payments = {
                new Payment("Андреев Андрей", 10, 5, 2023, 15050),
                new Payment("Петров Павел", 12, 5, 2023, 20000),
                new Payment("Андреева Мария", 15, 5, 2023, 5000),
                new Payment("Сергеев Сергей", 18, 5, 2023, 30000)
        };

        FinanceReport report = new FinanceReport("Автор", 1, 1, 2023, payments);
        FinanceReport result = FinanceReportProcessor.getPaymentsByLastName(report, 'А');

        assertEquals(2, result.getKolvoPlatezh());
        assertEquals("Андреев Андрей", result.getPlat(0).getFio());
        assertEquals("Андреева Мария", result.getPlat(1).getFio());
    }

    @Test
    void testGetPaymentsByLastNameCaseInsensitive() {
        Payment[] payments = {
                new Payment("андреев Андрей", 10, 5, 2023, 15050),
                new Payment("Андреева Мария", 15, 5, 2023, 5000),
                new Payment("Петров Павел", 12, 5, 2023, 20000)
        };

        FinanceReport report = new FinanceReport("Автор", 1, 1, 2023, payments);

        FinanceReport resultUpper = FinanceReportProcessor.getPaymentsByLastName(report, 'А');
        FinanceReport resultLower = FinanceReportProcessor.getPaymentsByLastName(report, 'а');

        assertEquals(2, resultUpper.getKolvoPlatezh());
        assertEquals(2, resultLower.getKolvoPlatezh());
    }

    @Test
    void testGetPaymentsByLastNameNoMatches() {
        Payment[] payments = {
                new Payment("Петров Павел", 12, 5, 2023, 20000),
                new Payment("Сергеев Сергей", 18, 5, 2023, 30000)
        };

        FinanceReport report = new FinanceReport("Автор", 1, 1, 2023);
        FinanceReport result = FinanceReportProcessor.getPaymentsByLastName(report, 'И');

        assertEquals(0, result.getKolvoPlatezh());
    }

    @Test
    void testGetPaymentsByLastNamePreservesMetadata() {
        Payment[] payments = {
                new Payment("Андреев Андрей", 10, 5, 2023, 15050),
                new Payment("Петров Павел", 12, 5, 2023, 20000)
        };

        FinanceReport report = new FinanceReport("Автор", 15, 6, 2023, payments);
        FinanceReport result = FinanceReportProcessor.getPaymentsByLastName(report, 'А');

        assertEquals("Автор", result.getAvtor());
        assertEquals(15, result.getDataDay());
        assertEquals(6, result.getDataMonth());
        assertEquals(2023, result.getDataYear());
    }

    @Test
    void testGetPaymentsLessThanAmountNullReport() {
        FinanceReport result = FinanceReportProcessor.getPaymentsLessThanAmount(null, 10000);

        assertNotNull(result);
        assertEquals(0, result.getKolvoPlatezh());
    }

    @Test
    void testGetPaymentsLessThanAmountEmptyReport() {
        FinanceReport report = new FinanceReport("Автор", 1, 1, 2023);
        FinanceReport result = FinanceReportProcessor.getPaymentsLessThanAmount(report, 10000);

        assertEquals(0, result.getKolvoPlatezh());
    }
}