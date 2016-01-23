/**
 * 
 */
package nl.rug.tdconfession.dao;

import java.util.List;

import nl.rug.tdconfession.domain.Confession;

/**
 * @author Georgios Digkas <digasgeo@yahoo.gr>
 *
 */
public interface ConfessionDao {
	
	void insert(Confession confession);
	void update(Confession confession);
	void delete(Confession confession);
	void delete(int id);
	Confession findById(int id);
	List<Confession> findAll();

}
