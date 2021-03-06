package com.hellobike.flutter.thrio.navigator

import android.content.Context
import io.flutter.embedding.engine.FlutterEngine

internal data class NavigatorFlutterEngine(private val context: Context, private val id: String) {

    var entryPoint: String = id
    var flutterEngine: FlutterEngine = FlutterEngine(context)
    var sendChannel: NavigatorSendChannel
    var receiveChannel: NavigatorReceiveChannel

    init {
        sendChannel = NavigatorSendChannel(flutterEngine.dartExecutor, id)
        receiveChannel = NavigatorReceiveChannel(id)
        sendChannel.setMethodCallHandler(receiveChannel)
    }

}