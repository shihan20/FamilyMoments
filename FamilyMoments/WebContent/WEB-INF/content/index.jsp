<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jasny-bootstrap.css" rel="stylesheet">
        <script src="js/jquery-1.11.3.min.js"></script>
        <script src="js/jasny-bootstrap.min.js"></script>
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
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li role="presentation" class="active"><a href="#texttab" aria-controls="texttab" role="tab" data-toggle="tab" >发布状态</a></li>
                                        <li role="presentation"><a href="#imgtab" aria-controls="imgtab" role="tab" data-toggle="tab">添加照片/视频</a></li>
                                    </ul>
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane fade in active" id="texttab">
                                            <div class="row" style="padding:5px">
                                                <div class="col-xs-2">
                                                    <img src="img/profile_picture_1.jpg" alt="Responsive image" class="img-circle img-responsive">
                                                </div>
                                                    <form class="col-md-10 col-sm-10 col-xs-10" onsubmit="return checkUpdateTextIsEmpty()" action="updateText" method="post">
                                                        <div class="row">
                                                            <div class="col-xs-12">
                                                                <textarea name="text" class="form-control" id="updateText" placeholder="分享新鲜事"></textarea>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-xs-2 col-xs-offset-9">
                                                                <input type="submit" value="发布"  class="btn btn-primary"/>
                                                            </div>
                                                        </div>
                                                    </form>
                                            </div>
                                        </div>
                                        <div role="tabpanel" class="tab-pane fade" id="imgtab">
                                            <div class="row" style="padding:5px">
                                                <div class="col-xs-2">
                                                    <img src="img/profile_picture_1.jpg" alt="Responsive image" class="img-circle img-responsive">
                                                </div>
                                                <div class="col-md-10 col-sm-10 col-xs-10">

                                                    <form action="updateImg" enctype="multipart/form-data" method="post">
                                                    <div class="row">
                                                        <div class="col-xs-12">
                                                                <div class="row"><textarea name="text" class="form-control" placeholder="分享新鲜事"></textarea></div>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="fileinput fileinput-new" data-provides="fileinput">
                                                            <div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
                                                                <img data-src="holder.js/100%x100%" alt="image">
                                                            </div>
                                                            <div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
                                                            <div>
                                                                <span class="btn btn-default btn-file"><span class="fileinput-new">Select image</span><span class="fileinput-exists">Change</span><input type="file" name="uploadPic" accept="image/gif, image/png, image/jpeg"></span>
                                                                <a href="#" class="btn btn-default fileinput-exists" data-dismiss="fileinput">Remove</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                        <div class="row">
                                                            <div class="col-xs-2 col-xs-offset-9">
                                                                <input type="submit" value="发布"  class="btn btn-primary"/>
                                                            </div>
                                                        </div>
                                                    </form>

                                                </div>
                                            </div>
                                        </div>
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
