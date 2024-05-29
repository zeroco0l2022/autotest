package ru.netology

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {
    @Test
    fun testCommissionBlock() {
        val card: String = "Mastercard"
        val amountMonth = 600_000
        val amount = 10_000
        val result = commission(card, amountMonth, amount)
        assertEquals("Операция заблокирована. Превышен лимит.", result)
    }

    @Test
    fun testCommissionVkPayBlock() {
        val card: String = "VK Pay"
        val amountMonth = 1_000
        val amount = 40_000
        val result = commission(card, amountMonth, amount)
        assertEquals("Операция заблокирована. Превышен лимит.", result)
    }

    @Test
    fun testCommissionCardsNoCommission() {
        val card: String = "Mastercard"
        val amountMonth = 10_000
        val amount = 10_000
        val result = commission(card, amountMonth, amount)
        assertEquals("Комиссия составит: 0", result)
    }

    @Test
    fun testCommissionMastercardCommission() {
        val card: String = "Mastercard"
        val amountMonth = 100_000
        val amount = 30_000
        val result = commission(card, amountMonth, amount)
        assertEquals("Комиссия составит: 200", result)
    }



    @Test
    fun testCommissionMaestroCommission() {
        val card: String = "Maestro"
        val amountMonth = 100_000
        val amount = 30_000
        val result = commission(card, amountMonth, amount)
        assertEquals("Комиссия составит: 200", result)
    }



    @Test
    fun testCommissionVisaCommission() {
        val card: String = "Visa"
        val amountMonth = 100_000
        val amount = 30_000
        val result = commission(card, amountMonth, amount)
        assertEquals("Комиссия составит: 225", result)
    }
    @Test
    fun testCommissionVisaMinCommission() {
        val card: String = "Visa"
        val amountMonth = 1_000
        val amount = 1_000
        val result = commission(card, amountMonth, amount)
        assertEquals("Комиссия составит: 35", result)
    }

    @Test
    fun testCommissionMirCommission() {
        val card: String = "Мир"
        val amountMonth = 100_000
        val amount = 30_000
        val result = commission(card, amountMonth, amount)
        assertEquals("Комиссия составит: 225", result)
    }
    @Test
    fun testCommissionMirMinCommission() {
        val card: String = "Мир"
        val amountMonth = 1_000
        val amount = 1_000
        val result = commission(card, amountMonth, amount)
        assertEquals("Комиссия составит: 35", result)
    }

    @Test
    fun testCommissionVkPay() {
        val card: String = "VK Pay"
        val amountMonth = 1_000
        val amount = 1_000
        val result = commission(card, amountMonth, amount)
        assertEquals("Комиссия составит: 0", result)
    }

}