package com.example.nouveaudesseinapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.nouveaudesseinapp.R

//Set fonts for green tuto
val AlegreyaFontFamily = FontFamily(
    listOf(
        Font(resId = R.font.alegreya_bold, weight = FontWeight.Bold),
        Font(resId = R.font.alegreya_semibold, weight = FontWeight.SemiBold)
    )
)

val AlegreyaSansFontFamily = FontFamily(
    listOf(
        Font(resId = R.font.alegreya_regular, weight = FontWeight.Normal),
        Font(resId = R.font.alegreya_medium, weight = FontWeight.Medium)
    )
)


val Inter= FontFamily(
    listOf(
        Font(resId = R.font.inter_italic, weight = FontWeight.Medium)
    )
)

val Rubik= FontFamily(
    listOf(
        Font(resId = R.font.rubik, weight = FontWeight.Bold)
    )
)
val Roboto= FontFamily(
    listOf(
        Font(resId = R.font.inter_italic, weight = FontWeight.Medium)
    )
)
// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),




    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)