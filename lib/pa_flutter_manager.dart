import 'dart:async';

import 'package:flutter/services.dart';
import 'package:paflutterplugin/channel_name.dart';

typedef Future<dynamic> MethodHandler(MethodCall call);

class PaflutterManager {
  static PaflutterManager instance = new PaflutterManager._internal();
  MethodChannel _funcChannel;
  EventChannel _eventChannel;
  MethodHandler _handler;

  void setMethodCallHandler(MethodHandler hdler) {
    _handler = hdler;
    _funcChannel.setMethodCallHandler(_handler);
  }

  static MethodChannel getMethodChannel(){
    return instance._funcChannel;
  }

  static EventChannel getEventChannel(){
    return instance._eventChannel;
  }

  PaflutterManager._internal() {
    _funcChannel = new MethodChannel(ChannelName.MethodName);
    _eventChannel = new EventChannel(ChannelName.EvenName);
    _funcChannel.setMethodCallHandler(_handle);
  }

  /// dart 调用android & ios时的方式
  Future<String> get platformVersion async {
    final String version =
        await getMethodChannel().invokeMethod(ChannelName.getPlatformVersion);
    return version;
  }

  /// android & ios  调用dart时方法调用在这里添加代码。
  MethodHandler _handle = (MethodCall call) {
    String method = call.method;
    switch (method) {
    }
    return null;
  };
}
