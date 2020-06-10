package service.wrappers;

/**
 * @author sambitdikshit
 *
 *         Enum used as Error category
 */
public enum ErrorCategory {

    APPLICATION("Application/Service specific error."), SYSTEM(
            "System/Container specific error."), REQUEST(
            "Request/Transaction specific error."), DATA("Data specific error.");

    private final String description;

    private String getDescription() {
        return description;
    }

    private ErrorCategory(String description) {
        this.description = description;
    }

}
