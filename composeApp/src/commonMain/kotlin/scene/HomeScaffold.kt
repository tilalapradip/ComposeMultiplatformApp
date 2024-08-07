package org.pradip.cmp.scene

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.pradip.cmp.ui_components.MobileRow
import org.pradip.cmp.viewmodel.MobileDataState
import org.pradip.cmp.viewmodel.MobileListViewModel

@Composable
fun HomeScaffold(
    modifier: Modifier = Modifier,
    viewModel: MobileListViewModel = viewModel { MobileListViewModel() },
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = {
                    Text(text = "CMP Product List", color = Color.White)
                })
        })
    { contentPadding ->
        MobileListView(modifier = Modifier.padding(contentPadding), viewModel)
    }
}

@Composable
fun MobileListView(modifier: Modifier, viewModel: MobileListViewModel) {
    LaunchedEffect("FETCH DATA") {
        viewModel.getMobilesFake()
    }

    val listItemState = viewModel.mobileDataState.collectAsState()
    val listItems = listItemState.value

    when (listItems) {
        MobileDataState.Initial -> {
            Column(modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text("Initial", fontSize = 18.sp)
            }
        }

        MobileDataState.Loading -> {
            Column(modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text("Loading...", fontSize = 18.sp)
            }
        }

        is MobileDataState.Success -> {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
            ) {
                items(listItems.data) { mobileDetail ->
                    MobileRow(mobileItem = mobileDetail)
                }
            }
        }

        is MobileDataState.Failure -> {
            FailureView(modifier, viewModel)
        }
    }
}

@Composable
fun FailureView(modifier: Modifier = Modifier, viewModel: MobileListViewModel) {
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Failure", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.getMobilesFake()
        },
            content = {
                Text("Retry", fontSize = 18.sp)
            })
    }
}
