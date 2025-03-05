package com.baseflow.permissionhandler;

import android.content.Context;

import androidx.annotation.NonNull;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class MethodCallHandlerImpl implements MethodChannel.MethodCallHandler {
    private final Context context;
    
    MethodCallHandlerImpl(Context context) {
        this.context = context;
    }
    
    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        // Implementation can be added as needed
        result.notImplemented();
    }
}