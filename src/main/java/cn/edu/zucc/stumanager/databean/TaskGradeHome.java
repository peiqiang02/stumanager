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
 * Home object for domain model class TaskGrade.
 * @see cn.edu.zucc.stumanager.databean.TaskGrade
 * @author Hibernate Tools
 */
public class TaskGradeHome {

	private static final Log log = LogFactory.getLog(TaskGradeHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TaskGrade transientInstance) {
		log.debug("persisting TaskGrade instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TaskGrade instance) {
		log.debug("attaching dirty TaskGrade instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TaskGrade instance) {
		log.debug("attaching clean TaskGrade instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TaskGrade persistentInstance) {
		log.debug("deleting TaskGrade instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TaskGrade merge(TaskGrade detachedInstance) {
		log.debug("merging TaskGrade instance");
		try {
			TaskGrade result = (TaskGrade) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TaskGrade findById(java.lang.Integer id) {
		log.debug("getting TaskGrade instance with id: " + id);
		try {
			TaskGrade instance = (TaskGrade) sessionFactory.getCurrentSession()
					.get("cn.edu.zucc.stumanager.databean.TaskGrade", id);
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

	public List findByExample(TaskGrade instance) {
		log.debug("finding TaskGrade instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("cn.edu.zucc.stumanager.databean.TaskGrade").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
