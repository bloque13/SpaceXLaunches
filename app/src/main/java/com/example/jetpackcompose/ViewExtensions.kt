package com.example.jetpackcompose

import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId
import java.util.*

fun LocalDate.isYesterday(): Boolean = this.isEqual(LocalDate.now().minusDays(1L))

fun LocalDate.isToday(): Boolean = this.isEqual(LocalDate.now())

fun Date.toDateLabel(): String {
    val currentDate = Instant.ofEpochMilli(this.time).atZone(ZoneId.systemDefault()).toLocalDate()

    var dateLabel = this.formatToViewDateDefaults()
    val timeLabel = this.formatToHHmm()

    if (currentDate.isToday()) {
        dateLabel = "Today"
    } else if (currentDate.isYesterday()) {
        dateLabel = "Yesterday"
    }

    return "$dateLabel $timeLabel"

}

fun String.digitsOnly(): String {
    val regex = Regex("[^0-9]")

    return regex.replace(this, "")
}

fun String.isInteger() = this.toIntOrNull().let { true }