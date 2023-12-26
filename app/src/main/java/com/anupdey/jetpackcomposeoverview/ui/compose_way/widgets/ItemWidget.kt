package com.anupdey.jetpackcomposeoverview.ui.compose_way.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.anupdey.jetpackcomposeoverview.R
import com.anupdey.jetpackcomposeoverview.data.model.RepoInfo
import com.anupdey.jetpackcomposeoverview.ui.theme.LightGray

@Preview(showBackground = true)
@Composable
fun ItemWidgetPreview() {
    //val model = RepoInfo(name = "Test", )
    //ItemWidget(RepoInfo())
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemWidget(model: RepoInfo, clickListener: () -> Unit) {
    Box(
        modifier = Modifier.padding(
            start = 10.dp,
            end = 10.dp,
            top = 10.dp,
            bottom = 0.dp
        ),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightGray)
                .padding(10.dp),
            shape = RoundedCornerShape(5.dp),
            onClick = clickListener
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LightGray)
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = model.owner?.avatarUrl,
                        builder = {
                            placeholder(R.drawable.ic_github)
                            error(R.drawable.ic_github)
                        }), contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(10.dp))
                )

                Spacer(modifier = Modifier.width(10.dp))

                val style1 = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                )
                val style2 = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                )
                Column(modifier = Modifier.weight(1f)) {
                    ItemDataWidget(
                        icon = R.drawable.ic_source_repository,
                        text = model.name,
                        style1
                    )
                    ItemDataWidget(
                        icon = R.drawable.ic_github,
                        text = model.owner?.login,
                        style2
                    )
                    ItemDataWidget(
                        icon = R.drawable.ic_link_variant,
                        text = model.htmlUrl,
                        style2
                    )
                    ItemDataWidget(
                        icon = R.drawable.ic_star,
                        text = model.stargazersCount.toString(),
                        style2
                    )
                }

            }
        }
    }
}

@Composable
private fun ItemDataWidget(@DrawableRes icon: Int, text: String?, style: TextStyle) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(10.dp)
        )

        Spacer(modifier = Modifier.width(3.dp))

        Text(
            text = text ?: "",
            modifier = Modifier.fillMaxWidth(),
            style = style,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}