$(document).ready(function () {
    if (!localStorage.getItem("mode")) {
        if (window.matchMedia("(prefers-color-scheme: dark)").matches) {
            localStorage.setItem("mode", "dark");
        } else {
            localStorage.setItem("mode", "light");
        }
    }

    //set interface to match localStorage
    if (localStorage.getItem("mode") === "dark") {
        $("html").addClass("dark");
        $("html").removeClass("light");
        $("#theme-toggle-light-icon").removeClass("hidden");
        document.getElementById("theme-toggle").checked = true;
    } else {
        $("html").removeClass("dark");
        $("html").addClass("light");
        $("#theme-toggle-dark-icon").removeClass("hidden");
        document.getElementById("theme-toggle").checked = false;
    }

    //add toggle
    $("#theme-toggle").on("click", function () {
        if ($("html").hasClass("dark")) {
            $("html").removeClass("dark");
            $("html").addClass("light");
            $("#theme-toggle-light-icon").addClass("hidden");
            $("#theme-toggle-dark-icon").removeClass("hidden");
            localStorage.setItem("mode", "light");
        } else {
            $("html").addClass("dark");
            $("html").removeClass("light");
            $("#theme-toggle-dark-icon").addClass("hidden");
            $("#theme-toggle-light-icon").removeClass("hidden");
            localStorage.setItem("mode", "dark");
        }
    });
});