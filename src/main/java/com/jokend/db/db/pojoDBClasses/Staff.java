package com.jokend.db.db.pojoDBClasses;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "staff")
@Entity
@IdClass(StaffKey.class)
public class Staff {
  @Id
  @Getter
  @Setter
  private long inn;

  @Id
  @Getter
  @Setter
  private long placeId;

  @Getter
  @Setter
  private java.sql.Time startTime;

  @Getter
  @Setter
  private java.sql.Time endTime;
}
