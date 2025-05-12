package com.example.wilowachnapp.presentation.screens



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share

import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
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
fun SharedJournalPage (navController: NavController) {
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
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }
                Text(
                    text = "Wilowachn",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
            }


            Text(
                text = "Shared With Me",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))



            SharedItem(title = "Daily Thoughts", date = "April 22, 2024", description = "Had an amazing weekend....")
            SharedItem(title = "Travel Journal", date = "April 20, 2024", description = "This morning I spent some time thinking....")
            SharedItem(title = "Research Idea", date = "April 19, 2024", description = "Thoughts on the novel I’ve been reading....")
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
fun SharedItem(title: String, date: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .shadow(4.dp, shape = RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.LightGray)
    )
    {


        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = date,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Navigate",
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}