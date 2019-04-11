package mmflutter.mm.yqb.com.paflutterplugin;

import java.util.HashMap;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * PaflutterpluginPlugin
 */
public class PaflutterpluginPlugin implements MethodCallHandler {
    /**
     * Plugin registration.
     */
    private static PaflutterpluginPlugin instance = null;
    private MethodChannel mMethodChannel;
    private MethodCallHandler mCallHandler;

    public static PaflutterpluginPlugin getInstance() {
        if (instance == null) {
            synchronized (PaflutterpluginPlugin.class) {
                if (instance == null) {
                    instance = new PaflutterpluginPlugin();
                }
            }
        }
        return instance;
    }

    public static void registerWith(Registrar registrar) {
        PaflutterpluginPlugin plugin = PaflutterpluginPlugin.getInstance();
        final MethodChannel channel = new MethodChannel(registrar.messenger(), ChannelName.MethodName);
        channel.setMethodCallHandler(plugin);
        plugin.setMethodChannel(channel);
    }

    public MethodChannel getMethodChannel() {
        return mMethodChannel;
    }

    private void setMethodChannel(MethodChannel val) {
        mMethodChannel = val;
    }

    public void setMethodCallHandler(MethodCallHandler handler) {
        mCallHandler = handler;

    }

    @Override
    public void onMethodCall(MethodCall call, Result result) {
        if (mCallHandler != null) {
            mCallHandler.onMethodCall(call, result);
            return;
        }
        result.notImplemented();
    }
}
