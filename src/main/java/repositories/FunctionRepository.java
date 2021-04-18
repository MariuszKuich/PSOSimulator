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
        functionsMap.put("Ackley function",
                new FunctionData("20 * Math.exp(-0.2 * Math.sqrt(0.5 * (x * x + y * y))) " +
                        "Math.exp(0.5 * (Math.cos(2 * Math.PI * x) + Math.cos(2 * Math.PI * y))) - 20",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return 20 * Math.exp(-0.2 * Math.sqrt(0.5 * (x * x + y * y)))
                                        + Math.exp(0.5 * (Math.cos(2 * Math.PI * x) + Math.cos(2 * Math.PI * y))) - 20;
                            }
                        }, -30, 30, -30, 30));
        functionsMap.put("Beale function",
                new FunctionData("-(Math.pow(1.5 - x + x * y, 2) + Math.pow(2.25 - x + x * y * y, 2) " +
                        "+ Math.pow(2.625 - x + x * y * y * y, 2))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(Math.pow(1.5 - x + x * y, 2) + Math.pow(2.25 - x + x * y * y, 2)
                                        + Math.pow(2.625 - x + x * y * y * y, 2));
                            }
                        }, -5, 5, -5, 5));
        functionsMap.put("Booth function",
                new FunctionData("-(Math.pow(x + 2 * y - 7, 2) + Math.pow(2 * x + y - 5, 2))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(Math.pow(x + 2 * y - 7, 2) + Math.pow(2 * x + y - 5, 2));
                            }
                        }, -10, 10, -10, 10));
        functionsMap.put("Bukin function",
                new FunctionData("-(100 * Math.sqrt(Math.abs(y - 0.01 * x * x)) + 0.01 * Math.abs(x + 10))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(100 * Math.sqrt(Math.abs(y - 0.01 * x * x)) + 0.01 * Math.abs(x + 10));
                            }
                        }, -15, -5, -3, 3));
        functionsMap.put("Three-hump camel function",
                new FunctionData("-(2 * Math.pow(x, 2) - 1.05 * Math.pow(x, 4) " +
                        "+ Math.pow(x, 6) / 6 + x * y + Math.pow(y, 2))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(2 * Math.pow(x, 2) - 1.05 * Math.pow(x, 4) + Math.pow(x, 6) / 6 + x * y
                                        + Math.pow(y, 2));
                            }
                        }, -5, 5, -5, 5));
        functionsMap.put("Cross-in-tray function",
                new FunctionData("0.0001 * Math.pow(Math.abs(Math.sin(x) * Math.sin(y) " +
                        "* Math.exp(Math.abs(100 - Math.sqrt(x * x + y + y) / Math.PI))) + 1, 0.1)",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return 0.0001 * Math.pow(Math.abs(Math.sin(x) * Math.sin(y)
                                        * Math.exp(Math.abs(100 - Math.sqrt(x * x + y + y) / Math.PI))) + 1, 0.1);
                            }
                        }, -10, 10, -10, 10));
        functionsMap.put("Easom function",
                new FunctionData("Math.cos(x) * Math.cos(y) * Math.exp(-(Math.pow(x - Math.PI, 2) " +
                        "+ Math.pow(y - Math.PI, 2)))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return Math.cos(x) * Math.cos(y) * Math.exp(-(Math.pow(x - Math.PI, 2)
                                        + Math.pow(y - Math.PI, 2)));
                            }
                        }, -100, 100, -100, 100));
        functionsMap.put("Eggholder function",
                new FunctionData("(y + 47) * Math.sin(Math.sqrt(Math.abs(x / 2 + (y + 47)))) " +
                        "+ x * Math.sin(Math.sqrt(Math.abs(x - (y + 47))))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return (y + 47) * Math.sin(Math.sqrt(Math.abs(x / 2 + (y + 47))))
                                        + x * Math.sin(Math.sqrt(Math.abs(x - (y + 47))));
                            }
                        }, -512, 512, -512, 512));
        functionsMap.put("Goldstein-Price function",
                new FunctionData("-((1 + Math.pow(x + y + 1, 2) * (19 - 14 * x + 3 * x * x - 14 * y " +
                        "+ 6 * x * y + 3 * y * y)) * (30 + Math.pow(2 * x - 3 * y, 2) " +
                        "* (18 - 32 * x + 12 * x * x + 48 * y - 36 * x * y + 27 * y * y)))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -((1 + Math.pow(x + y + 1, 2)
                                        * (19 - 14 * x + 3 * x * x - 14 * y + 6 * x * y + 3 * y * y))
                                        * (30 + Math.pow(2 * x - 3 * y, 2)
                                        * (18 - 32 * x + 12 * x * x + 48 * y - 36 * x * y + 27 * y * y)));
                            }
                        }, -2, 2, -2, 2));
        functionsMap.put("Griewank function",
                new FunctionData("-1 / 4000.0 * (x * x + y * y) + Math.cos(x) * Math.cos(y / Math.sqrt(2)) - 1",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -1 / 4000.0 * (x * x + y * y) + Math.cos(x) * Math.cos(y / Math.sqrt(2)) - 1;
                            }
                        }, -300, 300, -300, 300));
        functionsMap.put("Holder table function",
                new FunctionData("Math.abs(Math.sin(x) * Math.cos(y) * Math.exp(Math.abs(1 " +
                        "- Math.sqrt(x * x + y * y) / Math.PI)))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return Math.abs(Math.sin(x) * Math.cos(y)
                                        * Math.exp(Math.abs(1 - Math.sqrt(x * x + y * y) / Math.PI)));
                            }
                        }, -10, 10, -10, 10));
        functionsMap.put("Levi function",
                new FunctionData("-(Math.pow(Math.sin(3 * Math.PI * x), 2) + Math.pow(x - 1, 2) " +
                        "* (1 + Math.pow(Math.sin(3 * Math.PI * y), 2)) + Math.pow(y - 1, 2) " +
                        "* (1 + Math.pow(Math.sin(2 * Math.PI * y), 2)))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(Math.pow(Math.sin(3 * Math.PI * x), 2) + Math.pow(x - 1, 2)
                                        * (1 + Math.pow(Math.sin(3 * Math.PI * y), 2)) + Math.pow(y - 1, 2)
                                        * (1 + Math.pow(Math.sin(2 * Math.PI * y), 2)));
                            }
                        }, -10, 10, -10, 10));
        functionsMap.put("McCormick function",
                new FunctionData("-(Math.sin(x + y) + Math.pow(x - y, 2) - 1.5 * x + 2.5 * y + 1)",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(Math.sin(x + y) + Math.pow(x - y, 2) - 1.5 * x + 2.5 * y + 1);
                            }
                        }, -1, 4, -3, 4));
        functionsMap.put("Michalewicz function",
                new FunctionData("Math.sin(x) * Math.pow(Math.sin(x * x / Math.PI), 2 * 10) + Math.sin(y) " +
                        "* Math.pow(Math.sin(y * y / Math.PI), 2 * 10)",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return Math.sin(x) * Math.pow(Math.sin(x * x / Math.PI), 2 * 10) + Math.sin(y)
                                        * Math.pow(Math.sin(y * y / Math.PI), 2 * 10);
                            }
                        }, 0, 4, 0, 4));
        functionsMap.put("Rastrigin function",
                new FunctionData("-(10 * 2 + (x * x - 10 * Math.cos(2 * Math.PI * x)) " +
                        "+ (y * y - 10 * Math.cos(2 * Math.PI * y)))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(10 * 2 + (x * x - 10 * Math.cos(2 * Math.PI * x))
                                        + (y * y - 10 * Math.cos(2 * Math.PI * y)));
                            }
                        }, -1, 1, -1, 1));
        functionsMap.put("Rosenbrock function",
                new FunctionData("-(100 * Math.pow((y - x * x), 2) + Math.pow((x - 1), 2))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(100 * Math.pow((y - x * x), 2) + Math.pow((x - 1), 2));
                            }
                        }, -5, 5, -50, 50));
        functionsMap.put("Schaffer function",
                new FunctionData("-(0.5 + (Math.pow(Math.sin(x * x - y * y), 2) - 0.5) " +
                        "/ Math.pow(1 + 0.001 * (x * x + y * y), 2))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(0.5 + (Math.pow(Math.sin(x * x - y * y), 2) - 0.5)
                                        / Math.pow(1 + 0.001 * (x * x + y * y), 2));
                            }
                        }, -100, 100, -100, 100));
        functionsMap.put("Schwefel function",
                new FunctionData("x * Math.sin(Math.sqrt(Math.abs(x))) + y * Math.sin(Math.sqrt(Math.abs(y)))",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return x * Math.sin(Math.sqrt(Math.abs(x))) + y * Math.sin(Math.sqrt(Math.abs(y)));
                            }
                        }, -500, 500, -500, 500));
        functionsMap.put("Styblinski-Tang function",
                new FunctionData("-(((Math.pow(x, 4) - 16 * x * x + 5 * x) " +
                        "+ (Math.pow(y, 4) - 16 * y * y + 5 * y)) / 2)",
                        new Mapper() {
                            @Override
                            public double f(double x, double y) {
                                return -(((Math.pow(x, 4) - 16 * x * x + 5 * x)
                                        + (Math.pow(y, 4) - 16 * y * y + 5 * y)) / 2);
                            }
                        }, -5, 5, -1, 2));
    }

    public Set<String> getFunctionsNamesSet() {
        return functionsMap.keySet();
    }

    public FunctionData getFunctionDataByFunctionName(String functionName) {
        return functionsMap.get(functionName);
    }
}
