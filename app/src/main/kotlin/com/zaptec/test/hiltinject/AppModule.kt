package com.zaptec.test.hiltinject

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideTestString(): String {
        return "Hello, Hilt!"
    }
}