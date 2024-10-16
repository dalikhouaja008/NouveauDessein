package com.example.nouveaudesseinapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button // Ensure you're using material3 if applicable
import androidx.compose.material3.ButtonDefaults // Ensure you're using material3 if applicable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier // Correct import for Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp // For using dp units
import androidx.compose.ui.unit.sp
import com.example.nouveaudesseinapp.ui.theme.AlegreyaSansFontFamily


@Composable
fun CButton(
    onClick: () -> Unit =  {},
    text:String,
    modifier: Modifier
){
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF7C9A92)
        ),
        modifier = Modifier




    ){
        Text(
            text =text,
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = AlegreyaSansFontFamily,
                fontWeight = FontWeight(300),
                color = Color.White
            )
        )
    }
}