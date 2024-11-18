package models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String first_name() {
        return first_name;
    }

    public String last_name() {
        return last_name;
    }

    public String avatar() {
        return avatar;
    }
    @JsonProperty("email")
    private String email;
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("first_name")
    private String first_name ;
    @JsonProperty("last_name")
    private String last_name ;

    @JsonProperty("avatar")
    private String avatar ;

}
