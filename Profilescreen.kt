package com.example.myapplication.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class Profilescreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProfileScreen()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {

    var selectedRole by remember {
        mutableStateOf("Member")
    }

    var showSheet by remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState()

    val scope = rememberCoroutineScope()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.Center
    ) {

        OutlinedCard(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "User Profile",
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                Text(
                    text = "Selected Role: $selectedRole"
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Button(
                    onClick = {
                        showSheet = true
                    }
                ) {

                    Text("View Bio & Settings")
                }
            }
        }
    }


    if (showSheet) {

        ModalBottomSheet(

            sheetState = sheetState,

            onDismissRequest = {
                showSheet = false
            }
        ) {

            BioSettingsContent(

                currentRole = selectedRole,

                onSave = { role ->

                    selectedRole = role


                    scope.launch {

                        sheetState.hide()

                        showSheet = false
                    }
                }
            )
        }
    }
}
