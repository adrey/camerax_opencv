package info.safronoff.camerax

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import info.safronoff.camerax.ui.camera.CameraFragment
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null
            && supportFragmentManager.findFragmentByTag(CameraFragment.TAG) == null
        ) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CameraFragment.newInstance(), CameraFragment.TAG)
                .commitNow()
        }
    }

    companion object {

        /** Use external media if it is available, our app's file directory otherwise */
        fun getOutputDirectory(context: Context): File {
            val appContext = context.applicationContext
            val mediaDir = context.externalMediaDirs.firstOrNull()?.let {
                File(it, appContext.resources.getString(R.string.app_name)).apply { mkdirs() }
            }
            return if (mediaDir != null && mediaDir.exists())
                mediaDir else appContext.filesDir
        }
    }
}
