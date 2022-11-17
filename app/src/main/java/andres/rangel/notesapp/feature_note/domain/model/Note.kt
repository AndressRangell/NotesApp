package andres.rangel.notesapp.feature_note.domain.model

import andres.rangel.notesapp.ui.theme.BabyBlue
import andres.rangel.notesapp.ui.theme.LightGreen
import andres.rangel.notesapp.ui.theme.RedOrange
import andres.rangel.notesapp.ui.theme.RedPink
import andres.rangel.notesapp.ui.theme.Violet
import androidx.room.PrimaryKey

data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(
            RedOrange,
            LightGreen,
            Violet,
            BabyBlue,
            RedPink
        )
    }
}
