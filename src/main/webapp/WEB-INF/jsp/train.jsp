<!DOCTYPE HTML>
<html>

<head>
  <style>
    #train {
      position: relative;
      cursor: pointer;
    }
  </style>
</head>

<body>
<div>
<h1  items="${driver}" var ="driver">
Success, you add new driver:
 <br>Name=${driver.username}
 <br>Password=${driver.password}
</h1>
</div>
<div>
  <img id="train" src="https://js.cx/clipart/train.gif">


  <script>
    train.onclick = function() {
      let start = Date.now();

      let timer = setInterval(function() {
        let timePassed = Date.now() - start;

        train.style.left = timePassed / 5 + 'px';

        if (timePassed > 2000) clearInterval(timer);

      }, 20);
    }
  </script>
  </div>
  <div>
<a href="${pageContext.request.contextPath}/api/driver/drivers">All drivers</a>
</div>
</body>

</html>