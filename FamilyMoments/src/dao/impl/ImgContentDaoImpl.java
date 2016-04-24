package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.ImgContentDao;
import domain.ImgContent;

@Repository
@Transactional
public class ImgContentDaoImpl extends BaseDaoImpl<ImgContent> implements ImgContentDao{

}
