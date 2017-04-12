package com.mpp.group.proj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.mpp.group.proj.model.*;


@Repository
public class AnimalDaoImp implements AnimalDao {

	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Animal animal){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(animal!=null){
			paramSource.addValue("an_id", animal.getId());
			paramSource.addValue("an_name", animal.getName());
			paramSource.addValue("an_gender", animal.getGender().toString());
			paramSource.addValue("an_neuter", (animal.isNeutered() ? 1:0));
			paramSource.addValue("an_birth", animal.getBirth());
			paramSource.addValue("an_color", animal.getColor());
			paramSource.addValue("an_deceased", animal.getDate2());
			paramSource.addValue("an_status", (animal.isStatus()?1:0));
		}
		return paramSource;
	}
	
	private static final class AnimalMapper implements RowMapper<Animal>{
		
		public Animal mapRow(ResultSet rs, int rowNum) throws SQLException{
			Animal animal = new Animal();
			animal.setId(rs.getInt("an_id"));
			animal.setName(rs.getString("an_name"));
			animal.setGender(Gender.valueOf(rs.getString("an_gender")));
			animal.setNeutered(rs.getBoolean("an_neuter"));
			animal.setBirth(rs.getDate("an_birth"));
			animal.setColor(rs.getString("an_color"));
			animal.setDeceased(rs.getDate("an_deceased"));
			animal.setStatus(rs.getBoolean("an_status"));
					
			return animal;
		}
	}
	
	
	@Override
	public List<Animal> listAllAnimal() {
		
		String sql="SELECT * FROM t_animal";
		List<Animal> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new AnimalMapper());
		return list;
		
	}

	@Override
	public void addAnimal(Animal animal) {
		
		String sql = "insert into t_animal(an_name,an_gender,an_neuter,an_birth,an_color"
				+ ",an_deceased,an_status) values(:an_name,:an_gender,:an_neuter,:an_birth,:an_color"
				+ ",:an_deceased,:an_status)";
				
		System.out.println(animal);
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(animal));
		
	}

	@Override
	public void updateAnimal(Animal animal) {
		
		String sql = "update t_animal set an_name =:an_name,"
				+ " an_gender =:an_gender"
				+ " an_neuter =:an_neuter"
				+ " an_birth =:an_birth"
				+ " an_color =:an_color"
				+ " an_deceased =:an_deceased"
				+ " an_status =:an_status"
				+ " where id =:id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(animal));
		
	}

	@Override
	public void deleteAnimal(int id) {
		
		String sql = "delete from t_animal where id =:id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Animal(id)));
		
	}

	@Override
	public Animal findAnimalById(int id) {
		String sql="select id, category_name from tbl_category where id = " +id;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Animal(id)), new AnimalMapper());
	}

}
