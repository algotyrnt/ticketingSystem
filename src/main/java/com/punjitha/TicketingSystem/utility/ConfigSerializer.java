package com.punjitha.TicketingSystem.utility;

import com.google.gson.Gson;
import com.punjitha.TicketingSystem.config.SystemConfig;

import java.io.*;

public class ConfigSerializer {

    // Load the SystemConfig object from a JSON file
    public static SystemConfig loadFromFile(String filePath) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, SystemConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Save the SystemConfig object to a JSON file
    public static void saveToFile(SystemConfig config, String filePath)  {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(config, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
