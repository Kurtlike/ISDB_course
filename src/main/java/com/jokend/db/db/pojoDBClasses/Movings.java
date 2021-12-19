package com.jokend.db.db.pojoDBClasses;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "movings")
@Entity
@IdClass(MovingsKey.class)
public class Movings {
  @Id
  @Getter
  @Setter
  private long publicTransport;

  @Id
  @Getter
  @Setter
  private long inn;

  @Id
  @Getter
  @Setter
  private java.sql.Timestamp date;
}
