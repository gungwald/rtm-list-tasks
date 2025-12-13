import java.io.IOException;

@SuppressWarnings("CallToPrintStackTrace")
public class Main {

    public static final String API_KEY = "2ced8adb82d476bf6c53780a09b99c6b";

    public static void main(String[] args) {
        try {
            String response = Http.get("https://api.rememberthemilk.com/services/rest/?method=rtm.test.echo&api_key=" + API_KEY);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}