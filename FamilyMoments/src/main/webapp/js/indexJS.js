/**
 * Created by shihan on 12/19/15.
 */
var currPage = 0;
var flag = 0;
$(document).ready(function(){
    $.getJSON("getTimeline?page="+currPage.toString(), function(result){
        generate(result, "Henry");
    });
    currPage++;
});
$(function(){
    $(window).scroll(function() {
        //when the page is scrolling down to the bottom, loading more contents
        if ($(this).scrollTop() + $(window).height() + 20 >= $(document).height() && $(this).scrollTop() > 20) {
            //the page is loading
            if (flag == 1)
                return;
            loadPage(currPage);
            currPage++;
        }
    });
});

function loadPage(currPage) {
    $.getJSON("getTimeline?page="+currPage.toString(), function(result){
        var json = result;
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
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                generateLikes(JSON.parse(xhr.responseText), id, "Henry");
            }
        }
    };
    if (document.getElementById("button_like_"+id).firstElementChild.className == "glyphicon glyphicon-heart") {
        xhr.open("get", "like?cancel=1&userid=1&postid="+id, true)
    }
    else {
        xhr.open("get", "like?cancel=0&userid=1&postid="+id, true);
    }
    xhr.send(null);
}

$('#img-tab').click(function (e) {
    e.preventDefault()
    $(this).tab('show')
})

$('#text-tab').click(function (e) {
    e.preventDefault()
    $(this).tab('show')
})
