package base;

import utilities.Logs;

import java.io.File;

public abstract class BaseTest {
    protected Logs logs = new Logs();
    protected final String baseUrl = "https://restful-booker.herokuapp.com";
    private final String schemaFolder = "src/test/resources/schemas";

    protected final String smoke = "Smoke";
    protected final String regression = "Regression";

    protected File getSchema(String json) {
        var path = String.format("%s/%s", schemaFolder, json);
        return new File(path);
    }

}
