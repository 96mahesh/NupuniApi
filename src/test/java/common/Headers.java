package common;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.FileUtils;

import static io.restassured.RestAssured.given;
public class Headers {
	public static Response GetHeader(String endpoint) {

        return given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().get(endpoint).then().contentType(ContentType.JSON).extract().response();


    }


    public static Response PostHeader(String endpoint) {

        String request="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).body(FileUtils.readJson("attractiondesc.json")).
                        when().post(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }


    public static Response PatchHeader(String endpoint) {

        String request="{\"name\": \"Training\",\"job\": \"software\"}";

        return
                given().headers("Content-Type",ContentType.JSON, "Accept", ContentType.JSON).body(request).
                        when().patch(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }



public static RequestSpecification getBasicAuth(){
    return RestAssured.given().auth().basic("username","password");
}
}
