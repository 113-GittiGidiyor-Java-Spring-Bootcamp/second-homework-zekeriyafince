package com.zekeriyafince.schoolmanagement.entity.concretes;

import com.zekeriyafince.schoolmanagement.entity.abstracts.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "permanents")
@PrimaryKeyJoinColumn(name = "instructor_id", referencedColumnName = "id")
public class PermanentInstructor extends Instructor {
    @Column(name = "salary")
    private double salary;
}
