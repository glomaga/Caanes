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
		
		if(vaccine!=null){
			paramSource.addValue("id", vaccine.getId());
			paramSource.addValue("animal", vaccine.getAnimal_id());
			paramSource.addValue("date", vaccine.getDate());
			paramSource.addValue("name", vaccine.getName());
			paramSource.addValue("Batch", vaccine.getBatch());
			paramSource.addValue("doctor", vaccine.getDoctor_id());
		}
		return paramSource;
	}
	
	private static final class VaccineMapper implements RowMapper<Vaccine>{
		
		public Vaccine mapRow(ResultSet rs, int rowNum) throws SQLException{
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
			 
			Vaccine vaccine = new Vaccine();
			vaccine.setId(rs.getInt("va_id"));
			vaccine.setAnimal_id(rs.getInt("an_id"));//animal
			vaccine.setDoctor_id(rs.getInt("pr_id"));//doctor
			try {
				vaccine.setDate(format.parse(rs.getString("va_date")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}///aqui es localdate
			
			vaccine.setName(rs.getString("va_name"));
			vaccine.setBatch(rs.getString("va_batch"));

			
			return vaccine;
		}
	}
	
	
	@Override
	public List<Vaccine> listAllVaccine() {
		String sql="SELECT mr_id,mr_description,im_id,mr_brand,mr_date FROM t_microchip order by mr_id";
		List<Vaccine> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new VaccineMapper());
		return list;
	}

	@Override
	public void addVaccine(Vaccine Vaccine) {

		 String sql = "INSERT INTO t_microchip (mr_description,im_id,mr_brand)"
				+ "VALUES (:description,:implantSite,:brand)";
	
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Vaccine));
	
	}

	@Override
	public void updateVaccine(Vaccine Vaccine) {
		// TODO Auto-generated method stub
		//String sql = "update tbl_category set category_name =:category_name where id =:id";
		String sql = "UPDATE  t_microchip SET mr_description = :description, im_id = :implantSite, mr_brand = :brand WHERE mr_id = :id;";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(Vaccine));
	
	}

	@Override
	public void deleteVaccine(int id) {
		String sql = "delete from t_microchip where mr_id =:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Vaccine(id)));
		
	}

	@Override
	public Vaccine findVaccineById(int id) {
		//String sql="select id, category_name from tbl_category where id = " +id;
		String sql="SELECT mr_id,mr_description,im_id,mr_brand,mr_date FROM t_microchip where mr_id=" +id;;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Vaccine(id)), new VaccineMapper());
	
	}

}
