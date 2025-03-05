package com.example.ar_app

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import com.baseflow.permissionhandler.CustomPermissionPlugin

class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        
        // Register our custom plugin
        flutterEngine.plugins.add(CustomPermissionPlugin())
    }
}