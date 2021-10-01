package com.pihda.manages

import android.app.Application

class Globals : Application() {
    companion object {
        var restAddress = "http://localhost:8080"
    }
}