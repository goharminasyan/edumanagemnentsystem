function PopUpShowMonday() {
    $("#popup-container-monday").show();
    $("#main-wrapper").css("-webkit-filter", "blur(10px)");
    $("#header").css("-webkit-filter", "blur(10px)");
    $("#header").css("pointer-events", "none");
    $("#main-wrapper").css("pointer-events", "none");
    $("#header").css("pointer-events", "none");
    $("#show-btn").css("pointer-events", "none");
    $("#show-btn").css("-webkit-filter", "blur(10px)");
}

function PopUpShowTuesday() {
    $("#popup-container-tuesday").show();
    document.getElementById("demo").innerHTML = document.getElementById("tuesday").
    getElementsByTagName("a").item(0).text;;
    $("#main-wrapper").css("-webkit-filter", "blur(10px)");
    $("#header").css("-webkit-filter", "blur(10px)");
    $("#main-wrapper").css("pointer-events", "none");
    $("#header").css("pointer-events", "none");
    $("#show-btn").css("pointer-events", "none");
    $("#show-btn").css("-webkit-filter", "blur(10px)");
}

function PopUpShowWednesday() {
    $("#popup-container-wednesday").show();
    document.getElementById("demo").innerHTML = document.getElementById("tuesday").
    getElementsByTagName("a").item(0).text;;
    $("#main-wrapper").css("-webkit-filter", "blur(10px)");
    $("#header").css("-webkit-filter", "blur(10px)");
    $("#main-wrapper").css("pointer-events", "none");
    $("#header").css("pointer-events", "none");
    $("#show-btn").css("pointer-events", "none");
    $("#show-btn").css("-webkit-filter", "blur(10px)");
}

function PopUpShowThursday() {
    $("#popup-container-thursday").show();
    document.getElementById("demo").innerHTML = document.getElementById("tuesday").
    getElementsByTagName("a").item(0).text;;
    $("#main-wrapper").css("-webkit-filter", "blur(10px)");
    $("#header").css("-webkit-filter", "blur(10px)");
    $("#main-wrapper").css("pointer-events", "none");
    $("#header").css("pointer-events", "none");
    $("#show-btn").css("pointer-events", "none");
    $("#show-btn").css("-webkit-filter", "blur(10px)");
}

function PopUpShowFriday() {
    $("#popup-container-friday").show();
    document.getElementById("demo").innerHTML = document.getElementById("tuesday").
    getElementsByTagName("a").item(0).text;;
    $("#main-wrapper").css("-webkit-filter", "blur(10px)");
    $("#header").css("-webkit-filter", "blur(10px)");
    $("#main-wrapper").css("pointer-events", "none");
    $("#header").css("pointer-events", "none");
    $("#show-btn").css("pointer-events", "none");
    $("#show-btn").css("-webkit-filter", "blur(10px)");
}

function PopUpShowSaturday() {
    $("#popup-container-saturday").show();
    document.getElementById("demo").innerHTML = document.getElementById("tuesday").
    getElementsByTagName("a").item(0).text;;
    $("#main-wrapper").css("-webkit-filter", "blur(10px)");
    $("#header").css("-webkit-filter", "blur(10px)");
    $("#main-wrapper").css("pointer-events", "none");
    $("#header").css("pointer-events", "none");
    $("#show-btn").css("pointer-events", "none");
    $("#show-btn").css("-webkit-filter", "blur(10px)");
}

function PopUpShowSunday() {
    $("#popup-container-sunday").show();
    document.getElementById("demo").innerHTML = document.getElementById("tuesday").
    getElementsByTagName("a").item(0).text;;
    $("#main-wrapper").css("-webkit-filter", "blur(10px)");
    $("#header").css("-webkit-filter", "blur(10px)");
    $("#main-wrapper").css("pointer-events", "none");
    $("#header").css("pointer-events", "none");
    $("#show-btn").css("pointer-events", "none");
    $("#show-btn").css("-webkit-filter", "blur(10px)");
}

function PopUpHide() {
    window.location.href = $("#tab").text();
    $("#main-wrapper").css("-webkit-filter", "blur(0px)");
    $("#header").css("-webkit-filter", "blur(0px)");
    $("#main-wrapper").css("pointer-events", "auto");
    $("#header").css("pointer-events", "auto");
    $("#show-btn").css("pointer-events", "auto");
    $("#show-btn").css("-webkit-filter", "blur(0px)");
}

function deleteItem(){
    var value = document.getElementById("delete").value;
}

function add() {

}