package repositories;

import models.FunctionFormula;
import org.jzy3d.plot3d.builder.Mapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionRepository {
    private Map<String, FunctionFormula> functionsMap;

    public FunctionRepository() {
        initializeFunctionsMap();
    }

    private void initializeFunctionsMap() {
        functionsMap = new HashMap<>();
        functionsMap.put("Sphere function",
                new FunctionFormula("-(x * x + y * y)", new Mapper() {
                    @Override
                    public double f(double x, double y) {
                        return -(x * x + y * y);
                    }
        }));
        functionsMap.put("Himmelblau function",
                new FunctionFormula("-(Math.pow(x * x + y - 11, 2) + Math.pow(x + y * y - 7, 2))",
                        new Mapper() {
                    @Override
                    public double f(double x, double y) {
                        return -(Math.pow(x * x + y - 11, 2) + Math.pow(x + y * y - 7, 2));
                    }
        }));
        functionsMap.put("Matyas function",
                new FunctionFormula("-(0.26 * (x * x + y * y) - 0.48 * x * y)",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(0.26 * (x * x + y * y) - 0.48 * x * y);
                            }
        }));
    }

    public Set<String> getFunctionsNamesSet() {
        return functionsMap.keySet();
    }

    public String getFormulaByFunctionName(String functionName) {
        return functionsMap.get(functionName).getFormulaString();
    }

    public Mapper getMapperByFunctionName(String functionName) {
        return functionsMap.get(functionName).getFormulaMapper();
    }
}
