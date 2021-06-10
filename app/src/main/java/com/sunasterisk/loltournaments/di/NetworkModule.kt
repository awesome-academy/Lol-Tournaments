package com.sunasterisk.loltournaments.di

import com.sunasterisk.loltournaments.data.source.remote.API_KEY
import com.sunasterisk.loltournaments.data.source.remote.ApiService
import com.sunasterisk.loltournaments.data.source.remote.BASE_URL
import com.sunasterisk.loltournaments.data.source.remote.TOKEN
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { initHttpClient() }
    single { initRetrofit(get()) }
    single { createApiService(get()) }
}

fun initHttpClient(): OkHttpClient {
    val interceptor = Interceptor { chain ->
        val original = chain.request()
        val request = original.newBuilder().url(
            original.url.newBuilder()
                .addQueryParameter(
                    TOKEN,
                    API_KEY
                )
                .build()
        ).build()
        chain.proceed(request)
    }
    return OkHttpClient.Builder().addInterceptor(interceptor).build()
}

fun initRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()

fun createApiService(retrofit: Retrofit): ApiService? = retrofit.create(ApiService::class.java)
