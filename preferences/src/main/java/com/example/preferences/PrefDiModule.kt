package com.example.preferences

import org.koin.dsl.module

/**
 * Created by Sadate Tchamouza on 8/15/20.
 */

val prefDiModule = module {
    factory<SessionModel> { SessionModelImpl }
}