//
//$(document).ready(function () {
//
//    $("#load").click(function () {
//        $("#loader").show();
//        $.ajax({
//            type: "GET",
//            url: "/home/cards",
//            dataType: "json",
//            data: {
//                cnum: 0//$("input[name=n]").val()
//            },
//            success: function (data) {
//                $.each(data, function (index, item) {
//                    $("#posts").append("<div id=card-body " + index + " class='cards' style='margin: 15px 5px 25px 5px ;'>"
//                            + data[index] + data[index] + data[index] + data[index] + data[index] + "</div>");
//                });
//            },
//
//            complete: function () {
//                $("#loader").hide();
//            }
//        });
//
//    });
//});


$(window).scroll(function () {
    if ($(window).scrollTop() === $(document).height() - $(window).height())
    {
        AddCard();
    }
});

$(document).ready(function () {
    $('#loginForm').validate({// initialize the plugin
        rules: {
            field1: {
                required: true,
                
            },
            field2: {
                required: true,
                minlength: 5
            }
        }
    });
});

function AddCard() {
    $.ajax({
        type: "GET",
        url: "/home/cards",
        dataType: "json",
        data: {
            cnum: 0//$("input[name=n]").val()
        },
        success: function (data) {
            $.each(data, function (index, item) {
                $("#posts").append("<div id=card-body " + index + " class='cards' style='margin: 15px 5px 25px 5px ;'>"
                        + data[index] + data[index] + data[index] + data[index] + data[index] + "</div>");
            });
        },

        complete: function () {
            //$("#loader").hide();
        }
    });
}

function isUsernameAvailable() {

    $.ajax({
        type: "GET",
        url: "/user/username-available",
        data: {
            username: $("#username").val()
        },
        success: function (response) {
            if (response === "false") {

                return true;
            } else {
                $("#username").addClass("btn-danger");
            }
        }
    });
    return false;

}

function loginFormValidator() {
    var username = $("#uname").val();
    console.log(validateUsername(username));
    return validateUsername(username);
}

function signupFormValidator() {
    var username = $("#username").val();
    return validateUsername(username);
}

function validateUsername(username) {
    var regex = /^[a-zA-Z0-9]+$/;
    return regex.match(username);
}
