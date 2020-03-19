<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="x-admin-sm">
  
  <head>
    <meta charset="UTF-8">
    <title>BBS论坛系统——用户密码修改</title>
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
        <form class="layui-form" method="post">
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                 用户名
              </label>
              <div class="layui-input-inline">
                   <input type="text" id="L_username" name="userid" value="${users.userid }" required="" lay-verify="nikename"
                  autocomplete="off" class="layui-input" readonly="readonly">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>旧密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="oldpass" value="" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>新密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="newpass" required="" value="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  6到16个字符
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>确认密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" value="" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="save" lay-submit="">
                  修改
              </button>
          </div>
      </form>
    </div>
    <script>
       layui.use(['form','layer'], function(){
           $ = layui.jquery;
         var form = layui.form
         ,layer = layui.layer;
         //监听提交
         form.on('submit(save)', function(data){
       	  // 使用ajax进行数据的增加
	          $.ajax({
	            	url:"${pageContext.request.contextPath }/UserPsw",
	            	type:"post",
	            	data:data.field,
	            	dataType:"text",// servlet中返回的是普通文本
	            	success:function(text){
	            		if(text.trim()=="true"){
	            			layer.alert("修改成功", {icon: 6},function () {
		                        //关闭当前frame
		                        x_admin_close();
		                        // 可以对父窗口进行刷新 
		                        x_admin_father_reload();
		                    }); 
	            		}else{
	            			layer.alert("修改失败", {icon: 6},function () {
		                        //关闭当前frame
		                        x_admin_close();
		                        // 可以对父窗口进行刷新 
		                        x_admin_father_reload();
		                    }); 
	            		}
	            	}
	            });
           return false;
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