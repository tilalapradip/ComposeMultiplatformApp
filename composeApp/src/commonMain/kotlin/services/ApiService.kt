package org.pradip.cmp.services

import org.pradip.cmp.data.MobileItem

internal interface ApiService {

    suspend fun getMobiles(): List<MobileItem>

    suspend fun getMobilesFake(): List<MobileItem>

    companion object {
        fun create(): ApiService {
            return ApiServiceImpl()
        }
    }
}