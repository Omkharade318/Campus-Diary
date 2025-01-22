package com.example.dyp

import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import com.example.dyp.ui.theme.DYPTheme

class Garden : AppCompatActivity() {
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
                GardenUI()
            }
        }
    }
}

@Composable
fun GardenUI() {

    val selectedImage = remember { mutableStateOf<Int?>(null) }

    // Full-screen view when an image is clicked
    if (selectedImage.value != null) {
        FullScreenImage(selectedImage.value!!) {
            selectedImage.value = null // Reset on back
        }
    } else {

        // Define a list of image pairs and heights for LazyRows
        val rows = listOf(
            Pair(R.drawable.garden_pic1 to 180.dp, R.drawable.garden_pic2 to 180.dp),
            Pair(R.drawable.garden_pic3 to 170.dp, R.drawable.garden_pic4 to 180.dp),
            Pair(R.drawable.garden_pic5 to 200.dp, R.drawable.garden_pic6 to 220.dp),
            Pair(R.drawable.garden_pic7 to 220.dp, R.drawable.garden_pic8 to 200.dp),
            Pair(R.drawable.garden_pic9 to 210.dp, R.drawable.garden_pic_10 to 210.dp),
            Pair(R.drawable.garden_pic_11 to 190.dp, R.drawable.garden_pic_12 to 220.dp),
            Pair(R.drawable.garden_pic_13 to 170.dp, R.drawable.garden_pic_14 to 195.dp),
            Pair(R.drawable.garden_pic_15 to 200.dp, R.drawable.garden_pic_16 to 220.dp),
            Pair(R.drawable.garden_pic_17 to 205.dp, R.drawable.garden_pic_18 to 220.dp),
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
                        painter = painterResource(id = R.drawable.garden_head),
                        contentDescription = "Department of Computer Science and Engineering",
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

