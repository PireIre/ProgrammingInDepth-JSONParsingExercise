import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Member {

    public Member(){

    }

    @JsonProperty
    private String name;

    @JsonProperty
    private String id;

    @JsonProperty
    private boolean attended;

    public String toString() {
        return "•" +"Member {" +
                "|Name: " + name +
                "|\t ID: " + id +
                "\t|Present during last taken attendance: " + attended + " |}";

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
}
