package com.github.juke404.test.impl;

import com.github.juke404.test.api.LuaApi;
import com.github.juke404.test.api.script.LuaScript;

/**
 * @author Jake
 * @since 03/03/2022
 **/

public class Main {
    public static void main(String[] args) {
        LuaApi.init(new MyLib());

        LuaScript script = new LuaScript("/scripts/test.lua");

        script.init();
    }
}
