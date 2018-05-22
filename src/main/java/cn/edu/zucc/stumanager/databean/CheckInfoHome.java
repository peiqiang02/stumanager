package cn.edu.zucc.stumanager.databean;
// Generated 2018-5-22 21:15:40 by Hibernate Tools 5.1.7.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class CheckInfo.
 * @see cn.edu.zucc.stumanager.databean.CheckInfo
 * @author Hibernate Tools
 */
public class CheckInfoHome {

	private static final Log log = LogFactory.getLog(CheckInfoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(CheckInfo transientInstance) {
		log.debug("persisting CheckInfo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CheckInfo instance) {
		log.debug("attaching dirty CheckInfo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CheckInfo instance) {
		log.debug("attaching clean CheckInfo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CheckInfo persistentInstance) {
		log.debug("deleting CheckInfo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CheckInfo merge(CheckInfo detachedInstance) {
		log.debug("merging CheckInfo instance");
		try {
			CheckInfo result = (CheckInfo) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CheckInfo findById(int id) {
		log.debug("getting CheckInfo instance with id: " + id);
		try {
			CheckInfo instance = (CheckInfo) sessionFactory.getCurrentSession()
					.get("cn.edu.zucc.stumanager.databean.CheckInfo", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CheckInfo instance) {
		log.debug("finding CheckInfo instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("cn.edu.zucc.stumanager.databean.CheckInfo").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
