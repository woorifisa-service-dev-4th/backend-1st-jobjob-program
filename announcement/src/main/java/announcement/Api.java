package announcement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import org.json.JSONObject;

public class Api {
    String ACCESS_KEY = "TZeNzZLOVSK6HKPyhsUjU5IkHaTfrQbq7UDq3LK0QUOO8S5ZL1W";
    private int announcementNum=0;
    public Api() {

    }

    void callToSaramin(LocalDate date) {
        try{
            String apiURL = "https://oapi.saramin.co.kr/job-search?access-key="+ACCESS_KEY+"&published="+date;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");
            int responseCode = con.getResponseCode();
            BufferedReader br;

            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            JSONObject jsonResponse = new JSONObject(response.toString());
            // 전체 데이터 수 가져오기
            Object o1 = jsonResponse.getJSONObject("jobs").get("total");
            announcementNum = Integer.parseInt((String) o1);
            System.out.println("공고 갯수: "+announcementNum+"개");
        }catch (Exception e) {
            System.out.println("일일 최대 요청 가능 횟수가 초과되었습니다.");
        }
    }

}
