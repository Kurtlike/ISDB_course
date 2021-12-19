package com.jokend.db.db.pojoDBClasses;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "remedies")
@Entity
public class Remedies {
  @Id
  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private long efficiency;

  @Getter
  @Setter
  private long comfortable;
}
