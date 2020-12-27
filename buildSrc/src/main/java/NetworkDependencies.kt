object NetworkDependencies {
    const val BASE_URL = "\"https://lookup.binlist.net/\""
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val mockWebserver = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"
}