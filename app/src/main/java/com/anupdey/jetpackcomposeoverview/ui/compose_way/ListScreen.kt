package com.anupdey.jetpackcomposeoverview.ui.compose_way

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anupdey.jetpackcomposeoverview.ui.common.MainViewModel
import com.anupdey.jetpackcomposeoverview.ui.compose_way.widgets.ToolbarWidget

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen() {

    val viewModel: MainViewModel = viewModel()
    val listState by viewModel.repoListState

    Scaffold(
        topBar = {
            ToolbarWidget(true)
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(listState.count()) {
                    val model = listState[it]
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .padding(top = 10.dp),
                        shape = RoundedCornerShape(5.dp),

                    ) {
                        Text(text = model.fullName ?: "")
                    }
                }
            }
        }
    )
}