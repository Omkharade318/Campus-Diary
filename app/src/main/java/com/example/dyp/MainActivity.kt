package com.example.dyp

import android.content.Intent
import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.dyp.databinding.ActivityMainBinding
import com.example.dyp.ui.theme.DYPTheme

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val classroomsCardView = findViewById<CardView>(R.id.classrooms)
         val labsCardView = findViewById<CardView>(R.id.labs)
         val messCardView = findViewById<CardView>(R.id.mess)
         val groundCardView = findViewById<CardView>(R.id.ground)
         val gardenCardView = findViewById<CardView>(R.id.garden)
         val cafeCardView = findViewById<CardView>(R.id.cafe)
         val hostelsCardView = findViewById<CardView>(R.id.hostels)
         val event_hallsCardView = findViewById<CardView>(R.id.event_halls)
         val gymCardView = findViewById<CardView>(R.id.gym)
         val eventsCardView = findViewById<CardView>(R.id.events)
         val researchCardView = findViewById<CardView>(R.id.research)
         val bus_facilityCardView = findViewById<CardView>(R.id.bus_facility)

        classroomsCardView.setOnClickListener {
            // Start ClassroomActivity
            val intent = Intent(this, Classrooms::class.java)
            startActivity(intent)
        }

        labsCardView.setOnClickListener {
            val intent = Intent(this, Labs::class.java)
            startActivity(intent)
        }

        messCardView.setOnClickListener {
            val intent = Intent(this, Mess::class.java)
            startActivity(intent)
        }

        groundCardView.setOnClickListener {
            val intent = Intent(this, Ground::class.java)
            startActivity(intent)
        }

        gardenCardView.setOnClickListener {
            val intent = Intent(this, Garden::class.java)
            startActivity(intent)
        }

        cafeCardView.setOnClickListener {
            val intent = Intent(this, Cafe::class.java)
            startActivity(intent)
        }

        hostelsCardView.setOnClickListener {
            val intent = Intent(this, Hostels::class.java)
            startActivity(intent)
        }

        event_hallsCardView.setOnClickListener {
            val intent = Intent(this, Event_Halls::class.java)
            startActivity(intent)
        }


        gymCardView.setOnClickListener {
            val intent = Intent(this, Gym::class.java)
            startActivity(intent)
        }

        eventsCardView.setOnClickListener {
            val intent = Intent(this, Events::class.java)
            startActivity(intent)
        }

        researchCardView.setOnClickListener {
            val intent = Intent(this, Research::class.java)
            startActivity(intent)
        }

        bus_facilityCardView.setOnClickListener {
            val intent = Intent(this, Bus_Facility::class.java)
            startActivity(intent)
        }

        // Set up ImageSlider
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.garden_pic_12, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.garden_pic_15, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.garden_pic_13, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.garden_pic_16, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.garden_pic_17, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        setContent {
            enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.light(Color.Transparent.toArgb(), Color.White.toArgb())
            )
            DYPTheme {
                HomeScreen()
            }
        }
    }
    
}

@Composable
fun HomeScreen() {
    Box(contentAlignment = Alignment.Center){
        Text(text = "Home Screen")
    }
}