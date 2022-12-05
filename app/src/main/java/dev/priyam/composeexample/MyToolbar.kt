package dev.priyam.composeexample

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.priyam.composeexample.ui.theme.ComposeExampleTheme
import dev.priyam.composeexample.ui.theme.greenColor

@Composable
fun MyToolbar() {
    ComposeExampleTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("My Compose Demo", modifier = Modifier.fillMaxWidth())
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Menu, contentDescription = "menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(Icons.Filled.Search, contentDescription = "search")
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Filled.Notifications,
                                contentDescription = "notification"
                            )
                        }
                    }
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = { MyExtendedFloatingActionButton()}
        ) {
            Surface(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Scaffold provides slots for the most common top-level Material components," +
                            " such as TopAppBar, BottomAppBar, FloatingActionButton, and Drawer." +
                            " By using Scaffold, it's easy to make sure these components are" +
                            " properly positioned and work together correctly.", fontSize = 14.sp
                )
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun PreviewMyToolbar() {
    MyToolbar()
}