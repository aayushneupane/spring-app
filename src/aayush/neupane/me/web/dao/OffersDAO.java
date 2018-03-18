package aayush.neupane.me.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component("OffersDAO")
public class OffersDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	
	//@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers(){
		
		String sql = "select * from offers";
		
		return jdbc.query(sql, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				return offer;
			}
			
		});
	}
	
	public Offer getOffer(int id){
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		String sql = "select * from offers where id = :id";
		
		return jdbc.queryForObject(sql, params, new RowMapper<Offer>() {
			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				return offer;
			}
			
		});
	}
	
	public boolean deleteOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		String sql = "delete from offers where id = :id";
		
		return jdbc.update(sql, params) == 1;
	}
	
	public boolean createOffer(Offer offer) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);	
		String sql = "insert into offers (name, email, text) values (:name, :email, :text)";
			
		return jdbc.update(sql, params) == 1;
	}
	
	public boolean updateOffer(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);	
		String sql = "update offers set name=:name, email=:email, text=:text where id = :id";
		
		return jdbc.update(sql, params) == 1;
	}
	
	@Transactional
	public int[] createOffer(List<Offer> offers) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		String sql = "insert into offers (id, name, email, text) values (:id, :name, :email, :text)";
		return jdbc.batchUpdate(sql, params);
	}
	
	

}
