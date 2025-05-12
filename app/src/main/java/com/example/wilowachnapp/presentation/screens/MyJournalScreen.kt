package com.example.wilowachnapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Myjournals(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF6F6))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                IconButton(onClick = { navController.navigate("welcome") }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }
                Text(
                    text = "Wilowachn",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
            }


            Button(
                onClick = { navController.navigate("editor") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0000FF))
            ) {
                Text(text = "+   New Journal", color = Color.White)
            }
            Text(
                text = "My Journals",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))



            JournalItem(title = "Weekend Trip", date = "April 22, 2024", description = "Had an amazing weekend....")
            JournalItem(title = "Morning Reflection", date = "April 20, 2024", description = "This morning I spent some time thinking....")
            JournalItem(title = "Book Notes", date = "April 19, 2024", description = "Thoughts on the novel I’ve been reading....")
        }

        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            containerColor = Color(0xE0E7E1E1)
        ) {
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("welcome") },
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.Black) }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("editor") },
                icon = { Icon(Icons.Filled.Edit, contentDescription = "Edit", tint = Color.Black) }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("myjournals") },
                icon = { Icon(Icons.Filled.DateRange, contentDescription = "Table", tint = Color.Black) }
            )
            NavigationBarItem(
                selected = false,
                onClick = {navController.navigate("Sharing") },
                icon = { Icon(Icons.Filled.Share, contentDescription = "Share", tint = Color.Black) }
            )
        }
    }
}

@Composable
fun JournalItem(title: String, date: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .shadow(4.dp, shape = RoundedCornerShape(8.dp)), // Use shadow instead of elevation
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = date, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = description, fontSize = 14.sp, color = Color.Black) // Add description
            Spacer(modifier = Modifier.height(8.dp))
            // Optionally, add an edit icon or button here
            Text(
                text = "✎", // Placeholder for edit icon
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}
