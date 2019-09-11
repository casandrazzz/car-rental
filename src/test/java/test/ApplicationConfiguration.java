package test;

import com.spring.rental.dao.EmployeeRepository;
import com.spring.rental.domain.Employee;
import com.spring.rental.service.EmployeeServiceImpl;
import org.codehaus.plexus.component.annotations.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class ApplicationConfiguration {

	@Bean
	public EmployeeServiceImpl employeeService() {
		EmployeeServiceImpl emplImp = new EmployeeServiceImpl(new EmployeeRepository() {
			@Override
			public List<Employee> getEmployees() {
				return null;
			}

			@Override
			public List<Employee> findEmployeesByFirstName(String firstName) {
				return null;
			}

			@Override
			public List<Employee> findEmployeesByLastName(String lastName) {
				return null;
			}

			@Override
			public List<Employee> findEmployeesByUsername(String username) {
				return null;
			}

			@Override
			public List<Employee> findEmployeesByEmailAddress(String emailAddress) {
				return null;
			}

			@Override
			public Employee deleteEmployee(long pk) {
				return null;
			}

			@Override
			public List<Employee> findAll() {
				return null;
			}

			@Override
			public List<Employee> findAll(Sort sort) {
				return null;
			}

			@Override
			public List<Employee> findAllById(Iterable<Long> iterable) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> saveAll(Iterable<S> iterable) {
				return null;
			}

			@Override
			public void flush() {

			}

			@Override
			public <S extends Employee> S saveAndFlush(S s) {
				return null;
			}

			@Override
			public void deleteInBatch(Iterable<Employee> iterable) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public Employee getOne(Long aLong) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> findAll(Example<S> example) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
				return null;
			}

			@Override
			public Page<Employee> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Employee> S save(S s) {
				return null;
			}

			@Override
			public Optional<Employee> findById(Long aLong) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long aLong) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Long aLong) {

			}

			@Override
			public void delete(Employee employee) {

			}

			@Override
			public void deleteAll(Iterable<? extends Employee> iterable) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public <S extends Employee> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Employee> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends Employee> boolean exists(Example<S> example) {
				return false;
			}
		});

		return emplImp;
	}
	
	@Bean
	public EmployeeRepository employeeDAO() {
		return new EmployeeRepository() {
			@Override
			public List<Employee> getEmployees() {
				return null;
			}

			@Override
			public List<Employee> findEmployeesByFirstName(String firstName) {
				return null;
			}

			@Override
			public List<Employee> findEmployeesByLastName(String lastName) {
				return null;
			}

			@Override
			public List<Employee> findEmployeesByUsername(String username) {
				return null;
			}

			@Override
			public List<Employee> findEmployeesByEmailAddress(String emailAddress) {
				return null;
			}

			@Override
			public Employee deleteEmployee(long pk) {
				return null;
			}

			@Override
			public List<Employee> findAll() {
				return null;
			}

			@Override
			public List<Employee> findAll(Sort sort) {
				return null;
			}

			@Override
			public List<Employee> findAllById(Iterable<Long> iterable) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> saveAll(Iterable<S> iterable) {
				return null;
			}

			@Override
			public void flush() {

			}

			@Override
			public <S extends Employee> S saveAndFlush(S s) {
				return null;
			}

			@Override
			public void deleteInBatch(Iterable<Employee> iterable) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public Employee getOne(Long aLong) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> findAll(Example<S> example) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
				return null;
			}

			@Override
			public Page<Employee> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Employee> S save(S s) {
				return null;
			}

			@Override
			public Optional<Employee> findById(Long aLong) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long aLong) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Long aLong) {

			}

			@Override
			public void delete(Employee employee) {

			}

			@Override
			public void deleteAll(Iterable<? extends Employee> iterable) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public <S extends Employee> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Employee> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends Employee> boolean exists(Example<S> example) {
				return false;
			}
		};
	}
}
