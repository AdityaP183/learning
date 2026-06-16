public class Main {
    static void main(String[] args) {
        ErrorLogger logger = new ErrorLogger();

        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (Exception e) {
            String errorMessage =
                    "Error: " + e.getClass().getSimpleName()
                            + " - " + e.getMessage();

            logger.logError(errorMessage);
            System.out.println("Exception occurred and logged successfully.");
        }
        logger.displayLogs();
    }
}
