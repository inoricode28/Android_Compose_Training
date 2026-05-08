package com.example.dataset

import android.graphics.Color
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.apply {
            setFlags(
                android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        setContent {
            WeatherApp()
        }
    }
}

data class HourlyModel(val hour: String, val temp: Int, val picPath: String)

data class FutureModel(val day: String, val picPath: String, val status: String, val highTemp: Int, val lowTemp: Int)

private val hourlyItems = listOf(
    HourlyModel("10:00", 25, "cloudy_sunny"),
    HourlyModel("11:00", 26, "sunny"),
    HourlyModel("12:00", 27, "cloudy_sunny"),
    HourlyModel("13:00", 26, "cloudy"),
    HourlyModel("14:00", 25, "sunny")
)

private val dailyItems = listOf(
    FutureModel("Mon", "sunny", "Sunny", 27, 18),
    FutureModel("Tue", "cloudy", "Cloudy", 25, 17),
    FutureModel("Wed", "rainy", "Rainy", 22, 15),
    FutureModel("Thu", "storm", "Storm", 20, 14),
    FutureModel("Fri", "windy", "Windy", 24, 16),
    FutureModel("Sat", "cloudy_sunny", "Partly Cloudy", 26, 18)
)

@Composable
fun getDrawableResourceId(picPath: String): Int {
    return when (picPath) {
        "storm" -> R.drawable.storm
        "cloudy" -> R.drawable.cloudy
        "sunny" -> R.drawable.sunny
        "rainy" -> R.drawable.rainy
        "windy" -> R.drawable.windy
        "cloudy_sunny" -> R.drawable.cloudy_sunny
        "rain" -> R.drawable.rain
        "wind" -> R.drawable.wind
        "humidity" -> R.drawable.humidity
        else -> R.drawable.cloudy_sunny
    }
}

@Composable
fun WeatherApp() {
    val gradientColors = listOf(
        ComposeColor(Color.parseColor("#59469d")),
        ComposeColor(Color.parseColor("#643d67"))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.horizontalGradient(colors = gradientColors))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 20.dp)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Mostly Cloudy",
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Image(
                        painter = painterResource(id = R.drawable.cloudy_sunny),
                        contentDescription = "Weather Icon",
                        modifier = Modifier.size(150.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Mon June 17 | 10:00 AM",
                        color = colorResource(id = R.color.white),
                        fontSize = 19.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "25°C",
                        color = colorResource(id = R.color.white),
                        fontSize = 63.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "H:27 L:18",
                        color = colorResource(id = R.color.white),
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(colorResource(id = R.color.purple))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            WeatherDetailItem(
                                icon = R.drawable.rain,
                                value = "22%",
                                label = "Rain"
                            )
                            WeatherDetailItem(
                                icon = R.drawable.wind,
                                value = "12 Km/h",
                                label = "Wind"
                            )
                            WeatherDetailItem(
                                icon = R.drawable.humidity,
                                value = "18%",
                                label = "Humidity"
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Today",
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(hourlyItems) { item ->
                        FutureModelViewHolder(model = item)
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Future",
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "Next 7 day>",
                        color = colorResource(id = R.color.white),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
            }

            items(dailyItems) { item ->
                FutureItem(item = item)
            }
        }
    }
}

@Composable
fun WeatherDetailItem(icon: Int, value: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = label,
            modifier = Modifier.size(34.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            color = colorResource(id = R.color.white),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = label,
            color = colorResource(id = R.color.white),
            fontSize = 12.sp
        )
    }
}

@Composable
fun FutureModelViewHolder(model: HourlyModel) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(colorResource(id = R.color.purple))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = model.hour,
            color = colorResource(id = R.color.white),
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            painter = painterResource(id = getDrawableResourceId(model.picPath)),
            contentDescription = model.picPath,
            modifier = Modifier.size(45.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${model.temp}°",
            color = colorResource(id = R.color.white),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun FutureItem(item: FutureModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item.day,
            color = colorResource(id = R.color.white),
            fontSize = 14.sp,
            modifier = Modifier.width(40.dp)
        )

        Image(
            painter = painterResource(id = getDrawableResourceId(item.picPath)),
            contentDescription = item.picPath,
            modifier = Modifier.size(45.dp)
        )

        Text(
            text = item.status,
            color = colorResource(id = R.color.white),
            fontSize = 14.sp,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "${item.highTemp}°",
            color = colorResource(id = R.color.white),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "${item.lowTemp}°",
            color = colorResource(id = R.color.white),
            fontSize = 14.sp
        )
    }
}

@Composable
fun Image(painter: androidx.compose.ui.graphics.painter.Painter, contentDescription: String, modifier: Modifier = Modifier) {
    androidx.compose.foundation.Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier
    )
}