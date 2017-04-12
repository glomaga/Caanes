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

import com.mpp.group.proj.model.Microchip;

@Repository
public class MicrochipDaoImpl implements MicrochipDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	DataSource dataSource;
	

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
			throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(Microchip microchip){
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		
		if(microchip!=null){
			paramSource.addValue("id", microchip.getId());
			paramSource.addValue("description", microchip.getDescription());
			paramSource.addValue("brand", microchip.getBrand());
			paramSource.addValue("implantDate", microchip.getImplantDate());
			paramSource.addValue("implantSite", microchip.getImplantSite());
			
		}
		return paramSource;
	}
	
	private static final class MicrochipMapper implements RowMapper<Microchip>{

		
		
		public Microchip mapRow(ResultSet rs, int rowNum) throws SQLException{

			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
		
			Microchip microchip = new Microchip();
			microchip.setId(rs.getInt("mr_id"));
			microchip.setDescription(rs.getString("mr_description"));
			microchip.setBrand(rs.getString("mr_brand"));
			try {
				microchip.setImplantDate(format.parse(rs.getString("mr_date")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}///aqui es localdate
			//LocalDateTime.parse(s, DateTimeFormat.forPattern("YYYY-MM-dd HH:mm")
			microchip.setImplantSite(rs.getInt("im_id"));
			return microchip;
		}
	}
	
	public List<Microchip> listAllMicrochip() {
		//String sql="select id, category_name from tbl_category order by id";
		String sql="SELECT mr_id,mr_description,im_id,mr_brand,mr_date FROM t_microchip order by mr_id";
		List<Microchip> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new MicrochipMapper());
		return list;
	}

	public void addMicrochip(Microchip microchip) {
		//String sql = "insert into tbl_category(category_name)"
		//		+ " values(:category_name)";

		 String sql = "INSERT INTO t_microchip (mr_description,im_id,mr_brand)"
				+ "VALUES (:description,:implantSite,:brand)";
	
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(microchip));
	}

	public void updateMicrochip(Microchip microchip) {
		//String sql = "update tbl_category set category_name =:category_name where id =:id";
		String sql = "UPDATE  t_microchip SET mr_description = :description, im_id = :implantSite, mr_brand = :brand WHERE mr_id = :id;";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(microchip));
	}

	public void deleteMicrochip(int id) {
		String sql = "delete from t_microchip where mr_id =:id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Microchip(id)));
	}

	public Microchip findMicrochipById(int id) {
		//String sql="select id, category_name from tbl_category where id = " +id;
		String sql="SELECT mr_id,mr_description,im_id,mr_brand,mr_date FROM t_microchip where mr_id=" +id;;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Microchip(id)), new MicrochipMapper());
	}


}
