package com.jokend.db.db.pojoDBClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "families")
@Entity
@IdClass(FamiliesKey.class)
public class Families {
  @Id
  @Getter
  @Setter
  private long id;

  @Id
  @Getter
  @Setter
  private long inn;

  @Getter
  @Setter
  private String role;
}
