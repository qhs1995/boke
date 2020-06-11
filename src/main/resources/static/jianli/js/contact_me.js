$(function() {

    $("a[data-toggle=\"tab\"]").click(function(e) {
        e.preventDefault();
        $(this).tab("show");
    });

    $("#submit").click(function(e) {
        var name = $("input#name").val();
        var message = $("textarea#message").val();
        var _data = {
            'name': name,
            'content':message
        };
        $.ajax({
            type: "POST",  //提交方式
            url: "/jianli/sendEmail",
            dataType: 'json',
            async: false,
            contentType: 'application/json',
            data: JSON.stringify(_data),
            success:function(data){
                // Success message
                $('#success').html("<div class='alert alert-success'>");
                 $('#success > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                   .append("</button>");
                $('#success > .alert-success')
                    .append("<strong>"+data.msg+"</strong>");
                 $('#success > .alert-success')
                    .append('</div>');
                 //clear all fields
               $('#contactForm').trigger("reset");
            },
            error:function(e){
                     $('#success').html("<div class='alert alert-danger'>");
                     $('#success > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                        .append("</button>");
                     $('#success > .alert-danger').append("<strong>"+ "发送失败！");
                     $('#success > .alert-danger').append('</div>');
                      //clear all fields
                     $('#contactForm').trigger("reset");
            }
        });

        return false;
    });


    $("#dl").click(function() {
        var rurl = "/jianli/download";
        window.open(rurl)
    });

});


/*When clicking on Full hide fail/success boxes */
$('#name').focus(function() {
    $('#success').html('');
});
