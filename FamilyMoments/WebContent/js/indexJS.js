/**
 * Created by shihan on 12/19/15.
 */
var currPage = 0;
var flag = 0;
$(document).ready(function(){
    $.getJSON("/FamilyMoments/GetTimelineAction?page="+currPage.toString(), function(result){
        generate(result, "Henry");
    });
    currPage++;
});
$(function(){
    $(window).scroll(function() {
        //当内容滚动到底部时加载新的内容
        if ($(this).scrollTop() + $(window).height() + 20 >= $(document).height() && $(this).scrollTop() > 20) {
            //当前要加载的页码
            if (flag == 1)
                return;
            loadPage(currPage);
            currPage++;
        }
    });
});
function loadPage(currPage) {
    $.getJSON("/FamilyMoments/GetTimelineAction?page="+currPage.toString(), function(result){
        var json = JSON.parse(result);
        if (json.length<10)
            flag=1;
        generate(result, "Henry");
    });
}
function checkUpdateTextIsEmpty() {
    var text = document.getElementById("updateText").value;
    if (text == "") {
        return false;
    }
}
function like(id) {
    //alert("hit like!");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                generateLikes(JSON.parse(xhr.responseText), id, "Henry");
            }
        }
    };
    if (document.getElementById("button_like_"+id).firstElementChild.className == "glyphicon glyphicon-heart") {
        xhr.open("get", "/FamilyMoments/LikeAction?cancel=1&userid=1&postid="+id, true)
    }
    else {
        xhr.open("get", "/FamilyMoments/LikeAction?cancel=0&userid=1&postid="+id, true);
    }
    xhr.send(null);
}