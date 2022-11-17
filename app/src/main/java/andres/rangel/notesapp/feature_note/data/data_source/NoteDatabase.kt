package andres.rangel.notesapp.feature_note.data.data_source

import andres.rangel.notesapp.feature_note.domain.model.Note
import androidx.room.Database

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase {
    abstract val noteDao: NoteDao
}