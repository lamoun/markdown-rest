$( document ).ready(function() {

    var $source = $("#source");
    var $result = $("#result");

    var $submit = $("#submit");
    var $reset = $("#reset");

    var $errorBox = $("#errorBox");

    $reset.click(function () {
        $errorBox.hide();
    });

    $submit.click(function (e) {
        e.preventDefault();

        $.ajax({
            type: "POST",
            contentType: 'text/html',
            url: CONTEXT + "/convert",
            data: $source.val(),
            success: function (data) {
                $result.val(data);
            },
            error: function () {
                $result.val('');
                $errorBox.show();
            }
        });
    });





});