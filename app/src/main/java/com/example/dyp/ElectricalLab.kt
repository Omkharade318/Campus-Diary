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
import ir.kaaveh.sdpcompose.sdp

class ElectricalLab : ComponentActivity() {
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
                ElectricalLabUI()
            }
        }
    }
}

@Composable
fun ElectricalLabUI() {
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
                R.drawable.deparment_of_electrical_pic1 to 180.sdp,
                R.drawable.deparment_of_electrical_pic2 to 180.sdp
            ),
            Pair(
                R.drawable.electrical_project_lab to 170.sdp,
                R.drawable.electrical_project_2 to 180.sdp
            ),
            Pair(
                R.drawable.basic_electrical_lab to 200.sdp,
                R.drawable.electrical_machine_lab to 220.sdp
            ),
            Pair(
                R.drawable.control_system_and_power_system_lab to 200.sdp,
                R.drawable.advanced_switchgear_and_protection_lab to 220.sdp
            ),
            Pair(
                R.drawable.analog_electronics_and_power_electronics_lab to 220.sdp,
                R.drawable.electrical_measurements_and_instruments_lab1 to 235.sdp
            )
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 8.sdp, vertical = 32.sdp)
        ) {
            // Header Image
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.department_of_electrical_engg),
                        contentDescription = "Department of Electrical Engineering",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.sdp)
                            .height(200.sdp),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

            // Use items to iterate over the rows
            items(rows.size) { row ->
                LazyRow(modifier = Modifier.padding(vertical = 8.sdp)) {
                    item {
                        val (image1, image2) = rows[row]

                        // First image
                        MyImage(
                            id = image1.first,
                            height = image1.second,
                            width = 210.sdp,
                            onClick = { selectedImage.value = image1.first }
                        )

                        Spacer(modifier = Modifier.width(8.sdp))

                        // Second image
                        MyImage(
                            id = image2.first,
                            height = image2.second,
                            width = 215.sdp,
                            onClick = { selectedImage.value = image2.first }
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewElectricalLabUI() {
    DYPTheme {
        ElectricalLabUI()
    }
}
