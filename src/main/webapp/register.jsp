<html>
<body>
    <div class="bgr">
        <form action="<%=request.getContextPath()%>/register" method="POST">
        <div class="container">
            <div class="row">
                <div class="col" style="width: 100px;">
                    <b>User Name</b>
                </div>

                <div class="col">
                <input type="text" placeholder="username" name="username" required>
                </div>
            </div>
            
            <div class="row">
               <div class="col" style="width: 100px;">
                    <b>Password</b>
                </div>

                <div class="col">
                <input type="password" placeholder="password" name="password" required>
                </div>

            </div>
            <div class="row">
               <div class="col" style="width: 100px;">
                    <b>Email</b>
                </div>

                <div class="col">
                <input type="text" placeholder="email" name="email" required>
                </div>

            </div>
            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <button type="submit">Login</button>
                </div>
            </div>
        </div>
        </form>
    </div>
</body>
</html>


