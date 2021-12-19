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
  private long virusId;

  @Id
  @Getter
  @Setter
  private long vaccineId;

  @Getter
  @Setter
  private long maxAge;

  @Getter
  @Setter
  private long efficiency;
}
