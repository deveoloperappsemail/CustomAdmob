package com.example.adnetworkdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import com.example.allnetworkads.Ads
import com.example.allnetworkads.adslib.TestAds

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Example of library usage

        val button = findViewById<Button>(R.id.button)
        val adFrame = findViewById<FrameLayout>(R.id.native_ad_layout)

        /*to show admob ads save true
        to show applovin ads save false*/
        val showAdmob = false
        TestAds.getTestAds(this, showAdmob, packageName)

        //LiveAds.getLiveAds(this, packageName)
        Ads.loadNative(this, this, adFrame)
        Ads.loadInter(this, this)

        button.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            Ads.showInter(this, this, intent)
        }
    }
}