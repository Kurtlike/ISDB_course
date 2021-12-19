package com.jokend.db.db.pojoDBClasses;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "illness")
@Entity
public class Illness {
  @Id
  @Getter
  @Setter
  private long id;

  @Getter
  @Setter
  private java.sql.Timestamp dateOfInfection;

  @Getter
  @Setter
  private long virusId;

  @Getter
  @Setter
  private long innInjured;

  @Getter
  @Setter
  private long innCarrier;

  @Getter
  @Setter
  private long placeTransmission;

  @Getter
  @Setter
  private String status;
}
