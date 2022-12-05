package dev.priyam.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.priyam.composeexample.model.UsersModel
import dev.priyam.composeexample.model.dummyData
import dev.priyam.composeexample.ui.theme.ComposeExampleTheme

class DummyRecyclerViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    RecyclerView(dummyData())
                }
            }
        }
    }
}

@Composable
fun EachRow(data: UsersModel) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(CornerSize(10.dp)),
        elevation = 2.dp
    ) {
        Row(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "profile",
                modifier = Modifier
                    .padding(2.dp)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
            )
            Text(text = data.description, modifier = Modifier.padding(8.dp).fillMaxWidth())
        }
    }
}

@Composable
fun RecyclerView(users: List<UsersModel>) {
    LazyColumn {
        items(users) { user ->
            EachRow(data = user)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecyclerViewPreview() {
    RecyclerView(users = dummyData())
}