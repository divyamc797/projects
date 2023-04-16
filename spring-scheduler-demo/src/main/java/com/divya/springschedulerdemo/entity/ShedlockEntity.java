package com.divya.springschedulerdemo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "shedlock")
public class ShedlockEntity {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name= "lock_until")
    private LocalDateTime lock_until;

    @Column(name = "locked_at")
    private LocalDateTime locked_at;

    @Column(name = "locked_by")
    private String locked_by;

}
