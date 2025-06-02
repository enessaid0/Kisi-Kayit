package com.enessaidokur.odevkiileruygulamas.di

import com.enessaidokur.odevkiileruygulamas.data.datasource.GorevlerDataSource
import com.enessaidokur.odevkiileruygulamas.data.repository.GorevlerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideGorevlerDataSource() : GorevlerDataSource{
        return GorevlerDataSource()
    }
    @Provides
    @Singleton
    fun provideGorevlerRepository(gds:GorevlerDataSource) : GorevlerRepository{
        return GorevlerRepository(gds)

}}