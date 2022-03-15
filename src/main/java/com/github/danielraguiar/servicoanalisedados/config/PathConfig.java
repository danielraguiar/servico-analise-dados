package com.github.danielraguiar.servicoanalisedados.config;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathConfig {

    public static final Path PATH_DATA = Paths.get(
            System.getProperty("user.home")
                    + File.separator
                    + "data"
                    + File.separator);

    public static final Path PATH_IN = Paths.get(
            System.getProperty("user.home")
                    + File.separator
                    + "data"
                    + File.separator
                    + "in"
                    + File.separator);

    public static final Path PATH_OUT = Paths.get(
            System.getProperty("user.home")
                    + File.separator
                    + "data"
                    + File.separator
                    + "out"
                    + File.separator);
}
