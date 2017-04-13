package com.mpp.group.proj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.mpp.group.proj.model.Animal;
import com.mpp.group.proj.model.Vaccine;

@Repository
public class VaccineDaoImpl implements VaccineDao {
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	
	private SqlParameterSource getSqlParameterByModel(Vaccine vaccine){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		

		System.out.println(vaccine);	 
		if(vaccine!=null){
			System.out.println("interno");
			paramSource.addValue("id", vaccine.getId());
			paramSource.addValue("animal", vaccine.getAnimal().getId());
			paramSource.addValue("date", vaccine.getDate());
			paramSource.addValue("name", vaccine.getName());
			paramSource.addValue("batch", vaccine.getBatch());
			paramSource.addValue("doctor_id", vaccine.getDoctor_id());
		}
		return paramSource;
	}
	
	private static final class VaccineMapper implements RowMapper<Vaccine>{
		
		public Vaccine mapRow(ResultSet rs, int rowNum) throws SQLException{

			Vaccine vaccine = new Vaccine();
			vaccine.setId(rs.getInt("va_id"));
			Animal animal= new Animal(rs.getInt("an_id"));
			vaccine.setAnimal(animal);//animal
			vaccine.setDoctor_id(rs.getInt("pr_id"));//doctor
			vaccine.setDate(rs.getDate("va_date"));
			vaccine.setName(rs.getString("va_name"));
			vaccine.setBatch(rs.getString("va_batch"));

			
			return vaccine;
		}
	}
	
	
	@Override
	public List<Vaccine> listAllVaccine() {
		String sql="SELECT * FROM t_vaccine order by va_id";
		List<Vaccine> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new VaccineMapper());
		return list;
	}

	@Override
	public void addVaccine(Vaccine Vaccine) {
		 String sql = "INSERT INTO t_vaccine (va_id,an_id,pr_id,va_date,va_name,va_batch)"
				+ "VALUES (:id,:animal_id,:doctor_id,:date,:name,:batch)";
	
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Vaccine));
	
	}

	@Override
	public void updateVaccine(Vaccine Vaccine) {
		// TODO Auto-generated method stub
		//String sql = "update tbl_category set category_name =:category_name where id =:id";
		String sql = "UPDATE  t_vaccine SET an_id = :animal_id, pr_id = :doctor_id, va_date = :date, va_name=:name, va_batch=:batch WHERE va_id = :id;";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Vaccine));
	
	}

	@Override
	public void deleteVaccine(int id) {
		
		
		String sql = "delete from t_vaccine where va_id =:id";
		System.out.println(sql);
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Vaccine(id)));
		
	}

	@Override
	public Vaccine findVaccineById(int id) {
		//String sql="select id, category_name from tbl_category where id = " +id;
		String sql="SELECT * FROM t_vaccine where va_id=" +id;;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Vaccine(id)), new VaccineMapper());
	
	}

}
