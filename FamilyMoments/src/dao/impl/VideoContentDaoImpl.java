package dao.impl;

import org.springframework.transaction.annotation.Transactional;

import dao.VideoContentDao;
import domain.VideoContent;
@Transactional
public class VideoContentDaoImpl extends BaseDaoImpl<VideoContent> implements VideoContentDao{

}
