package app;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");

            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();

            content = content.replaceAll("\\n", "");
            //regex
            Pattern p = Pattern.compile("class=\"info_song\"(.*?) onclick");
            Matcher m = p.matcher(content);
            while (m.find()) {
                String trim1 = m.group(1);
                Pattern p2 = Pattern.compile("title=\"(.*?)\"");
                Matcher m2 = p2.matcher(trim1);
                while (m2.find()) {
                    System.out.println(m2.group(1));
                }
            }
            scanner.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
