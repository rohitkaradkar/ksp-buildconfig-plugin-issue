package com.example.kspbuildconfigissue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kspbuildconfigissue.ui.theme.KSPBuildConfigIssueTheme
import com.example.library.ServerConfig
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.example.library.BuildConfig as LibBuildConfig

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var serverConfig: ServerConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KSPBuildConfigIssueTheme {
                Greeting("Welcome to ${BuildConfig.APP_NAME} at port ${serverConfig.portNo()}")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KSPBuildConfigIssueTheme {
        Greeting("App ${BuildConfig.APP_NAME} port ${LibBuildConfig.PORT_NO}")
    }
}
