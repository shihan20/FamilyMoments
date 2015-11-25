package dao.impl;

import org.springframework.transaction.annotation.Transactional;

import dao.ContentDao;
import domain.Content;
@Transactional
public class ContentDaoImpl extends BaseDaoImpl<Content> implements ContentDao{

}
