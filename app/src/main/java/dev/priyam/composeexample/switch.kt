package dev.priyam.composeexample

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MySwitch() {
    Column(modifier = Modifier
        .fillMaxWidth(),
    horizontalAlignment = Alignment.Start
    ) {
    val isChanged = remember {
        mutableStateOf(true)
    }
    Switch(checked = isChanged.value, onCheckedChange = {
        isChanged.value = it
    })

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SwitchPreview() {
    MySwitch()
}