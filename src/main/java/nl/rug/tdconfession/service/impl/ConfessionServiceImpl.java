/**
 * 
 */
package nl.rug.tdconfession.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.rug.tdconfession.dao.ConfessionDao;
import nl.rug.tdconfession.domain.Confession;
import nl.rug.tdconfession.service.ConfessionService;

/**
 * @author Georgios Digkas <digasgeo@yahoo.gr>
 *
 */
@Service
public class ConfessionServiceImpl implements ConfessionService {

	private ConfessionDao confessionDao;

	public void setConfessionDao(ConfessionDao confessionDao) {
		this.confessionDao = confessionDao;
	}

	@Override
	@Transactional
	public void insert(Confession confession) {
		confessionDao.insert(confession);
	}

	@Override
	@Transactional
	public void update(Confession confession) {
		confessionDao.update(confession);
	}

	@Override
	@Transactional
	public void delete(Confession confession) {
		confessionDao.delete(confession);
	}

	@Override
	@Transactional
	public void delete(int id) {
		confessionDao.delete(id);
	}

	@Override
	@Transactional
	public Confession findById(int id) {
		return confessionDao.findById(id);
	}

	@Override
	@Transactional
	public List<Confession> findAll() {
		return confessionDao.findAll();
	}

}
