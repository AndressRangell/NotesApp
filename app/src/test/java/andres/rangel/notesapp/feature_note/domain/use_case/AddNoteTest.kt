package andres.rangel.notesapp.feature_note.domain.use_case

import andres.rangel.notesapp.feature_note.data.repository.FakeNoteRepository
import andres.rangel.notesapp.feature_note.domain.model.InvalidNoteException
import andres.rangel.notesapp.feature_note.domain.model.Note
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AddNoteTest {

    private lateinit var fakeNoteRepository: FakeNoteRepository
    private lateinit var addNote: AddNote

    @Before
    fun setUp() {
        fakeNoteRepository = FakeNoteRepository()
        addNote = AddNote(fakeNoteRepository)
    }

    @Test
    fun `Add note successfully`() = runBlocking {
        val note = Note(title = "Título", content = "Contenido", 1, 1, 1)
        fakeNoteRepository.insertNote(note)
        assertEquals(fakeNoteRepository.getNoteById(1), note)
    }

    @Test
    fun `Add note with empty title error, return InvalidNoteException`() {
        val note = Note(title = "", content = "Contenido", 1, 1, 1)
        val exception = assertThrows(InvalidNoteException::class.java) {
            runBlocking {
                fakeNoteRepository.insertNote(note)
            }
        }
        assertEquals("The title of the note can't be empty", exception.message)
    }

    @Test
    fun `Add note with empty content error, return InvalidNoteException`() {
        val note = Note(title = "Título", content = "", 1, 1, 1)
        val exception = assertThrows(InvalidNoteException::class.java) {
            runBlocking {
                fakeNoteRepository.insertNote(note)
            }
        }
        assertEquals("The content of the note can't be empty", exception.message)
    }

}