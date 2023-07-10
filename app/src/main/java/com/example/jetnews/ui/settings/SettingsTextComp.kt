package com.example.jetnews.ui.settings

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnews.R

sealed class SettingIcon {
    data class DrawableResIcon(@DrawableRes val iconId: Int) : SettingIcon()
    data class ImageVectorIcon(val imageVector: ImageVector) : SettingIcon()
}

@Composable
fun SettingsTextComp(
    settingIcon: SettingIcon,
    @StringRes iconDesc: Int,
    @StringRes name: Int,
//    state: State<String>, // current value
) {

    // if the dialog is visible
//    val isDialogShown by remember {
//        mutableStateOf(false)
//    }
//
//    // conditional visibility in dependence to state
//    if (isDialogShown) {
//        Dialog(onDismissRequest = {
//            // dismiss the dialog on touch outside
////            isDialogShown = false
//        }) {
//            TextEditDialog(name, state, onSave, onCheck) {
//                // to dismiss dialog from within
////                isDialogShown = false
//            }
//        }
//    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.dark_gray))
            .padding(16.dp),
//        onClick = {
            // clicking on the preference, will show the dialog
//            isDialogShown = true
//        },
    ) {
        Column(modifier = Modifier.background(colorResource(id = R.color.dark_gray))) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                settingIcon?.let { icon ->
                    when (icon) {
                        is SettingIcon.DrawableResIcon -> {
                            Icon(
                                painterResource(id = icon.iconId),
                                contentDescription = stringResource(id = iconDesc),
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        is SettingIcon.ImageVectorIcon -> {
                            Icon(
                                imageVector = icon.imageVector,
                                contentDescription = stringResource(id = iconDesc),
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.padding(8.dp)) {
                    // setting text title
                    Text(
                        text = stringResource(id = name),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    // current value shown
                }
            }
            Divider(
                color = Color.White,
                thickness = 0.5.dp
            )
        }
    }
}

//@Composable
//private fun TextEditDialog(
//    @StringRes name: Int,
//    storedValue: State<String>,
//    onSave: (String) -> Unit,
//    onCheck: (String) -> Boolean,
//    onDismiss: () -> Unit // internal method to dismiss dialog from within
//) {
//
//    // storage for new input
//    val currentInput by remember {
//        mutableStateOf(TextFieldValue(storedValue.value))
//    }
//
//    // if the input is valid - run the method for current value
//    val isValid by remember {
//        mutableStateOf(onCheck(storedValue.value))
//    }
//
//    Surface(
//        color = MaterialTheme.colorScheme.surfaceTint
//    ) {
//
//        Column(
//            modifier = Modifier
//                .wrapContentHeight()
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Text(stringResource(id = name))
//            Spacer(modifier = Modifier.height(8.dp))
//            TextField(currentInput, onValueChange = {
//                // check on change, if the value is valid
////                isValid = onCheck(it.text)
////                currentInput = it
//            })
//            Row {
//                Spacer(modifier = Modifier.weight(1f))
//                Button(onClick = {
//                    // save and dismiss the dialog
//                    onSave(currentInput.text)
//                    onDismiss()
//                    // disable / enable the button
//                }, enabled = isValid) {
//                    Text(stringResource(id = R.string.Tour_title))
//                }
//            }
//        }
//    }
//}

@Preview("Settings Text Component")
@Composable
fun SettingsTextCompPreview(){
    SettingsTextComp(
        name = R.string.Settings,
        settingIcon = SettingIcon.DrawableResIcon(R.drawable.ic_jetnews_bookmark),
        iconDesc = R.string.Settings,
    )
}