package repositories;

import models.FunctionData;
import org.jzy3d.plot3d.builder.Mapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionRepository {
    private Map<String, FunctionData> functionsMap;

    public FunctionRepository() {
        initializeFunctionsMap();
    }

    private void initializeFunctionsMap() {
        functionsMap = new HashMap<>();
        functionsMap.put("Sphere function",
                new FunctionData("-(x * x + y * y)", new Mapper() {
                    @Override
                    public double f(double x, double y) {
                        return -(x * x + y * y);
                    }
            }, -5, 5, -5, 5));
        functionsMap.put("Himmelblau function",
                new FunctionData("-(Math.pow(x * x + y - 11, 2) + Math.pow(x + y * y - 7, 2))",
                        new Mapper() {
                    @Override
                    public double f(double x, double y) {
                        return -(Math.pow(x * x + y - 11, 2) + Math.pow(x + y * y - 7, 2));
                    }
        }, -5, 5, -5, 5));
        functionsMap.put("Matyas function",
                new FunctionData("-(0.26 * (x * x + y * y) - 0.48 * x * y)",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(0.26 * (x * x + y * y) - 0.48 * x * y);
                            }
        }, -10, 10, -10, 10));
    }

    public Set<String> getFunctionsNamesSet() {
        return functionsMap.keySet();
    }

    public FunctionData getFunctionDataByFunctionName(String functionName) {
        return functionsMap.get(functionName);
    }
}
