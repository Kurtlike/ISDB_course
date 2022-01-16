package com.jokend.db.db.pojoDBClasses;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "virus")
@Entity
@Getter
@Setter
public class Virus {
  @Id
  private String virusId;
  private Integer mortality;
  private Integer incubationPeriod;
  private Integer asymptomaticProb;
  private Integer infectiousness;
}
