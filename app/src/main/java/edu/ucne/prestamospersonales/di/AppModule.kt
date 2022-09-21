package edu.ucne.prestamospersonales.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.prestamospersonales.data.OcupacionDao
import edu.ucne.prestamospersonales.data.PersonasDao
import edu.ucne.prestamospersonales.data.PrestamoDao
import edu.ucne.prestamospersonales.data.PrestamosDb
import edu.ucne.prestamospersonales.data.repository.Ocupacionrepository
import edu.ucne.prestamospersonales.data.repository.Personarepository
import edu.ucne.prestamospersonales.data.repository.Prestamorepository
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

    @Provides
    fun ProvidesPrestamosDAO(prestamosDb: PrestamosDb):PersonasDao{
        return prestamosDb.PersonasDao
    }
    @Provides
    fun ProvidesPrestamorePepository(prestamosDao: PersonasDao):Personarepository{
        return Personarepository(prestamosDao)
    }
    @Provides
    fun ProvidePrestamosDAO(prestamosDb: PrestamosDb):PrestamoDao{
        return  prestamosDb.PrestamoDao
    }
    @Provides
    fun ProvidesPrestamoreRepository(prestamosDao: PrestamoDao):Prestamorepository{
        return Prestamorepository(prestamosDao)
    }

}