package k.arez.niki.fbla;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

public class ApplicationExtension extends Application {

    private Map<String, Object> vars = new HashMap<>();

    public Object getGlobalVariable(String varName) {
        return vars.get(varName);
    }

    public void setGlobalVariable(String varName, Object var) {
        vars.put(varName, var);
    }
}
