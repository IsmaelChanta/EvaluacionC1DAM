package pe.edu.idat.ec1_ismaelchanta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Alumno() {
    var grade1 by remember { mutableStateOf("") }
    var grade2 by remember { mutableStateOf("") }
    var grade3 by remember { mutableStateOf("") }
    var grade4 by remember { mutableStateOf("") }
    var average by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Calculando Promedio de Alumno", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = grade1,
            onValueChange = { grade1 = it },
            label = { Text("Nota 1") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = grade2,
            onValueChange = { grade2 = it },
            label = { Text("Nota 2") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = grade3,
            onValueChange = { grade3 = it },
            label = { Text("Nota 3") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = grade4,
            onValueChange = { grade4 = it },
            label = { Text("Nota 4") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val grades = listOf(
                grade1.toDoubleOrNull() ?: 0.0,
                grade2.toDoubleOrNull() ?: 0.0,
                grade3.toDoubleOrNull() ?: 0.0,
                grade4.toDoubleOrNull() ?: 0.0
            ).sorted()

            val finalGrades = grades.drop(1)
            average = finalGrades[0] * 0.2 + finalGrades[1] * 0.3 + finalGrades[2] * 0.5
        }) {
            Text("Calcular Promedio")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Promedio: $average", fontSize = 24.sp)
    }
}