package com.example.myapplicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            MyApplicationComposeTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
//            }
//        }

        setContent {
            MyApplicationComposeTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun PuppyImage(puppy: Puppy) {
    Image(
        painter = painterResource(id = puppy.puppyImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationComposeTheme {
        Greeting("Android")
    }
}

@Composable
fun MyApp() {
    Scaffold(
        content = {
            BarkHomeContent()
        }
    )
}

@Composable
fun BarkHomeContent() {
    val puppies = remember { DataProvider.puppyList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = puppies,
            itemContent = {
                PuppyListItem(puppy = it)
            })
    }
}

@Composable
fun PuppyListItem(puppy: Puppy) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            PuppyImage(puppy)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = puppy.title, style = typography.h6)
                Text(text = "VIEW DETAIL", style = typography.caption)
            }
        }
    }
}

data class Puppy(
    val id: Int,
    val title: String,
    val sex: String,
    val age: Int,
    val description: String,
    val puppyImageId: Int = 0
)

object DataProvider {

    val puppyList = listOf(
        Puppy(
            id = 1,
            title = "Monty",
            sex = "Male",
            age = 14,
            description = "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            puppyImageId = R.drawable.p1
        ),
        Puppy(
            id = 2,
            title = "Jubilee",
            sex = "Female",
            age = 6,
            description = "Jubilee enjoys thoughtful discussions by the campfire.",
            puppyImageId = R.drawable.p2
        ),
        Puppy(
            id = 3,
            title = "Beezy",
            sex = "Male",
            age = 8,
            description = "Beezy's favorite past-time is helping you choose your brand color.",
            puppyImageId = R.drawable.p3
        ),
        Puppy(
            id = 4,
            title = "Mochi",
            sex = "Male",
            age = 10,
            description = "Mochi is the perfect \"rubbery ducky\" debugging pup, always listening.",
            puppyImageId = R.drawable.p4
        ),
        Puppy(
            id = 5,
            title = "Brewery",
            sex = "Female",
            age = 12,
            description = "Brewery loves fetching you your favorite homebrew.",
            puppyImageId = R.drawable.p5
        ),
        Puppy(
            id = 6,
            title = "Lucy",
            sex = "Female",
            age = 8,
            description = "Picture yourself in a boat on a river, Lucy is a pup with kaleidoscope eyes.",
            puppyImageId = R.drawable.p6
        ),
        Puppy(
            id = 7,
            title = "Astro",
            sex = "Male",
            age = 10,
            description = "Is it a bird? A plane? No, it's Astro blasting off into your heart!",
            puppyImageId = R.drawable.p7
        ),
        Puppy(
            id = 8,
            title = "Boo",
            sex = "Female",
            age = 9,
            description = "Boo is just a teddy bear in disguise. What he lacks in grace, he makes up in charm.",
            puppyImageId = R.drawable.p8
        ),
        Puppy(
            id = 9,
            title = "Pippa",
            sex = "Male",
            age = 7,
            description = "Pippa likes to look out the window and write pup-poetry.",
            puppyImageId = R.drawable.p9
        ),
        Puppy(
            id = 10,
            title = "Coco",
            sex = "Female",
            age = 10,
            description = "Coco enjoys getting pampered at the local puppy spa.",
            puppyImageId = R.drawable.p10
        ),
        Puppy(
            id = 11,
            title = "Brody",
            sex = "Male",
            age = 13,
            description = "Brody is a good boy, waiting for your next command.",
            puppyImageId = R.drawable.p11
        ),
        Puppy(
            id = 12,
            title = "Stella",
            sex = "Female",
            age = 14,
            description = "Stella! Calm and always up for a challenge, she's the perfect companion.",
            puppyImageId = R.drawable.p12
        ),
    )
}