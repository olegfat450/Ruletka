package com.example.ruletka.riletka_screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ruletka.R
import com.example.ruletka.riletka_screen.utils.Nambers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newCoroutineContext
import kotlin.math.roundToInt


private var rotation: MutableState<Float> = mutableStateOf(0f)

@Composable
fun Ruletka_Screen() {

           val nambers = Nambers.nambers

            var score by remember {  mutableStateOf(0) }

           val angle by animateFloatAsState(targetValue = rotation.value, animationSpec = tween(durationMillis = 2000),


               finishedListener = { val index = ((it % 360) / (360f/37)).roundToInt() ; score = if (index < 37 ) nambers[index] else nambers[36]})


          Column (modifier = Modifier
              .fillMaxSize()
              .background(color = colorResource(R.color.green)),
              verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally) {

               Text(text = score.toString(), fontSize = 62.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, color = Color.White)

    Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter,
       ) {


        Image(
            painter = painterResource(R.drawable.ruletka1),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 54.dp)
                .rotate(angle),
            contentScale = ContentScale.Crop
        )
        Image(painter = painterResource(R.drawable.ukaz1), contentDescription = "")

    }

              Button(onClick = { val s = (720..1080).random()

                  rotation.value =  s.toFloat() + angle - 9.37f },
                   colors = ButtonDefaults.buttonColors(containerColor = Color.Black), shape = RectangleShape,

                  modifier = Modifier.padding(bottom = 52.dp)
                      .sizeIn(minWidth = 200.dp)
                      .border(width = 2.dp, color = Color.White)) { Text(text = "Start", fontSize = 32.sp) }


    }
}
















