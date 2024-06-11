package pe.edu.idat.ec1_ismaelchanta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DNI() {
    var birthYear by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Verificador si debe sacar o no DNI", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = birthYear,
            onValueChange = { birthYear = it },
            label = { Text("Año de Nacimiento") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val year = birthYear.toIntOrNull() ?: 0
            val currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)
            val age = currentYear - year

            message = if (age >= 18) {
                "Debe sacar su DNI"
            } else {
                "No debe sacar su DNI"
            }
        }) {
            Text("Verificar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(message, fontSize = 24.sp)
    }
}