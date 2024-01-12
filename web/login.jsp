<%-- 
    Document   : login
    Created on : Nov 3, 2023, 9:09:55 PM
    Author     : mybos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <meta charset="UTF-8">

        <link rel="stylesheet" type="text/css" href="assets/css/loginCSS.css">
        <!--===============================================================================================-->
    </head>

    <body>
        <br><br><br><br><br><br><br><br><br><br><br><br>
        <div class="cont">
            <form class="form-signin" action="login" method="post">
                <div class="form sign-in">
                    <h2>Welcome</h2>
                    <br>
                    <label>
                        <span>Username</span>
                        <input type="user" name="user" />
                    </label>
                    <label>
                        <span>Password</span>
                        <input type="password" name="password"/>
                    </label>

                    <label>
                        <div class="alert alert-danger" role="alert">
                            <p>${mess}</p>
                        </div>
                    </label>

                    <button type="submit" class="submit">Sign In</button>

                </div>
            </form>
            <form action="signup" method="post" class="form-signup">
                <div class="sub-cont">
                    <div class="img">
                        <div class="img__text m--up">
                            <h3>Don't have an account? Please Sign up!<h3>
                                    </div>
                                    <div class="img__text m--in">
                                        <h3>If you already has an account, just sign in.<h3>
                                                </div>
                                                <div class="img__btn">
                                                    <span class="m--up">Sign Up</span>
                                                    <span class="m--in">Sign In</span>
                                                </div>
                                                </div>
                                                <div class="form sign-up">
                                                    <h2>Create your Account</h2>
                                                    <label>
                                                        <span>Username</span>
                                                        <input type="text" id="user-name" />
                                                    </label>
                                                    <label>
                                                        <span>Email</span>
                                                        <input type="email" id="user-email" />
                                                    </label>
                                                    <label>
                                                        <span>Password</span>
                                                        <input type="password" id="user-password" />
                                                    </label>
                                                    <button type="submit" class="submit">Sign Up</button>
                                                </div>
                                                </div>
                                                </form>
                                                </div>

                                                <script>
                                                    document.querySelector('.img__btn').addEventListener('click', function () {
                                                        document.querySelector('.cont').classList.toggle('s--signup');
                                                    });

                                                    function toggleResetPswd(e) {
                                                        e.preventDefault();
                                                        $('#logreg-forms .form-signin').toggle(); // display:block or none
                                                        $('#logreg-forms .form-reset').toggle(); // display:block or none
                                                    }

                                                    function toggleSignUp(e) {
                                                        e.preventDefault();
                                                        $('#logreg-forms .form-signin').toggle(); // display:block or none
                                                        $('#logreg-forms .form-signup').toggle(); // display:block or none
                                                    }

                                                    $(() => {
                                                        // Login Register Form
                                                        $('#logreg-forms #forgot_pswd').click(toggleResetPswd);
                                                        $('#logreg-forms #cancel_reset').click(toggleResetPswd);
                                                        $('#logreg-forms #btn-signup').click(toggleSignUp);
                                                        $('#logreg-forms #cancel_signup').click(toggleSignUp);
                                                    });
                                                </script>
                                                 </body>
                                                </html>