package com.github.juke404.test.api.script;

import com.github.juke404.test.api.event.EnumLuaEvent;
import org.luaj.vm2.LuaValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import static com.github.juke404.test.api.LuaApi.getGlobals;

/**
 * @author Jake
 * @since 03/03/2022
 **/

public class LuaScript {
    protected String path;
    protected boolean init;
    protected final String script;

    public LuaScript(String path) {
        this.path = path;
        this.init = false;

        this.script = new BufferedReader(
                new InputStreamReader(LuaScript.class.getResourceAsStream(path), StandardCharsets.UTF_8))
                .lines().collect(Collectors.joining("\n"));
    }

    public void init() {
        run(EnumLuaEvent.ScriptInit);
    }

    public void run(EnumLuaEvent event) {
        if (event == EnumLuaEvent.ScriptInit) {
            if (init) throw new RuntimeException("Script already initialised!");

            getGlobals().load(script).call();
            init = true;
            return;
        }

        LuaValue func = null;

        switch (event) {
            case TestEvent:
                func = getGlobals().get("TestEvent");
                break;
        }

        if (func != null && func != LuaValue.NIL) func.call();
    }

    public boolean isInitialised() {
        return init;
    }

    public String getScript() {
        return script;
    }
}
