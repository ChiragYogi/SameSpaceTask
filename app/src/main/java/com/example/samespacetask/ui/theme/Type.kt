package com.example.samespacetask.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.samespacetask.R

// Set of Material typography styles to start with

val robertoFontFamily = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_bold, FontWeight.Bold),
)

val textStyleRegular = TextStyle(
    fontFamily = robertoFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp,
)

val textStyleMedium = TextStyle(
    fontFamily = robertoFontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp,
)
val textStyleBold = TextStyle(
    fontFamily = robertoFontFamily, fontWeight = FontWeight.Bold, fontSize = 16.sp,
)



