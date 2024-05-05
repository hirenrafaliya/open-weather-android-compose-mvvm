package com.application.search.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.application.base.common.SpacerMax
import com.application.base.common.SpacerXS
import com.application.base.theme.MyColor
import com.application.base.theme.MyShape
import com.application.base.theme.MyTypography
import com.application.base.theme.Paddings
import com.application.domain.model.Location
import com.application.home.R


@Composable
fun SearchResultView(results: List<Location>, onPin: (Location) -> Unit) {
    LazyColumn {
        items(results, key = { it.id }) {
            SearchResultItem(it, onClick = {onPin(it)})
        }
    }
}

@Composable
fun SearchResultItem(result: Location, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
            .background(MyColor.bgTertiaryMuted, MyShape.round)
            .border(0.85.dp, MyColor.bgPrimary.copy(0.10f), MyShape.round)
            .clip(MyShape.round)
            .clickable { onClick() }
            .padding(horizontal = Paddings.xSmall, vertical = Paddings.xxSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier,
            text = "${result.name}, ${result.country}, ${result.region}",
            style = MyTypography.SB14,
            color = MyColor.bgPrimary
        )
        SpacerXS()
        SpacerMax()
        Icon(
            modifier = Modifier.size(24.dp),
            tint = MyColor.bgPrimary,
            painter = painterResource(id = R.drawable.ic_pin),
            contentDescription = ""
        )
    }
}