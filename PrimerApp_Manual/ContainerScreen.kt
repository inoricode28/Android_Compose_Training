package com.example.primerapp


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.primerapp.ui.theme.PrimerAppTheme





@Composable
fun MiComponenteComplejo(){
    Column(Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Magenta),
            contentAlignment = Alignment.Center)
        {
            Text(text = "Hola Box!!")

        }

        Spacer(modifier = Modifier.height(30.dp))

        Box (modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Green),
            contentAlignment = Alignment.Center)
        {
            Text(text = "Hola Box!!")

        }

        Spacer(modifier = Modifier.height(30.dp))
        
        Box (modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Yellow),
            contentAlignment = Alignment.Center)
        {
            Text(text = "Hola Box!!")

        }
    }
}

@Composable
fun Micaja(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center)
    {
        Text(text = "Box Prueba")
    }
}


@Composable
fun MiColumnaPrueba(){
    Column (modifier = Modifier.fillMaxSize().padding(top = 90.dp))
    {
        Text(text = "Text 1", modifier = Modifier.fillMaxWidth().background(Color.Blue).height(100.dp), color = Color.White, textAlign = TextAlign.Center)
        Text(text = "Text 2", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text(text = "Text 3", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text(text = "Text 4", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Text(text = "Text 5", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)


    }
}

@Composable
fun EjemploConstrain(){
    ConstraintLayout (modifier = Modifier.fillMaxSize())
    {
        val (boxBlue, boxRed) = createRefs()
        //val guiaLineaArriba = createGuidelineFromTop(0.1f)

        Box(modifier = Modifier.size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue)
            {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })

        Box(modifier = Modifier.size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed)
            {
                top.linkTo(boxBlue.bottom)
                start.linkTo(boxBlue.end)

            })
    }
}