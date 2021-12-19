package com.jokend.db.db.pojoDBClasses;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "virus")
@Entity
public class Virus {
  @Id
  @Getter
  @Setter
  private long virusId;

  @Getter
  @Setter
  private long mortality;

  @Getter
  @Setter
  private long incubationPeriod;

  @Getter
  @Setter
  private long asymptomaticProb;
}
