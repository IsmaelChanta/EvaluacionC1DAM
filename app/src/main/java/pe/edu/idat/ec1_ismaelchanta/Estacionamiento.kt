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
fun Estacionamiento() {
    var hours by remember { mutableStateOf("") }
    var minutes by remember { mutableStateOf("") }
    var cost by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Calculando Estacionamiento", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = hours,
            onValueChange = { hours = it },
            label = { Text("Horas") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = minutes,
            onValueChange = { minutes = it },
            label = { Text("Minutos") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val hoursInt = hours.toIntOrNull() ?: 0
            val minutesInt = minutes.toIntOrNull() ?: 0
            val totalHours = if (minutesInt > 0) hoursInt + 1 else hoursInt
            cost = totalHours * 1.5
        }) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Total a pagar: S/. $cost", fontSize = 24.sp)
    }
}