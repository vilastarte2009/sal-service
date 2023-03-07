package com.vilas.entity;

import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class Emp {
	
	int id;
	String name;
	int salary_per_day;
	int total_working_day;
	int advance_salary;
	int total_salary;
	
	public Emp(){}

	public Emp(int id, String name, int salary_per_day, int total_working_day, int advance_salary, int total_salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary_per_day = salary_per_day;
		this.total_working_day = total_working_day;
		this.advance_salary = advance_salary;
		this.total_salary = total_salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary_per_day() {
		return salary_per_day;
	}

	public void setSalary_per_day(int salary_per_day) {
		this.salary_per_day = salary_per_day;
	}

	public int getTotal_working_day() {
		return total_working_day;
	}

	public void setTotal_working_day(int total_working_day) {
		this.total_working_day = total_working_day;
	}

	public int getAdvance_salary() {
		return advance_salary;
	}

	public void setAdvance_salary(int advance_salary) {
		this.advance_salary = advance_salary;
	}

	public int getTotal_salary() {
		return total_salary;
	}

	public void setTotal_salary(int total_salary) {
		this.total_salary = total_salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(advance_salary, id, name, salary_per_day, total_salary, total_working_day);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return advance_salary == other.advance_salary && id == other.id && Objects.equals(name, other.name)
				&& salary_per_day == other.salary_per_day && total_salary == other.total_salary
				&& total_working_day == other.total_working_day;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary_per_day=" + salary_per_day + ", total_working_day="
				+ total_working_day + ", advance_salary=" + advance_salary + ", total_salary=" + total_salary + "]";
	}
	
	

	
}
