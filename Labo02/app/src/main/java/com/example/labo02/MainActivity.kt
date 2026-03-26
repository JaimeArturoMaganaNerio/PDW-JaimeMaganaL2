package com.example.labo02

import android.graphics.Color.blue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labo02.ui.theme.Labo02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Labo02Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UIlISTA(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Labo02Theme {
        Greeting("Android")
    }
}

@Composable
fun UIlISTA(modifier: Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        val usuario: MutableState<String> = remember {
            mutableStateOf("")}
            TextField(
                value = usuario.value,
                onValueChange = {
                    usuario.value = it
                },
            )

        val pulsado: MutableState<Int> = remember {
            mutableIntStateOf(0)
        }
        Text(text = "Se ha pulsado el botón ${pulsado.value} veces")
        Button(
            onClick = {
                pulsado.value++
            }
        ) {
            Text(text = "Guardar")
        }

        Row{

            Text(
                text = "Lista de nombres y" +
                        " posicion de lista "

            )

            val pulsado: MutableState<Int> = remember {
                mutableIntStateOf(0)
            }
            Button(
                onClick = {
                    pulsado.value++
                }
            ) {
                Text(text = "Lompiar")
            }



        }

        val entries: List<String> = listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten")
        LazyColumn (Modifier.border(
            border = BorderStroke(3.dp, Color.Blue)
        )){
            itemsIndexed(entries.toList()) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item
                    )
                    Text(
                        text = (index + 1).toString()
                    )
                }
            }
        }



        }




    }

