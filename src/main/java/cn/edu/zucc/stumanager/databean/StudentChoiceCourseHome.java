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
 * Home object for domain model class StudentChoiceCourse.
 * @see cn.edu.zucc.stumanager.databean.StudentChoiceCourse
 * @author Hibernate Tools
 */
public class StudentChoiceCourseHome {

	private static final Log log = LogFactory.getLog(StudentChoiceCourseHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(StudentChoiceCourse transientInstance) {
		log.debug("persisting StudentChoiceCourse instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StudentChoiceCourse instance) {
		log.debug("attaching dirty StudentChoiceCourse instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudentChoiceCourse instance) {
		log.debug("attaching clean StudentChoiceCourse instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StudentChoiceCourse persistentInstance) {
		log.debug("deleting StudentChoiceCourse instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudentChoiceCourse merge(StudentChoiceCourse detachedInstance) {
		log.debug("merging StudentChoiceCourse instance");
		try {
			StudentChoiceCourse result = (StudentChoiceCourse) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StudentChoiceCourse findById(java.lang.Integer id) {
		log.debug("getting StudentChoiceCourse instance with id: " + id);
		try {
			StudentChoiceCourse instance = (StudentChoiceCourse) sessionFactory.getCurrentSession()
					.get("cn.edu.zucc.stumanager.databean.StudentChoiceCourse", id);
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

	public List findByExample(StudentChoiceCourse instance) {
		log.debug("finding StudentChoiceCourse instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("cn.edu.zucc.stumanager.databean.StudentChoiceCourse").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
