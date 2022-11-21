package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    private final Logger log;
    private final String tag = "Automation";
    private final String bigSeparator =
            "------------------------------------------------------------------------------------------";
    private final String smallSeparator = "**********************************************************";

    public Logs() {
        log = LogManager.getLogger(tag);
    }

    private void printTestSeparator() {
        log.info(bigSeparator);
    }

    public void printSeparator() {
        log.info(smallSeparator);
    }

    private void printSeparatorDebug() {
        log.debug(smallSeparator);
    }

    private void printNewLine() {
        log.info("");
    }

    public void startTest(String testName) {
        printTestSeparator();
        log.info("Test: " + testName);
        printTestSeparator();
    }

    public void endTest(String status) {
        printTestSeparator();
        log.info(status);
        printTestSeparator();
        printNewLine();
        printNewLine();
    }

    public void startSuite(String suiteName) {
        printNewLine();
        printTestSeparator();
        printTestSeparator();
        log.info("Suite: " + suiteName);
        printTestSeparator();
        printTestSeparator();
        printNewLine();
    }

    public void preconditionStart() {
        printSeparator();
        log.info("Preconditions");
        printSeparator();
    }

    public void postConditionStart() {
        printSeparatorDebug();
        log.debug("Post conditions");
        printSeparatorDebug();
    }

    public void postConditionFinish() {
        printSeparatorDebug();
    }

    public void testSteps() {
        printSeparator();
        log.info("Test steps:");
        printSeparator();
    }

    public void info(String message) {
        log.info(message);
    }

    public void warn(String message) {
        log.warn(message);
    }

    public void error(String message) {
        log.error(message);
    }

    public void debug(String message) {
        log.debug(message);
    }
}
