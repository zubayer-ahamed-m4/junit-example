/**
 * 
 */
package com.coderslab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author zubayer
 *
 */
@Data
@Entity
@Table(name = "student")
public class Student {

	@Id
	@SequenceGenerator(name = "StudentSeqnGen", schema = "public", sequenceName = "student_studentId_seqnGen", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StudentSeqnGen")
	@Column(name = "categoryId", nullable = false, unique = true)
	private Long id;

	@Column(name = "name", length = 50)
	private String name;
}
