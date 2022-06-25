package com.pravin.cryptocompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pravin.cryptocompose.data.remote.dto.TeamItem

@Composable
fun TeamListItem(
    teamMember: TeamItem,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = teamMember.name ?: "",
            style = MaterialTheme.typography.labelSmall,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = teamMember.position ?: "",
            style = MaterialTheme.typography.labelSmall,
            fontStyle = FontStyle.Italic,
            color = Color.Gray,
            textAlign = TextAlign.End
        )

    }

    Spacer(modifier = Modifier.height(5.dp))

}