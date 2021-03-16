package repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionRepository {
    private Map<String, String> functionsMap = new HashMap<>();

    public FunctionRepository() {
        try {
            initializeFunctionsMap();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void initializeFunctionsMap() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(getClass().getResource("/data/functions.json").getFile());
        TypeReference<HashMap<String, String>> typeRef = new TypeReference<>() {};
        functionsMap = objectMapper.readValue(jsonFile, typeRef);
    }

    public Set<String> getFunctionsNamesSet() {
        return functionsMap.keySet();
    }

    public String getFormulaByFunctionName(String functionName) {
        return functionsMap.get(functionName);
    }
}
