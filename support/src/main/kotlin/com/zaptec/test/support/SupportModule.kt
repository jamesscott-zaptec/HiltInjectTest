package com.zaptec.test.support

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class SupportModule {

    @Binds
    abstract fun provideMyInterface(
//        mClass: MyClassFlavourless
        mClass: MyClass
    ): MyInterface
}