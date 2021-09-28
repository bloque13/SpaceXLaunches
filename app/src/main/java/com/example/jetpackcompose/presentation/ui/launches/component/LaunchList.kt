package com.example.jetpackcompose.presentation.ui.launches.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.common.Constants
import com.example.jetpackcompose.common.Constants.PAGINATION_PAGE_SIZE
import com.example.jetpackcompose.data.dto.Launch
import com.example.jetpackcompose.presentation.ui.launches.component.LaunchView
import com.example.jetpackcompose.presentation.ui.launches.component.LoadingListAnimation

@Composable
fun LaunchList(
    loading: Boolean,
    launches: List<Launch>,
    page: Int,
    onTriggerNextPage: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.surface)
    ) {
        if (loading && launches.isEmpty()) {
            LoadingListAnimation(imageHeight = Constants.IMAGE_HEIGHT.dp,)
        } else if (launches.isEmpty()) {
            // There's nothing here
        } else {
            LazyColumn {
                itemsIndexed(
                    items = launches
                ) { index, item ->
                    if ((index + 1) >= (page * PAGINATION_PAGE_SIZE) && !loading) {
                        onTriggerNextPage()
                    }
                    LaunchView(
                        launch = item,
                    )
                }
            }
        }
    }
}