package com.paulocoutinho.buttonbadge

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.badge.BadgeDrawable

class MainActivity : AppCompatActivity() {

    @androidx.annotation.OptIn(com.google.android.material.badge.ExperimentalBadgeUtils::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find components
        val btNewsContainer = findViewById<FrameLayout>(R.id.btNewsContainer)
        val btNews = findViewById<Button>(R.id.btNews)

        // add drawable
        val badgeDrawable = BadgeDrawable.create(this)
        badgeDrawable.number = 1
        badgeDrawable.backgroundColor = Color.RED
        badgeDrawable.horizontalOffset = 60
        badgeDrawable.verticalOffset = 30
        badgeDrawable.isVisible = true

        // update drawable
        btNewsContainer.foreground = badgeDrawable
        btNewsContainer.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            badgeDrawable.updateBadgeCoordinates(btNews, btNewsContainer)
        }
    }

}