package service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JSONService implements PersistencyService{

    @Override
    public void save(String path, int rounds, int score) {
        JSONObject req = new JSONObject();
        req.put("rounds", rounds);
        req.put("score", score);
        try(FileWriter writer = new FileWriter(path)){
            writer.write(req.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JSONObject read(String path) {
        JSONObject res = null;
        JSONParser parser = new JSONParser();
        try{
            res = (JSONObject) parser.parse(new InputStreamReader(new FileInputStream(path)));
        }
        catch(ParseException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
