package andres.rangel.notesapp.di

import andres.rangel.notesapp.feature_note.data.data_source.NoteDatabase
import andres.rangel.notesapp.feature_note.data.repository.NoteRepositoryImpl
import andres.rangel.notesapp.feature_note.domain.repository.NoteRepository
import andres.rangel.notesapp.feature_note.domain.use_case.AddNote
import andres.rangel.notesapp.feature_note.domain.use_case.DeleteNote
import andres.rangel.notesapp.feature_note.domain.use_case.GetNotes
import andres.rangel.notesapp.feature_note.domain.use_case.NoteUseCases
import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(noteDatabase.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }

}