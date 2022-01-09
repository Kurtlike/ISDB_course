package com.jokend.db.db.pojoDBClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@ToString
@Table(name = "vaccination")
@Entity
@IdClass(VaccinationKey.class)
public class Vaccination {
  @Id
  @Getter
  @Setter
  private String vaccineId;

  @Id
  @Getter
  @Setter
  private long inn;

  @Getter
  @Setter
  private java.sql.Timestamp date;

}
