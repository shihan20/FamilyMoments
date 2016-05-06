package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.ContentDao;
import domain.Content;

@Repository
@Transactional
public class ContentDaoImpl extends BaseDaoImpl<Content> implements ContentDao{

}
