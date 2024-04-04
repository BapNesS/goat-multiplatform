package com.baptistecarlier.am24.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.baptistecarlier.am24.ui.navigation.OmgNavHost
import com.baptistecarlier.am24.ui.theme.OmgTheme

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OmgTheme {
                OmgNavHost()
            }
        }
    }
}