
function generate(json) {
	var posts = JSON.parse(json);
	for (var i=0; i<posts.length; i++) {
	var post = posts[i];
	var date = processDate(new Date(post.date));
    var html = "<div class=\"panel panel-default\">\
                        <div class=\"panel-body\">\
                            <div class=\"row\" style=\"padding:5px\">\
                                <div class=\"col-xs-2\">\
                                    <img src=\"img/photo.jpg\" alt=\"Responsive image\" class=\"img-circle img-responsive\">\
                                </div>\
                                <div class=\"col-xs-10\">\
                                    <div class=\"row\">\
                                        <div class=\"col-xs-12\">" +
                                            post.publisher +
                                        "</div>\
                                    </div>\
                                    <div class=\"row\">\
                                        <div class=\"col-xs-12\">" + 
                                            date +
                                        "</div>\
                                    </div>\
                                </div>\
                            </div>\
                            <div class=\"row\" style=\"padding:5px 5px 0px 5px\">\
                                <div class=\"col-xs-12\">" +
                                    post.text;
                                "</div>\
                            </div>\
                            <div class=\"row\" style=\"padding:5px\">\
                                <div class=\"col-xs-2\">\
                                    <button type=\"button\" class=\"btn btn-default btn-sm\" aria-label=\"Left Align\" style=\"border:0px\">\
                                        <span class=\"glyphicon glyphicon-thumbs-up\"></span>\
                                        赞\
                                    </button>\
                                </div>\
                                <div class=\"col-xs-2\">\
                                    <button type=\"button\" class=\"btn btn-default btn-sm\" aria-label=\"Left Align\" style=\"border:0px\">\
                                        <span class=\"glyphicon glyphicon-comment\"></span>\
                                        评论\
                                    </button>\
                                </div>\
                            </div>\
                            <div class=\"row\">\
                                <div class=\"col-xs-12\" style=\"border:1px solid #eee;\">\
                                </div>\
                            </div>\
                            <div class=\"row\" style=\"padding:5px\">\
                            	<div class=\"col-xs-12\">\
                            		崔勇带 赞了\
                            	</div>\
                            </div>\
                            <div class=\"row\" style=\"padding:5px\">\
                            	<div class=\"col-xs-12\">\
                            		<div class=\"row\">\
                            			<div class=\"col-xs-12\">\
                            				崔勇带：哈哈哈哈\
                            			</div>\
                            		</div>\
                            		<div class=\"row\">\
                            			<div class=\"col-xs-12\">\
                            				施涵 @ 崔勇带：傻逼\
                            			</div>\
                            		</div>\
                            	</div>\
                            </div>\
                         </div>\
                    </div>"
	$("#posts").append(html);
	}
}

function processDate(date) {
	var currentDate = new Date().getTime();
	var timeDifference = currentDate - date;
	//计算出相差天数  
	var days=Math.floor(timeDifference/(24*3600*1000))  
	//计算出小时数  
	var leave1=timeDifference%(24*3600*1000)    //计算天数后剩余的毫秒数  
	var hours=Math.floor(leave1/(3600*1000))  
	//计算相差分钟数  	
	var leave2=leave1%(3600*1000)        //计算小时数后剩余的毫秒数  
	var minutes=Math.floor(leave2/(60*1000))  
		if (days >= 1) {
			return date.toLocaleString();
		}
		else {
			if (hours >= 1) {
				return hours + " hours ago";
			}
			else {
				return minutes + " minutes ago";
			}
		}
}

