<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet">
        <script src="js/jquery-1.11.3.min.js"></script>    
        <script src="js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-12 col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row" style="padding:5px">
                                <div class="col-xs-12">
                                    <ul class="nav nav-tabs">
                                        <li role="presentation" class="active"><a href="#">发布状态</a></li>
                                        <li role="presentation"><a href="#">添加照片/视频</a></li>
                                    </ul>
                                </div>
                            </div> 
                            <div class="row" style="padding:5px">
                                <div class="col-xs-2">
                                    <img src="img/photo.jpg" alt="Responsive image" class="img-circle img-responsive">
                                </div>
                                <div class="col-md-10 col-sm-10 col-xs-10">
                                <s:form action="UpdateTextAction">
                                    <s:textarea name="text" class="form-control" placeholder="分享新鲜事"></s:textarea>
                                    <input type="submit" value="发布"  class="btn btn-primary"/>
                                </s:form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row" style="padding:5px">
                                <div class="col-xs-2">
                                    <img src="img/photo.jpg" alt="Responsive image" class="img-circle img-responsive">
                                </div>
                                <div class="col-xs-10">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            施涵
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            12 mins ago
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="padding:5px 5px 0px 5px">
                                <div class="col-xs-12">
                                    test
                                </div>
                            </div>
                            <div class="row" style="padding:5px">
                                <div class="col-xs-12">
                                    <img src="img/share_photo.jpg" alt="Responsive image" class="img-responsive">
                                </div>
                            </div>
                            <div class="row" style="padding:5px">
                                <div class="col-xs-2">
                                    <button type="button" class="btn btn-default btn-sm" aria-label="Left Align" style="border:0px">
                                        <span class="glyphicon glyphicon-thumbs-up"></span>
                                        赞
                                    </button>
                                </div>
                                <div class="col-xs-2">
                                    <button type="button" class="btn btn-default btn-sm" aria-label="Left Align" style="border:0px">
                                        <span class="glyphicon glyphicon-comment"></span>
                                        评论
                                    </button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12" style="border:1px solid #eee;">
                                </div>
                            </div>
                            <div class="row" style="padding:5px">
                            	<div class="col-xs-12">
                            		崔勇带 赞了
                            	</div>
                            </div>
                            <div class="row" style="padding:5px">
                            	<div class="col-xs-12">
                            		<div class="row">
                            			<div class="col-xs-12">
                            				崔勇带：哈哈哈哈
                            			</div>
                            		</div>
                            		<div class="row">
                            			<div class="col-xs-12">
                            				施涵 @ 崔勇带：傻逼
                            			</div>
                            		</div>
                            	</div>
                            </div>
                         </div>
                    </div>
                                       <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="row" style="padding:5px">
                                <div class="col-xs-2">
                                    <img src="img/photo.jpg" alt="Responsive image" class="img-circle img-responsive">
                                </div>
                                <div class="col-xs-10">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            施涵
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xs-12">
                                            12 mins ago
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" style="padding:5px 5px 0px 5px">
                                <div class="col-xs-12">
                                    test
                                </div>
                            </div>
                            <div class="row" style="padding:5px">
                                <div class="col-xs-12">
                                    <img src="img/share_photo.jpg" alt="Responsive image" class="img-responsive">
                                </div>
                            </div>
                            <div class="row" style="padding:5px">
                                <div class="col-xs-2">
                                    <button type="button" class="btn btn-default btn-sm" aria-label="Left Align" style="border:0px">
                                        <span class="glyphicon glyphicon-thumbs-up"></span>
                                        赞
                                    </button>
                                </div>
                                <div class="col-xs-2">
                                    <button type="button" class="btn btn-default btn-sm" aria-label="Left Align" style="border:0px">
                                        <span class="glyphicon glyphicon-comment"></span>
                                        评论
                                    </button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12" style="border:1px solid #eee;">
                                </div>
                            </div>
                            <div class="row" style="padding:5px">
                            	<div class="col-xs-12">
                            		崔勇带 赞了
                            	</div>
                            </div>
                            <div class="row" style="padding:5px">
                            	<div class="col-xs-12">
                            		<div class="row">
                            			<div class="col-xs-12">
                            				崔勇带：哈哈哈哈
                            			</div>
                            		</div>
                            		<div class="row">
                            			<div class="col-xs-12">
                            				施涵 @ 崔勇带：😪
                            			</div>
                            		</div>
                            	</div>
                            </div>
                         </div>
                    </div>
                </div>
            </div>
        </body>
</html>
