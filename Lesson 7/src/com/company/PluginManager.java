package com.company;


import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class PluginManager {
    private ArrayList<String> pluginsPaths; //будем хранить списки путей к плагинам и сами плагины
    private ArrayList<Plugin> plugins;

    public ArrayList<Plugin> getPlugins() {
        return plugins;
    }

    public PluginManager(String pluginRootDirectory) {
        pluginsPaths = getJavaFilePaths(new File(pluginRootDirectory));
        plugins = new ArrayList<>();

        pluginsPaths.forEach(value -> plugins.add(load(value))); //для каждого значения из коллекции 
    }


    public Plugin load(String pluginFIlePath) {
        try {
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:/" + pluginFIlePath)});
            Class<?> clazz = urlClassLoader.loadClass(pluginFIlePath.substring(3, pluginFIlePath.length() - 5).replace("\\", "."));
            Object instance = clazz.newInstance();
            if (instance instanceof Plugin)
                return (Plugin) instance;
        }
        catch (Exception e) {
            System.out.println("Fail:" + e);
        }
        return null;
    }


    public static ArrayList<String> getJavaFilePaths(File root)
    {
        ArrayList<String> result = new ArrayList<>();
        for (File tmpFile : root.listFiles()) {
            if (tmpFile.isDirectory()) {
                result.addAll(getJavaFilePaths(tmpFile));
            }
            else {
                String path = tmpFile.getPath();
                if(path.endsWith(".java"))
                    result.add(path);
            }
        }
        return result;
    }

}