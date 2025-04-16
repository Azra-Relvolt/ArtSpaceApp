package com.example.artspaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Data untuk artwork
    private val artworks = listOf(
        Artwork(R.drawable.art1, R.string.artwork1_title, R.string.artwork1_artist),
        Artwork(R.drawable.art2, R.string.artwork2_title, R.string.artwork2_artist),
        Artwork(R.drawable.art3, R.string.artwork3_title, R.string.artwork3_artist)
    )

    private var currentArtworkIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val previousButton = findViewById<Button>(R.id.previous_button)
        val nextButton = findViewById<Button>(R.id.next_button)

        previousButton.setOnClickListener {
            showPreviousArtwork()
        }

        nextButton.setOnClickListener {
            showNextArtwork()
        }

        updateArtworkDisplay()
    }

    private fun showPreviousArtwork() {
        currentArtworkIndex = if (currentArtworkIndex == 0) {
            artworks.size - 1
        } else {
            currentArtworkIndex - 1
        }
        updateArtworkDisplay()
    }

    private fun showNextArtwork() {
        // Implementasi sesuai permintaan
        if (currentArtworkIndex == 0) {
            // Update states to show the second artwork
            currentArtworkIndex = 1
        } else if (currentArtworkIndex == 1) {
            // Update states to show the third artwork
            currentArtworkIndex = 2
        } else if (currentArtworkIndex == artworks.size - 1) {
            // Update state to show the first artwork
            currentArtworkIndex = 0
        }
        updateArtworkDisplay()
    }

    private fun updateArtworkDisplay() {
        val currentArtwork = artworks[currentArtworkIndex]

        val artworkImage = findViewById<ImageView>(R.id.artwork_image)
        val artworkTitle = findViewById<TextView>(R.id.artwork_title)
        val artworkArtist = findViewById<TextView>(R.id.artwork_artist)

        artworkImage.setImageResource(currentArtwork.imageResId)
        artworkTitle.setText(currentArtwork.titleResId)
        artworkArtist.setText(currentArtwork.artistResId)
    }
}

data class Artwork(
    val imageResId: Int,
    val titleResId: Int,
    val artistResId: Int
)