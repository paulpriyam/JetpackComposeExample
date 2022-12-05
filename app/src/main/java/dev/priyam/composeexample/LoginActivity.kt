package dev.priyam.composeexample

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.priyam.composeexample.ui.theme.ComposeExampleTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen()
                }
            }
        }

    }
}


fun logged(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    val userName = remember {
        mutableStateOf("")
    }
    val password = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(top = 100.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello Again!",
            color = Color.Blue,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Welcome",
            color = Color.Blue,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = "Back", color = Color.Blue, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        OutlinedTextField(value = userName.value, onValueChange = {
            userName.value = it
        }, leadingIcon = { Icon(Icons.Filled.Person, "person") },
            label = {
                Text(text = "Username")
            },
            placeholder = {
                Text(text = "enter username")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password.value, onValueChange = {
                password.value = it
            },
            leadingIcon = {
                Icon(Icons.Filled.Info, contentDescription = "Info")
            },
            label = {
                Text(text = "Password")
            },
            placeholder = {
                Text(text = "enter password")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedButton(
            onClick = { logged(context, "Logged!!") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true, name = "lightMode")
@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "mightMode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun LoginScreenPreview() {
    LoginScreen()
}