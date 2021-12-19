package com.jokend.db.db.pojoDBClasses;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
public class VaccinationKey implements Serializable{
    private static final long serialVersionUID = 7063787474085184326L;

    @Getter
    @Setter
    private long vaccineId;

    @Getter
    @Setter
    private long inn;
}
