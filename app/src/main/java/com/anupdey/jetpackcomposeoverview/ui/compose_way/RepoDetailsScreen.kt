package com.anupdey.jetpackcomposeoverview.ui.compose_way

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.anupdey.jetpackcomposeoverview.R
import com.anupdey.jetpackcomposeoverview.data.model.RepoInfo
import com.anupdey.jetpackcomposeoverview.ui.compose_way.widgets.ToolbarWidget

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RepoDetailsScreen(
    navController: NavHostController, model: RepoInfo?
) {
    model ?: return

    Scaffold(
        topBar = {
            ToolbarWidget(showBackBtn = true, onNavClicked = {
                navController.popBackStack()
            })
        },
        content = { padding ->
            Column(
                modifier = Modifier.padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = model.owner?.avatarUrl,
                        builder = {
                            placeholder(R.drawable.ic_github)
                            error(R.drawable.ic_github)
                        }), contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(10.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = model.name ?: "",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = model.htmlUrl ?: "",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

            }
        }
    )

}