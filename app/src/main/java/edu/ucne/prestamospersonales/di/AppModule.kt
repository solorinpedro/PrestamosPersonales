package edu.ucne.prestamospersonales.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.prestamospersonales.data.OcupacionDao
import edu.ucne.prestamospersonales.data.PrestamosDb
import edu.ucne.prestamospersonales.data.repository.Ocupacionrepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun ProvideTicketDb(@ApplicationContext context: Context): PrestamosDb {
        val DATABASE_NAME = "PrestamoDb"
        return Room.databaseBuilder(
            context,
            PrestamosDb::class.java,
            DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    }
    @Provides
    fun ProvidePrestamoDAO(prestamosDb: PrestamosDb): OcupacionDao {
        return prestamosDb.OcupacionDao
    }

    @Provides
    fun ProvidePrestamoRepository(prestamosDao: OcupacionDao): Ocupacionrepository {
        return Ocupacionrepository(prestamosDao)
    }
}