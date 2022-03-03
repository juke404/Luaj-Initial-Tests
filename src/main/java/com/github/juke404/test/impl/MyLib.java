package com.github.juke404.test.impl;

import com.github.juke404.test.api.function.LuaFunction;
import com.github.juke404.test.api.library.LuaLibrary;
import org.luaj.vm2.LuaValue;

/**
 * @author Jake
 * @since 02/03/2022
 **/

public final class MyLib extends LuaLibrary {
    public MyLib() {
        super("mylib", new LuaFunction[]{
                // We want to add our functions here
                new LuaFunction(
                        "customFunc",
                        new Class[]{String.class},
                        params -> {
                            System.out.println("Printed by java! " + params[0]);
                            return LuaValue.valueOf("Retured Value");
                        }
                )
        });
    }
}
