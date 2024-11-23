package com.example.coop_2

import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil3.compose.AsyncImage
import com.example.coop_2.ui.theme.Coop2Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Coop2Theme {
                val result = remember {
                    mutableStateOf<Uri?>(null)
                }


                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.GetMultipleContents(),
                    onResult = {
                        result.value = it[0]
                    }
                )

                Column {
                    AsyncImage(
                        modifier = Modifier.size(100.dp),
                        model = result.value,
                        contentDescription = "image"
                    )

                    Button(
                        onClick = {
                            launcher.launch("image/*")
                        }
                    ) {
                        Text("Click")
                    }
                }

            }
        }
        }
    }



