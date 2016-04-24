
function generate(json, username) {
	var posts = json;
	for (var i=0; i<posts.length; i++) {
	    var post = posts[i];
	    var date = processDate(new Date(post.date));
        
        var html = "<div id=\"post_" + post.id + "\" class=\"panel panel-default\">\
                        <div class=\"panel-body\">\
                            <div class=\"row\" style=\"padding:5px\">\
                                <div class=\"col-xs-2\">\
                                    <img src=\"" + post.publisher_profile_picture + "\" alt=\"Responsive image\" class=\"img-circle img-responsive\">\
                                </div>\
                                <div class=\"col-xs-10\">\
                                    <div class=\"row\">\
                                        <div class=\"col-xs-12\">" +
                                            post.publisher_name +
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
                                    post.text +
                                    "</div>\
                                    </div>"
        if (post.image != null) {
            html += "<div class=\"row\" style=\"padding:5px 5px 0px 5px\">\
                                <div class=\"col-xs-12\">" +
                    "<img src=\"" + post.image + "\" class=\"img-thumbnail\">\
                </div>\
                </div>"
        }
        html += "<div class=\"row\" style=\"padding:5px\">\
                                        <div class=\"col-xs-2\">\
                                            <button type=\"button\" id=\"button_like_" + post.id + "\" onclick=\"like(" + post.id + ")\" class=\"btn btn-default btn-sm\" aria-label=\"Left Align\" style=\"border:0px\">\
                                                <span class=\"glyphicon glyphicon-heart-empty\"></span>\
                                                赞\
                                            </button>\
                                        </div>\
                                        <div class=\"col-xs-2\">\
                                            <button type=\"button\" class=\"btn btn-default btn-sm\" aria-label=\"Left Align\" style=\"border:0px\">\
                                                <span class=\"glyphicon glyphicon-comment\"></span>\
                                                评论\
                                            </button>\
                                        </div>\
                                    </div>"
        $("#posts").append(html);

        if (post.likes != "[]") {
            generateLikes(post.likes, post.id, username);
        }
        //alert(document.getElementById("post_41").firstElementChild.childElementCount);
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
				if (minutes <= 1)
					return "just ago";
				else
					return minutes + " minutes ago";
			}
		}
}

function generateLikes(json_likes, postid, username) {
    var element = document.getElementById("post_"+postid).firstElementChild;

    if (document.getElementById("line_"+postid) == null) {
        var div_line_row = document.createElement("div");
        div_line_row.id = "line_"+postid;
        div_line_row.className="row";
        var div_line_col = document.createElement("div");
        div_line_col.className="col-xs-12";
        div_line_col.setAttribute("style", "border:1px solid #eee;");
        div_line_row.appendChild(div_line_col);
        element.appendChild(div_line_row);
    }

    if (document.getElementById("likes_"+postid) == null){
        var div_likes_row = document.createElement("div");
        div_likes_row.id = "likes_"+postid;
        div_likes_row.className="row";
        div_likes_row.setAttribute("style", "padding:5px");
        element.appendChild(div_likes_row);
        var div_likes_col = document.createElement("div");
        div_likes_col.className = "col-xs-12";
        div_likes_row.appendChild(div_likes_col);
    }

    var likes = json_likes;

    var string = "";
    var FLAG_I_LIKE_THIS = false;
    for (var i=0; i<likes.length; i++) {
        if (likes[i].username == username) {
            FLAG_I_LIKE_THIS = true;
            document.getElementById("button_like_" + postid).innerHTML = "\<span class=\"glyphicon glyphicon-heart\"></span>\
                    取消";
        }
        if (i != 0) {
            string = string + ", ";
        }
        string = string + likes[i].username;
    }
    if (FLAG_I_LIKE_THIS == false) {
        document.getElementById("button_like_" + postid).innerHTML = "\<span class=\"glyphicon glyphicon-heart-empty\"></span>\
                    赞";
    }
    string = string + " like this";
    var ele = document.getElementById("likes_"+postid).firstElementChild.firstChild;
    if (ele == null)
        document.getElementById("likes_"+postid).firstElementChild.appendChild(document.createTextNode(string));
    else
        document.getElementById("likes_"+postid).firstElementChild.replaceChild(document.createTextNode(string), ele)

    if (likes.length == 0) {
        element.removeChild(element.lastChild);
        element.removeChild(element.lastChild);
    }
}