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

        <script src="js/generatePost.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/indexJS.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
    </head>
    <body style="background-color:rgb(245,248,250);">
        <div class="container">
            <div class="row">
                <div id="posts" class="col-md-6 col-sm-12 col-xs-12">
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
                                    <img src="img/profile_picture_1.jpg" alt="Responsive image" class="img-circle img-responsive">
                                </div>
                                <div class="col-md-10 col-sm-10 col-xs-10">
                                <s:form onsubmit="return checkUpdateTextIsEmpty()" action="UpdateTextAction">
                                    <div class="row"><s:textarea name="text" id="updateText" class="form-control" placeholder="分享新鲜事"></s:textarea></div>
                                    <div class="row"><input type="submit" id="post" value="发布"  class="btn btn-primary"/></div>
                                </s:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </body>
</html>
