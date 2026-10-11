package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableIntStateOf
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ArtSpaceTheme {
                ArtSpaceScreen()
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {
    var currentArtwork by remember {
        mutableIntStateOf(0)
    }
    val artworkImages = listOf(
        R.drawable.starry_night,
        R.drawable.great_wave,
        R.drawable.pearl_earring
    )

    val artworkTitles = listOf(
        "Starry Night",
        "The Great Wave",
        "Girl with a Pearl Earring"
    )

    val artworkArtists = listOf(
        "Vincent van Gogh (1889)",
        "Katsushika Hokusai (1831)",
        "Johannes Vermeer (1665)"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // Artwork
        // Artwork
        Image(
            painter = painterResource(
                id = artworkImages[currentArtwork]
            ),
            contentDescription = artworkTitles[currentArtwork],
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp),
            contentScale = ContentScale.Fit
        )

        // Artwork information
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = artworkTitles[currentArtwork],
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = artworkArtists[currentArtwork],
                style = MaterialTheme.typography.bodyLarge
            )
        }

        // Navigation buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentArtwork =
                        if (currentArtwork > 0) {
                            currentArtwork - 1
                        } else {
                            artworkImages.lastIndex
                        }
                }
            ) {
                Text("Previous")
            }

            Button(
                onClick = {
                    currentArtwork =
                        if (currentArtwork < artworkImages.lastIndex) {
                            currentArtwork + 1
                        } else {
                            0
                        }
                }
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}