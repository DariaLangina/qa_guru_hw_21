package dlangina.helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {

  public static String videoUrl(String sessionId) {
    return given()
        .auth().basic("darialangina_OmWiPT", "8hszBadbqtdFVbh9JLuC")
        .when()
        .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
        .then()
        .statusCode(200)
        .log().body()
        .extract()
        .path("automation_session.video_url");
  }
}
