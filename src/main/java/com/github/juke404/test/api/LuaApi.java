package com.github.juke404.test.api;

import com.github.juke404.test.api.library.LuaLibrary;
import org.luaj.vm2.Globals;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * @author Jake
 * @since 03/03/2022
 **/

public final class LuaApi {
    private static Globals globals;

    public static void init(LuaLibrary... libraries) {
        globals = JsePlatform.standardGlobals();

        for (LuaLibrary library : libraries) {
            globals.load(library);
        }
    }

    public static Globals getGlobals() {
        return globals;
    }
}
