package service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;

public interface PersistencyService {

    public void save(String path, int rounds, int score);

    public JSONObject read(String path);
}
