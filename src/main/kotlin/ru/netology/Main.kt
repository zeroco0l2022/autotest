package ru.netology

import kotlin.math.max


fun main() {
    println(commission("Visa", 0, amount = 1_000))
}

fun commissionCalc(
    amount: Int,
    amountMonth: Int,
    commissionRate: Double,
    minCommission: Int = 0,
    commissionStarts: Int = 0,
    commissionFix: Int = 0
): Int {
    val commissionBase = if (amountMonth > commissionStarts) amount else max(amount + amountMonth - commissionStarts, 0)
    var commission = (commissionBase * (commissionRate / 100)).toInt()
    commission = if (commission > 0) (commission + commissionFix) else commission
    return if (commission > minCommission) commission else minCommission

}

fun commission(card: String = "Мир", amountMonth: Int, amount: Int): String {

    val limitMonth = if(card == "VK Pay") 40_000 else 600_000
    val limitDay =  if(card == "VK Pay") 15_000 else 150_000
    if (amount > limitDay || amount + amountMonth > limitMonth) {
        return "Операция заблокирована. Превышен лимит."
    }
    val commission = when (card) {
        "Mastercard", "Maestro" -> commissionCalc(amount, amountMonth, 0.6, commissionStarts = 75000, commissionFix = 20)
        "Visa", "Мир" -> commissionCalc(amount, amountMonth, 0.75, 35)
        else -> 0
    }
    return "Комиссия составит: $commission"
}
