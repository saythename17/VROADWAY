package com.example.jetnews.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.compose.material3.Text

class SettingActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SettingScreen()
        }
    }
}

@Composable
fun SettingScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        SettingItem("Notices", MainActivity::class.java)
        SettingItem("Licenses", MainActivity::class.java)
        SettingItem("FAQ", MainActivity::class.java)
    }
}

@Composable
fun SettingItem(title: String, activityClass: Class<*>) {
    // Fetching the Local Context
//    val context = LocalContext.current
    Text(
        text = title,
//        modifier = Modifier
//            .padding(8.dp)
//            .clickable {
//                val intent = Intent(context, activityClass)
//                context.startActivity(intent)
//            }
//            .fillMaxWidth()
//            .wrapContentHeight()

    )
}

