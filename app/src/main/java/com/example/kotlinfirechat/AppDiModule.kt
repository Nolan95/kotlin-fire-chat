package com.example.kotlinfirechat

import com.example.datalayer.dataModule
import com.example.domain.domainModule
import com.example.presentation.presentationModule
import com.example.remote.remoteModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

/**
 * Created by Sadate Tchamouza on 3/23/20.
 */

@FlowPreview
@ExperimentalCoroutinesApi
val appDiModule = presentationModule + dataModule + remoteModule + domainModule