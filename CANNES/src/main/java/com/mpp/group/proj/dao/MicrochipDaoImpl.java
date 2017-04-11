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

import com.mpp.group.proj.model.Microchip;

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
			//paramSource.addValue("animal", microchip.getAnimal());
			paramSource.addValue("description", microchip.getDescription());
			paramSource.addValue("brand", microchip.getBrand());
			paramSource.addValue("implantDate", microchip.getImplantDate());
			paramSource.addValue("implantSite", microchip.getImplantSite());
			
		}
		return paramSource;
	}
	
	private static final class MicrochipMapper implements RowMapper<Microchip>{
		
		public Microchip mapRow(ResultSet rs, int rowNum) throws SQLException{
			Microchip microchip = new Microchip();
			microchip.setId(rs.getInt("id"));
			//microchip.setAnimal(rs.getInt(columnLabel)"animal"));
			microchip.setDescription(rs.getString("description"));
			microchip.setBrand(rs.getString("brand"));
			microchip.setImplantDate(rs.getDate("implantdate").toLocalDate());
			//microchip.setImplantSite(rs.getString("implantSite"));
			return microchip;
		}
	}
	
	public List<Microchip> listAllMicrochip() {
		String sql="select id, category_name from tbl_category order by id";
		List<Microchip> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new MicrochipMapper());
		return list;
	}

	public void addMicrochip(Microchip microchip) {
		String sql = "insert into tbl_category(category_name)"
				+ " values(:category_name)";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(microchip));
	}

	public void updateMicrochip(Microchip microchip) {
		String sql = "update tbl_category set category_name =:category_name where id =:id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(microchip));
	}

	public void deleteMicrochip(int id) {
		String sql = "delete from tbl_category where id =:id";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new Categories(id)));
	}

	public Microchip findMicrochipById(int id) {
		String sql="select id, category_name from tbl_category where id = " +id;
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Categories(id)), new CategoryMapper());
	}


}
