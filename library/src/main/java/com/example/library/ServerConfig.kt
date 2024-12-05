package com.example.library

import javax.inject.Inject

class ServerConfig @Inject constructor() {
    fun portNo() = BuildConfig.PORT_NO
}
