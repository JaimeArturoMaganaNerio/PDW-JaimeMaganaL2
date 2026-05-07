package screen

import android.hardware.Sensor
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import sensores.useSensor

@Composable
fun LightSensor () {
    val lightValues = useSensor(Sensor.TYPE_LIGHT)

    Scaffold { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sensor de Luz", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            if (lightValues.isNotEmpty()) {
                Text(text = "Intensidad:${lightValues[0]} lx", fontSize = 18.sp)
            } else {
                Text(text = "Sensor no disponible", fontSize = 18.sp, color = androidx.compose.ui.graphics.Color.Red)
            }
        }
    }
}