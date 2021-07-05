package com.sunasterisk.loltournaments.ultils

import java.text.SimpleDateFormat

fun convertTime(textDate: String?, withHour: Boolean): String? {
    textDate?.let {
        var patternFormat = PATTERN_DATE
        var patternParse = PATTERN_DATE_REVERSE
        var dateString = it.split(DELIMITER_T).first()

        if (withHour) {

            patternFormat = PATTERN_DATE_WITH_HOUR
            patternParse = PATTERN_DATE_FULL
            dateString = it.split(DELIMITER_T).let { dateSplit ->
                "${dateSplit.first()} ${dateSplit.last().split(DELIMITER_Z).first()}"
            }
        }

        val simpleDateFormat = SimpleDateFormat(patternFormat)
        val date = SimpleDateFormat(patternParse).parse(dateString)
        return simpleDateFormat.format(date)
    }
    return null
}

const val PATTERN_DATE_REVERSE = "yyyy-MM-dd"
const val PATTERN_DATE_FULL = "yyyy-MM-dd HH:mm:ss"
const val PATTERN_DATE = "dd-MM-yyyy"
const val PATTERN_DATE_WITH_HOUR = "HH:mm dd-MM-yyyy"
const val DELIMITER_T = "T"
const val DELIMITER_Z = "Z"
