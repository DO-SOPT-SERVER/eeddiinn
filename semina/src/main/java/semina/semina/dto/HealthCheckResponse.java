package semina.semina.dto;

public class HealthCheckResponse {

    private static final String STATUS = "OK";
    private String status;

    public HealthCheckResponse(String status)
    {
        this.status = STATUS;
    }
}
