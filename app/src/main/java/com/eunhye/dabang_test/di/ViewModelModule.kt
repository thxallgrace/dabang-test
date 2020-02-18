package com.eunhye.dabang_test.di

import com.eunhye.dabang_test.viewmodel.RoomListViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val viewModelModule = applicationContext {
    viewModel { RoomListViewModel() }
}