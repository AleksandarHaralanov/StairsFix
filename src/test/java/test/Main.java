package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
    public static void main(String[] args)
    {
        String oldPath = System.getenv("OLD_PATH");
        String newPath = System.getenv("NEW_PATH");
        File newFile = new File(newPath);
        if (newFile.exists()) newFile.delete();
        else newFile.getParentFile().mkdirs();
        try
        {
            Files.move(Paths.get(oldPath), Paths.get(newPath));
            org.bukkit.craftbukkit.Main.main(args);
        }
        catch (IOException ex) { System.out.println("Failed to move plugin to test server"); }
    }
}
