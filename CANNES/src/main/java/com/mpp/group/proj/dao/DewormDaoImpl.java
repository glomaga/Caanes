package com.mpp.group.proj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.mpp.group.proj.model.Deworm;


@Repository
public class DewormDaoImpl implements DewormDao{
NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	
	private SqlParameterSource getSqlParameterByModel(Deworm Deworm){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		

		System.out.println(Deworm);	 
		if(Deworm!=null){
			System.out.println("interno");
			paramSource.addValue("id", Deworm.getId());
			paramSource.addValue("animal", Deworm.getAnimal().getId());
			paramSource.addValue("date", Deworm.getDate());
			paramSource.addValue("name", Deworm.getName());
			paramSource.addValue("doctor_id", Deworm.getDoctor_id());
		}
		return paramSource;
	}
	
	private static final class DewormMapper implements RowMapper<Deworm>{
		
		public Deworm mapRow(ResultSet rs, int rowNum) throws SQLException{

			Deworm Deworm = new Deworm();
			Deworm.setId(rs.getInt("va_id"));
			Animal animal= new Animal(rs.getInt("an_id"));
			Deworm.setAnimal(animal);//animal
			Deworm.setDoctor_id(rs.getInt("pr_id"));//doctor
			Deworm.setDate(rs.getDate("va_date"));
			Deworm.setName(rs.getString("va_name"));

			
			return Deworm;
		}
	}
	
	@Override
	public List<Deworm> listAllDeworm() {
		String sql="SELECT * FROM t_vaccine order by va_id";
		List<Deworm> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new DewormMapper());
		return list;
	}

	@Override
	public void addDeworm(Deworm Deworm) {
		 String sql = "INSERT INTO t_vaccine (va_id,an_id,pr_id,va_date,va_name,va_batch)"
					+ "VALUES (:id,:animal_id,:doctor_id,:date,:name,:batch)";
		
			namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Deworm));
		
	}

	@Override
	public void updateDeworm(Deworm Deworm) {
		//String sql = "update tbl_category set category_name =:category_name where id =:id";
		String sql = "UPDATE  t_vaccine SET an_id = :animal_id, pr_id = :doctor_id, va_date = :date, va_name=:name, va_batch=:batch WHERE va_id = :id;";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Deworm));
	
		
	}

	@Override
	public void deleteDeworm(int id) {
		String sql = "delete from t_vaccine where va_id =:id";
		System.out.println(sql);
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Deworm(id)));
	
	}

	@Override
	public Deworm findDewormById(int id) {
		//String sql="select id, category_name from tbl_category where id = " +id;
		String sql="SELECT * FROM t_vaccine where va_id=" +id;;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Deworm(id)), new DewormMapper());
	
	}

}
