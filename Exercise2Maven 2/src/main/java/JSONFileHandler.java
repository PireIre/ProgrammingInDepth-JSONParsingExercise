import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class JSONFileHandler {


    public MembersList ReadMembersList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MembersList org = new MembersList();
        org = new ObjectMapper().readerFor(MembersList.class).readValue(new File("SDA.json"));

        return org;
    }

    public void writeUpdatedMembersList(MembersList membersList) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("SDA.json"), membersList);
    }

}
