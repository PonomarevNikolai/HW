<html>
   <body>

      <form form action="#" th:action="@{/save}" th:object="${driver}" method = "POST">
      <table border="1">
              <tr>
                  <th>Name</th>
                  <th><input type = "text" name = "username"> </th>
              </tr>
              <tr>
                   <th> Password</th>
                   <th><input type = "text" name = "password" /></th>
               </tr>

         <input type = "submit" value = "Submit" />
      </form>

   </body>
</html>