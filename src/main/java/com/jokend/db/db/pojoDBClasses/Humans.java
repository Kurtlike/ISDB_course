package com.jokend.db.db.pojoDBClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "humans")
@Entity
public class Humans {
  @Id
  @Getter
  @Setter
  private long inn;

  @Getter
  @Setter
  private String status;
  @Getter
  @Setter
  private java.sql.Timestamp birthday;

  @Getter
  @Setter
  private String district;

  @Getter
  @Setter
  private String remedy;
}
