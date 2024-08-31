package org.example;

public enum HttpStatus {
    CONTINUE(100, "Continue"),
    OK(200, "OK"),
    CREATED(201, "Created"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    UNKNOWN(-1, "Unknown Status");

    private final int code;
    private final String description;

    HttpStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static HttpStatus getStatusFromCode(int code) {
        for (HttpStatus status : HttpStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return UNKNOWN;
    }
}

