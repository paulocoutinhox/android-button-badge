package com.paulocoutinho.buttonbadge

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.badge.BadgeDrawable

class MainActivity : AppCompatActivity() {

    @androidx.annotation.OptIn(com.google.android.material.badge.ExperimentalBadgeUtils::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        applyOnRow1()
        applyOnRow2()
    }

    private fun applyOnRow1() {
        // find components
        val btNewsContainer = findViewById<FrameLayout>(R.id.btNewsContainer1)
        val btNews = findViewById<Button>(R.id.btNews1)

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

    private fun applyOnRow2() {
        // find components
        val btNewsContainer = findViewById<FrameLayout>(R.id.btNewsContainer2)
        val btNews = findViewById<TextView>(R.id.btNews2)

        // add drawable
        val badgeDrawable = BadgeDrawable.create(this)
        badgeDrawable.number = 1
        badgeDrawable.backgroundColor = Color.RED
        badgeDrawable.isVisible = true

        // update drawable
        btNewsContainer.foreground = badgeDrawable
        btNewsContainer.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
            badgeDrawable.updateBadgeCoordinates(btNews, btNewsContainer)
        }
    }

}