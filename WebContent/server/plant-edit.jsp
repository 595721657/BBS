<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="x-admin-sm">
  <head>
    <meta charset="UTF-8">
    <title>BBS论坛系统——板块管理——板块信息修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/xadmin.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form layui-form-pane">
                        <div class="layui-form-item">
                    <label for="name" class="layui-form-label">
                        <span class="x-red">*</span>模块Id
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="idnmae" name="plateid" required="" lay-verify="required"
                        autocomplete="off" class="layui-input" value="${plates.plateid }" readonly="readonly">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label for="name" class="layui-form-label">
                        <span class="x-red">*</span>模块名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="name" name="platetitle" required="" lay-verify="required"
                        autocomplete="off" class="layui-input" value="${plates.platetitle }">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label for="desc" class="layui-form-label">
                        模块描述
                    </label>
                    <div class="layui-input-block">
                        <textarea  id="desc" name="platemessage" class="layui-textarea" placeholder="${plates.platemessage }"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="add">修改</button>
              </div>
            </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

          //监听提交
          form.on('submit(add)', function(data){
        	  $.ajax({
         		 url:"${pageContext.request.contextPath}/PlantServlet?op=update",
         		 type:"post",
         		 data:data.field,
         		 dataType:"text",
         		 success:function(res){
         			 if(res.trim()=="true"){
         				 layer.alert("修改成功", {icon: 6},function () {
         		                // 获得frame索引
         		                var index = parent.layer.getFrameIndex(window.name);
         		                //关闭当前frame
         		                parent.layer.close(index);
         		                // 可以对父窗口进行刷新 
         		                x_admin_father_reload();
         		            });
         			 }else{
         				 layer.alert("修改失败", {icon: 2},function () {
      		                // 获得frame索引
      		                var index = parent.layer.getFrameIndex(window.name);
      		                //关闭当前frame
      		                parent.layer.close(index);
      		                // 可以对父窗口进行刷新 
      		                x_admin_father_reload();
      		            });
         			 }
         		 }
         	  });         
             return false;
           });   
          //
        form.on('checkbox(father)', function(data){
            if(data.elem.checked){
                $(data.elem).parent().siblings('td').find('input').prop("checked", true);
                form.render(); 
            }else{
               $(data.elem).parent().siblings('td').find('input').prop("checked", false);
                form.render();  
            }
        });                  
        });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>