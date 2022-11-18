package andres.rangel.notesapp.feature_note.presentation.notes

import andres.rangel.notesapp.feature_note.domain.model.Note
import andres.rangel.notesapp.feature_note.domain.util.NoteOrder
import andres.rangel.notesapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)