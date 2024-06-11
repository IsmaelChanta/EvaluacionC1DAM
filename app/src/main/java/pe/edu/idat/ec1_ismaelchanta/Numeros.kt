package pe.edu.idat.ec1_ismaelchanta

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Numeros() {
    val evenNumbers = (10..20).filter { it % 2 == 0 }.sortedDescending()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Números Pares Descendentes", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        evenNumbers.forEach { number ->
            Text(text = "$number", fontSize = 24.sp)
        }
    }
}