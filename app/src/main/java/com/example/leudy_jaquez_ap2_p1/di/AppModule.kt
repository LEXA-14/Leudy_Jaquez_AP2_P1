package com.example.leudy_jaquez_ap2_p1.di

import android.content.Context
import androidx.room.Room
import com.example.leudy_jaquez_ap2_p1.data.x.local.CervezaDB
import com.example.leudy_jaquez_ap2_p1.data.x.local.amonestacionDao
import com.example.leudy_jaquez_ap2_p1.data.x.local.repository.borrameRepositoryImpl
import com.example.leudy_jaquez_ap2_p1.domain.borrame.repository.borrameRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideBorrameDatabase(
        @ApplicationContext context: Context
    ): CervezaDB {
        return Room.databaseBuilder(
            context,
            CervezaDB::class.java,
            "CervezaDB"
        ).fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provBorrameDao(database: CervezaDB): amonestacionDao {
        return database.borrameDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTaskRepository(
        impl: borrameRepositoryImpl
    ): borrameRepository
}
