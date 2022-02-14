import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class ReadJsonFile {
    public static String getJSONFromFile(String filename) {
        String jsonText = "";
        try {		
            BufferedReader bufferedReader = 
                          new BufferedReader(new FileReader(filename));
        
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }
        
            bufferedReader.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return jsonText;
    }
    
    public static String getJSONFromURL(String strUrl) {
        String jsonText = "";

        try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();

            BufferedReader bufferedReader = 
                            new BufferedReader(new InputStreamReader(is));
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }

            is.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return jsonText;
    }
    
    public static void main(String[] args) {
;
        String strJson = getJSONFromURL(
            "../JsonFiles/1-input.json"
        );
        
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(strJson);
            JSONObject mainJsonObject = (JSONObject) object;
            
            JSONArray jsonExpenseDatas = (JSONArray) mainJsonObject.get("expenseData");
            System.out.println("expenseData : ");
            
            for (int i = 0; i < jsonExpenseDatas.size(); i++) {
                JSONObject jsonExpenseData = (JSONObject) jsonExpenseDatas.get(i);
                System.out.println("     expenseData " + (i + 1));

                String amount = (String) jsonExpenseData.get("amount");
                System.out.println("      amount : " + amount);

                String startDate = (String) jsonExpenseData.get("startDate");
                System.out.println("      startDate : " + startDate);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(strJson);
            JSONObject mainJsonObject = (JSONObject) object;
            
            JSONArray jsonRevenueDatas = (JSONArray) mainJsonObject.get("revenueData");
            System.out.println("revenueData : ");
            
            for (int i = 0; i < jsonRevenueDatas.size(); i++) {
                JSONObject jsonRevenueData = (JSONObject) jsonRevenueDatas.get(i);
                System.out.println("     revenueData " + (i + 1));

                String amount = (String) jsonRevenueData.get("amount");
                System.out.println("      amount : " + amount);

                String startDate = (String) jsonRevenueData.get("startDate");
                System.out.println("      startDate : " + startDate);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

    
        
       
    }
  
    }



