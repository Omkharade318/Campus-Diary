package com.example.dyp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dyp.ui.theme.DYPTheme

class CivilLabs : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.light(
                    Color.Transparent.toArgb(),
                    Color.White.toArgb()
                )
            )
            DYPTheme {
                CivilLabUI()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CivilLabUI() {
    // Define a list of image pairs and heights for LazyRows
    val selectedImage = remember { mutableStateOf<Int?>(null) }

    // Full-screen view when an image is clicked
    if (selectedImage.value != null) {
        FullScreenImage(selectedImage.value!!) {
            selectedImage.value = null // Reset on back
        }
    } else {

        val rows = listOf(
            Pair(
                R.drawable.model_and_material_museum to 180.dp,
                R.drawable.model_and_material_museum_2 to 180.dp
            ),
            Pair(
                R.drawable.geotechnical_engineering_lab to 170.dp,
                R.drawable.environmental_engineering_lab to 180.dp
            ),
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 8.dp, vertical = 32.dp)
        ) {
            // Header Image
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.civil),
                        contentDescription = "Department of Electrical Engineering",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(200.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            // Use items to iterate over the rows
            items(rows.size) { row ->
                LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
                    item {
                        val (image1, image2) = rows[row]

                        // First image
                        MyImage(
                            id = image1.first,
                            height = image1.second,
                            width = 210.dp,
                            onClick = { selectedImage.value = image1.first }
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        // Second image
                        MyImage(
                            id = image2.first,
                            height = image2.second,
                            width = 215.dp,
                            onClick = { selectedImage.value = image2.first }
                        )
                    }
                }
            }
        }
    }
}

