<html>
<head><title>Главная страница</title></head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<body>
  <div><a href="/">в начало</a></div>
  <div>Идентификатор<input id="id" type="text"/></div>
  <div>Родитель<input id="up_id" type="text"/></div>
  <div>Наименование<input id="name" type="text"/></div>
  <div id="btn_ins" style="height: 30px; width: 80px; background: #eee; cursor: pointer;">Добавить</div>
  <div id="btn_upd" style="height: 30px; width: 80px; background: #eee; cursor: pointer;">Изменить</div>
  <div id="ret"></div>
  <script>
      function a(action) {
          var mass = {};
          mass.id = $("#id").val();
          mass.up_id = $("#up_id").val();
          mass.name = $("#name").val();


          $.ajax({
              url: '/db2_dml/'+action,
              type: 'post',
              data: JSON.stringify(mass),
              contentType: 'application/json; charset=utf-8',
              dataType: 'application/json',
              success:
                      function(ret){
                          $("#ret").text(ret);
                      },
              error:
                      function(xhr){
                          $("#ret").text(xhr.statusText);
                      }
          });

      };
      $(function() {
          $("#btn_ins").click(function(){
              a('ins');
          });
          $("#btn_upd").click(function(){
              a('upd');
          });
      });
  </script>
</body>
</html>