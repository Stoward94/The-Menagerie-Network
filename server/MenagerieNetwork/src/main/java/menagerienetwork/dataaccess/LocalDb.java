/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menagerienetwork.dataaccess;

import com.google.gson.Gson;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import menagerienetwork.entities.Animal;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Scanner;
import menagerienetwork.entities.Zoo;

/**
 *
 * @author Luke
 */
public class LocalDb {

    public LocalDb() {
    }

    public List<Animal> GetAnimals() {
        
        return null;
    }

    public List<Zoo> GetZoos() {
        
        //Bad hardcoded json string
        String obj = "[{\"name\":\"Blackpool Zoo\",\"url\":\"http://www.blackpoolzoo.org.uk/\",\"latitude\":53.81625,\"longtitude\":-3.011161,\"postcode\":\"FY3 8PP\"},{\"name\":\"Edinburgh Zoo\",\"url\":\"http://www.edinburghzoo.org.uk/\",\"latitude\":-3.269331,\"longtitude\":-0.29962,\"postcode\":\"EH12 6TS\"},{\"name\":\"Kingston Zoo\",\"url\":\"http://www.kingston.ac.uk/\",\"latitude\":51.40298,\"longtitude\":-0.30311,\"postcode\":\"KT1 2EE\"},{\"name\":\"Welsh Mountain Zoo\",\"url\":\"http://www.welshmountainzoo.org/\",\"latitude\":53.293116,\"longtitude\":-3.746532,\"postcode\":\"LL28 5UY\"}]";

        Type listType = new TypeToken<List<Zoo>>(){}.getType();
        List<Zoo> zoos = new Gson().fromJson(obj, listType);

        return zoos;
    }
}
