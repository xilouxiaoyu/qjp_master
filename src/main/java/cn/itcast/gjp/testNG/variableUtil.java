package cn.itcast.gjp.testNG;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class variableUtil {

    public static void saveVariable(String result, Integer collectionId){

    }

    public static String getVariable(String string,Integer collectionId){
        HashMap<String, String> variableMap = ApiTestConfig.globalVariableMap;
        if(collectionId != 0){
            variableMap.putAll(ApiTestConfig.collectionVariableMap);
        }
        if(!string.isEmpty()){
            String reg = "\\$\\{.*?}";
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(string);
            while (m.find()) {
                String key = m.group().replace("${", "").replace("}", "");
                if (variableMap.containsKey(key)) {
                    string = string.replace(m.group(), variableMap.get(key));
                }
            }
            return string;
        }else {
            return "";
        }

    }

}
