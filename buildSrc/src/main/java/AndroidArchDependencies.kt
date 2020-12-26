object AndroidArchDependencies {
    const val navFragKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navDynamicFeatures = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"

    const val room = "androidx.room:room-ktx:${Versions.room}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val work = "androidx.work:work-runtime-ktx:${Versions.work}"

    const val dagger =  "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}