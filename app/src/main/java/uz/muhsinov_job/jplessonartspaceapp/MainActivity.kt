package uz.muhsinov_job.jplessonartspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.muhsinov_job.jplessonartspaceapp.ui.theme.JPlessonArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JPlessonArtSpaceAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ArtSpaceApp()

                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var position by remember { mutableIntStateOf(1) }
    val imageResource = when(position){
        1 -> R.drawable.img1
        2 -> R.drawable.img2
        3 -> R.drawable.img3
        4 -> R.drawable.img4
        else -> {R.drawable.img5}
    }
    val descriptionResource = when(position) {
        1 -> R.string.description1
        2 -> R.string.description2
        3 -> R.string.description3
        4 -> R.string.description4
        else -> {
            R.string.description5
        }
    }
    val descriptionLocation = when(position){
        1 -> R.string.location1
        2 -> R.string.location2
        3 -> R.string.location3
        4 -> R.string.location4
        else -> {
            R.string.location5
        }
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 100.dp)
    ) {

        ImageHolder(
            image = imageResource,
            modifier = modifier.align(Alignment.TopCenter)
        )
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {


            Column(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
                    .padding(horizontal = 40.dp)
                    .background(
                        colorResource(R.color.my_color)
                    )
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = stringResource(descriptionResource),
                        fontSize = 20.sp,

                        )
                    Text(text = stringResource(descriptionLocation), fontWeight = FontWeight.Bold)
                }

            }
            Row(
                modifier = Modifier

                    .padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        if (position!=1){
                            position--
                        }else{
                            position=5
                        }
                    },
                    modifier = Modifier.weight(1f),
                ) {
                    Text(stringResource(R.string.previous))
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = {
                        if (position!=5){
                            position++
                        }else{
                            position=1
                        }
                    },
                    modifier = Modifier.weight(1f),
                ) {
                    Text(stringResource(R.string.next))
                }
            }
        }

    }
}

@Composable
fun ImageHolder(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(400.dp)

    )

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JPlessonArtSpaceAppTheme {
        ArtSpaceApp()
    }
}