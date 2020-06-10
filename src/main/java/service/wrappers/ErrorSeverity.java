package service.wrappers;

/**
 * @author sambitdikshit
 *
 *         Enum used as Error severity
 */
public enum ErrorSeverity {

    INFO("Info"), WARN("Warning."), ERROR("Error");

    private final String description;

    private String getDescription() {
        return description;
    }

    private ErrorSeverity(String description) {
        this.description = description;
    }

}
