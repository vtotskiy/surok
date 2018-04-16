<html>
<head><title>Удаление записи</title></head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<body>
  <div><a href="/">в начало</a></div>
  <div>Идентификатор<input id="id" type="text"/></div>
    <div id="btn_del" style="height: 30px; width: 80px; background: #eee; cursor: pointer;">Удалить</div>
    <div id="ret"></div>
  <script>
      function del() {
          var mass = {};
          mass.id = $("#id").val();
          $.ajax({
              url: '/db2_dml/del',
              type: 'post',
              data: mass,
              dataType: 'application/json',
              success:
                      function(ret){
                          $("#ret").text('ok');
                      },
              error:
                      function(xhr){
                          $("#ret").text('Ошибка');
                      }
          });

      };
      $(function() {
          $("#btn_del").click(function(){
              del();
          });

      });
  </script>
</body>
</html>