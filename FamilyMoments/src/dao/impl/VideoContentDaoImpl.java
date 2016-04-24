package dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.VideoContentDao;
import domain.VideoContent;

@Repository
@Transactional
public class VideoContentDaoImpl extends BaseDaoImpl<VideoContent> implements VideoContentDao{

}
