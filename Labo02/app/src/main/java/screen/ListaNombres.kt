package screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UIlISTA(modifier: Modifier) {
    val entries = remember { mutableStateListOf<String>() }
    val usuario = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TextField(
            value = usuario.value,
            onValueChange = {
                usuario.value = it
            },
            label = { Text("Nombre") }
        )


        Text(text = "Se han guardado ${entries.size} nombres")

        Button(
            onClick = {
                if (usuario.value.isNotBlank()) {
                    entries.add(usuario.value)
                    usuario.value = ""
                }
            }
        ) {
            Text(text = "Guardar")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(
                text = "Lista de nombres y posición "
            )

            Button(
                onClick = {
                    entries.clear()
                }
            ) {
                Text(text = "Limpiar")
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .border(BorderStroke(3.dp, Color.Blue))
                .fillMaxWidth()
                .height(300.dp)
        ) {
            itemsIndexed(entries) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item)
                    Text(text = (index + 1).toString())
                }
            }
        }
    }
}

