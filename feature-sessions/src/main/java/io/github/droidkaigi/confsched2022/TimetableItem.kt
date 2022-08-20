package io.github.droidkaigi.confsched2022

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.github.droidkaigi.confsched2022.model.TimetableItem

@Composable
fun TimetableItem(
    timetableItem: TimetableItem,
    isFavorited: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .background(if (isFavorited) Color.Cyan else Color.Gray)
            .padding(4.dp)
    ) {
        Text(timetableItem.title.currentLangTitle)
        if (timetableItem is TimetableItem.Session) {
            Text(timetableItem.speakers.joinToString { it.name })
        }
        Text(timetableItem.startsTimeString)
    }
}