package com.jokend.db.db.pojoDBClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Table(name = "public_places")
@Entity
public class PublicPlaces {
  @Id
  @Getter
  @Setter
  private long id;

  @Getter
  @Setter
  private String pClass;

  @Getter
  @Setter
  private String district;

  @Getter
  @Setter
  private String isWorking;

  @Getter
  @Setter
  private long capacity;

  @Getter
  @Setter
  private long area;

  @Getter
  @Setter
  private long avrTimeVisitor;

  @Getter
  @Setter
  private long avrTimeStaff;

  @Getter
  @Setter
  private long restrictionsLevel;

}
