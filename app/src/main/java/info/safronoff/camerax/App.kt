package info.safronoff.camerax

import android.app.Application
import info.safronoff.camerax.di.cameraModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.opencv.android.OpenCVLoader
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.d("Opencv loaded: ${OpenCVLoader.initDebug()}")
        startKoin {
            androidContext(this@App)
            modules(listOf(cameraModule))
        }
    }
}