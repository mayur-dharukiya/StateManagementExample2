package com.example.statemanagementexample2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.tooling.preview.Preview
import com.example.statemanagementexample2.ui.theme.StateManagementExample2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateManagementExample2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                           RememberState()
                }
            }
        }
    }
}
@Composable
fun RememberState()
{
   // var clickCount:Int=0
    var clickCount by rememberSaveable {mutableStateOf(0) }
    var context= LocalContext.current

    Column{

        Button(onClick={

            //clickCount=clickCount+1
            clickCount++
        })
        {

            Text(text=""+clickCount+"Times clicked")
        }

        Button(onClick={

            context.startActivity(Intent(context,Details::class.java))

        })
        {

            Text(text="Go to Next Screen")
        }

    }
}



