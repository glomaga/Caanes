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
import com.mpp.group.proj.model.Vaccine;


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
	
	
	private SqlParameterSource getSqlParameterByModel(Deworm Deworm, boolean isById){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		System.out.println(Deworm);	 
		if(Deworm!=null){
			paramSource.addValue("de_id", Deworm.getId());
			if(!isById)
			{
			System.out.println("interno");
			paramSource.addValue("de_id", Deworm.getId());
			//paramSource.addValue("an_id", vaccine.getAnimal().getId());
			paramSource.addValue("an_id", Deworm.getAnimal_id());
		//	paramSource.addValue("an_name", vaccine.getAnimal().getName());
			paramSource.addValue("de_date", Deworm.getDate());
			paramSource.addValue("de_name", Deworm.getName());
			paramSource.addValue("pr_id", Deworm.getDoctor_id());
		}
		}
		return paramSource;
	}
	
	private static final class DewormMapper implements RowMapper<Deworm>{
		
		public Deworm mapRow(ResultSet rs, int rowNum) throws SQLException{
			
			Deworm Deworm = new Deworm();
			Deworm.setId(rs.getInt("de_id"));
			System.out.println("Animal ID "+ rs.getInt("an_id"));
			Animal animal= new Animal();
			
			animal.setId(rs.getInt("an_id"));
			animal.setName(rs.getString("an_name"));			
			Deworm.setAnimal(animal);//animal
			
			Deworm.setDoctor_id(rs.getInt("pr_id"));//doctor
			
			Deworm.setDate(rs.getDate("de_date"));
			Deworm.setName(rs.getString("de_name"));
			
			
			System.out.println(Deworm);
			return Deworm;
		}
	}
	
	@Override
	public List<Deworm> listAllDeworm() {
		String sql="select "
		+" t_deworm.de_id,"
		+"   t_deworm.an_id,"
		+"	t_animal.an_name,"
		+"    t_deworm.pr_id,"
		+"    t_deworm.de_date,"
		+"    t_deworm.de_name "
		+" from t_deworm, t_animal where "
		+" t_animal.an_id = t_deworm.de_id "
		+ " order by de_id";
		List<Deworm> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null,false), new DewormMapper());
		return list;
	}

	@Override
	public void addDeworm(Deworm Deworm) {
		 String sql = "INSERT INTO t_deworm (an_id,pr_id,de_date,de_name)"
					+ "VALUES (:an_id,:pr_id,:de_date,:de_name)";
		
			namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Deworm,false));
		
	}

	@Override
	public void updateDeworm(Deworm Deworm) {
		//String sql = "update tbl_category set category_name =:category_name where id =:id";
		String sql = "UPDATE  t_deworm"
				+" SET an_id = :an_id,"
				+"pr_id = :pr_id, "
				+ "de_date = :de_date, "
				+"de_name=:de_name "
				+"WHERE de_id = :de_id;";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Deworm,false));
	
		
	}

	@Override
	public void deleteDeworm(int id) {
		String sql = "delete from t_deworm where de_id =:de_id";
		System.out.println(sql);
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Deworm(id),true));
	
	}

	@Override
	public Deworm findDewormById(int id) {
		//String sql="select id, category_name from tbl_category where id = " +id;
		
		String sql="select "
		+" t_deworm.de_id,"
		+"   t_deworm.an_id,"
		+"	t_animal.an_name,"
		+"    t_deworm.pr_id,"
		+"    t_deworm.de_date,"
		+"    t_deworm.de_name "
		+" from t_deworm, t_animal where "
		+" t_animal.an_id = t_deworm.de_id "
		+ " and t_deworm.de_id=" +id;
	return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Deworm(id),true), new DewormMapper());
	
	}

}
