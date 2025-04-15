package lang;

import java.util.HashMap;
import java.util.Map;

public class Env {
    private final Map<String, Object> vars;

    public Env() {
        vars = new HashMap<>();
    }

    public Env(Map<String, Object> vars) {
        this.vars = new HashMap<>(vars);
    }

    public void set(String key, Object value) {
        vars.put(key, value);
    }

    public Object get(String key) {
        return vars.get(key);
    }

    public Env copy() {
        return new Env(vars);
    }
}
