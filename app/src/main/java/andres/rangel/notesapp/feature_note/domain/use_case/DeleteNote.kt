package andres.rangel.notesapp.feature_note.domain.use_case

import andres.rangel.notesapp.feature_note.domain.model.Note
import andres.rangel.notesapp.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}