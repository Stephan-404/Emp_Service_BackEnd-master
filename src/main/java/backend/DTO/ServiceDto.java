package backend.DTO;

import lombok.Data;

@Data
public class ServiceDto {
    private int id;
    private String name;
    private int employeeId;
    private String date;
    private String longitude;
    private String latitude;
}
