/**
 * 
 */
package nl.rug.tdconfession.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import nl.rug.tdconfession.dao.ConfessionDao;
import nl.rug.tdconfession.domain.Confession;

/**
 * @author Georgios Digkas <digasgeo@yahoo.gr>
 *
 */
@Repository
public class ConfessionDaoImpl implements ConfessionDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(Confession confession) {
		this.sessionFactory.getCurrentSession().persist(confession);

	}

	@Override
	public void update(Confession confession) {
		this.sessionFactory.getCurrentSession().merge(confession);
	}

	@Override
	public void delete(Confession confession) {
		this.sessionFactory.getCurrentSession().delete(confession);
	}

	@Override
	public void delete(int id) {
		Confession confession = findById(id);

		if (confession != null)
			this.sessionFactory.getCurrentSession().delete(confession);
	}

	@Override
	public Confession findById(int id) {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("Confession.findById");
		query.setInteger("id", id);
		return (Confession) query.uniqueResult();
	}

	@Override
	public List<Confession> findAll() {
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("Confession.findAll");
		return (List<Confession>) query.list();
	}

}
