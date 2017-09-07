package com.cart.dao.impl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cart.dao.ChargeDAO;
import com.cart.entity.ChargeInfo;
import com.cart.model.ChargeInfoModel;


@Transactional
public class ChargeDAOImpl implements ChargeDAO{

	 @Autowired
	    private SessionFactory sessionFactory;

	@Override
	public ChargeInfo findCharge(String id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(ChargeInfo.class);
		crit.add(Restrictions.eq("id", id));
		return (ChargeInfo)crit.uniqueResult();
	}

	@Override
	public void saveCharge(ChargeInfoModel charge) {
		ChargeInfo chargeInfo =new ChargeInfo();
		 chargeInfo.setId(charge.getId());
		 chargeInfo.setAmount(charge.getAmount());
		 chargeInfo.setCreateDate(charge.getCreateDate());
		 chargeInfo.setObject(charge.getObject());
		 this.sessionFactory.getCurrentSession().persist(chargeInfo);
		 this.sessionFactory.getCurrentSession().flush();
		 
		
	}
}