package dev.priyam.composeexample

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.priyam.composeexample.ui.theme.greenColor

@Composable
fun MyExtendedFloatingActionButton() {
    ExtendedFloatingActionButton(text = {
        Text(text = "Extended")
    }, onClick = { /*TODO*/ },
        backgroundColor = greenColor,
        contentColor = Color.Cyan,
        icon = { Icon(Icons.Filled.Add, "") }
    )
}

@Composable
fun MyFloatingActionButton() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Floating action button example")
        Spacer(modifier = Modifier.height(20.dp))
        FloatingActionButton(
            onClick = {
                Toast.makeText(context, "Floating action button clicked", Toast.LENGTH_SHORT).show()
            },
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Add, contentDescription = "add")
        }
        Spacer(modifier = Modifier.height(20.dp))
        FloatingActionButton(
            onClick = {
                Toast.makeText(context, "Floating action button clicked", Toast.LENGTH_SHORT).show()
            },
            shape = RectangleShape,
            backgroundColor = greenColor,
            contentColor = Color.White
        ) {
            Icon(Icons.Filled.Add, "")
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun FabPreview(){
    MyFloatingActionButton()
}