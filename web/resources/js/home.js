
$(document).ready(function () {

    $("#load").click(function () {
        $("#loader").show();
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
                $("#loader").hide();
            }
        });

    });
});
