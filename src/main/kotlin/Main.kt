fun main() {
    val amount = 200 // стоимость текущей продажи
    var lastTotal = 11_000 // сумма предыдущих продаж
    var exclusiveStatus: String // статус пользователя
    var discount: Int // скидка пользователя в зависимости от статуса

    exclusiveStatus = userStatusToDiscount(lastTotal)
    discount = userLevelToDiscount(exclusiveStatus)
    var fee= calculateFee(itemAmount = amount, itemDiscount = discount)
    println(fee)

    lastTotal = 0
    exclusiveStatus = userStatusToDiscount(lastTotal)
    discount = userLevelToDiscount(exclusiveStatus)
    fee= calculateFee(itemAmount = amount, itemDiscount = discount)
    println(fee)

    lastTotal = 5_050
    exclusiveStatus = userStatusToDiscount(lastTotal)
    discount = userLevelToDiscount(exclusiveStatus)
    fee= calculateFee(itemAmount = amount, itemDiscount = discount)
    println(fee)

    lastTotal = 1_000_000
    exclusiveStatus = userStatusToDiscount(lastTotal)
    discount = userLevelToDiscount(exclusiveStatus)
    fee= calculateFee(itemAmount = amount, itemDiscount = discount)
    println(fee)
}

fun userStatusToDiscount(lastTotal: Int = 0): String {
    if (lastTotal in 1_001..10_000) return "silver"
    if (lastTotal in 10_001..50_000) return "gold"
    if (lastTotal > 50_001) return "platinum"
    return "normal"
}

fun userLevelToDiscount(level: String = "normal") = when (level) {
    "silver" -> 25
    "gold" -> 20
    "platinum" -> 15
    else -> 30
}

fun calculateFee(itemAmount: Int, itemDiscount: Int): Int {
    return (itemAmount / 100) * itemDiscount
}