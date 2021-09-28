package com.example.jetpackcompose.presentation.ui.launches.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.data.dto.Launch

@Composable
fun LaunchView(
    launch: Launch,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            LaunchBadge(url = launch.links.patch.small, contentDescription = "launch badge")

        }

        Column {
            Text(
                text = "${launch.name}.",
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Launch date: ${launch.date_local}",
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body2
            )

            Row {
                Text(
                    text = "Mission Success: ",
                    style = MaterialTheme.typography.body2
                )

                if (launch.success) {
                    Icon(Icons.Filled.Done, "launch success", tint = Color.Green)
                } else {
                    Icon(Icons.Filled.Close, "launch fail", tint = Color.Red)
                }
            }

        }


    }
}

