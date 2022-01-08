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
  private Integer virusId;

  @Getter
  @Setter
  private Integer mortality;

  @Getter
  @Setter
  private Integer incubationPeriod;

  @Getter
  @Setter
  private Integer asymptomaticProb;

  @Getter
  @Setter
  private Integer infectiousness;
}
