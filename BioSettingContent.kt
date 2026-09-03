package com.example.myapplication.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BioSettingsContent(
    currentRole: String,
    onSave: (String) -> Unit
) {

    var selectedRole by remember {
        mutableStateOf(currentRole)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {

        Text(
            text = "Bio & Settings",
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Select User Role")

        Spacer(modifier = Modifier.height(10.dp))
        
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedRole == "Admin",
                onClick = {
                    selectedRole = "Admin"
                }
            )

            Text("Admin")
        }

        
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedRole == "Member",
                onClick = {
                    selectedRole = "Member"
                }
            )

            Text("Member")
        }

        
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedRole == "Guest",
                onClick = {
                    selectedRole = "Guest"
                }
            )

            Text("Guest")
        }

        Spacer(modifier = Modifier.height(15.dp))

        when (selectedRole) {

            "Admin" -> {
                Text("Admin can manage users and settings.")
            }

            "Member" -> {
                Text("Member can view and edit profile.")
            }

            "Guest" -> {
                Text("Guest has limited access.")
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onSave(selectedRole)
            }
        ) {
            Text("Save & Close")
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}
