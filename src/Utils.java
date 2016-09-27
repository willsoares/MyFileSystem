
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author a14034
 */
public class Utils {
    public ArrayList<String> parseParameters (String params){
        ArrayList<String> parameters = new ArrayList<String>();
        String[] ps;
        ps = params.split(" ");
        parameters.addAll(Arrays.asList(ps));

        return parameters;
    }
    
}
