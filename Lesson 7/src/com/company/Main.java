package com.company;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        String pathToPlugins = "C:/Users/Daria/Desktop/JavaSchoolRND/src/PluginsForLesson7";

        PluginManager pm = new PluginManager(pathToPlugins);
        ArrayList<Plugin> plugins = pm.getPlugins();
        plugins.forEach(Plugin::doUsefull);
    }
}
