$("#password, #confirm_password").on("keyup", function () {
  if ($("#newPassword").val() == $("#confirmPassword").val()) {
    $("#message").html("Matching").css("color", "green");
  } else $("#message").html("Not Matching").css("color", "red");
});
