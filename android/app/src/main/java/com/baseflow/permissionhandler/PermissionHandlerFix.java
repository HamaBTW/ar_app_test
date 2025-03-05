package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public class PermissionHandlerFix implements FlutterPlugin, ActivityAware {
    private MethodChannel channel;
    private Activity activity;
    private Context context;
    private PermissionManager permissionManager;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        setupChannel(binding.getBinaryMessenger(), binding.getApplicationContext());
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        teardownChannel();
    }

    @Override
    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {
        activity = binding.getActivity();
        permissionManager = new PermissionManager(activity);
        registerListeners(binding);
    }

    @Override
    public void onDetachedFromActivityForConfigChanges() {
        activity = null;
    }

    @Override
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {
        activity = binding.getActivity();
        registerListeners(binding);
    }

    @Override
    public void onDetachedFromActivity() {
        activity = null;
    }

    private void setupChannel(BinaryMessenger messenger, Context context) {
        this.context = context;
        channel = new MethodChannel(messenger, "flutter.baseflow.com/permissions/methods");
        final MethodCallHandlerImpl handler = new MethodCallHandlerImpl(context);
        channel.setMethodCallHandler(handler);
    }

    private void registerListeners(ActivityPluginBinding binding) {
        // Add activity result listeners if needed
    }

    private void teardownChannel() {
        channel.setMethodCallHandler(null);
        channel = null;
    }
}