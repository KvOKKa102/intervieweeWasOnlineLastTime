fun agoToText(timestamp: Long): String {
    val now = System.currentTimeMillis()
    val diff = ((now - timestamp) / 1000).toInt()
    return when {
        diff <= 60 -> "был(а) только что"
        diff <= 60 * 60 -> "${minutesAgo(diff)} назад"
        diff <= 24 * 60 * 60 -> "${hoursAgo(diff)} назад"
        diff <= 48 * 60 * 60 -> "был(а) вчера"
        diff <= 72 * 60 * 60 -> "был(а) позавчера"
        else -> "был(а) давно"
    }
}

fun minutesAgo(diff: Int): String {
    val minutes = diff / 60
    return when {
        minutes == 1 || minutes == 21 || minutes == 31 || minutes == 41 || minutes == 51 -> "$minutes минуту"
        minutes < 5 || (minutes in 21..24) || (minutes in 31..34) || (minutes in 41..44) || (minutes in 51..54) -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun hoursAgo(diff: Int): String {
    val hours = diff / (60 * 60)
    return when {
        hours == 1 || hours == 21 -> "$hours час"
        hours < 5 || hours in 21..24 -> "$hours часа"
        else -> "$hours часов"
    }
}