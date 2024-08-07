package org.pradip.cmp.ui_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.pradip.cmp.data.MobileItem

@Composable
fun MobileRow(modifier: Modifier = Modifier, mobileItem: MobileItem) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column(modifier = modifier.padding(10.dp)) {
            Text(text = mobileItem.id)
            Text(text = mobileItem.name)
        }
    }
}