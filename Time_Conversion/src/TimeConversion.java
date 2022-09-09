import java.util.HashMap;
import java.util.Map;

/*
* Task: Convert 12 hour time to 24 hour time;
* */

public class TimeConversion {

    public static void main(String[] args) {

        String time1 = "12:01:00AM";
        String time2 = "12:01:00PM";
        String time3 = "01:01:00PM";

        System.out.println(timeConversion(time1)); // 00:01:00
        System.out.println(timeConversion(time2)); // 12:01:00
        System.out.println(timeConversion(time3)); // 13:01:00
    }

    public static String timeConversion(String s) {

        String time = "";

        Map<String, String> map = new HashMap<>();
        map.put("h", s.substring(0, 2));
        map.put("t", s.substring(s.length() - 2));

        if(map.get("h").equals("12") && map.get("t").equals("AM")) {
            time += "00:";
        }else if(map.get("t").equals("AM")){
            time += map.get("h") + ":";
        }else if (map.get("h").equals("12") && map.get("t").equals("PM")){
            time += 12 + ":";
        }else {
            int hour = Integer.parseInt(map.get("h")) + 12;
            time += hour + ":";
        }

        time += s.substring(3, 5) + ":";
        time += s.substring(6, 8);

        return time;
    }
}


