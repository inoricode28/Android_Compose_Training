package com.example.primerapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.primerapp.ui.theme.PrimerAppTheme


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimerAppTheme {
        PromedioScreen()

    }
}

@Composable
fun PromedioScreen(){

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 35.dp)){

        var ec1 by rememberSaveable {
            mutableStateOf("")
        }
        var ec2 by rememberSaveable {
            mutableStateOf("")
        }
        var ec3 by rememberSaveable {
            mutableStateOf("")
        }
        var ef by rememberSaveable {
            mutableStateOf("")
        }

        var resultado by rememberSaveable {
            mutableStateOf("")
        }

        Column {
            Text(text = "Promedio de Notas",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold, fontSize = 30.sp)
            )

            MySpace(16)

            OutlinedTextField(value = ec1 ,
                onValueChange={ec1 = it},
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "Ingrese EC 1")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            MySpace(16)
            OutlinedTextField(value = ec2 ,
                onValueChange={ec2 = it},
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "Ingrese EC 2")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = ec3 ,
                onValueChange={ec3 = it},
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "Ingrese EC 3")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            OutlinedTextField(value = ef ,
                onValueChange={ef = it},
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "Ingrese EF")},
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(onClick = {
                                resultado = CalcularPromedio(ec1.toInt(),
                                    ec2.toInt(), ec3.toInt(), ef.toInt())

                             },
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "CALCULAR")
            }
            MySpace(16)
            Text(text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.DarkGray))


        }
    }

}

@Composable
fun MySpace(espacio: Int){
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun CalcularPromedio(ec1: Int, ec2:Int, ec3: Int, ef: Int): String{
    var promedio = (ec1*0.04)+(ec2*0.12)+(ec3*0.24)+(ef*0.6)
    var resultado = "DESAPROBADO"
    if (promedio>12.5){
        resultado = "APROBADO"
    }
    return "Su promedio es $promedio su estado es $resultado"

}