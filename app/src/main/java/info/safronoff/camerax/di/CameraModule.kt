package info.safronoff.camerax.di

import info.safronoff.camerax.ui.camera.CameraViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cameraModule = module {

    viewModel { CameraViewModel() }
}