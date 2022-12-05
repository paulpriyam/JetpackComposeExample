package dev.priyam.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dagger.hilt.android.AndroidEntryPoint
import dev.priyam.composeexample.model.Post
import dev.priyam.composeexample.ui.theme.ComposeExampleTheme
import dev.priyam.composeexample.utils.ApiStates
import dev.priyam.composeexample.viewModel.PostViewModel

@AndroidEntryPoint
class PostRecyclerViewActivity : ComponentActivity() {

    private val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExampleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    getData(postViewModel = postViewModel)
                }
            }
        }
    }
}

@Composable
fun getData(postViewModel: PostViewModel) {
    when (val result = postViewModel.response.value) {
        is ApiStates.Success -> {
            RecyclerView(posts = result.data)
        }
        is ApiStates.Failure -> {
            FailureSate(msg = result.msg.message.orEmpty())
        }
        ApiStates.Loading -> {
            LoadingState()
        }
        ApiStates.Empty -> {

        }
    }
}

@Composable
fun LoadingState() {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()
        .fillMaxHeight()) {
        val progressBar = createRef()
        CircularProgressIndicator(modifier = Modifier.constrainAs(progressBar) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

    }
}


@Composable
fun FailureSate(msg: String) {
    Card(modifier = Modifier.padding(8.dp), elevation = 2.dp, shape = RoundedCornerShape(10.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "emptyImage",
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
                    .align(Alignment.CenterVertically)
            )

            Text(text = msg)
        }
    }
}

@Composable
@Preview(name = "failure")
fun FailureStatePreview() {
    FailureSate(msg = "network failure")
}


@Composable
fun RecyclerView(posts: List<Post>) {
    LazyColumn {
        items(posts) { post ->
            EachRow(post = post)
        }
    }
}

@Composable
fun EachRow(post: Post) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(CornerSize(10.dp))
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "postImage",
                modifier = Modifier
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
                    .padding(4.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(text = post.body, modifier = Modifier.fillMaxWidth())
        }
    }
}