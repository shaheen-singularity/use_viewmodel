package com.example.use_viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.use_viewmodel.MainActivity.Companion.database
import com.example.use_viewmodel.ui.theme.Use_viewmodelTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var database: AppDatabase
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            database = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "my_database"
            ).build()

        Use_viewmodelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    LandingScreen()
                }

            }
        }
    }
}
@Composable
fun LandingScreen(homeScreenViewModel: HomeScreenViewModel = viewModel()){
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(20.dp))
            SimpleImageComponent()
            Spacer(modifier = Modifier.size(20.dp))
            TextComponents(textValue = "Hi There... \uD83D\uDE0A", fontSize = 32.sp)
            Spacer(modifier = Modifier.size(20.dp))
            TextFieldComponent(onTextChange = {
                homeScreenViewModel.onEvent(
                    HomeScreenUiEvents.NameTextField(it)
                )
            })
            Spacer(modifier = Modifier.size(20.dp))
            ElevatedButton(onClick = {
                println("Clicked")
                GlobalScope.launch {
                    database.homeDao().insertName(HomeScreenDataClass(name = "AisJac"))
                }

            }) {
                Text(text = "Submit")
            }

            TextComponents(textValue = homeScreenViewModel.uiState.value.name, fontSize = 24.sp)


        }

    }
}