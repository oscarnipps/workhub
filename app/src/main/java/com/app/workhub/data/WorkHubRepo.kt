package com.app.workhub.data

import com.app.workhub.R
import com.app.workhub.models.Reviewer
import com.app.workhub.models.Tutor


fun getTutors(): List<Tutor> {
    return listOf(
        Tutor("jane wilson", R.drawable.tutor1, "$24", 100),
        Tutor("diego simone", R.drawable.tutor2, "$27", 120),
        Tutor("sasha davies", R.drawable.tutor3, "$29", 80),
        Tutor("john doe", R.drawable.tutor4, "$30", 150),
        Tutor("zayn meshak ", R.drawable.tutor4, "$30", 150),
        Tutor("oliver banes", R.drawable.tutor4, "$30", 150),
        Tutor("richard bun", R.drawable.tutor4, "$30", 150),
        Tutor("mohammed ali", R.drawable.tutor4, "$30", 150),
        Tutor("isac jando", R.drawable.tutor4, "$30", 150),
        Tutor("derrick soweto", R.drawable.tutor5, "$35", 321)
    )
}

fun getReviewers(): List<Reviewer> {
    return listOf(
        Reviewer("panini davies", R.drawable.tutor3),
        Reviewer("piki jones ", R.drawable.tutor4),
        Reviewer("alison becker", R.drawable.tutor2),
        Reviewer("james deen", R.drawable.tutor1),
        Reviewer("derrick soweto", R.drawable.tutor1),
        Reviewer("oliver banes", R.drawable.tutor1),
        Reviewer("mohammed ali", R.drawable.tutor1),
        Reviewer("peter gregory", R.drawable.tutor4)
    )
}
