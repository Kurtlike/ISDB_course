package com.jokend.db.db.pojoDBClasses;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "public_transport")
@Entity
public class PublicTransport {
  @Id
  @Getter
  @Setter
  private long id;

  @Getter
  @Setter
  private String district1;

  @Getter
  @Setter
  private String district2;

  @Getter
  @Setter
  private String type;

  @Getter
  @Setter
  private long capacity;

  @Getter
  @Setter
  private long area;

  @Getter
  @Setter
  private long period;

  @Getter
  @Setter
  private java.sql.Time startTime;

  @Getter
  @Setter
  private java.sql.Time endTime;
}
