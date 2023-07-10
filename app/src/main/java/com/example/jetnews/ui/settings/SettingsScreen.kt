package com.example.jetnews.ui.settings

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Dvr
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.sharp.Book
import androidx.compose.material.icons.sharp.ChangeCircle
import androidx.compose.material.icons.sharp.LibraryAdd
import androidx.compose.material.icons.sharp.Money
import androidx.compose.material.icons.sharp.QrCode
import androidx.compose.material.icons.sharp.RoomPreferences
import androidx.compose.material.icons.sharp.Send
import androidx.compose.material.icons.sharp.Share
import androidx.compose.material.icons.sharp.TypeSpecimen
import androidx.compose.material.icons.sharp.Vrpano
import androidx.compose.material.icons.sharp.Wallet
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnews.R

@Composable
fun SettingsScreen(
    navigateToHome: () -> Unit,
//    vm: SettingsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            SettingsTopBar(navigateToHome)
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(it)
                .padding(16.dp)
        ) {
            VRPlaySettingGroups()
            UserSettingGroups()
            BoardsGroup()

            VersionInfo()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsTopBar(navigateToHome: () -> Unit) {
    TopAppBar(
        title = {
            Row {
                IconButton(onClick = { navigateToHome() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.cd_back)
                    )
                }
                Text(
                    text = "Settings",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .height(50.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )
            }
        },
    )
}

@Composable
fun VRPlaySettingGroups() {
    SettingsGroup(name = R.string.vr_play_setting) {
//                SettingsSwitchComp(
//                    name = R.string.Settings,
//                    icon = R.drawable.ic_jetnews_bookmark,
//                    iconDesc = R.string.Exhibition_title,
//                    state = vm.isSwitchOn.collectAsState()
//                ) {
//                    vm.toggleSwitch()
//                }
        SettingsTextComp(
            name = R.string.wifi_only,
            settingIcon = SettingIcon.ImageVectorIcon(Icons.Filled.Wifi),
            iconDesc = R.string.Settings,
//                    state = vm.textPreference.collectAsState(),
//                    onSave = { finalText -> vm.saveText(finalText) },
//                    onCheck = { text -> vm.checkTextInput(text) },
        )

        SettingsTextComp(
            name = R.string.change_hmd,
            settingIcon = SettingIcon.ImageVectorIcon(Icons.Sharp.QrCode),
            iconDesc = R.string.Settings,
        )
    }
}

@Composable
fun UserSettingGroups() {
    SettingsGroup(name = R.string.user_settings) {
        SettingsTextComp(
            name = R.string.login,
            settingIcon = SettingIcon.ImageVectorIcon(Icons.Filled.Login),
            iconDesc = R.string.Settings,
        )
        SettingsTextComp(
            name = R.string.purchase_history,
            settingIcon = SettingIcon.ImageVectorIcon(Icons.Sharp.Wallet),
            iconDesc = R.string.Settings,
        )
        SettingsTextComp(
            name = R.string.review,
            settingIcon = SettingIcon.ImageVectorIcon(Icons.Sharp.Send),
            iconDesc = R.string.Settings,
        )
    }
}

@Composable
fun BoardsGroup() {
    SettingsGroup(name = R.string.board) {
        SettingsTextComp(
            name = R.string.notices,
            settingIcon = SettingIcon.ImageVectorIcon(Icons.Filled.Notifications),
            iconDesc = R.string.Settings,
        )

        SettingsTextComp(
            name = R.string.guide,
            settingIcon = SettingIcon.ImageVectorIcon(Icons.Sharp.Book),
            iconDesc = R.string.Settings,
        )

        SettingsTextComp(
            name = R.string.license,
            settingIcon = SettingIcon.ImageVectorIcon(Icons.Sharp.LibraryAdd),
            iconDesc = R.string.Settings,
        )

        SettingsTextComp(
            name = R.string.app_share,
            settingIcon = SettingIcon.ImageVectorIcon(Icons.Sharp.Share),
            iconDesc = R.string.Settings,
        )
    }
}

@Composable
fun VersionInfo() {
    Text(
        text = "Version 2.3 (AVP5.1ISX1.2) \nPowered by ALPHAView",
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .wrapContentHeight(align = Alignment.CenterVertically)
            .wrapContentWidth(align = Alignment.CenterHorizontally)
    )
}

@Composable

fun SettingsGroup(
    @StringRes name: Int,
    // to accept only composables compatible with column
    content: @Composable ColumnScope.() -> Unit ){
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(stringResource(id = name))
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            color = colorResource(id = R.color.dark_gray),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4),
        ) {
            Column {
                content()
            }
        }
    }
}

@Preview("Settings")
@Composable
fun SettingsPreview(){
    SettingsScreen(
        modifier = Modifier.fillMaxHeight(),
        navigateToHome = {},
    )
}