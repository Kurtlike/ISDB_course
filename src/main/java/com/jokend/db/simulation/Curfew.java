package com.jokend.db.simulation;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Component
public class Curfew {
    private boolean isActive = false;
    private LocalTime start;
    private LocalTime end;
}
