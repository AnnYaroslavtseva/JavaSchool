package com.company;



public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws ClassNotFoundException {
        Class<?> с = findLoadedClass(pluginName);
        if (c == null){
            try{
                if (parent != null){
                    c = parent.loadClass(name, false);
                } else
                {c = findBootstrapClassOrNull(name);}
            } catch (ClassNotFoundException ignore){
                if(c == null) c = findClass(name);

            }
        }
        return c;
    }

}


