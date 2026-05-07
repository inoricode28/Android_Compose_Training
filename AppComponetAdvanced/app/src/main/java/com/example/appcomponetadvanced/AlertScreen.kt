package com.example.appcomponetadvanced

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun EjemploDialogBasic(){
    AlertDialog(onDismissRequest = { /*TODO*/ },
        confirmButton = {},
        title = { Text(text = "Titulo Dialog") },
        text = {Text(text = "Hola soy un Dialog Compose")}
        )
}