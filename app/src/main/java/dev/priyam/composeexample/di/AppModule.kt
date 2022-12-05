package dev.priyam.composeexample.di

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.priyam.composeexample.service.PostApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun providesPostApiService(moshi: Moshi): PostApiService =
        Retrofit
            .Builder().run {
                baseUrl(PostApiService.BASE_URL)
                addConverterFactory(MoshiConverterFactory.create(moshi))
                build()
            }.create(PostApiService::class.java)
}