package com.jokend.db.db.pojoDBClasses;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "district")
@Entity
public class District {
  @Id
  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private long livingStandard;


}
