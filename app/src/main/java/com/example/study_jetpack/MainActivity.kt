package com.example.study_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.example.study_jetpack.data.MessageCard

class MainActivity : ComponentActivity() {
    private val messages:Array<MessageCard> = arrayOf(
        MessageCard("dark lark", "深い暗闇に飲まれそうな虹", R.drawable.dsc_3315, "dsc_3315"),
        MessageCard("wide sun set", "夕暮れの広大な美しい眺望", R.drawable.dsc_3267, "dsc_3267"),
        MessageCard("sun set behind mountain", "夕暮れに覆われた山の影", R.drawable.dsc_3325, "dsc_3325"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageList(messages)
        }
    }
}

@Composable
fun MessageList(messages: Array<MessageCard> = arrayOf()) {
    Column {
        for (m in messages) {
            MessageColumn(m)
        }
    }
}

@Composable
fun MessageColumn(message: MessageCard) {
    Column(
        modifier = Modifier.padding(top=2.5.dp, bottom=2.5.dp)
    ) {
        Row (verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(message.img),
                contentDescription = message.imgDescribe,
                modifier = Modifier.size(200.dp).padding(start=3.0.dp, end=3.0.dp),
                contentScale = ContentScale.Crop,
            )
            Column (modifier = Modifier.padding(start=3.0.dp, end=3.0.dp)) {
                Text(text = message.title)
                Text(text = message.body)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageListPreview() {
     val testMessages = arrayOf(
        MessageCard("テスト１", "テストテスト", R.drawable.ic_launcher_foreground, "テスト画像1"),
        MessageCard("テスト2", "テストテストてすとてすと", R.drawable.ic_launcher_foreground,"テスト画像2")
    )
    MessageList(testMessages)
}