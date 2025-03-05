// Add this import
import com.baseflow.permissionhandler.CustomPermissionPlugin;

public class MainActivity extends FlutterActivity {
    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        
        // Register our custom plugin
        flutterEngine.getPlugins().add(new CustomPermissionPlugin());
    }
}