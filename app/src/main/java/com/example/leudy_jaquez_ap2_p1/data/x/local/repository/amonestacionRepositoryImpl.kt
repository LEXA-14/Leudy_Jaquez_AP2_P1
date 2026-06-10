package com.example.leudy_jaquez_ap2_p1.data.x.local.repository

import com.example.leudy_jaquez_ap2_p1.data.x.local.amonestacionDao
import com.example.leudy_jaquez_ap2_p1.data.x.local.mappers.ToDomain
import com.example.leudy_jaquez_ap2_p1.data.x.local.mappers.ToEntity
import com.example.leudy_jaquez_ap2_p1.domain.borrame.model.amonestacion
import com.example.leudy_jaquez_ap2_p1.domain.borrame.repository.borrameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class amonestacionRepositoryImpl @Inject constructor(
    private val localDataSource: amonestacionDao
) : borrameRepository{
    override fun observeAll(): Flow<List<amonestacion>> {
      return localDataSource.observeAll().map { entities -> entities.map { it.ToDomain() } }
    }

    override suspend fun getBorrame(id: Int): amonestacion? {
        return localDataSource.getById(id)?.ToDomain()
    }

    override suspend fun upsert(amonestacion: amonestacion): Int {
        localDataSource.upsert(amonestacion.ToEntity())
        return amonestacion.amonestacionId
    }

    override suspend fun delete(id: Int) {
        return localDataSource.deleteById(id)
    }

    override suspend fun exists(id: Int): Boolean {
        TODO("Not yet implemented")
    }


}