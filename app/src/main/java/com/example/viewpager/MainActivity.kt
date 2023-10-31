package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    private val images: List<Int> = listOf(R.drawable.img, R.drawable.img_1, R.drawable.img_2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        val adapter = ImagePagerAdapter(images)
        viewPager.adapter = adapter

        // Настройка анимации для ViewPager2
        viewPager.setPageTransformer { page, position ->
            val scaleFactor = if (position < 0) 1f + position else 1f - position
            page.scaleX = scaleFactor
            page.scaleY = scaleFactor
        }


//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//
//        }.attach()
    }
}