import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressWarnings("CallToPrintStackTrace")
public class Http {

    public static String get(String url) throws IOException {
        String responseBody;
        Reader in = null;
        try {
            URL website = new URL(url);
            InputStream is = (InputStream) website.getContent();
            in = new InputStreamReader(is);
            responseBody = readAllChars(in);
        } finally {
            close(in);
        }
        return responseBody;
    }

    protected static String readAllChars(Reader reader) throws IOException {
        char[] buffer = new char[2048];
        StringBuilder text = new StringBuilder();
        int count;
        while ((count = reader.read(buffer)) != -1) {
            text.append(buffer, 0, count);
        }
        return text.toString();
    }

    protected static void close(Reader in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
