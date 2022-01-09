package com.jokend.db.db.pojoDBClasses;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "vaccines")
@Entity
public class Vaccines {
  @Getter
  @Setter
  private String virusId;

  @Id
  @Getter
  @Setter
  private String vaccineId;

  @Getter
  @Setter
  private Integer maxAge;

  @Getter
  @Setter
  private Integer efficiency;
}
