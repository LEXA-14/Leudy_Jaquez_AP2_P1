package com.example.leudy_jaquez_ap2_p1.data.x.local.repository

import com.example.leudy_jaquez_ap2_p1.data.x.local.borrameDao
import com.example.leudy_jaquez_ap2_p1.domain.borrame.model.borrame
import com.example.leudy_jaquez_ap2_p1.domain.borrame.repository.borrameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class borrameRepositoryImpl @Inject constructor(
    private val localDataSource: borrameDao
) : borrameRepository{
    override fun observeAll(): Flow<List<borrame>> {
        TODO("Not yet implemented")
    }

    override suspend fun getBorrame(id: Int): borrame? {
        TODO("Not yet implemented")
    }

    override suspend fun upsert(borrame: borrame): Int {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun exists(id: Int): Boolean {
        TODO("Not yet implemented")
    }


}