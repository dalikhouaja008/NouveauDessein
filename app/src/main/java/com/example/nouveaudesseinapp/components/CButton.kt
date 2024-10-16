package com.example.nouveaudesseinapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nouveaudesseinapp.ui.theme.AlegreyaSansFontFamily

@Composable
fun CButton(
    onClick: () -> Unit = {},
    text: String,
) {
    // make this button also resuable
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1B6DE5)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
    ) {

        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = AlegreyaSansFontFamily,
                fontWeight = FontWeight(500),
                color = Color.White

            )
        )

    }
}