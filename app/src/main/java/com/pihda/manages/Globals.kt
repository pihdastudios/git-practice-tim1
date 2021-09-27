package com.pihda.manages

import android.app.Application

class Globals : Application() {
    companion object {
        var restAddress = "localhost:8080"
    }
}