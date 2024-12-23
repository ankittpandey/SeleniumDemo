package SeleniumScenarios;

import SeleniumWaits.PageLoadTimeOut;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class VerifyLinkStatus {
    public static int invalidLinkCount;

    public static void getInvalidLinkCount() {
        System.out.println("Total Invalid Link - "+invalidLinkCount);
    }

    public static void verifyLink(String link) throws IOException {
        if (link != null && !link.isEmpty()) {
            Response res = given().relaxedHTTPSValidation().get(link);
            if (res.getStatusCode() != 200)
                invalidLinkCount++;
        }
    }

}
